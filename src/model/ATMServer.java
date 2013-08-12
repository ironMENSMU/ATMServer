package model;

import java.util.ArrayList;

public class ATMServer {

	private static ArrayList<String> loginList = new ArrayList<String>();

	public ATMServer() {
	}

	public static void addUser(String nric) {
		loginList.add(nric);
	}

	public static void removeUser(String nric) {
		for (int i = 0; i < loginList.size(); i++) {
			if (loginList.get(i).equals(nric)) {
				loginList.remove(i);
			}
		}
	}

	public static boolean isDuplicate(String nric) {
		for (String s : loginList) {
			if (s.equals(nric)) {
				return true;
			}
		}
		return false;
	}
}
