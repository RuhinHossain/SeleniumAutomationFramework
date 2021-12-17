package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bjit.constants.FrameworkConstants;
import com.bjit.utils.ExcelUtils;

public class ReadDataFromExcel {
	
	public static void main(String[] args) {
		Method m = null;
		System.out.println(m.getName());
	}
	

	public static Object[] getData(Method m) {
		String testname = m.getName();
		System.out.println(testname + " test name");
		
		List<Map<String, String>> list = ExcelUtils.getTestDetails("DATA");
		List<Map<String, String>> smallList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testname)) {
				if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smallList.add(list.get(i));
				}
			}
		}

		return smallList.toArray();
	}
	
	public static List<Map<String, String>> getTestDetails(String sheetname) {
		List<Map<String, String>> list = null;
		XSSFWorkbook workbook = null;
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {
			workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			list = new ArrayList<>();

			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastcolnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}

				list.add(map);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (Objects.nonNull(workbook)) {
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;

	}
}
