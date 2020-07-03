package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DataAccess.ArtDao;
import DataAccess.CustomersDao;
import Entities.Customers;
import View.CustomerProfileView;
import View.LoginView;
import model.ArtsPieceModel;

public class CustomerProfileController implements ActionListener{
	
	private CustomerProfileView view;
	private ArtsPieceModel model;
	private CustomersDao dao;
	private LoginView loginView;
	private LoginController loginController;

	public CustomerProfileController() {
		model = new ArtsPieceModel();
		dao = new CustomersDao();
		//model.setArtPieces(dao.getArtPieces());
		view = new CustomerProfileView(this);
		//dao.getActiveUser(user);
	}	

	
	public CustomerProfileController(Customers user) {
		view = new CustomerProfileView(this, user);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
