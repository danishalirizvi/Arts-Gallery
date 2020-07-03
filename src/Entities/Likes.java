package Entities;

public class Likes {
	
	int User_Id,Art_Id;

	public Likes(int user_Id, int art_Id) {
		User_Id = user_Id;
		Art_Id = art_Id;
	}

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}

	public int getArt_Id() {
		return Art_Id;
	}

	public void setArt_Id(int art_Id) {
		Art_Id = art_Id;
	}
	
	
}
