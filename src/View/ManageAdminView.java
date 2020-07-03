package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import controller.CustomerHomeController;
import model.UserModel;
import net.proteanit.sql.DbUtils;

public class ManageAdminView extends JFrame {

	private JPanel formPanel,buttonPanel;
	private JTable table;
	private JTextField firstnameField,surnameField,emailField,usernameField,passwordField,addressField;
	private JLabel galleryLabel,firstnameLabel,surnameLabel,usernameLabel,emailLabel,addressLabel,passwordLabel;
	private JButton logoutButton,backButton;
	private JButton profileButton;
	private CustomerHomeController controller;
	private UserModel userModel;
	
	public ManageAdminView() {
		setResizable(false);
		
		
	}

	public ManageAdminView(CustomerHomeController controller, UserModel userModel) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.userModel = userModel;
		
		attributesSetter();
		components();
		validation();
	}

	private void attributesSetter() {
		this.setVisible(true);
		this.setBounds(100, 100, 800, 450);
		this.setTitle("Admins");
	}
	
	private void components() {
		JPanel p = new JPanel();
		p.setLayout(null);
		getContentPane().add(p);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 719, 175);
		p.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		galleryLabel = new JLabel("Gallery");
		galleryLabel.setBounds(310, 11, 46, 14);
		p.add(galleryLabel);

		backButton = new JButton("Back");
		backButton.setBounds(10, 11, 65, 23);
		p.add(backButton);

		formPanel = new JPanel();
		formPanel.setBounds(23, 62, 516, 104);
		p.add(formPanel);
		formPanel.setLayout(null);

		firstnameLabel = new JLabel("First Name");
		firstnameLabel.setBounds(12, 14, 57, 14);
		formPanel.add(firstnameLabel);

		firstnameField = new JTextField();
		firstnameField.setBounds(98, 11, 136, 20);
		formPanel.add(firstnameField);
		firstnameField.setColumns(10);

		surnameLabel = new JLabel("Sur Name");
		surnameLabel.setBounds(10, 39, 57, 14);
		formPanel.add(surnameLabel);

		surnameField = new JTextField();
		surnameField.setBounds(98, 36, 136, 20);
		formPanel.add(surnameField);
		surnameField.setColumns(10);

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 64, 57, 14);
		formPanel.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setBounds(98, 64, 136, 20);
		formPanel.add(usernameField);
		usernameField.setColumns(10);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(264, 14, 57, 14);
		formPanel.add(emailLabel);

		emailField = new JTextField();
		emailField.setBounds(346, 11, 136, 20);
		formPanel.add(emailField);
		emailField.setColumns(10);

		addressField = new JTextField();
		addressField.setBounds(347, 61, 135, 20);
		formPanel.add(addressField);
		addressField.setColumns(10);

		addressLabel = new JLabel("Address");
		addressLabel.setBounds(264, 64, 73, 14);
		formPanel.add(addressLabel);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(264, 39, 57, 14);
		formPanel.add(passwordLabel);

		passwordField = new JTextField();
		passwordField.setBounds(346, 36, 136, 20);
		formPanel.add(passwordField);
		passwordField.setColumns(10);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(597, 55, 89, 125);
		p.add(buttonPanel);
		buttonPanel.setLayout(null);

		JButton addButton = new JButton("Add");
		addButton.setBounds(0, 0, 89, 23);
		buttonPanel.add(addButton);
		addButton.addActionListener((ActionListener) controller);
		addButton.setActionCommand("adminAddButton");
		

		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(0, 34, 89, 23);
		buttonPanel.add(deleteButton);
		deleteButton.addActionListener((ActionListener) controller);
		deleteButton.setActionCommand("adminDeleteButton");

		JButton updateButton = new JButton("Update");
		updateButton.setBounds(0, 68, 89, 23);
		buttonPanel.add(updateButton);
		updateButton.addActionListener((ActionListener) controller);
		updateButton.setActionCommand("adminUpdateButton");

		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(0, 102, 89, 23);
		buttonPanel.add(resetButton);
		resetButton.addActionListener((ActionListener) controller);
		resetButton.setActionCommand("adminResetButton");


		JButton updatetableButton = new JButton("Update Table");
		updatetableButton.setBounds(310, 189, 97, 23);
		p.add(updatetableButton);
		
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(685, 11, 89, 23);
		p.add(logoutButton);
		
		profileButton = new JButton("Profile");
		profileButton.setBounds(586, 11, 89, 23);
		p.add(profileButton);
		profileButton.addActionListener((ActionListener) controller);
		profileButton.setActionCommand("profileButton");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(DbUtils.resultSetToTableModel(userModel.getResult()));
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				firstnameField.setText(model.getValueAt(index, 1).toString());
				surnameField.setText(model.getValueAt(index, 2).toString());
				emailField.setText(model.getValueAt(index, 3).toString());
				usernameField.setText(model.getValueAt(index, 4).toString());
				passwordField.setText(model.getValueAt(index, 5).toString());
				addressField.setText(model.getValueAt(index, 6).toString());
			}
		});
		
	}
	
	public JPanel getFormPanel() {
		return formPanel;
	}

	public void setFormPanel(JPanel formPanel) {
		this.formPanel = formPanel;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getFirstnameField() {
		return firstnameField;
	}

	public void setFirstnameField(JTextField firstnameField) {
		this.firstnameField = firstnameField;
	}

	public JTextField getSurnameField() {
		return surnameField;
	}

	public void setSurnameField(JTextField surnameField) {
		this.surnameField = surnameField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
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

	public JTextField getAddressField() {
		return addressField;
	}

	public void setAddressField(JTextField addressField) {
		this.addressField = addressField;
	}

	public JLabel getGalleryLabel() {
		return galleryLabel;
	}

	public void setGalleryLabel(JLabel galleryLabel) {
		this.galleryLabel = galleryLabel;
	}

	public JLabel getFirstnameLabel() {
		return firstnameLabel;
	}

	public void setFirstnameLabel(JLabel firstnameLabel) {
		this.firstnameLabel = firstnameLabel;
	}

	public JLabel getSurnameLabel() {
		return surnameLabel;
	}

	public void setSurnameLabel(JLabel surnameLabel) {
		this.surnameLabel = surnameLabel;
	}

	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}

	public JLabel getAddressLabel() {
		return addressLabel;
	}

	public void setAddressLabel(JLabel addressLabel) {
		this.addressLabel = addressLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JButton getProfileButton() {
		return profileButton;
	}

	public void setProfileButton(JButton profileButton) {
		this.profileButton = profileButton;
	}

	public CustomerHomeController getController() {
		return controller;
	}

	public void setController(CustomerHomeController controller) {
		this.controller = controller;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	private void validation() {
		this.validate();
		this.repaint();
	}

}
