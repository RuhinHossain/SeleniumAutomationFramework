package com.bjit.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.bjit.constants.FrameworkConstants;

public final class DataProviderUtils {
	private DataProviderUtils() {
	}

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel=false)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
			System.out.println(list);
		}

		List<Map<String, String>> smalllist = new ArrayList<>();

		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) &&
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
				smalllist.add(list.get(i));
			}
		}
		System.out.println(smalllist);
		return smalllist.toArray();

	}
}
