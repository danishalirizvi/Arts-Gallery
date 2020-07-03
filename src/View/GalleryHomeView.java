package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.GalleryHomeController;
import model.ArtsPieceModel;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalleryHomeView extends JFrame {

	private JPanel panel,panel_1;
	private JLabel galleryLabel;
	private JButton signupButton,signinButton,searchButton;
	private JTextField searchField;
	private JRadioButton artRadio,artistRadio,typeRadio;
	private JScrollPane scrollPane;
	private JTable table;
	private ArtsPieceModel model;
	private ButtonGroup radioButtonGroup;
	private GalleryHomeController controller;

	public GalleryHomeView(GalleryHomeController controller, ArtsPieceModel model) {
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
		panel.setBounds(598, 11, 164, 23);
		p.add(panel);
		panel.setLayout(null);
		
		signupButton = new JButton("SignUp");
		signupButton.setBounds(84, 0, 80, 23);
		panel.add(signupButton);
		
		signinButton = new JButton("SignIn");
		signinButton.setBounds(0, 0, 80, 23);
		panel.add(signinButton);
		signinButton.addActionListener((ActionListener) controller);
		signinButton.setActionCommand("signin");
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 24, 309, 94);
		p.add(panel_1);
		panel_1.setLayout(null);
		
		searchField = new JTextField();
		searchField.setBounds(0, 0, 309, 19);
		panel_1.add(searchField);
		searchField.setColumns(10);
		
		artRadio = new JRadioButton("Art");
		artRadio.setBounds(0, 26, 73, 23);
		panel_1.add(artRadio);
		
		artistRadio = new JRadioButton("Artist");
		artistRadio.setBounds(0, 71, 73, 23);
		panel_1.add(artistRadio);
		
		typeRadio = new JRadioButton("Type");
		typeRadio.setBounds(0, 52, 73, 23);
		panel_1.add(typeRadio);
		
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(artRadio);
		radioButtonGroup.add(artistRadio);
		radioButtonGroup.add(typeRadio);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 764, 282);
		p.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(DbUtils.resultSetToTableModel(model.getArtPieces()));
		
				searchButton = new JButton("Search");
				searchButton.setBounds(340, 24, 78, 23);
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

	private void validation() {
		this.validate();
		this.repaint();
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JLabel getGalleryLabel() {
		return galleryLabel;
	}

	public void setGalleryLabel(JLabel galleryLabel) {
		this.galleryLabel = galleryLabel;
	}

	public JButton getSignupButton() {
		return signupButton;
	}

	public void setSignupButton(JButton signupButton) {
		this.signupButton = signupButton;
	}

	public JButton getSigninButton() {
		return signinButton;
	}

	public void setSigninButton(JButton signinButton) {
		this.signinButton = signinButton;
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

	public GalleryHomeController getController() {
		return controller;
	}

	public void setController(GalleryHomeController controller) {
		this.controller = controller;
	}

	
	
}
