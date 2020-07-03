package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.CustomerHomeController;
import model.UserModel;
import net.proteanit.sql.DbUtils;

	public class ManageArtistsView extends JFrame {

		private JPanel formPanel,buttonPanel;
		private JTable table;
		private JTextField firstnameField,surnameField,websiteField,addressField;
		private JLabel firstnameLabel,surnameLabel,websiteLabel,addressLabel;
		private JButton logoutButton,addButton,deleteButton,updateButton,resetButton,updatetableButton;
		private JButton profileButton;
		private CustomerHomeController controller;
		private UserModel userModel;

		public ManageArtistsView(CustomerHomeController controller, UserModel userModel) {
			setResizable(false);
			// TODO Auto-generated constructor stub
			this.controller = controller;
			this.userModel = userModel;
			
			attributesSetter();
			components();
			validation();
		}

		private void attributesSetter() {
			this.setVisible(true);
			this.setBounds(100, 100, 800, 366);
			this.setTitle("Artists");
		}
		
		private void components() {
			JPanel p = new JPanel();
			p.setLayout(null);
			getContentPane().add(p);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 151, 751, 175);
			p.add(scrollPane);

			table = new JTable();
			scrollPane.setViewportView(table);

			formPanel = new JPanel();
			formPanel.setBounds(22, 66, 516, 74);
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
			surnameLabel.setBounds(12, 39, 57, 14);
			formPanel.add(surnameLabel);

			surnameField = new JTextField();
			surnameField.setBounds(98, 36, 136, 20);
			formPanel.add(surnameField);
			surnameField.setColumns(10);

			websiteLabel = new JLabel("Website");
			websiteLabel.setBounds(258, 14, 57, 14);
			formPanel.add(websiteLabel);

			websiteField = new JTextField();
			websiteField.setBounds(346, 14, 136, 20);
			formPanel.add(websiteField);
			websiteField.setColumns(10);

			addressField = new JTextField();
			addressField.setBounds(347, 39, 135, 20);
			formPanel.add(addressField);
			addressField.setColumns(10);

			addressLabel = new JLabel("Address");
			addressLabel.setBounds(258, 39, 73, 14);
			formPanel.add(addressLabel);

			buttonPanel = new JPanel();
			buttonPanel.setBounds(565, 63, 208, 77);
			p.add(buttonPanel);
			buttonPanel.setLayout(null);

			addButton = new JButton("Add");
			addButton.setBounds(10, 11, 89, 23);
			buttonPanel.add(addButton);
			addButton.addActionListener((ActionListener) controller);
			addButton.setActionCommand("artistsAddButton");


			deleteButton = new JButton("Delete");
			deleteButton.setBounds(10, 45, 89, 23);
			buttonPanel.add(deleteButton);
			deleteButton.addActionListener((ActionListener) controller);
			deleteButton.setActionCommand("artistsDeleteButton");
			
			updateButton = new JButton("Update");
			updateButton.setBounds(109, 11, 89, 23);
			buttonPanel.add(updateButton);
			updateButton.addActionListener((ActionListener) controller);
			updateButton.setActionCommand("artistsUpdateButton");

			resetButton = new JButton("Reset");
			resetButton.setBounds(108, 45, 89, 23);
			buttonPanel.add(resetButton);
			resetButton.addActionListener((ActionListener) controller);
			resetButton.setActionCommand("artistsResetButton");

			updatetableButton = new JButton("Update Table");
			updatetableButton.setBounds(441, 32, 97, 23);
			p.add(updatetableButton);
			
			logoutButton = new JButton("Logout");
			logoutButton.setBounds(685, 11, 89, 23);
			p.add(logoutButton);
			
			profileButton = new JButton("Profile");
			profileButton.setBounds(586, 11, 89, 23);
			p.add(profileButton);
			

			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(DbUtils.resultSetToTableModel(userModel.getResult()));
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					TableModel model = table.getModel();
					firstnameField.setText(model.getValueAt(index, 1).toString());
					surnameField.setText(model.getValueAt(index, 2).toString());
					websiteField.setText(model.getValueAt(index, 3).toString());
					addressField.setText(model.getValueAt(index, 4).toString());					
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

		public JTextField getWebsiteField() {
			return websiteField;
		}

		public void setWebsiteField(JTextField websiteField) {
			this.websiteField = websiteField;
		}

		public JTextField getAddressField() {
			return addressField;
		}

		public void setAddressField(JTextField addressField) {
			this.addressField = addressField;
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

		public JLabel getWebsiteLabel() {
			return websiteLabel;
		}

		public void setWebsiteLabel(JLabel websiteLabel) {
			this.websiteLabel = websiteLabel;
		}

		public JLabel getAddressLabel() {
			return addressLabel;
		}

		public void setAddressLabel(JLabel addressLabel) {
			this.addressLabel = addressLabel;
		}

		public JButton getLogoutButton() {
			return logoutButton;
		}

		public void setLogoutButton(JButton logoutButton) {
			this.logoutButton = logoutButton;
		}

		public JButton getAddButton() {
			return addButton;
		}

		public void setAddButton(JButton addButton) {
			this.addButton = addButton;
		}

		public JButton getDeleteButton() {
			return deleteButton;
		}

		public void setDeleteButton(JButton deleteButton) {
			this.deleteButton = deleteButton;
		}

		public JButton getUpdateButton() {
			return updateButton;
		}

		public void setUpdateButton(JButton updateButton) {
			this.updateButton = updateButton;
		}

		public JButton getResetButton() {
			return resetButton;
		}

		public void setResetButton(JButton resetButton) {
			this.resetButton = resetButton;
		}

		public JButton getUpdatetableButton() {
			return updatetableButton;
		}

		public void setUpdatetableButton(JButton updatetableButton) {
			this.updatetableButton = updatetableButton;
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
