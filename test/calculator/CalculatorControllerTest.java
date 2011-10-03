package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorControllerTest {
	
	private CalculatorModel model;
	private CalculatorController controller;

	@Before
	public void setupTests() {
		model = new CalculatorModel();
		controller = new CalculatorController(model);
	}

	@Test
	public void shouldDisplay() {
		controller.buttonPushed("C");
		assertEquals("0.", model.getDisplay());
		
	}
	@Test
	public void shouldMoreDisplay() {
		controller.buttonPushed("8");
		controller.buttonPushed("5");
		controller.buttonPushed("4");
		controller.buttonPushed("3");
		controller.buttonPushed("2");
		controller.buttonPushed("0");
		assertEquals("023458null", model.getDisplay());
		
	}
	/*
	@Test
	public void shouldDisplayDigit() {
		controller.buttonPushed("8");
		assertEquals("8.", model.getDisplay());
		
	}
	
	*/
	
	
	
	

}
