package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.NegativePriceException;
import exceptions.NoPriceException;

class ProductTest {
	private Product myProduct;
	private void setupScenary1() {
		myProduct = new Product("Milk",3200);
	}

	@Test
	public void testSetPrice1() {
		setupScenary1();		
		try {
			double newVal = 3300;			
			myProduct.setPrice(newVal);
			assertEquals(newVal, myProduct.getPrice());
		} catch (NegativePriceException negpe) {
			fail("Not NegativePriceException expected");
		} catch (NoPriceException nope) {
			fail("Not NoPriceException expected");
		}
	}

	@Test
	public void testSetPrice2() {
		setupScenary1();
		double currVal = myProduct.getPrice();
		try {
			double newVal = -2500;
			myProduct.setPrice(newVal);			
			fail("NegativePriceException expected");
		} catch (NegativePriceException e) {
			assertEquals(currVal, myProduct.getPrice());
		} catch (NoPriceException e) {
			fail("NegativePriceException expected, not NoPriceException");
		}
	}

	@Test
	public void testSetPrice3() {
		setupScenary1();
		double currVal = myProduct.getPrice();
		try {
			double newVal = 0;
			myProduct.setPrice(newVal);			
			fail("NoPriceException expected");
		} catch (NegativePriceException e) {
			fail("NoPriceException expected, not NegativePriceException");
		} catch (NoPriceException e) {
			assertEquals(currVal, myProduct.getPrice());			
		}
	}

}
