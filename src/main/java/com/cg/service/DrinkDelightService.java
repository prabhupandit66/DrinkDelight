package com.cg.service;

import java.util.HashMap;
import com.cg.main.ProductStock;

public interface DrinkDelightService {
	ProductStock trackProductOrder(String id);
	boolean doesProductOrderIdExists(String id);
	boolean validateExpiryDate(String id);
	boolean updateProductStock(ProductStock productStock);
	boolean updateStatus(String id,String status);
	HashMap<String, ProductStock> getMap();
	void setMap(HashMap<String, ProductStock> daoMap);
	
	
}
