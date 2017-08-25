package com.revature.gspj.gdf.dao;

import com.revature.gspj.gdf.bean.GDFUser;

public interface GDFUserDAO {
	void createUser(GDFUser user);
	GDFUser getUser(String username, String password); //use for validation
	GDFUser getUserFromId(int id);
	void editUser(GDFUser user);
}
