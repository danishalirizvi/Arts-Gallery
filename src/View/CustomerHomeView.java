package View;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import Entities.Customers;
import controller.CustomerHomeController;
import controller.GalleryHomeController;
import model.ArtsPieceModel;
import net.proteanit.sql.DbUtils;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class CustomerHomeView extends JFrame {

	private JPanel panel;
	private JLabel galleryLabel;
	private JButton profileButton,searchButton;
	private JTextField searchField;
	private JRadioButton artRadio,artistRadio,typeRadio;
	private JScrollPane scrollPane;
	private JTable table;
	private ArtsPieceModel model;
	private ButtonGroup radioButtonGroup;
	private CustomerHomeController controller;

	public CustomerHomeView(CustomerHomeController controller, ArtsPieceModel model) {
		setResizable(false);
		
		this.controller = controller;
		this.model = model;
		attributesSetter();
		components();
		validation();
	}
	
	private void attributesSetter() {
		this.setVisible(true);
		this.setBounds(100, 100, 800, 450);
		this.setTitle("Gallery");
	}

	private void components() {
		
		JPanel p = new JPanel();
		p.setLayout(null);
		getContentPane().add(p);
		
		galleryLabel = new JLabel("Gallery");
		galleryLabel.setBounds(10, 11, 46, 14);
		p.add(galleryLabel);
		
		panel = new JPanel();
		panel.setBounds(10, 43, 309, 76);
		p.add(panel);
		panel.setLayout(null);
		
		artRadio = new JRadioButton("Art");
		artRadio.setBounds(0, 26, 73, 23);
		panel.add(artRadio);
		
		typeRadio = new JRadioButton("Type");
		typeRadio.setBounds(0, 7, 73, 23);
		panel.add(typeRadio);
		
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(artRadio);
		radioButtonGroup.add(typeRadio);
		
		artistRadio = new JRadioButton("Artist");
		artistRadio.setBounds(0, 48, 73, 23);
		panel.add(artistRadio);
		radioButtonGroup.add(artistRadio);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 764, 282);
		p.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(DbUtils.resultSetToTableModel(model.getArtPieces()));
		
		profileButton = new JButton("Profile");
		profileButton.setBounds(694, 11, 80, 23);
		p.add(profileButton);
		profileButton.addActionListener((ActionListener) controller);
		profileButton.setActionCommand("profile");
		
		searchField = new JTextField();
		searchField.setBounds(10, 24, 309, 20);
		p.add(searchField);
		searchField.setColumns(10);
		
				searchButton = new JButton("Search");
				searchButton.setBounds(329, 23, 78, 23);
				p.add(searchButton);
				searchButton.addActionListener((ActionListener) controller);
				searchButton.setActionCommand("search");
	}
	
	public int radioSelected() {
		if(artRadio.isSelected()) {
			return 1;
		}
		else if(artistRadio.isSelected()){
			return 2;
		}
		else {
			return 3;
		}
	}
	
	private void validation() {
		this.validate();
		this.repaint();
	}

	public JPanel getPanel_1() {
		return panel;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel = panel_1;
	}

	public JLabel getGalleryLabel() {
		return galleryLabel;
	}

	public void setGalleryLabel(JLabel galleryLabel) {
		this.galleryLabel = galleryLabel;
	}

	public JButton getProfileButton() {
		return profileButton;
	}

	public void setProfileButton(JButton profileButton) {
		this.profileButton = profileButton;
	}


	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}

	public JRadioButton getArtRadio() {
		return artRadio;
	}

	public void setArtRadio(JRadioButton artRadio) {
		this.artRadio = artRadio;
	}

	public JRadioButton getArtistRadio() {
		return artistRadio;
	}

	public void setArtistRadio(JRadioButton artistRadio) {
		this.artistRadio = artistRadio;
	}

	public JRadioButton getTypeRadio() {
		return typeRadio;
	}

	public void setTypeRadio(JRadioButton typeRadio) {
		this.typeRadio = typeRadio;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ArtsPieceModel getModel() {
		return model;
	}

	public void setModel(ArtsPieceModel model) {
		this.model = model;
	}

	public ButtonGroup getRadioButtonGroup() {
		return radioButtonGroup;
	}

	public void setRadioButtonGroup(ButtonGroup radioButtonGroup) {
		this.radioButtonGroup = radioButtonGroup;
	}

	public CustomerHomeController getController() {
		return controller;
	}

	public void setController(CustomerHomeController controller) {
		this.controller = controller;
	}
	
	
}
