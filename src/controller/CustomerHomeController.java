package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import DataAccess.ArtDao;
import DataAccess.CustomersDao;
import Entities.Art;
import Entities.Customers;
import View.AdminHomeView;
import View.CustomerHomeView;
import View.ManageAdminView;
import View.ManageArtistsView;
import View.ManageArtsView;
import View.ManageUsersView;
import javax.swing.JOptionPane;
import model.ArtsPieceModel;
import model.UserModel;
import net.proteanit.sql.DbUtils;

public class CustomerHomeController implements ActionListener {
	private CustomerHomeView view;
	private ArtDao dao;
	private CustomersDao userDao;
	private UserModel userModel;

	private ManageAdminView manageAdminView;
        private ManageArtistsView manageArtisitView;
        private ManageArtsView manageArtsView;
        
	private String fName;
	private String sName;
	private String email;
	private String address;
	private String userName;
	private String password;

	public CustomerHomeController(ArtsPieceModel model) {
		dao = new ArtDao();
		model.setArtPieces(dao.getArtPieces());
		view = new CustomerHomeView(this, model);
	}

	public CustomerHomeController(UserModel userModel) {
		this.userModel = userModel;
		this.userDao = new CustomersDao();
		new AdminHomeView(this, userModel);
	}

	public CustomerHomeController(UserModel userModel, String viewType) {
		this.userDao = new CustomersDao();
		this.userModel = userModel;
		if (viewType == "adminView") {
			manageAdminView = new ManageAdminView(this, userModel);
		} else if (viewType == "artistsView") {
			manageArtisitView=new ManageArtistsView(this, userModel);
		} else if (viewType == "artsView") {
			manageArtsView=new ManageArtsView(this, userModel);
		} else if (viewType == "usersView") {
			new ManageUsersView(this, userModel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("search")) {
			String searchText = view.getSearchField().getText();
			int choice = view.radioSelected();
			view.getTable().setModel(DbUtils.resultSetToTableModel(dao.getSearchResults(choice, searchText)));

		} else if (e.getActionCommand().equals("profile")) {
			new CustomerProfileController(view.getModel().getUser());
		}

		// mAdmin, mUser, mArtists, mArts
		else if (e.getActionCommand().equals("mAdmin")) {
			System.out.print("admin");
			ResultSet result = userDao.getAdmins();
			userModel.setResult(result);
			new CustomerHomeController(userModel, "adminView");
		}

		else if (e.getActionCommand().equals("mUser")) {
			System.out.print("mUser");
			ResultSet result = userDao.getUsers();
			userModel.setResult(result);
			new CustomerHomeController(userModel, "usersView");
		}

		else if (e.getActionCommand().equals("mArtists")) {
			System.out.print("mArtists");

			ResultSet result = userDao.getArtists();
			userModel.setResult(result);
			new CustomerHomeController(userModel, "artistsView");
		}

		else if (e.getActionCommand().equals("mArts")) {
			System.out.print("mArts");

			ResultSet result = userDao.getArts();
			userModel.setResult(result);
			new CustomerHomeController(userModel, "artsView");		
		}	
		
		else if (e.getActionCommand().equals("adminAddButton")) {
			fName = this.manageAdminView.getFirstnameField().getText();
			sName = this.manageAdminView.getSurnameField().getText();			
			email = this.manageAdminView.getEmailField().getText();
			address = this.manageAdminView.getAddressField().getText();			
			userName = this.manageAdminView.getUsernameField().getText();
			password = this.manageAdminView.getPasswordField().getText();
			Customers user = new Customers(1,fName, sName, userName, email, password, address, ""
                        ,"","","","",2,"");
						 
			ResultSet result = userDao.InsertUsers(user);
			//userModel.setResult(result);			
			//new CustomerHomeController(userModel, "adminView");			
			this.manageAdminView.getTable().setModel(DbUtils.resultSetToTableModel(result));
		} 
		else if (e.getActionCommand().equals("adminDeleteButton")) {
			userName = this.manageAdminView.getUsernameField().getText();
                        System.out.println(userName);
			ResultSet result = userDao.DeleteUsers(userName, 2);
			this.manageAdminView.getTable().setModel(DbUtils.resultSetToTableModel(result));
		} 
		else if (e.getActionCommand().equals("adminUpdateButton")) {
			fName = this.manageAdminView.getFirstnameField().getText();
			sName = this.manageAdminView.getSurnameField().getText();			
			email = this.manageAdminView.getEmailField().getText();
			address = this.manageAdminView.getAddressField().getText();			
			userName = this.manageAdminView.getUsernameField().getText();
			password = this.manageAdminView.getPasswordField().getText();
			Customers user = new Customers(1,fName, sName, userName, email, password, "", "","","","","",2,"");
						 
			ResultSet result = userDao.UpdateUser(user);
			this.manageAdminView.getTable().setModel(DbUtils.resultSetToTableModel(result));
			
		} 
		else if (e.getActionCommand().equals("adminResetButton")) {
			this.manageAdminView.getFirstnameField().setText(null);
			this.manageAdminView.getSurnameField().setText(null);
			this.manageAdminView.getEmailField().setText(null);
			this.manageAdminView.getAddressField().setText(null);
			this.manageAdminView.getUsernameField().setText(null);
			this.manageAdminView.getPasswordField().setText(null);
		}

		else if (e.getActionCommand().equals("artistsAddButton")) {
			fName = this.manageArtisitView.getFirstnameField().getText();
			sName = this.manageArtisitView.getSurnameField().getText();			
			email = fName+sName+"@live.com";
			address = this.manageArtisitView.getAddressField().getText();			
			userName = fName+" "+sName;
			password = "123";
			Customers user = new Customers(1,fName, sName, userName, email, password, address, ""
                        ,"","","","",0,"");
						 
			ResultSet result = userDao.InsertUsers(user);
			//userModel.setResult(result);			
			//new CustomerHomeController(userModel, "adminView");			
			this.manageArtisitView.getTable().setModel(DbUtils.resultSetToTableModel(result));
		}
		else if (e.getActionCommand().equals("artistsDeleteButton")) {
                    userName = this.manageArtisitView.getTable().getValueAt(manageArtisitView.getTable().getSelectedRow(), 4).toString();


                        System.out.println(userName);
			ResultSet result = userDao.DeleteArtist(userName, 0);
			this.manageArtisitView.getTable().setModel(DbUtils.resultSetToTableModel(result));
		}
		else if (e.getActionCommand().equals("artistsUpdateButton")) {
                   fName = this.manageArtisitView.getFirstnameField().getText();
			sName = this.manageArtisitView.getSurnameField().getText();			
			email = fName+sName+"@live.com";
			address = this.manageArtisitView.getAddressField().getText();			
			userName = fName+" "+sName;
			password = "123";
			Customers user = new Customers(1,fName, sName, userName, email, password, address, ""
                        ,"","","","",0,"");	 
			ResultSet result = userDao.UpdateUser(user);
			this.manageArtisitView.getTable().setModel(DbUtils.resultSetToTableModel(result));
		}
		else if (e.getActionCommand().equals("artistsResetButton")) {
                    this.manageArtisitView.getFirstnameField().setText(null);
			this.manageArtisitView.getSurnameField().setText(null);
			this.manageArtisitView.getAddressField().setText(null);
                        this.manageArtisitView.getWebsiteField().setText(null);
		}

		else if (e.getActionCommand().equals("artsAddButton")) {
			String artName = this.manageArtsView.getTitleField().getText();
			int artistId = 1;			
			String type = this.manageArtsView.getTypeField().getText();
                        String description = "descriipton";
                        
			Art art = new Art(1,artName, artistId,type, description);
			ResultSet result = userDao.insertArt(art);
			userModel.setResult(result);			
			new CustomerHomeController(userModel, "artsView");
		}
		else if (e.getActionCommand().equals("artsDeleteButton")) {
                  String artName = this.manageArtsView.getTitleField().getText();
			int artistId = 1;			
			String type = this.manageArtsView.getTypeField().getText();
                        String description = "descriipton";
                        
			Art art = new Art(1,artName, artistId,type, description);
			ResultSet result = userDao.deleteArt(art,""+ manageArtsView.getTable().getValueAt(manageArtsView.getTable().getSelectedRow(), 0));
			this.manageArtsView.getTable().setModel(DbUtils.resultSetToTableModel(result));
		}
		else if (e.getActionCommand().equals("artsUpdateButton")) {
                    JOptionPane.showMessageDialog(null, "Left incomplete... Reason: short of time");
		}
		else if (e.getActionCommand().equals("artsResetButton")) {
                    this.manageArtsView.getTitleField().setText(null);
                    this.manageArtsView.getTypeField().setText(null);
                    this.manageArtsView.getArtistField().setText(null);
		}

	}

}
