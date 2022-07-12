
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[13];

	JButton addButton, subButton, divButton, mulButton;
	JButton equButton, decButton, delButton, clrButton, negButton, squareButton, mulinvButton, modulusButton,
			sqrtButton;

	JPanel panel;

	Double num1, num2, result;
	char operator;

	Font font = new Font("San Serif", Font.BOLD, 25);

	Calculator() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 460);
		frame.getContentPane().setBackground(Color.decode("#595959"));

		frame.setLayout(null);

		textfield = new JTextField();
		textfield.setBounds(0, 0, 340, 70);
		textfield.setFont(new Font("San Serif", Font.PLAIN, 40));
		textfield.setBackground(Color.decode("#D9D8D8"));
		textfield.setForeground(Color.decode("#999999"));
		textfield.setEditable(false);
		textfield.setBorder(
				BorderFactory.createCompoundBorder(textfield.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		addButton = new JButton("+");
		subButton = new JButton("-");
		divButton = new JButton("/");
		mulButton = new JButton("x");
		equButton = new JButton("=");
		decButton = new JButton(".");
		delButton = new JButton("DEL");
		clrButton = new JButton("CLR");
		negButton = new JButton("+/-");
		squareButton = new JButton("X2");
		mulinvButton = new JButton("1/X");
		modulusButton = new JButton("%");
		sqrtButton = new JButton("sr");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = divButton;
		functionButtons[3] = mulButton;
		functionButtons[4] = equButton;
		functionButtons[5] = decButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = squareButton;
		functionButtons[10] = mulinvButton;
		functionButtons[11] = modulusButton;
		functionButtons[12] = sqrtButton;

		for (int i = 0; i < 13; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(font);
			functionButtons[i].setForeground(Color.WHITE);
			functionButtons[i].setBackground(Color.decode("#BF3C30"));
			functionButtons[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font);
			numberButtons[i].setForeground(Color.WHITE);
			numberButtons[i].setBackground(Color.decode("#5375CF"));
			numberButtons[i].setFocusable(false);
		}

		negButton.setBounds(0, 370, 116, 50);
		clrButton.setBounds(116, 370, 116, 50);
		delButton.setBounds(232, 370, 116, 50);

		panel = new JPanel();
		panel.setBounds(0, 70, 340, 300);
		panel.setLayout(new GridLayout(5, 4, 0, 0));
		panel.setBackground(Color.decode("#595959"));

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);

		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(divButton);

		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(mulButton);
		panel.add(squareButton);
		panel.add(mulinvButton);
		panel.add(modulusButton);
		panel.add(sqrtButton);

		frame.add(textfield);
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {

			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}

		}

		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}

		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = 'X';
			textfield.setText("");
		}
		if (e.getSource() == modulusButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '%';
			textfield.setText("");
		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			case 'x':
				result = num1 * num2;
				break;
			case '%':
				result = num1 % num2;
			}

			textfield.setText(String.valueOf(result));
			checklength();
		}
		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		if (e.getSource() == delButton) {
			String strng = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < strng.length() - 1; i++) {
				textfield.setText(textfield.getText() + strng.charAt(i));
			}
		}

		if (e.getSource() == negButton) {
			if (textfield.getText().length() > 0) {
				Double val = Double.parseDouble(textfield.getText());
				val *= -1;
				textfield.setText(String.valueOf(val));
			}
		}
		if (e.getSource() == squareButton) {
			Double square = Double.parseDouble(textfield.getText());
			square *= square;
			textfield.setText(String.valueOf(square));
			checklength();
		}
		if (e.getSource() == mulinvButton) {
			Double mulinv = Double.parseDouble(textfield.getText());
			mulinv = 1 / mulinv;
			textfield.setText(String.valueOf(mulinv));
			checklength();
		}
		if (e.getSource() == sqrtButton) {
			Double sqrt = Double.parseDouble(textfield.getText());
			sqrt = Math.sqrt(sqrt);
			textfield.setText(String.valueOf(sqrt));
			checklength();
		}

	}
	
	//-----Check the length of text field----------//

	public void checklength() {
		String rslt = textfield.getText();
		int limit = 10;
		if (rslt.length() >= limit) {
			textfield.setText("");
			for (int i = 0; i < limit; i++)
				textfield.setText(textfield.getText() + rslt.charAt(i));
		}

	}
}
