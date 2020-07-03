package View;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;
import interfaces.CommonCallBack;

public class LoginView extends JFrame implements CommonCallBack {

	private JTextField usernameField;
	private JTextField passwordField;
	JLabel usernameLabel, passwordLabel;
	JButton button;
	private LoginController controller;

	public LoginView(LoginController controller) {
		setResizable(false);

		// Putting the reference of the controller in the local reference
		this.controller = controller;

		// We encapsulated the building process of the window
		attributesSetter();
		components();
		validation();
	}

	private void attributesSetter() {
		this.setVisible(true);
		this.setBounds(100, 100, 376, 257);
		this.setTitle("Login");
	}

	// Organising components
	private void components() {
		JPanel p = new JPanel();
		p.setLayout(null);
		getContentPane().add(p);

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(100, 11, 80, 30);

		usernameField = new JTextField();
		usernameField.setBounds(100, 30, 200, 30);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(100, 81, 80, 30);

		passwordField = new JTextField();
		passwordField.setBounds(96, 106, 200, 30);

		JButton button = new JButton("Login");
		button.setBounds(216, 147, 80, 30);
		button.addActionListener((ActionListener) controller);
		button.setActionCommand("b");

		p.add(usernameLabel);
		p.add(usernameField);
		p.add(passwordLabel);
		p.add(passwordField);
		p.add(button);

	}

	private void validation() {
		this.validate();
		this.repaint();
	}

	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return passwordField.getText();
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JTextField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}

	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public LoginController getController() {
		return controller;
	}

	public void setController(LoginController controller) {
		this.controller = controller;
	}

	@Override
	public void onGetSucces() {
		JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.");

	}

	@Override
	public void onGetFailed(String message) {
		JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.");
	}

	@Override
	public void onGetError(String error) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}
}
