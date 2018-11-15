import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.*;

class CalculatorScene extends JFrame implements UpdaterInterface{
	final static int CAL_WIDTH = 600;
	final static int CAL_HEIGHT = 800;
	
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
	
	CalculatorScene(String name) {
		super(name);
		initPanels();
		initTextArea();
		initButtons();
		initData();
	}
	
	void initPanels() {
		this.setLayout(null);
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 200, 600, 600);
		buttonsPanel.setLayout(new GridLayout(5, 4));
		
		textAreaPanel = new JPanel();
		textAreaPanel.setLayout(null);
		textAreaPanel.setBounds(0, 0, 600,200);
	}
	
	void initTextArea() {
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 600, 200);
		textArea.setText("0");
		textArea.setEditable(false);
		textArea.setFont(textArea.getFont().deriveFont(30f));
		textAreaPanel.add(textArea);
		this.add(textAreaPanel);
	}
	
	void initButtons() {
		for (int i=0; i<numberButtons.length; i++) {
			numberButtons[i] = new JButton("");
		}
		
		for (int i=0; i<numberButtons.length-2; i++) {
			setButtons(numberButtons[i], Integer.toString(i));
		}
		setButtons(numberButtons[10], "+-");
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
	
	void setActionListenerButtons(ActionListener l) {
		for (int i=0; i<numberButtons.length; i++) {
			numberButtons[i].addActionListener(l);
		}
		clearErrorButton.addActionListener(l);
		clearButton.addActionListener(l);
		eraserButton.addActionListener(l);
		divideButton.addActionListener(l);
		muliplyButton.addActionListener(l);
		minusButton.addActionListener(l);
		plusButton.addActionListener(l);
		resultButton.addActionListener(l);
	}
	void initData() {
		textArea.setText("0");
	}
	
	JButton[] getNumberButtons() {
		return numberButtons;
	}
	JButton getClearErrorButton() {
		return clearErrorButton;
	}
	JButton getClearButton() {
		return clearButton;
	}
	JButton getEraserButton() {
		return eraserButton;
	}
	JButton getDivideButton() {
		return divideButton;
	}
	JButton getMuliplyButton() {
		return muliplyButton;
	}
	JButton getMinusButton() {
		return minusButton;
	}
	JButton getPlusButton() {
		return plusButton;
	}
	JButton getResultButton() {
		return resultButton;
	}
	public void textUpdate(String text) {
		textArea.setText(text);
		System.out.println("textUpdate => text = " + text);
	}
	public void addTextUpdate(String text) {
		textArea.append(text);
	}
}
