package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CurrencyConverter;

/**
 * Michala Ouverson - mmouverson1
 * CIS171 <21708>
 * Apr 28, 2024
 */
public class ConverterPanel extends JPanel{

	private JLabel title = new JLabel("   ~~ Currency Converter ~~   ");
	
	private JLabel dollarText;
	private JTextField dollarField = new JTextField(5);
	
	private JLabel euroText = new JLabel("        To Euro: ");
	private JTextField euroField = new JTextField(5);
	
	private JLabel gbpText = new JLabel("To British Pounds: ");
	private JTextField gbpField = new JTextField(5);
	
	private JButton calculateButton = new JButton("Calculate");
	private JButton clearButton = new JButton("Clear");
	
	DecimalFormat df = new DecimalFormat("###.00");
	
	public ConverterPanel() {
		super();
		add(title);
		dollarText = new JLabel("Convert to US Dollar: ");
		
		add(dollarText);
		add(dollarField);
		
		add(euroText);
		add(euroField);
		
		add(gbpText);
		add(gbpField);
		
		CalculateButtonListener calcButtonListener = new CalculateButtonListener();
		calculateButton.addActionListener(calcButtonListener);
		
		ClearButtonListener clearButtonListener = new ClearButtonListener();
		clearButton.addActionListener(clearButtonListener);
		
		add(calculateButton);
		add(clearButton);
		
	}
	
	
	class CalculateButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
			double amt = Double.parseDouble(dollarField.getText());
			CurrencyConverter cc = new CurrencyConverter(amt);
			
			euroField.setText(df.format(cc.getEuros()) + "\u20AC");
			gbpField.setText(df.format(cc.getBritishPounds()) + "\u00A3");
			}
			catch (NumberFormatException ex) {
				resetFields();
			}
			
		}
		
	}
	
	class ClearButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			resetFields();
			
		}
		
	}
	
	public void resetFields() {
		dollarField.setText("");
		euroField.setText("");
		gbpField.setText("");
	}
}
