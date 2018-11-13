import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.*;

class CalculatorFrame extends JFrame implements ActionListener{
	final static int WIDHT = 600;
	final static int HEIGHT = 800;
	
	JPanel textAreaPanel = null;
	JPanel buttonsPanel = null;
	JTextArea textArea = null;
	JButton numberButtons[] = new JButton[12];
	
	JButton clearErrorButton;
	JButton clearButton;
	JButton eraserButton;
	JButton divideButton;
	JButton muliplyButton;
	JButton minusButton;
	JButton plusButton;
	JButton resultButton;
	
	String strCurrentOperator = "";
	String strBeforeOperator = "";
	
	int currentNumber = 0;
	int beforeNumber = 0;
	
	boolean isExcuted = false;
	boolean isInit = false;
	
	CalculatorFrame(String name) {
		super(name);
		initPanels();
		initTextArea();
		initButtons();
		initData();
	}
	
	void initPanels() {
//		this.setLayout(new BorderLayout());
		this.setLayout(null);
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 200, 600, 600);
		buttonsPanel.setLayout(new GridLayout(5, 4));
		
		textAreaPanel = new JPanel();
		textAreaPanel.setBackground(Color.BLUE);
		textAreaPanel.setBounds(0, 0, 600,200);
	}
	
	void initTextArea() {
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 600, 200);
		textArea.setText("0");
		textArea.setEditable(false);
		textArea.setFont(textArea.getFont().deriveFont(30f));
//		textArea.setAlignmentX(TextArea.RIGHT_ALIGNMENT);
		textAreaPanel.setLayout(null);
		textAreaPanel.add(textArea);
		this.add(textAreaPanel);
	}
	
	void initButtons() {
		for (int i=0; i<numberButtons.length; i++) {
			numberButtons[i] = new JButton("");
//			numberButtons[i].setSize(30, 30);
//			numberButtons[i].addActionListener(this);
		}
		
		for (int i=0; i<numberButtons.length-2; i++) {
//			numberButtons[i].setText(Integer.toString(i));
			setButtons(numberButtons[i], Integer.toString(i));
		}
//		numberButtons[10].setText("+-");
		setButtons(numberButtons[10], "+-");
//		numberButtons[11].setText(".");
		setButtons(numberButtons[11], ".");
		
		clearErrorButton = new JButton();
		setButtons(clearErrorButton, "CE");
		clearButton = new JButton();
		setButtons(clearButton, "C");
		eraserButton = new JButton();
		setButtons(eraserButton, "<=");
		divideButton = new JButton();
		setButtons(divideButton, "/");
		muliplyButton = new JButton();
		setButtons(muliplyButton, "*");
		minusButton = new JButton();
		setButtons(minusButton, "-");
		plusButton = new JButton();
		setButtons(plusButton, "+");
		resultButton = new JButton();
		setButtons(resultButton, "=");
		
		setButtonsPanel();
	}
	
	void setButtons(JButton button, String text) {
		setButtons(button, text, 30, 30);
	}
	void setButtons(JButton button, String text, int width, int height) {
		button.setText(text);
		button.setSize(width, height);
		button.addActionListener(this);
	}
	
	void setButtonsPanel() {
		// add buttons into the panel
		// CE, C, <=, /
		buttonsPanel.add(clearErrorButton);
		buttonsPanel.add(clearButton);
		buttonsPanel.add(eraserButton);
		buttonsPanel.add(divideButton);
		// 7,8,9, *
		buttonsPanel.add(numberButtons[7]);
		buttonsPanel.add(numberButtons[8]);
		buttonsPanel.add(numberButtons[9]);
		buttonsPanel.add(muliplyButton);
		// 4,5,6, -
		buttonsPanel.add(numberButtons[4]);
		buttonsPanel.add(numberButtons[5]);
		buttonsPanel.add(numberButtons[6]);
		buttonsPanel.add(minusButton);
		//1,2,3, +
		buttonsPanel.add(numberButtons[1]);
		buttonsPanel.add(numberButtons[2]);
		buttonsPanel.add(numberButtons[3]);
		buttonsPanel.add(plusButton);
		//+-,0,., =
		buttonsPanel.add(numberButtons[10]);
		buttonsPanel.add(numberButtons[0]);
		buttonsPanel.add(numberButtons[11]);
		buttonsPanel.add(resultButton);
		
		this.add(buttonsPanel);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == numberButtons[0]) {
			addNumber(numberButtons[0].getText());
		} else if (e.getSource() == numberButtons[1]) {
			addNumber(numberButtons[1].getText());
		} else if (e.getSource() == numberButtons[2]) {
			addNumber(numberButtons[2].getText());
		} else if (e.getSource() == numberButtons[3]) {
			addNumber(numberButtons[3].getText());
		} else if (e.getSource() == numberButtons[4]) {
			addNumber(numberButtons[4].getText());
		} else if (e.getSource() == numberButtons[5]) {
			addNumber(numberButtons[5].getText());
		} else if (e.getSource() == numberButtons[6]) {
			addNumber(numberButtons[6].getText());
		} else if (e.getSource() == numberButtons[7]) {
			addNumber(numberButtons[7].getText());
		} else if (e.getSource() == numberButtons[8]) {
			addNumber(numberButtons[8].getText());
		} else if (e.getSource() == numberButtons[9]) {
			addNumber(numberButtons[9].getText());
		} else if (e.getSource() == clearErrorButton) {
			initData();
		} else if (e.getSource() == clearButton) {
			initData();
		} else if (e.getSource() == eraserButton) {
			eraserNumber();
		} else if (e.getSource() == plusButton) {
			setOperator("+");
			excuteOperator();
		} else if (e.getSource() == minusButton) {
			setOperator("-");
			excuteOperator();
		} else if (e.getSource() == divideButton) {
			setOperator("/");
			excuteOperator();
		} else if (e.getSource() == muliplyButton) {
			setOperator("*");
			excuteOperator();
		} else if (e.getSource() == resultButton) {
			setOperator("=");
			excuteOperator();
			this.strCurrentOperator = "";
			this.strBeforeOperator = "";
		} else {
			System.out.println("wrong event!! => " + e.getSource());
		}		
	}
	
	void initData() {
		textArea.setText("0");
		currentNumber = 0;
		beforeNumber = 0;
		strCurrentOperator = "";
		strBeforeOperator = "";
	}
	void addNumber(String strNumber) {
		String currentNumber = textArea.getText();
		
		if ((currentNumber.equals("0") && strNumber.equals("0"))) {
			return;
		}

//		System.out.println("current number => " + currentNumber);

		if (isExcuted == true) {
			textArea.setText("");
			isExcuted = false;
		}
		
		if (currentNumber.equals("0")) {
			System.out.println("current number is zero");
			textArea.setText("");
		}
		
		isInit = false;
		textArea.append(strNumber);
		
//		System.out.println("textarea => " + textArea.getText());
		this.currentNumber = new Integer(textArea.getText()).intValue();
		
//		System.out.println("first number : " + firstNumber);
	}
	
	void eraserNumber() {
		System.out.println("text area length => " + textArea.getText().length());
		if (textArea.getText().length() <= 1) {
			textArea.setText("0");
			isInit = true;
		} else {
			String str = textArea.getText();
			textArea.setText(str.substring(0, str.length()-1));
		}
	}
	void setOperator(String operator) {
		if (isInit) {
			return;
		}
		
		this.strCurrentOperator = operator;
	}
	
	void excuteOperator() {
		if (isExcuted) {
			this.strBeforeOperator = this.strCurrentOperator;
			return;
		}
		
		isExcuted = true;
		if (this.strBeforeOperator.equals("+")) { 
			currentNumber = beforeNumber + currentNumber;
			textArea.setText(Integer.toString(currentNumber));
		} else if (this.strBeforeOperator.equals("-")) { 
			currentNumber = beforeNumber - currentNumber;
			textArea.setText(Integer.toString(currentNumber));
		} else if (this.strBeforeOperator.equals("*")) { 
			currentNumber = beforeNumber * currentNumber;
			textArea.setText(Integer.toString(currentNumber));
		} else if (this.strBeforeOperator.equals("/")) { 
			currentNumber = beforeNumber / currentNumber;
			textArea.setText(Integer.toString(currentNumber));
		}
		
		this.strBeforeOperator = this.strCurrentOperator;
		this.beforeNumber = this.currentNumber;
	}
}
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorFrame cf = new CalculatorFrame("Calculator");
		cf.setSize(CalculatorFrame.WIDHT, CalculatorFrame.HEIGHT);
		cf.setResizable(false);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cf.setVisible(true);
	}
}
