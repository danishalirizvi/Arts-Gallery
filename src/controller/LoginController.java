package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DataAccess.LoginDao;
import Entities.Customers;
import View.LoginView;
import model.ArtsPieceModel;
import model.UserModel;

public class LoginController implements ActionListener {

	private LoginView loginView;
	private UserModel userModel;
	private LoginDao loginDao;
	private ArtsPieceModel artpieceModel;
	private Customers user;
	
	public LoginController() {
		userModel = new UserModel();
		loginDao = new LoginDao();
		artpieceModel = new ArtsPieceModel();
		loginView = new LoginView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// When the button is clicked...
		if (e.getActionCommand().equals("b")) {
			userModel = new UserModel();
			userModel.setUserName(loginView.getUsername());
			userModel.setPassword(loginView.getPassword());
			
			user = loginDao.UserLogin(userModel);
			if (user != null) 
			{
				if (user.Admin_Check == 2) {
					userModel.setUser(user);
					new CustomerHomeController(userModel);
				} 
				else 
				{
					artpieceModel.setUser(user);
					new CustomerHomeController(artpieceModel);
				}
			} 
			else {
				loginView.onGetFailed("Error");
			}
		}
	}
}
