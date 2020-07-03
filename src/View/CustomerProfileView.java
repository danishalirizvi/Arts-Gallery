package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.Customers;
import controller.CustomerProfileController;
import controller.GalleryHomeController;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CustomerProfileView extends JFrame {

	private JPanel panel;
	private JButton homeButton, updateButton;
	private JLabel firstnameLabel, surnameLabel, emailLabel, usernameLabel, passwordLabel, addressLabel;
	private JTextField firstnameField, surnameField, usernameField, emailField, addressField, passwordField;
	private CustomerProfileController controller;

	public CustomerProfileView(CustomerProfileController controller, Customers user) {
		this.controller = controller;
		attributesSetter();
		components();
		validation();
		firstnameField.setText(user.f_name);
		surnameField.setText(user.l_name);
		usernameField.setText(user.username);
		emailField.setText(user.email);
		passwordField.setText(user.password);
		 
	}

	public CustomerProfileView(CustomerProfileController controller) {
		// TODO Auto-generated constructor stub
	}

	private void attributesSetter() {
		this.setVisible(true);
		this.setBounds(100, 100, 400, 350);
		this.setTitle("Profile");

	}

	private void components() {

		JPanel p = new JPanel();
		p.setLayout(null);
		getContentPane().add(p);

		homeButton = new JButton("Home");
		homeButton.setBounds(10, 11, 89, 23);
		p.add(homeButton);

		panel = new JPanel();
		panel.setBounds(48, 65, 280, 169);
		p.add(panel);
		panel.setLayout(null);

		firstnameLabel = new JLabel("First Name");
		firstnameLabel.setBounds(47, 14, 62, 14);
		panel.add(firstnameLabel);

		firstnameField = new JTextField();
		firstnameField.setBounds(119, 11, 151, 20);
		panel.add(firstnameField);
		firstnameField.setColumns(10);

		surnameLabel = new JLabel("Sur Name");
		surnameLabel.setBounds(47, 42, 62, 14);
		panel.add(surnameLabel);

		surnameField = new JTextField();
		surnameField.setBounds(119, 36, 151, 20);
		panel.add(surnameField);
		surnameField.setColumns(10);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(47, 67, 62, 14);
		panel.add(emailLabel);

		emailField = new JTextField();
		emailField.setBounds(119, 64, 151, 20);
		panel.add(emailField);
		emailField.setColumns(10);

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(47, 92, 62, 14);
		panel.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setBounds(119, 89, 151, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(47, 117, 62, 14);
		panel.add(passwordLabel);

		passwordField = new JTextField();
		passwordField.setBounds(119, 114, 151, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);

		addressLabel = new JLabel("Address");
		addressLabel.setBounds(47, 142, 62, 14);
		panel.add(addressLabel);

		addressField = new JTextField();
		addressField.setBounds(119, 139, 151, 20);
		panel.add(addressField);
		addressField.setColumns(10);

		updateButton = new JButton("Update");
		updateButton.setBounds(163, 267, 89, 23);
		p.add(updateButton);

	}

	private void validation() {
		this.validate();
		this.repaint();
	}

}
