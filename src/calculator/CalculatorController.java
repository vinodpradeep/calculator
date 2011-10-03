package calculator;

public class CalculatorController  {

	private final CalculatorModel model;

	public CalculatorController(CalculatorModel model) {
		this.model = model;
		this.buttonPushed("0.");
		
	}
	
	//String buttonOrder = "1234567890 ";

	public void buttonPushed(String buttonLabel) {
		/*
		if (buttonLabel.equals("C")){
			model.setDisplay("0.");
		}
		
		else if(isInteger(buttonLabel)){
			model.setDisplay(removeDot(model.getDisplay()) + buttonLabel +".");
		}
		
		/*
		for (int i=0; i<buttonOrder.length();i++){
			String key =buttonOrder.substring(i, i+1);
			if(key.equals(" ")){
				model.setDisplay("");
			}
		}
		*/
		if (buttonLabel.equals(null)){
			model.setDisplay("0.");
		}
		/*
		else if (isInteger(buttonLabel)){
			model.setDisplay(buttonLabel.replace(".",buttonLabel)+ model.getDisplay());
		}
		else if(buttonLabel.equals("C")){
			model.setDisplay("0.");
		}
		else if(buttonLabel.equals("decimalButton")){
			model.setDisplay(buttonLabel + "." + model.getDisplay());
		}
		*/
		
		
		
		if (buttonLabel.equals("C"))
		{
			model.setDisplay("0.");
		}
		
		else if (isInteger(buttonLabel)){
			//model.append(buttonLabel +".");
			//model.setDisplay(buttonLabel + ".");
			model.setDisplay(buttonLabel.replaceFirst(null,buttonLabel) + model.getDisplay());
			
		}
		
		
		
	}
	//String result =s.replace(".", "something");
	
	/*private boolean isNull(String input){
		try{
			buttonLabel = null;
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
	*/

	private boolean isInteger(String input){
		try{
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
	
}
