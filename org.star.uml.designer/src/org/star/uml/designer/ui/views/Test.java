package org.star.uml.designer.ui.views;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			List<String> list = new ArrayList();
			list.add("a");
			list.add("b");
			list.add("c");
			list.add("d");
			list.add("e");
			String ss = "";
			for(int i = list.size() - 1; i >= 0; i--){
				list.remove(i);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
