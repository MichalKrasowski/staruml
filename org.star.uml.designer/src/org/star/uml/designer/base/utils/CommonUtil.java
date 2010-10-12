package org.star.uml.designer.base.utils;

public class CommonUtil {
	public static String randomKey(){
		String key = "";
		try{
			String message[]= new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
										   "q","r","s","t","u","v","w","x","y","z","a","b","c","d","e","f",
										   "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
										   "w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L",
										   "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","A","B",
										   "C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
										   "S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8",
										   "9","0"};
			int num = 0;
			for(int i = 0; i < 10; i++){
				num = (int)(Math.random() * 113) + 1;
				key = key + message[num];
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
	}
}
