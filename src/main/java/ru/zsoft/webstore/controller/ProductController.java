package ru.zsoft.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ru.zsoft.webstore.domain.Product;
import ru.zsoft.webstore.domain.repository.ProductRepository;
import ru.zsoft.webstore.exception.NoProductsFoundUnderCategoryException;
import ru.zsoft.webstore.exception.ProductNotFoundException;
import ru.zsoft.webstore.service.ProductService;
import ru.zsoft.webstore.validator.UnitsInStockValidator;

@Controller
@RequestMapping("market")
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UnitsInStockValidator unitsInStockValidator;
	
	@PostConstruct
	public void setup() {
		System.out.println("Bean created");
	}
	
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@GetMapping("/update/stock")
	public String updateProducts(Model model ) {	
		
		productService.updateAllStock();
		return "redirect:/market/products";
	}
	
	@GetMapping("/products/{category}")
	public String listByCategory(Model model, @PathVariable("category") String category) {
		List<Product> products = productService.getProductsByCategory(category);
		if(products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/products/filter/{params}")
	public String getProductByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> params, Model model) {	
		model.addAttribute("products", productService.getProductByFilter(params));
		return "products";
	}

	@GetMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";		
	};
	
	//http://localhost:8080/webstore/market/products/Tablet/price;low=100;high=200?brand=Google
	@GetMapping("/products/{category}/{price}")
	public String filterProdusts(@PathVariable("category") String category, 
			@MatrixVariable(pathVar="price") Map<String, List<String>> params, @RequestParam("brand") String brand, Model model) {
		//model.addAttribute("product", productService.getProductById(category));
		System.out.println("Path variable category: " +category);
		params.entrySet().forEach(e->{System.out.println(e.getKey() + " -  " + e.getValue());});
		System.out.println("Request param: " + brand);
		return "product";		
	};
	
	@GetMapping("/products/add")
	public String getAddNewProductForm(Model model) {
		model.addAttribute("newProduct", new Product());
		return "addProduct";
	}
	
	@RequestMapping("/products/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}
	
	@PostMapping("/products/add")
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult bindingResult, HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			return "addProduct";
		}
		
		String[] suppressedFields = bindingResult.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("attempting to bind dissalowed fields " 
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory+"\\static\\images\\phones\\" + newProduct.getProductId()+".png"));
			} catch (Exception e) {
				throw new RuntimeException("Saving product image failed ", e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	 //  binder.setValidator(unitsInStockValidator);
	   binder.setAllowedFields("productId", "name", "unitPrice", "description",
	            "manufacturer", "category", "unitsInStock", "condition", "productImage","language");
	   
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalid Product ID", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL()+"?"+request.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
	
	@PostConstruct
	public void init() {
		System.out.println(unitsInStockValidator);
	}
}
