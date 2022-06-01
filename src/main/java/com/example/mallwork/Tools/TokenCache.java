package com.example.mallwork.Tools;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TokenCache {

	public static final String PREFIX="action_";
	
	//��ʼ���������
	private static LoadingCache<String, String> mCache = CacheBuilder.newBuilder()
			.initialCapacity(1000)
			.maximumSize(10000)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build(new CacheLoader<String, String>(){
				@Override
				public String load(String arg0) throws Exception {
					return "null";
				}
				
			});
		
	/**
	 * ������������뻺��
	 * @param key
	 * @param value
	 */
	public static void setCacheData(String key,String value) {
		mCache.put(key, value);
	}
	
	/**
	 * �ӻ����ж�ȡ����
	 * @param key
	 * @return
	 */
	public static String getCacheData(String key) {
		String value = null;
		try {
			value = mCache.get(key);
			if("null".equals(value)) {
				return null;
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
