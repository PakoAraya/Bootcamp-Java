package ejercicio2test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.miappl.ejercicio2.DiscountCalculator;
import com.miappl.ejercicio2.PricingService;

public class DiscountCalculatorTest {

	//Creo una clase Stub de PricingServide para alterar sus metodos y valores
	public class StubPricingService extends PricingService{
		@Override
		public double getPrice(String productCode) {
			return 100.0; //Precio fijo para pruebas
		}	
	}

	@Test
	void testCalculateDiscount() {
		//Usar el stub de PricingService
		StubPricingService stubprice = new StubPricingService();
		//Creo objeto de clase DiscountCalculator y le paso por parametros un objeto de tipo stubprice (StubPricingService)
		DiscountCalculator discountCalculator = new DiscountCalculator(stubprice);

		//Vamos a sobreescribir el valor del descuento
		double discountRate = 0.20;

		//Valor esperado de descuento | objeto con metodo calculateDiscount | Porcentaje nuevo de descuento por variable
		assertEquals(80, discountCalculator.calculateDiscount("Producto123", discountRate));
	}
}
