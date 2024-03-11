package com.javatechie.util;

public class JenkinsUtil {

	public static boolean isObjectNotEmpty(Object object) {
		if (null != object) {
			return true;
		}
		return false;
	}

	public static boolean isIdValid(Long id) {
		if (null != id && id > 0) {
			return true;
		}
		return false;
	}

}
