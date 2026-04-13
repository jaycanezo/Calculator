import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    public JTextField textField = new JTextField();
    public JButton[] numberButtons = new JButton[10];
    public JButton[] functionButtons = new JButton[8];
    public JButton addButton, subButton, mulButton, divButton;
    public JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;
    private Font myFont = new Font("PLAIN", 10, 30);

    public Calculator() {
        this.setTitle("OOP Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);
        this.setResizable(false);

        textField.setBounds(15, 25, 380, 70);
        textField.setFont(myFont);
        textField.setEditable(false);

        initializeButtons();
        setupPanel();

        this.add(panel);
        this.add(delButton);
        this.add(clrButton);
        this.add(textField);
        this.setVisible(true);
    }

    private void initializeButtons() {
        addButton = new JButton("+"); subButton = new JButton("-");
        mulButton = new JButton("*"); divButton = new JButton("/");
        decButton = new JButton("."); equButton = new JButton("=");
        delButton = new JButton("Delete"); clrButton = new JButton("Clear");

        functionButtons[0] = addButton; functionButtons[1] = subButton;
        functionButtons[2] = mulButton; functionButtons[3] = divButton;
        functionButtons[4] = decButton; functionButtons[5] = equButton;
        functionButtons[6] = delButton; functionButtons[7] = clrButton;

        for (JButton btn : functionButtons) {
            btn.setFont(myFont);
            btn.setFocusable(false);
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setForeground(Color.BLACK);
        }

        equButton.setBackground(Color.darkGray);
        equButton.setForeground(Color.WHITE);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].setForeground(Color.BLACK);
        }

        delButton.setBounds(15, 110, 185, 50);
        clrButton.setBounds(210, 110, 185, 50);
    }

    private void setupPanel() {
        panel = new JPanel();
        panel.setBounds(15, 170, 380, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);
        this.getContentPane().setBackground(Color.GRAY);

        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(equButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(decButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);
        
    }
}
