package com.cg.dao;

import java.util.HashMap;
import com.cg.main.ProductStock;

public class DrinkDelightDaoImpl implements DrinkDelightDao {
	HashMap<String,ProductStock> map= new HashMap<>();
	private int day = 27;
	private int month = 2;
	private int year = 2020;
	public DrinkDelightDaoImpl() {
		map.put("MJ", new ProductStock("MJ","Mango Juice",50.0, 100.0, 1.0,
				250.0, "WH1", "24/02/2020", "12/01/2020", "12/04/2020","Not Dispatched"
				));
			map.put("BS", new ProductStock("BS","Banana Shake",60.0, 100.0, 2.0,
					300.0, "WH2", "24/02/2020", "12/01/2020", "12/04/2020","Not Dispatched"
					));
			map.put("GJ", new ProductStock("GJ","Grapes Juice",40.0, 100.0, 1.0,
					200.0, "WH3", "24/02/2020", "12/01/2020", "12/04/2020","Dispatched"
					));
			map.put("PJ", new ProductStock("PJ","Pineapple Juice",70.0, 100.0, 3.0,
					350.0, "WH4", "24/02/2020", "12/01/2020", "12/04/2020","Not Dispatched"
					));
			map.put("OJ", new ProductStock("OJ","Orange Juice",30.0, 100.0, 2.0,
					150.0, "WH5", "24/02/2020", "12/01/2020", "12/04/2020","Not Dispatched"
					));
		
	}


	@Override
	public ProductStock trackProductOrder(String id) {
		return map.get(id);
	}

	@Override
	public boolean doesProductOrderIdExists(String id) {
		if(map.get(id)==null)return false;
		return true;
	}

	@Override
	public boolean validateExpiryDate(String id) {
		ProductStock  prod = map.get(id);
		String date = prod.getExpiryDate();
		//12/02/2020
		String arr[]=date.split("/");
		int exDay = Integer.parseInt(arr[0]);
		int exmon = Integer.parseInt(arr[1]);
		int exyear = Integer.parseInt(arr[2]);
		if(exyear>year) {
			if(exmon>month) {
				if(exDay>day) {
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public boolean updateProductStock(ProductStock productStock) {
		ProductStock e = map.put(productStock.getOrderId(), productStock);
		System.out.println(map);
		return true;
	}


	@Override
	public boolean updateStatus(String id, String status) {
		ProductStock prod =map.get(id);
		prod.setStatus(status);
		ProductStock prodNew = map.put(id,prod);
		return true;
	}


	@Override
	public HashMap<String, ProductStock> getMap() {
		return map;
	}


	@Override
	public void setMap(HashMap<String, ProductStock> daoMap) {
		map=daoMap;
	}


	

}
