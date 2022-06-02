package com.example.mallwork.Controller;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.User;
import com.example.mallwork.Service.UserService;
import com.example.mallwork.Tools.ConstUtil;
import com.example.mallwork.Vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService actionUserService;

	@RequestMapping("/do_login.do")
	@ResponseBody
	public SverResponse<User> doLogin(HttpSession session, String account, String password) {
		//1.����service��¼����
		SverResponse<User> response = actionUserService.doLogin(account, password);
		//2.�ж��Ƿ��ܵ�¼��¼��״̬�洢��session��
		if (response.isSuccess()) {
			//3.�ܵ�¼���ж��Ƿ��ǹ���Ա���ǹ���Ա�����session�����򱨸������Ϣ
			User user = response.getData();
			if(user.getRole()== ConstUtil.Role.ROLE_ADMIN) {
				session.setAttribute(ConstUtil.CUR_USER, user);
				return response;
			}
//			return SverResponse.createByErrorMessage("���ǹ���Ա�޷���¼��");
			if (user.getRole()==ConstUtil.Role.ROLE_CUSTOMER) {
				session.setAttribute(ConstUtil.CUR_USER, user);
				return response;
			}
		}
		return response;
	}
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	@RequestMapping("/do_register.do")
	@ResponseBody
	public SverResponse<String> registerUser(User user){
		
		return actionUserService.doRegister(user);
		
	}
	/**
	 * ��֤�û�������û�����
	 * @param account
	 * @return
	 */
	@RequestMapping("getUserByAccount.do")
	@ResponseBody
	public SverResponse<User> getUserByAccount(String account) {
		return actionUserService.findUserByAccount(account);
		
	}
	/**
	 * ע����¼
	 * @param request
	 * @return
	 */
	@RequestMapping("/do_logout.do")
	@ResponseBody
	public SverResponse<String> doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(ConstUtil.CUR_USER);
		return SverResponse.createRespBySuccessMessage("ע���ɹ���");
	}
	/**
	 * ��֤�û������޸�,�����
	 * @param account
	 * @param question
	 * @param asw
	 * @return
	 */
	@RequestMapping("/checkuserasw.do")
	@ResponseBody
	public SverResponse<String> checkUserAnswer(String account,String question,String asw) {
		return actionUserService.checkUserAnswer(account,question,asw);
		
	}
	
	/**
	 * ��������
	 * @param userId
	 * @param newpwd
	 * @return
	 */
	@RequestMapping("/resetpassword.do")
	@ResponseBody
	public SverResponse<String> resetPassword(Integer userId,String newpwd) {
		return actionUserService.resetPassword(userId,newpwd);
		
	}
	/**
	 * �޸��û���������
	 * @param session
	 * @param userVo
	 * @return
	 */
	//Voҵ��ʵ����
	@RequestMapping("/updateuserinfo.do")
	@ResponseBody
	public SverResponse<User> updateUserInfo(HttpSession session, UserVo userVo) {
		//1.��õ�ǰҳ��user����
		User curUser = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (curUser==null) {
			return SverResponse.createByErrorMessage("�û���δ��¼!");
		}
		userVo.setId(curUser.getId());
		userVo.setAccount(curUser.getAccount());
		SverResponse<User> resp = actionUserService.updateUserInfo(userVo);
		if (resp.isSuccess()) {
			//2.��дsession
			session.setAttribute(ConstUtil.CUR_USER, resp.getData());
		}
		return resp;
		
	}
	/**
	 * �޸�����
	 * @param session
	 * @param newpwd
	 * @param oldpwd
	 * @return
	 */
	//�޸�����
	@RequestMapping("/updatepassword.do")
	@ResponseBody
	public SverResponse<String> updatePassword(HttpSession session,String newpwd,String oldpwd) {
		//1.��sessionȡ��
		User user = (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null) {
			return SverResponse.createByErrorMessage("���ȵ�¼��");
		}
		SverResponse<String> result = actionUserService.updatePassword(user,newpwd,oldpwd);
		//2.�޸ĳɹ������session���µ�¼
		if (result.isSuccess()) {
			session.removeAttribute(ConstUtil.CUR_USER);
		}
		return result;
		
	}
	/**
	 * ����û���������
	 * @param account
	 * @return
	 */
	@RequestMapping("/getuserquestion.do")
	@ResponseBody
	public SverResponse<String> getUserQuestion(String account) {
		return actionUserService.getUserQuestion(account);
	}
	
	@RequestMapping(value = "/getuserinfo.do",method = RequestMethod.GET)
	@ResponseBody
	public SverResponse<User> getUserInfo(HttpSession session){
		User user= (User) session.getAttribute(ConstUtil.CUR_USER);
		if (user==null){
			return SverResponse.createByErrorMessage("�޷���ȡ�û���Ϣ!");
		}
		else
		{
			return SverResponse.createRespBySuccess(user);
		}
	}
	

	@RequestMapping("/do_check_info.do")
	@ResponseBody
	public SverResponse<String> checkindo(String info,String type){
		return actionUserService.checkValidation(info,type);
	}

}
