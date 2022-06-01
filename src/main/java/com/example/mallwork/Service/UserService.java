package com.example.mallwork.Service;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.User;
import com.example.mallwork.Vo.UserVo;

public interface UserService {
	/**
	 * �û���¼
	 * @param account
	 * @param password
	 * @return
	 */
	public SverResponse<User> doLogin(String account, String password);
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public SverResponse<String> doRegister(User user);
	
	/**
	 * ��ϢУ����֤
	 * @param str
	 * @param type
	 * @return
	 */
	public SverResponse<String> checkValidation(String str,String type) ;
	
	/**
	 * �����û�������û�����
	 * @param account
	 * @return
	 */
	public SverResponse<User> findUserByAccount(String account);
	/**
	 * У���û������
	 * @param account
	 * @param question
	 * @param asw
	 * @return
	 */
	public SverResponse<String> checkUserAnswer(String account, String question, String asw);
	
	/**
	 * ��������
	 * @param userId
	 * @param password
	 * @return
	 */
	public SverResponse<String> resetPassword(Integer userId, String password);
	
	/**
	 * �����û���Ϣ
	 * @param userVo
	 * @return
	 */
	public SverResponse<User> updateUserInfo(UserVo userVo);
	
	/**
	 * ��������
	 * @param user
	 * @param newPassword
	 * @param oldPassword
	 * @return
	 */
	public SverResponse<String> updatePassword(User user, String newPassword, String oldPassword);
	/**
	 * ��ѯ��������
	 * @param account
	 * @return
	 */
	public SverResponse<String> getUserQuestion(String account);
}
