package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import controller.CustomerHomeController;
import model.UserModel;

public class AdminHomeView extends JFrame {

	private JPanel panel;
	private JButton profileButton,logoutButton,manageadminsButton,manageusersButton,manageartistsButton,manageartsButton;
	private CustomerHomeController controller;
	private UserModel userModel;

	public AdminHomeView(CustomerHomeController controller, UserModel userModel) {
		setResizable(false);
		
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.userModel = userModel;
		attributesSetter();
		components();
		//validation();
	}
	
	private void attributesSetter() {
		this.setVisible(true);
		this.setBounds(100, 100, 800, 450);
		this.setTitle("Gallery");
		
	}
	
	private void components() {
		getContentPane().setLayout(null);
		
		JPanel p = new JPanel();
		p.setBounds(0, 0, 784, 411);
		p.setLayout(null);
		getContentPane().add(p);
		
		profileButton = new JButton("Profile");
		profileButton.setBounds(575, 11, 100, 23);
		p.add(profileButton);
		profileButton.setText(userModel.getUserName());
		
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(685, 11, 89, 23);
		p.add(logoutButton);
		
		panel = new JPanel();
		panel.setBounds(96, 90, 378, 125);
		p.add(panel);
		panel.setLayout(null);
		
		
		manageadminsButton = new JButton("Manage Admins");
		manageadminsButton.setBounds(0, 11, 140, 23);
		panel.add(manageadminsButton);
		manageadminsButton.addActionListener((ActionListener) controller);
		manageadminsButton.setActionCommand("mAdmin");
		
				
				manageusersButton = new JButton("Manage Users");
				manageusersButton.setBounds(228, 11, 140, 23);
				panel.add(manageusersButton);
				manageusersButton.addActionListener((ActionListener) controller);
				manageusersButton.setActionCommand("mUser");
				
				manageartistsButton = new JButton("Manage Artists");
				manageartistsButton.setBounds(228, 91, 140, 23);
				panel.add(manageartistsButton);
				manageartistsButton.addActionListener((ActionListener) controller);
				manageartistsButton.setActionCommand("mArtists");
				
				manageartsButton = new JButton("Manage Arts");
				manageartsButton.setBounds(0, 91, 140, 23);
				panel.add(manageartsButton);
				manageartsButton.addActionListener((ActionListener) controller);
				manageartsButton.setActionCommand("mArts");
		
	}
	
	private void validation() {
		this.validate();
		this.repaint();
	}

}
