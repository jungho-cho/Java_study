import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Font;

import javax.swing.*;

class CalculatorFrame extends JFrame {
	final static int WIDHT = 600;
	final static int HEIGHT = 800;
	
	JPanel textAreaPanel = new JPanel();
	JPanel buttonsPanel = null;
	JTextArea textArea = null;
	JButton numberButtons[] = new JButton[12];
	
	CalculatorFrame(String name) {
		super(name);
		if (buttonsPanel == null) {
			buttonsPanel = new JPanel();
			buttonsPanel.setBounds(0, 200, 600, 600);
		}
		if (textArea == null) {
			textArea = new JTextArea();
		}
		textAreaPanel.setBackground(Color.BLUE);
		textAreaPanel.setBounds(0, 0, 600,200);
	}
	
	void setPanels() {
//		this.setLayout(new BorderLayout());
		this.setLayout(null);
		buttonsPanel.setLayout(new GridLayout(4, 3));
	}
	
	void initTextArea() {
		textArea.setBounds(0, 0, 600, 200);
		textArea.setText("textArea");
		textArea.setFont(textArea.getFont().deriveFont(30f));
//		textArea.setAlignmentX(TextArea.RIGHT_ALIGNMENT);
		textAreaPanel.setLayout(null);
		textAreaPanel.add(textArea);
		this.add(textAreaPanel);
	}
	
	void initButtons() {
		for (int i=0; i<numberButtons.length; i++) {
			numberButtons[i] = new JButton("");
			numberButtons[i].setSize(30, 30);
		}
		
		for (int i=0; i<numberButtons.length-2; i++) {
			numberButtons[i].setText(Integer.toString(i));
		}
		numberButtons[10].setText("+-");
		numberButtons[11].setText(".");
		
		// add buttons into the panel
		// 7,8,9
		buttonsPanel.add(numberButtons[7]);
		buttonsPanel.add(numberButtons[8]);
		buttonsPanel.add(numberButtons[9]);
		// 4,5,6
		buttonsPanel.add(numberButtons[4]);
		buttonsPanel.add(numberButtons[5]);
		buttonsPanel.add(numberButtons[6]);
		//1,2,3
		buttonsPanel.add(numberButtons[1]);
		buttonsPanel.add(numberButtons[2]);
		buttonsPanel.add(numberButtons[3]);
		//+-,0,.
		buttonsPanel.add(numberButtons[10]);
		buttonsPanel.add(numberButtons[0]);
		buttonsPanel.add(numberButtons[11]);
		
		this.add(buttonsPanel);
		
	}
}
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorFrame cf = new CalculatorFrame("Calculator");
		cf.setSize(CalculatorFrame.WIDHT, CalculatorFrame.HEIGHT);
		cf.setResizable(false);
		cf.setPanels();
		cf.initTextArea();
		cf.initButtons();
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cf.setVisible(true);
	}

}
