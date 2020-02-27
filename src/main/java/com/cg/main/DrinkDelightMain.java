package com.cg.main;

import java.util.HashMap;
import java.util.Scanner;

import com.cg.dao.DrinkDelightDaoImpl;

import com.cg.service.DrinkDelightService;
import com.cg.service.DrinkDelightServiceImpl;
import com.cg.util.Validator;

public class DrinkDelightMain{
	
	public DrinkDelightMain() {
		DrinkDelightDaoImpl dao = new DrinkDelightDaoImpl();
		DrinkDelightService dservice = new DrinkDelightServiceImpl(dao);
		System.out.println("WELCOME TO DRINK AND DELIGHT");
		System.out.println("----------------------------");
		Scanner sc = new Scanner(System.in);
		int choice =0;
		while(true) {
			getChoice();
			choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				placeAnOrder(dservice,sc);
				break;
			case 2:
				
				updateAnOrder(dservice,sc);
				break;				
			case 3:
				sc.nextLine();
				displayOrderDetails(dservice,sc);
				break;
			case 4:
				System.out.println("Thank You..See You Again!!");
				System.exit(0);
				break;
			

			default:
				System.out.println("Please enter a valid input");
				break;
			}
			
		}
	}
	
	private void displayOrderDetails(DrinkDelightService dservice, Scanner sc) {
		System.out.println("Enter the order ID");
		String id = sc.nextLine();
		ProductStock prod = dservice.trackProductOrder(id);
		System.out.println(prod);
		
	}

	private void updateAnOrder(DrinkDelightService dservice, Scanner sc) {
		
		HashMap<String,ProductStock> daoMap = dservice.getMap();
		sc.nextLine();
		System.out.println(daoMap);
		
		System.out.println("Enter the orderID you want to update");
		String orderId = sc.nextLine();
		
		ProductStock prod = daoMap.get(orderId);
		
		System.out.println("1. Update price");
		System.out.println("2. Update Quantity");
		System.out.println("3. Update Price per Unit");
		System.out.println("4. Update Date of Delivery");
		System.out.println("5. Update status of order");
		
		int choice = sc.nextInt();
		
		

		switch (choice) {
		case 1:
			System.out.println("Enter price");
			double price = sc.nextDouble();
			prod.setPrice(price);
			System.out.println("Price updated successfully");
			break;
		case 2:
			System.out.println("Enter Quantity Unit");
			double qty = sc.nextDouble();
			prod.setQuantityUnit(qty);
			System.out.println("Quantity Unit updated succesfully");
			break;
		case 3:
			System.out.println("Enter Price_Per_Unit");
			double pricePerUnit = sc.nextDouble();
			prod.setPrice_per_unit(pricePerUnit);
			System.out.println("Price per unit updated succesfully");
			break;

		case 4:
			System.out.println("Enter Delivery Date");
			sc.nextLine();
			String dDate = sc.nextLine();
			prod.setDeliveryDate(dDate);
			System.out.println("Delivery Date updated successfully");
			break;
		case 5:
			System.out.println("Update Status ");
			sc.nextLine();
			String status = sc.nextLine();
			prod.setStatus(status);
			System.out.println("Status updated succesfully");
			break;
		default:
			System.out.println("Please Enter numbers between 1 to 5");
			break;
		}
		
		daoMap.put(orderId, prod);
		dservice.setMap(daoMap);
		
		
	}

	private void placeAnOrder(DrinkDelightService dservice, Scanner sc) {
		sc.nextLine();
		String oid=null;
		do {
		System.out.println("Enter order ID : ");
		System.out.println("Enter string only:");
		oid=sc.nextLine();
		}while(!Validator.check1(oid));

		String name=null;
		do {
		System.out.println("Enter name : ");
		System.out.println("Enter string only:");
		name=sc.nextLine();
		}while(!Validator.check(name));
		System.out.println("Enter Price per Unit : ");
		double ppu=sc.nextDouble();
		System.out.println("Enter Quantity Value : ");
		double qValue=sc.nextDouble();
		System.out.println("Enter Quantity Unit : ");
		double qUnit=sc.nextDouble();
		System.out.println("Enter Price : ");
		double price=sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter Ware House ID : ");
		String wHouse=sc.nextLine();
		String dDate=null;
		do {
		System.out.println("Enter Delivery Date : ");
		System.out.println("Enter in DD/MM/YYYY format");
		dDate=sc.nextLine();
		}while(!Validator.checkDate(dDate));
		String mDate=null;
		do {
		System.out.println("Enter Manufacturing Date : ");
		System.out.println("Enter in DD/MM/YYYY format");
		 mDate=sc.nextLine();
		}while(!Validator.checkMdate(mDate));
		String eDate=null;
		do {
		System.out.println("Enter Expiry Date : ");
		System.out.println("Enter in DD/MM/YYYY format");
		eDate=sc.nextLine();
		}while(!Validator.checkexpDate(eDate));
		System.out.println("Enter Status : ");
		String status=sc.nextLine();
		ProductStock product = new ProductStock(oid,name, ppu, qValue,qUnit, price, wHouse, dDate, mDate,eDate,status);
		if(dservice.updateProductStock(product)) {
			System.out.println("Order placed sucessfully");
		}
		
		
	}

	private void getChoice() 
	{
		
		System.out.println("1. Place an Order");
		System.out.println("2. Update an Order");
		System.out.println("3. Display Order Details");
		System.out.println("4. Exit System");
		System.out.println("Enter your choice");
		
		
	}
	
	public static void main(String[] args)
	{
		new DrinkDelightMain();    

	}

}
