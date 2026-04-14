import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Computation implements ComputationInterface, ActionListener {
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private Calculator calculator;
    private boolean startNewNumber = false;
    private DecimalFormat df = new DecimalFormat("#.##");

    public Computation(Calculator calculator) {
        this.calculator = calculator;
        attachListeners();
    }

    public void setNum1(double num){
        this.num1 = num; 
    }

    public void setNum2(double num){
        this.num2 = num;
    }

    public void setOperator(char op) {
        this.operator = op; 
    }
    
    public double calculate() {
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': 
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    result = 0;
                }
                break;
        }
        num1 = result;
        return result;
    }

    public double getResult() { 
        return result; 
    }

    private void attachListeners() {
        for (int i = 0; i < 10; i++) {
            calculator.numberButtons[i].addActionListener(this);
        }
        for (JButton btn : calculator.functionButtons) {
            btn.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == calculator.numberButtons[i]) {
                if (startNewNumber) {
                    calculator.textField.setText("");
                    startNewNumber = false;
                }
                calculator.textField.setText(calculator.textField.getText().concat(String.valueOf(i)));
                return;
            }
        }

        // Operation buttons
        if (e.getSource() == calculator.decButton) {
            if(!calculator.textField.getText().contains(".")) {
                calculator.textField.setText(calculator.textField.getText().concat("."));
            }
        }

        handleOperator(e.getSource(), calculator.addButton, '+');
        handleOperator(e.getSource(), calculator.subButton, '-');
        handleOperator(e.getSource(), calculator.mulButton, '*');
        handleOperator(e.getSource(), calculator.divButton, '/');

        if (e.getSource() == calculator.equButton) {
            setNum2(Double.parseDouble(calculator.textField.getText()));
            double result = calculate();
            calculator.textField.setText(df.format(result));
            setOperator('\0');
            startNewNumber = true;
        }

        if (e.getSource() == calculator.clrButton) {
            calculator.textField.setText("");
        }
        
        if (e.getSource() == calculator.delButton) {
            String str = calculator.textField.getText();
            if(!str.isEmpty()) calculator.textField.setText(str.substring(0, str.length()-1));
        }
    }

    private void handleOperator(Object source, JButton btn, char op) {
        if (source == btn) {
            String currentText = calculator.textField.getText();
            
            if (!currentText.isEmpty()) {
                startNewNumber = false;
                if (operator != '\0') { 
                    setNum2(Double.parseDouble(currentText));
                    calculate();
                    calculator.textField.setText(""); 
                } else {
                    setNum1(Double.parseDouble(currentText));
                    calculator.textField.setText("");
                }
                setOperator(op);
            }
        }
    }
}
