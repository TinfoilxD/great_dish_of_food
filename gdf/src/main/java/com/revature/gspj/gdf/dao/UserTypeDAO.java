package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.UserType;

public interface UserTypeDAO {
	List<UserType> getAllTypes();
	UserType getTypeFromId(int id);
}
