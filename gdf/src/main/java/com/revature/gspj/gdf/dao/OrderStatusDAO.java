package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.OrderStatus;

public interface OrderStatusDAO {
	List<OrderStatus> getAllStatus();

	OrderStatus getStatusFromId(int id);
}
