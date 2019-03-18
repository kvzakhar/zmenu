package ru.zsoft.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.zsoft.webstore.domain.repository.ProductRepository;
import ru.zsoft.webstore.service.ProductService;

@Controller
@RequestMapping("market")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
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
		model.addAttribute("products", productService.getProductsByCategory(category));
		return "products";
	}

}
