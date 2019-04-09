package ru.zsoft.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PromoCodeInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOGGER = Logger.getLogger(PromoCodeInterceptor.class);
	
	private String promoCode;
	private String errorRedirect;
	private String offerredirect;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//LOGGER.info("Entering PromoCodeInterceptor: " + request.getRequestURI());
		String givenPromoCode = request.getParameter("promo");
		if(this.promoCode.equals(givenPromoCode)) {
			response.sendRedirect(request.getContextPath() + "/" + offerredirect);			
		} else {
			response.sendRedirect(errorRedirect);
		}
		return false;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public void setErrorRedirect(String errorRedirect) {
		this.errorRedirect = errorRedirect;
	}

	public void setOfferredirect(String offerredirect) {
		this.offerredirect = offerredirect;
	}
	
	

}
