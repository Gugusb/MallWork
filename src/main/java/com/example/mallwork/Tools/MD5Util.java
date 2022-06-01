package com.example.mallwork.Tools;

import java.security.MessageDigest;

public class MD5Util {

	private final static String[] hexDigits= {
			"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"
	};
	/**
	 * ת��byteΪ16����
	 * @param b Ҫת����byte
	 * @return 16���ƶ�Ӧ���ַ�
	 */
	private static String byteToHexString(byte b) {
		int n=b;
		if(n<0) {
			n=256+n;
		}
		int d1=n/16;
		int d2=n%16;
		return hexDigits[d1]+hexDigits[d2];
	}
	/**
	 * ת���ֽ�����Ϊ16�����ַ���
	 * @param bytes
	 * @return
	 */
	private static String byteArrayToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for(byte b:bytes) {
			sb.append(byteToHexString(b));
		}
		return sb.toString();
	}
	/**
	 * MD5����
	 * @param source Ҫ���ܵ��ַ���
	 * @param encoding ָ����������
	 * @param upperCase �Ƿ�תΪ��д�ַ���
	 * @return
	 */
	public static String MD5Encode(String source,String encoding,boolean upperCase) {
		String result = null;
		try {
			result = source;
			//���MD5ժҪ����
			MessageDigest mesageDigest = MessageDigest.getInstance("MD5");
			mesageDigest.update(result.getBytes(encoding));
			result = byteArrayToHexString(mesageDigest.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upperCase?result.toUpperCase():result;
	}
	
}















