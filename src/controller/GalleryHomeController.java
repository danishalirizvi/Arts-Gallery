package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DataAccess.ArtDao;
import View.GalleryHomeView;
import View.LoginView;
import model.ArtsPieceModel;
import net.proteanit.sql.DbUtils;

public class GalleryHomeController implements ActionListener {

	private GalleryHomeView view;
	private ArtsPieceModel model;
	private ArtDao dao;
	private LoginView loginView;
	private LoginController loginController;
	
	public GalleryHomeController() {
		model = new ArtsPieceModel();
		dao = new ArtDao();
		model.setArtPieces(dao.getArtPieces());
		view = new GalleryHomeView(this, model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("signin")) {
			loginView = new LoginView(loginController);
			view.dispose();
		}
		else if(e.getActionCommand().equals("search")) {
			String searchText = view.getSearchField().getText();
			int choice = view.radioSelected();
			view.getTable().setModel(DbUtils.resultSetToTableModel(dao.getSearchResults(choice, searchText)));
			
			
			
//			model = new ArtsPieceModel();
//			model.setArtPieces(dao.getSearchResults(choice,searchText));
//			view.dispose();
//			view = new GalleryHomeView(this, model);
		}
	}

}
