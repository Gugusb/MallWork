package com.example.mallwork.Controller;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.Address;
import com.example.mallwork.Entity.User;
import com.example.mallwork.Service.AddrService;
import com.example.mallwork.Tools.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/addr")
public class AddressCotroller {
	@Autowired
	private AddrService AddrService;
	/**
	 * ������ַ
	 * @param session
	 * @param addr
	 * @return
	 */
	@RequestMapping("/saveaddr.do")
	@ResponseBody
	public SverResponse<List<Address>> saveAddress(HttpSession session, Address addr) {
		//1.�ж�User�Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		addr.setUserId(user.getId());//��ֵ
		
		//�ж����޸Ļ������
		SverResponse<String> result = null;
		if (addr.getId()==null) {//���
			result = AddrService.addAddress(addr);
		}else {//�޸�
			result = AddrService.updateAddress(addr);
		}
		//���ص�ǰ�û������е�ַ
		if (result.isSuccess()) {
			return AddrService.findAddressByUserId(user.getId());
		}
		return SverResponse.createByErrorMessage(result.getMsg());
		
	}
	/**
	 * �޸ĵ�ַ
	 * @param session
	 * @param addr
	 * @return
	 */
	@RequestMapping("/findAddressById.do ")
	@ResponseBody
	public SverResponse<List<Address>> changeAddress(HttpSession session,Address addr) {
		//1.�ж�User�Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		addr.setUserId(user.getId());//��ֵ
		
		//�ж����޸Ļ������
		SverResponse<String> result = null;
		if (addr.getId()==null) {//���
			result = AddrService.addAddress(addr);
		}else {//�޸�
			result = AddrService.updateAddress(addr);
		}
		//���ص�ǰ�û������е�ַ
		if (result.isSuccess()) {
			return AddrService.findAddressByUserId(user.getId());
		}
		return SverResponse.createByErrorMessage(result.getMsg());
		
	}
	/**
	 * ɾ����ַ��Ϣ
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/deladdr.do")
	@ResponseBody
	public SverResponse<List<Address>> deleteAddress (HttpSession session,Integer id) {
		//1.�ж�User�Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		//2.����ɾ������������ɾ����ַ
		SverResponse<String> result = AddrService.deleteAddress(user.getId(),id);
		//3.ɾ����ַ�󷵻ص�ǰ�û����е�ַ
		if (result.isSuccess()) {
			return AddrService.findAddressByUserId(user.getId());
		}
		return SverResponse.createByErrorMessage(result.getMsg());
		
	}
	/**
	 * ����Ĭ�ϵ�ַ
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("setdefault.do")
	@ResponseBody
	public SverResponse<List<Address>> setDefaultAddress(HttpSession session, Integer id) {
		//1.�ж�User�Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		//2.������Ϣ
		SverResponse<String> result = AddrService.updateDeaufultAddress(user.getId(),id);
		if (result.isSuccess()) {
			return AddrService.findAddressByUserId(user.getId());
		}
		return SverResponse.createByErrorMessage(result.getMsg());
	}
	/**
	 * ���ҵ�¼�û������е�ַ��Ϣ
	 * @param session
	 * @return
	 */
	@RequestMapping("/findaddrs.do")
	@ResponseBody
	public SverResponse<List<Address>> findAdderss(HttpSession session) {
		//1.�ж�User�Ƿ��¼
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���¼���ٽ��в�����");
		}
		return AddrService.findAddressByUserId(user.getId());
		
	}
}
