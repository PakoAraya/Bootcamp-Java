package com.miappl.ejercicio2;

public class DiscountCalculator {
	private PricingService pricingService; //Atributo tipo Objeto => Tipo PricingService

	//Constructor de la clase DiscountCalculator depende de PricingService
	public DiscountCalculator(PricingService pricingService) {
		this.pricingService = pricingService;
	}

	public double calculateDiscount(String productCode, double discountRate) {
		double price = pricingService.getPrice(productCode);
		return price * (1 - discountRate);
	}
}
