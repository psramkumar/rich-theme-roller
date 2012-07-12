package com.triadic.ram.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Named;

@Named
public class UserBean  implements Serializable{
	private static final long serialVersionUID = 7134413466613391840L;

	public UserBean() {
		popMap();
		popList();
	}

	private Map<String, String> map = new HashMap<String, String>();
	private List<String> list = new ArrayList<String>();

	public Map<String, String> getMap() {return map;}
	public List<String> getList() {return list;}

	private Map<String, String> popMap() {
		for (int i = 1; i < 100; i++) {
			String mills = "" + System.currentTimeMillis();
			String rand = "" + UUID.randomUUID();
			map.put(mills, rand);
		}
		return map;
	}

	private  List<String> popList() {
		for (int i = 1; i < 100; i++) {
			String rand = "" + UUID.randomUUID();
			list.add(rand);
		}
		return list;
	}
	
	
}
