package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.OrderType;

public interface OrderTypeDAO {
	List<OrderType> getAllTypes();
	OrderType getTypeFromId(int id);
	OrderType getTypeFromName(String name);
}
