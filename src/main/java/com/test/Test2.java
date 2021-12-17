package com.test;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;

import com.bjit.utils.ExcelUtils;

public class Test2 {
	
	public static void main(String[] args) {
		List<Map<String, String>> list = ExcelUtils.getTestDetails("Data");
		
		for (Map<String, String> map : list) {
			System.out.println(map);
		}
	}
}
