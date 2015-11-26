package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayHandleUtil {
	public static List<HashMap<String, String>> handle(String[][] arr){
		List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map=null;
		for (int i = 0; i < arr.length; i++) {
			map=new HashMap<String, String>();
			for (int j = 0; j < arr[0].length; j++) {
				map.put("col_"+j, arr[i][j]);
			}
			list.add(map);
		}
		return list;
	}
}
