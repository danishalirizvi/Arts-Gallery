package model;
import java.sql.ResultSet;

import Entities.Customers;


public class ArtsPieceModel {	
	 
	private ResultSet ArtPieces;
	private Customers user;
	public Customers getUser() {
		return user;
	}
	public void setUser(Customers user) {
		this.user = user;
	}
	private int ArtPiece_Id = 0;
	private String Title = null;
	private int Artist_Id = 0;
	private String Type = null;
	
	public int getArtPiece_Id() {
		return ArtPiece_Id;
	}
	public void setArtPiece_Id(int artPiece_Id) {
		ArtPiece_Id = artPiece_Id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getArtist_Id() {
		return Artist_Id;
	}
	public void setArtist_Id(int artist_Id) {
		Artist_Id = artist_Id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public ResultSet getArtPieces() {
		return ArtPieces;
	}
	public void setArtPieces(ResultSet artPieces) {
		ArtPieces = artPieces;
	} 

	
}
