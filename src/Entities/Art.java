package Entities;

public class Art {
	
	int Art_Id;
	String Art_N;
	int Artist_Id;
	String Art_Type;
        String Art_Description;
        
	
	public Art(int artPiece_Id, String title, int artist_Id, String type, String Decription) {
		Art_Id = artPiece_Id;
		Art_N = title;
		Artist_Id = artist_Id;
		Art_Type = type;
                Art_Description = Decription;
	}

	public int getArtPiece_Id() {
		return Art_Id;
	}

	public void setArtPiece_Id(int artPiece_Id) {
		Art_Id = artPiece_Id;
	}

	public String getTitle() {
		return Art_N;
	}

	public void setTitle(String title) {
		Art_N = title;
	}

	public int getArtist_Id() {
		return Artist_Id;
	}

	public void setArtist_Id(int artist_Id) {
		Artist_Id = artist_Id;
	}

	public String getType() {
		return Art_Type;
	}

	public void setType(String type) {
		Art_Type = type;
	}
	
	
}
