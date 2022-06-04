package com.example.mallwork.Service;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Vo.CartVo;

public interface CartService {
	/**
	 * ������Ʒ��Ϣ�����ﳵ
	 * @param userid
	 * @param productId
	 * @param count
	 * @return
	 */
	public SverResponse<String> saveOrUpdate(Integer userid, Integer productId, Integer count);
	/**
	 * �鿴���ﳵ������Ϣ
	 * @param userid
	 * @return
	 */
	public SverResponse<CartVo> findAllCarts(Integer userid);
	/**
	 * ��չ��ﳵ
	 * @param userid
	 * @return
	 */
	public SverResponse<String> clearCart(Integer userid);
	/**
	 * ���¹��ﳵ��Ϣ
	 * @param userid
	 * @param productId
	 * @param count
	 * @param checked
	 * @return
	 */
	public SverResponse<CartVo> updateCart(Integer userid, Integer productId, Integer count, Integer checked);
	/**
	 * ɾ����Ʒ
	 * @param userid
	 * @param productId
	 * @return
	 */
	public SverResponse<CartVo> deleteCart(Integer userid, Integer productId);
	/**
	 * ��ù��ﳵ������
	 * @param userid
	 * @return
	 */
	public SverResponse<Integer> getCartCount(Integer userid);

}
