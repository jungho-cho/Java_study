import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
	Calculator cal = null;
	CalculatorScene scene = null;
	
	CalculatorController(CalculatorScene scene, Calculator cal) {
		this.cal = cal;
		this.scene = scene;
		this.scene.setActionListenerButtons(this);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == scene.getNumberButtons()[0]) {
			cal.addNumber(scene.getNumberButtons()[0].getText());
		} else if (e.getSource() == scene.getNumberButtons()[1]) {
			cal.addNumber(scene.getNumberButtons()[1].getText());
		} else if (e.getSource() == scene.getNumberButtons()[2]) {
			cal.addNumber(scene.getNumberButtons()[2].getText());
		} else if (e.getSource() == scene.getNumberButtons()[3]) {
			cal.addNumber(scene.getNumberButtons()[3].getText());
		} else if (e.getSource() == scene.getNumberButtons()[4]) {
			cal.addNumber(scene.getNumberButtons()[4].getText());
		} else if (e.getSource() == scene.getNumberButtons()[5]) {
			cal.addNumber(scene.getNumberButtons()[5].getText());
		} else if (e.getSource() == scene.getNumberButtons()[6]) {
			cal.addNumber(scene.getNumberButtons()[6].getText());
		} else if (e.getSource() == scene.getNumberButtons()[7]) {
			cal.addNumber(scene.getNumberButtons()[7].getText());
		} else if (e.getSource() == scene.getNumberButtons()[8]) {
			cal.addNumber(scene.getNumberButtons()[8].getText());
		} else if (e.getSource() == scene.getNumberButtons()[9]) {
			cal.addNumber(scene.getNumberButtons()[9].getText());
		} else if (e.getSource() == scene.getNumberButtons()[10]) {  
			cal.changeNumberType();
		} else if (e.getSource() == scene.getClearErrorButton()) {
			cal.clearError();
		} else if (e.getSource() == scene.getClearButton()) {
			cal.clear();
		} else if (e.getSource() == scene.getEraserButton()) {
			cal.eraseNumber();
		} else if (e.getSource() == scene.getPlusButton()) {
			cal.setOperator("+");
			cal.excuteOperator();
		} else if (e.getSource() == scene.getMinusButton()) {
			cal.setOperator("-");
			cal.excuteOperator();
		} else if (e.getSource() == scene.getDivideButton()) {
			cal.setOperator("/");
			cal.excuteOperator();
		} else if (e.getSource() == scene.getMuliplyButton()) {
			cal.setOperator("*");
			cal.excuteOperator();
		} else if (e.getSource() == scene.getResultButton()) {
			cal.setOperator("=");
			cal.excuteOperator();
		} else {
			System.out.println("wrong event!! => " + e.getSource());
		}		
		System.out.println("actionPerformed");
	}
}
