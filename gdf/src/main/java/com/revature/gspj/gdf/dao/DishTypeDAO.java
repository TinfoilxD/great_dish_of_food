package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.DishType;

public interface DishTypeDAO {
	List<DishType> getAllTypes();
	DishType getTypeFromId(int id);
	void createType(DishType type);
	void updateType(DishType type);
}
