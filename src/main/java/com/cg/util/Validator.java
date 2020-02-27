package com.cg.util;

public class Validator {

	public static boolean check(String name) {
		
		return (!name.equals("")&&(name!=null)&&(name.matches("^[a-zA-Z]*$")));
	}

	public static boolean check1(String oid) {
		
		return (!oid.equals("")&&(oid!=null)&&(oid.matches("^[a-zA-Z]*$")));
	}

	public static boolean checkDate(String dDate) {
		
		return (!dDate.equals("")&&(dDate!=null)&&(dDate.matches("^(1[0-2]|0[1-9])/(3[01]"
				+  "|[12][0-9]|0[1-9])/[0-9]{4}$")));
	}

	public static boolean checkMdate(String mDate) {
		return (!mDate.equals("")&&(mDate!=null)&&(mDate.matches("^(1[0-2]|0[1-9])/(3[01]"
				+  "|[12][0-9]|0[1-9])/[0-9]{4}$")));
	}

	public static boolean checkexpDate(String eDate) {
		return (!eDate.equals("")&&(eDate!=null)&&(eDate.matches("^(1[0-2]|0[1-9])/(3[01]"
				+  "|[12][0-9]|0[1-9])/[0-9]{4}$")));
	}

}
