import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Calculator2 implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons2 = new JButton[10];
    JButton[] operationButtons2 = new JButton[8];
    JButton addButton2, subButton2, multButton2, divButton2;
    JButton equButton2, decButton2, delButton2, clrButton2;
    JPanel panel;
    Font myFont = new Font("ink free", Font.PLAIN, 25);
    double num1 = 0, num2 = 0, result = 0;
    char operators;

    Calculator2() {

        frame = new JFrame("Wilson Demo Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);


        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(50, 25, 300, 50);
        textField.setVisible(true);
        textField.setBackground(Color.LIGHT_GRAY);

        addButton2 = new JButton("+");
        subButton2 = new JButton("-");
        multButton2 = new JButton("*");
        divButton2 = new JButton("/");
        decButton2 = new JButton(".");
        equButton2 = new JButton("=");
        delButton2 = new JButton("DELETE");
        clrButton2 = new JButton("CLEAR");

        operationButtons2[0] = addButton2;
        operationButtons2[1] = subButton2;
        operationButtons2[2] = multButton2;
        operationButtons2[3] = divButton2;
        operationButtons2[4] = equButton2;
        operationButtons2[5] = decButton2;
        operationButtons2[6] = delButton2;
        operationButtons2[7] = clrButton2;

        for (int i = 0; i < 8; i++) {
            operationButtons2[i].addActionListener(this);
            operationButtons2[i].setFont(myFont);
            operationButtons2[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons2[i] = new JButton(String.valueOf(i));
            numberButtons2[i].addActionListener(this);
            numberButtons2[i].setFocusable(false);
        }

        delButton2.setBounds(50, 430, 145, 50);
        clrButton2.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setBounds(50, 100, 300, 301);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setFocusable(true);

        panel.add(numberButtons2[1]);
        panel.add(numberButtons2[2]);
        panel.add(numberButtons2[3]);
        panel.add(addButton2);
        panel.add(numberButtons2[4]);
        panel.add(numberButtons2[5]);
        panel.add(numberButtons2[6]);
        panel.add(subButton2);
        panel.add(numberButtons2[7]);
        panel.add(numberButtons2[8]);
        panel.add(numberButtons2[9]);
        panel.add(multButton2);
        panel.add(decButton2);
        panel.add(numberButtons2[0]);
        panel.add(equButton2);
        panel.add(divButton2);


        frame.add(textField);
        frame.add(delButton2);
        frame.add(clrButton2);
        frame.add(panel);
    }


    public static void main(String[] args) {

        Calculator2 calculator2 = new Calculator2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons2[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                textField.setFont(myFont);
            }
        }

        if (e.getSource() == decButton2) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton2) {
            num1 = Double.parseDouble(textField.getText());
            operators = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton2) {
            num1 = Double.parseDouble(textField.getText());
            operators = '-';
            textField.setText("");
        }
        if (e.getSource() == multButton2) {
            num1 = Double.parseDouble(textField.getText());
            operators = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton2) {
            num1 = Double.parseDouble(textField.getText());
            operators = '/';
            textField.setText("");
        }

        if (e.getSource() == equButton2) {
            num2 = Double.parseDouble(textField.getText());

            switch (operators) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

            if (e.getSource() == clrButton2) {
                textField.setText("");
            }

            if (e.getSource() == delButton2) {
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textField.setText(textField.getText() + string.charAt(i));
                }
            }

        }



}

