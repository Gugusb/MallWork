package com.example.mallwork.Service;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.Address;

import java.util.List;

public interface AddrService {
	/**
	 * �����ռ��˵�ַ��Ϣ
	 * @param addr
	 * @return
	 */
	public SverResponse<String> addAddress(Address addr);
	
	/**
	 * �����ռ��˵�ַ��Ϣ
	 * @param addr
	 * @return
	 */
	public SverResponse<String> updateAddress(Address addr);
	/**
	 * ����ĳ���û������ջ���ַ
	 * @param userId
	 * @return
	 */
	public SverResponse<List<Address>> findAddressByUserId(Integer userId);
	
	/**
	 * ����idɾ����ַ��Ϣ
	 * @param userId
	 * @param id
	 * @return
	 */
	public SverResponse<String> deleteAddress(Integer userId, Integer id);
	
	/**
	 * ����Ĭ�ϵ�ַ
	 * @param userId
	 * @param id
	 * @return
	 */
	public SverResponse<String> updateDeaufultAddress(Integer userId, Integer id);

}
