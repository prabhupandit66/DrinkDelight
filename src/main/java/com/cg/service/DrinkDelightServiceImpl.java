package com.cg.service;

import java.util.HashMap;
import com.cg.dao.DrinkDelightDao;
import com.cg.dao.DrinkDelightDaoImpl;
import com.cg.main.ProductStock;

public class DrinkDelightServiceImpl implements DrinkDelightService {
	DrinkDelightDao dao;

	public DrinkDelightServiceImpl(DrinkDelightDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public ProductStock trackProductOrder(String id) {
		return dao.trackProductOrder(id);
	}

	@Override
	public boolean doesProductOrderIdExists(String id) {
		return dao.doesProductOrderIdExists(id);
	}

	@Override
	public boolean validateExpiryDate(String id) {
		return dao.validateExpiryDate(id);
	}

	@Override
	public boolean updateProductStock(ProductStock productStock) {
		return dao.updateProductStock(productStock);
	}

	@Override
	public boolean updateStatus(String id, String status) {
		return dao.updateStatus(id, status);
	}

	@Override
	public HashMap<String, ProductStock> getMap() {
		return dao.getMap();
	}

	@Override
	public void setMap(HashMap<String, ProductStock> daoMap) {
		dao.setMap(daoMap);
		
	}



	

}
