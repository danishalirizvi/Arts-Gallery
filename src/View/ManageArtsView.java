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

public class ManageArtsView extends JFrame {

	private JPanel formPanel, buttonPanel;
	private JTable table;
	private JTextField titleField, artistField, typeField;
	private JLabel titleLabel, artistLabel, typeLabel;
	private JButton logoutButton, addButton, deleteButton, updateButton, resetButton, updatetableButton;
	private JButton profileButton;
	private CustomerHomeController controller;
	private UserModel userModel;

	public ManageArtsView() {
		setResizable(false);

		attributesSetter();
		components();
		validation();
	}

	public ManageArtsView(CustomerHomeController controller, UserModel userModel) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.userModel = userModel;
		
		attributesSetter();
		components();
		validation();
	}

	private void attributesSetter() {
		this.setVisible(true);
		this.setBounds(100, 100, 800, 378);
		this.setTitle("Arts");
	}

	private void components() {
		JPanel p = new JPanel();
		p.setLayout(null);
		getContentPane().add(p);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 764, 175);
		p.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		formPanel = new JPanel();
		formPanel.setBounds(10, 45, 261, 104);
		p.add(formPanel);
		formPanel.setLayout(null);

		titleLabel = new JLabel("Title");
		titleLabel.setBounds(12, 14, 57, 14);
		formPanel.add(titleLabel);

		titleField = new JTextField();
		titleField.setBounds(98, 11, 136, 20);
		formPanel.add(titleField);
		titleField.setColumns(10);

		artistLabel = new JLabel("Artist");
		artistLabel.setBounds(10, 39, 57, 14);
		formPanel.add(artistLabel);

		artistField = new JTextField();
		artistField.setBounds(98, 36, 136, 20);
		formPanel.add(artistField);
		artistField.setColumns(10);

		typeLabel = new JLabel("Type");
		typeLabel.setBounds(10, 64, 57, 14);
		formPanel.add(typeLabel);

		typeField = new JTextField();
		typeField.setBounds(98, 64, 136, 20);
		formPanel.add(typeField);
		typeField.setColumns(10);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(281, 45, 272, 104);
		p.add(buttonPanel);
		buttonPanel.setLayout(null);

		addButton = new JButton("Add");
		addButton.setBounds(0, 0, 89, 23);
		buttonPanel.add(addButton);
		addButton.addActionListener((ActionListener) controller);
		addButton.setActionCommand("artsAddButton");

		deleteButton = new JButton("Delete");
		deleteButton.setBounds(146, 0, 89, 23);
		buttonPanel.add(deleteButton);
		deleteButton.addActionListener((ActionListener) controller);
		deleteButton.setActionCommand("artsDeleteButton");

		updateButton = new JButton("Update");
		updateButton.setBounds(146, 70, 89, 23);
		buttonPanel.add(updateButton);
		updateButton.addActionListener((ActionListener) controller);
		updateButton.setActionCommand("artsUpdateButton");


		resetButton = new JButton("Reset");
		resetButton.setBounds(0, 70, 89, 23);
		buttonPanel.add(resetButton);
		resetButton.addActionListener((ActionListener) controller);
		resetButton.setActionCommand("artsResetButton");

		updatetableButton = new JButton("Update Table");
		updatetableButton.setBounds(174, 23, 97, 23);
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
				titleField.setText(model.getValueAt(index, 1).toString());
				artistField.setText(model.getValueAt(index, 2).toString());
				typeField.setText(model.getValueAt(index, 3).toString());
				
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

	public JTextField getTitleField() {
		return titleField;
	}

	public void setTitleField(JTextField titleField) {
		this.titleField = titleField;
	}

	public JTextField getArtistField() {
		return artistField;
	}

	public void setArtistField(JTextField artistField) {
		this.artistField = artistField;
	}

	public JTextField getTypeField() {
		return typeField;
	}

	public void setTypeField(JTextField typeField) {
		this.typeField = typeField;
	}


	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JLabel getArtistLabel() {
		return artistLabel;
	}

	public void setArtistLabel(JLabel artistLabel) {
		this.artistLabel = artistLabel;
	}

	public JLabel getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(JLabel typeLabel) {
		this.typeLabel = typeLabel;
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