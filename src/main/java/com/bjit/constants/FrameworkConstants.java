package com.bjit.constants;

import com.bjit.enums.ConfigProperties;
import com.bjit.utils.PropertyUtils;

public final class FrameworkConstants {
	private static final String RESOURCESPATH = System.getProperty("user.dir");
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/excutables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH + "/excutables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final int EXPLICITLYWAIT = 10;
	private static final String EXTENTREPORTFOLDERPATH = RESOURCESPATH + "/extent-test-output/";
	private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
	private static String extentReportFilePath = "";
	private static final String RUNMANAGERSHEET= "RUNMANAGER";
	private static final String ITERATIONDATASHEET= "DATA";

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}
	
	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	private FrameworkConstants() {
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitlywait() {
		return EXPLICITLYWAIT;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	public static String createReportPath() {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
		}
		return EXTENTREPORTFOLDERPATH + "index.html";
	}

}
