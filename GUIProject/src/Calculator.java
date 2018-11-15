import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.*;

public class Calculator {
	UpdaterInterface ui;
	
	String beforeNumber;
	String currentNumber;
	
	String beforeOperator = "";
	String currentOperator = "";
	
	boolean hasOperator = false;
	
	Calculator() {
		initData();
	}
	void initData() {
		beforeNumber = "0";
		currentNumber = "0";
		
		beforeOperator = "";
		currentOperator = "";
	}
	
	void setCurrentNumber(int n) {
		currentNumber = new Integer(n).toString();
		ui.textUpdate(currentNumber);
	}
	void setNumber(int n) {
		currentNumber = new Integer(n).toString();
		beforeNumber = currentNumber;
		ui.textUpdate(currentNumber);
	}
	void addNumber(int n) {
//		beforeNumber = currentNumber;
//		currentNumber = n;
//		ui.textUpdate(new Integer(n).toString());
//		System.out.println("addNumber => n = " + n);
	}
	
	void addNumber(String str) {
		beforeNumber = currentNumber;
		if (currentNumber.equals("0") && str.equals("0")) {
			
		} else {
			if (hasOperator == true) {
				currentNumber = "";
				hasOperator = false;
			}
			if (currentNumber.equals("0")) {
				currentNumber = "";
			}
			currentNumber += str;
		}
//		addNumber(new Integer(str));
		ui.textUpdate(currentNumber);
	}
	
	void changeNumberType() {
		int n = new Integer(currentNumber).intValue();
		n *= -1;
		setCurrentNumber(n);
	}
	void clearError() {
		initData();
		ui.textUpdate(currentNumber);
	}
	
	void clear() {
		initData();
		ui.textUpdate(currentNumber);
	}
	void eraseNumber() {
		if (hasOperator)
			return;
		
		int length = currentNumber.length();
		
		if (length <= 1) {
			currentNumber = "0";
		} else {
			currentNumber = currentNumber.substring(0, length - 1);
		}
		ui.textUpdate(currentNumber);
	}
	void setOperator(String o) {
		beforeOperator = currentOperator;
		currentOperator = o;
	}
	
	void excuteOperator() {
		if (beforeOperator.equals("") || hasOperator) {
			
		} else {
			if (beforeOperator.equals("+")) {
				sum();
			} else if (beforeOperator.equals("-")) {
				minus();
			} else if (beforeOperator.equals("/")) {
				divide();
			} else if (beforeOperator.equals("*")) {
				multiply();
			}
		}
		hasOperator = true;
	}
	void sum() {
		int num1 = new Integer(beforeNumber).intValue();
		int num2 = new Integer(currentNumber).intValue();
		int result = num1 + num2;
		setNumber(result);
	}
	void minus() {
		int num1 = new Integer(beforeNumber).intValue();
		int num2 = new Integer(currentNumber).intValue();
		int result = num1 - num2;
		setNumber(result);
	}
	void divide() {
		int num1 = new Integer(beforeNumber).intValue();
		int num2 = new Integer(currentNumber).intValue();
		int result = num1 / num2;
		setNumber(result);
	}
	void multiply() {
		int num1 = new Integer(beforeNumber).intValue();
		int num2 = new Integer(currentNumber).intValue();
		int result = num1 * num2;
		setNumber(result);
	}
	void registerUpdater(UpdaterInterface ui) {
		this.ui = ui;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		CalculatorScene cs = new CalculatorScene("Calculator");
		CalculatorController cc = new CalculatorController(cs, c);
		c.registerUpdater(cs);
		cs.setSize(CalculatorScene.CAL_WIDTH, CalculatorScene.CAL_HEIGHT);
		cs.setResizable(false);
		cs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cs.setVisible(true);
	}
}