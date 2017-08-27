package com.revature.gspj.gdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.dao.DishTypeDAO;

@Service
public class DishTypeService {

	@Autowired
	private DishTypeDAO dao;
	
	
	public void setDao(DishTypeDAO dao) {
		this.dao = dao;
	}


	@Transactional
	public void createType(DishType dish) {
		dao.createType(dish);
	}


	@Transactional
	public List<DishType> getAllTypes() {
		return dao.getAllTypes();
	}

}
