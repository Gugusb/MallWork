package com.example.mallwork.Controller;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.User;
import com.example.mallwork.Service.OrderService;
import com.example.mallwork.Tools.ConstUtil;
import com.example.mallwork.Tools.PageBean;
import com.example.mallwork.Vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService OrderService;
	@RequestMapping("/getlist.do")
	@ResponseBody
	/**
	 * ��ȡ�����б�
	 * @param session
	 * @param status
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public SverResponse<PageBean<OrderVo>> list(HttpSession session, Integer status,
												@RequestParam(value="pageNum",defaultValue="1") int pageNum,
												@RequestParam(value="pageSize",defaultValue="10") int pageSize) {
		//1.�ж��û��Ƿ��Ѿ���¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		//2.��ѯ���ж���
		return OrderService.findOrder(user.getId(),status,pageNum,pageSize);
		
	}
	/**
	 * ȡ������
	 * @param session
	 * @param orderNo
	 * @return
	 */
	@RequestMapping("/cancelorder.do")
	@ResponseBody
	public SverResponse<String> cancelOrder(HttpSession session,Long orderNo) {
		//1.�ж��û��Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		//2.ȡ������������Ϣ
		return OrderService.cancelOrder(user.getId(),orderNo);
	}
	/**
	 * ȷ������
	 * @param session
	 * @param orderNo
	 * @return
	 */
	@RequestMapping("/confirmreceipt.do")
	@ResponseBody
	public SverResponse<String> confirmReceipt(HttpSession session,Long orderNo) {
		//1.�ж��û��Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		//2.ȡ������������Ϣ
		return OrderService.cancelOrder(user.getId(),orderNo);
	}
	/**
	 * ��ȡ��������
	 * @param session
	 * @param orderNo
	 * @return
	 */
	@RequestMapping("/getdetail.do")
	@ResponseBody
	public SverResponse<OrderVo> getDetail(HttpSession session,Long orderNo) {
		//1.�ж��û��Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		return OrderService.findOrderDetail(user.getId(),orderNo);
		
	}
	/**
	 * ��������
	 * @param session
	 * @param addrId
	 * @return
	 */
	@RequestMapping("/createorder.do")
	@ResponseBody
	public SverResponse<OrderVo> createOrder(HttpSession session,Integer addrId) {
		//1.�ж��û��Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		return OrderService.generateOrder(user.getId(),addrId);
		
	}
}
