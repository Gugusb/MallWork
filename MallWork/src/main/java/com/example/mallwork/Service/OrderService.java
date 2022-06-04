package com.example.mallwork.Service;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Tools.PageBean;
import com.example.mallwork.Vo.OrderVo;

public interface OrderService {
/**
 * ������ҳ�б�
 * @param userid
 * @param status
 * @param pageNum
 * @param pageSize
 * @return
 */
	public SverResponse<PageBean<OrderVo>> findOrder(Integer userid, Integer status, int pageNum, int pageSize);
/**
 * ȡ������
 * @param id
 * @param orderNo
 * @return
 */
public SverResponse<String> cancelOrder(Integer id, Long orderNo);
/**
 * ���ݶ����Ż�ȡ��������
 * @param userid
 * @param orderNo
 * @return
 */
public SverResponse<OrderVo> findOrderDetail(Integer userid, Long orderNo);
/**
 * ��������
 * @param userid
 * @param addrId
 * @return
 */
public SverResponse<OrderVo> generateOrder(Integer userid, Integer addrId);

}
