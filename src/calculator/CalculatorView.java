package calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class CalculatorView implements ActionListener{
	
	private final CalculatorModel model;
	private final CalculatorController controller;
	//private final JTextArea text = new JTextArea(1,20);
	private final JLabel displayLabel = new JLabel("0.", JLabel.RIGHT);	
	private final JButton backspaceButton = new JButton("Backspace");
	private final JButton ceButton = new JButton("CE");
	private final JButton cancelButton = new JButton("C");
	private final JButton mcButton = new JButton("MC");
	private final JButton sevenButton = new JButton("7");
	private final JButton eightButton = new JButton("8");
	private final JButton nineButton = new JButton("9");
	private final JButton divideButton = new JButton("/");
	private final JButton squareRootButton = new JButton("sqrt");
	private final JButton mrButton = new JButton("MR");
	private final JButton fourButton = new JButton("4");
	private final JButton fiveButton = new JButton("5");
	private final JButton sixButton = new JButton("6");
	private final JButton timesButton = new JButton("*");
	private final JButton percentButton = new JButton("%");
	private final JButton msButton = new JButton("MS");
	private final JButton oneButton = new JButton("1");
	private final JButton twoButton = new JButton("2");
	private final JButton threeButton = new JButton("3");
	private final JButton minusButton = new JButton("-");
	private final JButton reciprocalButton = new JButton("1/x");
	private final JButton mPlusButton = new JButton("M+");
	private final JButton zeroButton = new JButton("0");
	private final JButton plusMinusButton = new JButton("+/-");
	private final JButton decimalButton = new JButton(".");
	private final JButton plusButton = new JButton("+");
	private final JButton equalsButton = new JButton("=");
	private final List<JButton> buttons = new ArrayList<JButton>();
	
	//My editing for add/sub/multi/div functions
	Double number1,number2,result;
	int addc = 0, subc =0,multic =0,divc =0;
	
	public CalculatorView(CalculatorModel model, CalculatorController controller) {
		this.model = model;
		this.controller = controller;
	}

	public void createUI (Container container) {
		container.setLayout(new MigLayout(null, "[]11px[][][][][]"));
		
		displayLabel.setOpaque(true);
		displayLabel.setBackground(Color.WHITE);
		Border paddingBorder = BorderFactory.createEmptyBorder(0,6,0,6);
		Border lineBorder = LineBorder.createGrayLineBorder();
		displayLabel.setBorder(BorderFactory.createCompoundBorder(lineBorder,paddingBorder));
		displayLabel.setPreferredSize(new Dimension(35, 25));
		displayLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		container.add(displayLabel, "span 6, growx, wrap paragraph");

		buttons.add(backspaceButton);
		buttons.add(ceButton);
		buttons.add(cancelButton);
		buttons.add(mcButton);
		buttons.add(sevenButton);
		buttons.add(eightButton);
		buttons.add(nineButton);
		buttons.add(divideButton);
		buttons.add(squareRootButton);
		buttons.add(mrButton);
		buttons.add(fourButton);
		buttons.add(fiveButton);
		buttons.add(sixButton);
		buttons.add(timesButton);
		buttons.add(percentButton);
		buttons.add(msButton);
		buttons.add(oneButton);
		buttons.add(twoButton);
		buttons.add(threeButton);
		buttons.add(minusButton);
		buttons.add(reciprocalButton);
		buttons.add(mPlusButton);
		buttons.add(zeroButton);
		buttons.add(plusMinusButton);
		buttons.add(decimalButton);
		buttons.add(plusButton);
		buttons.add(equalsButton);
		

		  for (JButton button : buttons) {
			button.setMargin(new Insets(2,2,2,2));  
			button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
			button.setPreferredSize(new Dimension(35, 30));
			button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					String keyLabel = e.getActionCommand();
					controller.buttonPushed(keyLabel);
					updateView();
				}
				
			});
		}
	
		
		sevenButton.addActionListener(this);
		eightButton.addActionListener(this);
		nineButton.addActionListener(this);
		divideButton.addActionListener(this);
		fourButton.addActionListener(this);
		fiveButton.addActionListener(this);
		sixButton.addActionListener(this);
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
		minusButton.addActionListener(this);
		mPlusButton.addActionListener(this);
		zeroButton.addActionListener(this);
		plusButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		/*sevenButton.addActionListener(this);
		sevenButton.addActionListener(this);
		sevenButton.addActionListener(this);
		sevenButton.addActionListener(this);
		sevenButton.addActionListener(this);
		sevenButton.addActionListener(this);
		*/
		
		backspaceButton.setForeground(Color.red);
		container.add(backspaceButton, "skip, span 5, split 3, sizegroup toprow");
		ceButton.setForeground(Color.red);
		container.add(ceButton, "sizegroup toprow");
		cancelButton.setForeground(Color.red);
		container.add(cancelButton, "sizegroup toprow, wrap");
		
		mcButton.setForeground(Color.red); 
		container.add(mcButton);
		sevenButton.setForeground(Color.blue);
		container.add(sevenButton);
		eightButton.setForeground(Color.blue);
		container.add(eightButton);
		nineButton.setForeground(Color.blue);
		container.add(nineButton);
		divideButton.setForeground(Color.red); 
		container.add(divideButton);
		squareRootButton.setForeground(Color.blue);
		container.add(squareRootButton, "wrap");
		
		mrButton.setForeground(Color.red); 
		container.add(mrButton);
		fourButton.setForeground(Color.blue);
		container.add(fourButton);
		fiveButton.setForeground(Color.blue);
		container.add(fiveButton);
		sixButton.setForeground(Color.blue);
		container.add(sixButton);
		timesButton.setForeground(Color.red); 
		container.add(timesButton);
		percentButton.setForeground(Color.blue);
		container.add(percentButton, "wrap");

		msButton.setForeground(Color.red); 
		container.add(msButton);
		oneButton.setForeground(Color.blue);
		container.add(oneButton);
		twoButton.setForeground(Color.blue);
		container.add(twoButton);
		threeButton.setForeground(Color.blue);
		container.add(threeButton);
		minusButton.setForeground(Color.red); 
		container.add(minusButton);
		reciprocalButton.setForeground(Color.blue);
		container.add(reciprocalButton, "wrap");

		mPlusButton.setForeground(Color.red); 
		container.add(mPlusButton);
		zeroButton.setForeground(Color.blue);
		container.add(zeroButton);
		plusMinusButton.setForeground(Color.blue);
		container.add(plusMinusButton);
		decimalButton.setForeground(Color.blue);
		container.add(decimalButton);
		plusButton.setForeground(Color.red); 
		container.add(plusButton);
		equalsButton.setForeground(Color.red); 
		container.add(equalsButton);
	}

	public void updateView() {
		
		displayLabel.setText(model.getDisplay());
	}
	public void actionPerformed(ActionEvent e){
			Object source =e.getSource();
			
		if (source ==cancelButton){
			number1 =0.0;
			number2=0.0;
			displayLabel.setText("0.");
		}
		if (source ==sevenButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			//text.append("7");
			
		}
		if (source ==eightButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			
			
		}if (source ==nineButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			
			
		}if (source ==fourButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			
			
		}if (source ==fiveButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			
			
		}if (source ==sixButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			
			
		}if (source ==oneButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			
			
		}if (source ==twoButton){
			displayLabel.setText(model.getDisplay());
			//addDigit(String.valueOf(sevenButton));
			
			
		}
		
		if(source ==divideButton){
			number1 = number_reader();
			displayLabel.setText("");
			divc =1;
			addc=0;
			subc =0;
			multic = 0;
		}
		if(source ==minusButton){
			number1 = number_reader();
			displayLabel.setText("");
			divc =0;
			addc=0;
			subc =1;
			multic = 0;
		}
		if(source ==plusButton){
			number1 = number_reader();
			displayLabel.setText("");
			divc =0;
			addc=1;
			subc =0;
			multic = 0;
		}
		if(source ==timesButton){
			number1 = number_reader();
			displayLabel.setText("");
			divc =0;
			addc=0;
			subc =0;
			multic = 1;
		}
		
		if (source ==equalsButton){
			number2 = number_reader();
			
			if(addc>0){
				result = number1+number2;
				displayLabel.setText(Double.toString(result));
			}
			if(divc>0){
				result = number1/number2;
				displayLabel.setText(Double.toString(result));
			}
			if(subc>0){
				result = number1-number2;
				displayLabel.setText(Double.toString(result));
			}
			if(multic>0){
				result = number1*number2;
				displayLabel.setText(Double.toString(result));
			}
		}
	}
	public double number_reader(){
		Double num1;
		String s ;
		s= displayLabel.getText();
		num1 = Double.valueOf(s);
		return num1;
	}
	

	private void addDigit(String valueOf) {
		// TODO Auto-generated method stub
		
	}

}
