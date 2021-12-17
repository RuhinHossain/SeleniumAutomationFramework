package com.bjit.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.bjit.constants.FrameworkConstants;
import com.bjit.enums.ConfigProperties;

public class PropertyUtils {
	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	private PropertyUtils() {
	}

	static {
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath());) {
			property.load(fis);

			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) throws NullPointerException {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new NullPointerException(
					"Property name " + key + " is not found. please check the config.properties file");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}