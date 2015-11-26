package com.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PhoneCode;
import com.bean.PhoneCodeExample;
import com.bean.PhoneCodeExample.Criteria;
import com.google.gson.Gson;
import com.bean.TMember;
import com.bean.TMemberExample;
import com.mapper.PhoneCodeMapper;
import com.mapper.TMemberMapper;
import com.service.auth.Permission;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;
import com.util.DateUtil;
import com.util.GsonUtil;
import com.util.LogUtils;
import com.util.RandomUtil;
import com.util.SmsBaseUtil;
import com.util.StringUtil;

@RestController
public class InfoController {

	@Autowired
	private TMemberMapper tMemberDAO;
	@Autowired
	private PhoneCodeMapper phoneCodeDAO;
	@Autowired
	PhoneCodeController phoneCodeController;
	@Autowired
	private CouponController couponController;
	
	/**
	 * 获取session中用户信息
	 * 
	 * @param request
	 * @return
	 */
	@Permission
	@RequestMapping("/tmember/getBean")
	public HashMap<String, Object> getInfo(HttpServletRequest request){
		TMember member = (TMember)request.getSession().getAttribute("user");
		String gson=GsonUtil.toJson(member);
		TMember member2=new Gson().fromJson(gson, TMember.class);
		String phone = member2.getPhone();
		if(StringUtil.isNotEmpty(phone)){
			phone = phone.substring(0, 3) + "****" + phone.substring(7,11);
			member2.setPhone(phone);
		}
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, member2);
	}
	
	/**
	 * 从数据库中获取用户信息
	 * 
	 * @param request
	 * @return
	 */
	@Permission
	@RequestMapping("/tmember/getTmember")
	public HashMap<String, Object> getTmember(HttpServletRequest request){
		TMember member = (TMember) request.getSession().getAttribute("user");
		TMember tMember = tMemberDAO.selectByPrimaryKey(member.getId());
		String phone = tMember.getPhone();
		tMember.setPhone(phone.substring(0, 3) + "****" + phone.substring(7, 11));
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, tMember);
	}
	/**
	 * 
	 * @描述:异步获取用户余额 
	 * @作者: john
	 */
	@RequestMapping("/tmember/getBalance")
	public HashMap<String, Object> getBalance(HttpServletRequest request,HttpServletResponse response) throws SQLException{
		TMember tmember =(TMember) request.getSession().getAttribute("user");
		TMember newTmember =tMemberDAO.selectByPrimaryKey(tmember.getId());
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, newTmember);
	}

	/**
	 * 
	 * @throws SQLException 
	 * @描述: 更新个人资料
	 * @作者: john
	 */
	@RequestMapping("/tmember/save")
	public HashMap<String, Object> modifyInfo(TMember member, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		TMember tMember = (TMember)request.getSession().getAttribute("user");
		TMember user=tMemberDAO.selectByPrimaryKey(tMember.getId());
		String newNameString = member.getRealname();
//		String emailString = member.getEmail();
		Byte sex = member.getSex();
		user.setRealname(newNameString);
		user.setSex(sex);
//		user.setEmail(emailString);
		request.getSession().setAttribute("user", user);
		return ResultHandleUtil.dataUpdateResult(tMemberDAO.updateByPrimaryKey(user));
	}

	/**
	 * 
	 * @throws SQLException 
	 * @描述: 更换手机 发送验证码
	 * @作者: john
	 */
	@RequestMapping("/tmember/sendCode")
	public HashMap<String, Object> sendCode(String phone,HttpServletResponse response,HttpServletRequest request) throws SQLException{
		TMember user=(TMember) request.getSession().getAttribute("user");
		TMember tMember=tMemberDAO.selectByPrimaryKey(user.getId());
		if(!phone.equals(tMember.getPhone())){
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
		else{
			phoneCodeController.sendCode(phone);
			return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
		}
	}
	
	/**
	 * 
	 * @描述:修改手机号
	 * @作者:testpc
	 */
	@Permission
	@RequestMapping("/tmember/codeTest")
	public HashMap<String, Object> codeTest(String phone,String newPhone,String code,HttpServletResponse response,HttpServletRequest request) throws SQLException{
		TMemberExample tMemberExample=new TMemberExample();
		com.bean.TMemberExample.Criteria cri = tMemberExample.createCriteria();
		cri.andPhoneEqualTo(newPhone);
		List list=tMemberDAO.selectByExample(tMemberExample);
		if(list!=null&&list.size()>0){
			return ResultHandleUtil.resultHandle(ContantUtil.FAIL, "ERROR");
		}
		else{
			if(phoneCodeController.codeTest(phone, code)){
				TMember tMember=(TMember) request.getSession().getAttribute("user");
				tMember.setPhone(newPhone);
				tMemberDAO.updateByPrimaryKeySelective(tMember);
				request.getSession().removeAttribute("user");
				return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
			}
			else{
				return ResultHandleUtil.resultHandle(ContantUtil.FAIL, "FAIL");
			}
		}
	}
	
	
	/**
	 * 
	 * 校验、修改输入的新邮箱
	 * 
	 * @param email
	 * @param newEmail
	 * @param request
	 * @param response
	 * @throws SQLException
	 */
	@RequestMapping("/tmember/checkMail")
	public HashMap<String, Object> checkMail(String newEmail, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		TMember member = (TMember)request.getSession().getAttribute("user");
		String emailString = member.getEmail();
		//如果有邮箱，判断新邮箱是否和旧邮箱一致
		if(StringUtil.isNotEmpty(emailString)){
			if(emailString.equals(newEmail)){
				return ResultHandleUtil.resultHandle(ContantUtil.FAIL,"REPEAT");
			}
		}
		//更新用户邮箱
		member.setEmail(newEmail);
		tMemberDAO.updateByPrimaryKeySelective(member);
		request.getSession().setAttribute("user", member);
		return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
	}
	/**
	 * 校验、修改输入的新密码
	 * 
	 * @param password
	 * @param newPassword
	 * @param request
	 * @param response
	 * @throws SQLException
	 */
	@RequestMapping("/tmember/checkPass")
	public HashMap<String, Object> checkPass(String password, String newPassword, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		TMember tMember = (TMember)request.getSession().getAttribute("user");
		TMember user=tMemberDAO.selectByPrimaryKey(tMember.getId());
		String paswd = user.getPassword();
		if(paswd.equals(password)){
			//判断新密码是否和旧密码一致
			if(paswd.equals(newPassword)){
				return ResultHandleUtil.resultHandle(ContantUtil.FAIL,"REPEAT");
			}else{
				//更新用户密码
//				member.setPhone(null);
				user.setPassword(newPassword);
				tMemberDAO.updateByPrimaryKeySelective(user);
//				request.getSession().removeAttribute("user");
				return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
			}
		}
		return ResultHandleUtil.resultHandle(ContantUtil.FAIL,"ERROR");
	}
	
	
	/**
	 * 更新密码
	 * 
	 * @param tMember
	 * @param password
	 * @return
	 */
	@RequestMapping("/tmember/resetPassword")
	public HashMap<String, Object> resetPassword(String cellphone,String password) throws SQLException{
		TMemberExample example=new TMemberExample();
		com.bean.TMemberExample.Criteria cri = example.createCriteria();
		cri.andPhoneEqualTo(cellphone);
		List list = tMemberDAO.selectByExample(example);
		if( list.size() > 0) {
			TMember mber = (TMember)list.get(0);
			mber.setPassword(password);
			tMemberDAO.updateByPrimaryKeySelective(mber);
		}
		return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
	}
	
	/**
	 * 
	 * @描述:注册 
	 * @作者: john
	 */
	@RequestMapping("/tmember/reg")
	public HashMap<String, Object> reg(TMember tMember,HttpServletRequest request) throws SQLException{
//		String password = MD5Util.MD5Encode(tMember.getPassword(), "utf-8");
		tMember.setPassword(tMember.getPassword());
		tMember.setRegTime(DateUtil.getDate());
		tMember.setBalance(new BigDecimal(0));
		tMemberDAO.insert(tMember);
		request.getSession().setAttribute("user", tMember);
		//首次注册送10元优惠券，有效期一个月
		couponController.insert(tMember.getId(), new BigDecimal(10), 1,"首次注册送优惠券", "1", "month");
		return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
	}

	@RequestMapping("/tmember/openid")
	public HashMap<String, Object> openid(HttpServletRequest request) throws SQLException{
		LogUtils.info("set openid");
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		if(request.getSession().getAttribute("openid")==null||request.getSession().getAttribute("openid").equals("")){
			LogUtils.info("session中不存在openid");
			request.getSession().removeAttribute("user");
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
		else{
			LogUtils.info("session中有openid");
			tMember.setOpenid((String)request.getSession().getAttribute("openid"));
			tMemberDAO.updateByPrimaryKeySelective(tMember);
			request.getSession().removeAttribute("openid");
			return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);

		}
	}
	/**
	 * 注册验证码的校验
	 * 
	 * 
	 * @param code
	 * @param phone
	 * @param response
	 * @throws SQLException
	 */
	@RequestMapping("/tmember/validate_code")
	public HashMap<String, Object> validate_code(String code, String phone,HttpServletResponse response) throws SQLException{
		boolean result = phoneCodeController.codeTest(phone, code);
		if(result){
			return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
		}else{
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
	}
	

	/**
	 * 
	 * 获取验证码
	 * 
	 * @param codeType
	 * @param phone
	 * @param response
	 * @param status
	 * @throws SQLException
	 */
	@RequestMapping("/tmember/getCode")
	public HashMap<String, Object> getCode(String codeType, String phone,HttpServletResponse response) throws SQLException{
		//判断是否注册过
		TMemberExample tMemberExample=new TMemberExample();
		com.bean.TMemberExample.Criteria tmemberCri = tMemberExample.createCriteria();
		tmemberCri.andPhoneEqualTo(phone);
		int tmemberCount=tMemberDAO.countByExample(tMemberExample);
		//找回密码页面调用
		if("1".equals(codeType)){
			if(tmemberCount == 0){
				return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);			
			}else{
				sendCode(phone, codeType);
				return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
			}
		}else{
			//用户注册
			if(tmemberCount>0){
				return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
			}else{
				sendCode(phone, codeType);
				return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
			}
		}
	}
	
	
	/**
	 * 保存或更新验证码
	 * 
	 * 
	 * @param phone
	 * @throws SQLException
	 */
	public void sendCode(String phone, String type) throws SQLException{
		String codeString = RandomUtil.getNum(4);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 10); 
		String validTime = DateUtil.getDate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
		PhoneCodeExample example = new PhoneCodeExample();
		Criteria cri = example.createCriteria();
		cri.andPhoneEqualTo(phone);
		List<PhoneCode> list = phoneCodeDAO.selectByExample(example);
		if(list == null||list.size() == 0){
			PhoneCode phoneCode = new PhoneCode();
			phoneCode.setPhone(phone);
			phoneCode.setCode(codeString);
			phoneCode.setValidtime(validTime);
			phoneCode.setType(new Byte("1"));
			phoneCodeDAO.insert(phoneCode);
		}
		else{
			PhoneCode phoneCode = list.get(0);
			phoneCode.setCode(codeString);
			phoneCode.setValidtime(validTime);
			phoneCodeDAO.updateByPrimaryKeySelective(phoneCode);
		}
		//发送手机验证码
		if(type == "1"){
			SmsBaseUtil.SendSms(phone, "欢迎使用一道通停车，您正通过一道通停车修改密码，验证码为："+codeString);
		}else{
			SmsBaseUtil.SendSms(phone, "欢迎使用一道通停车，验证码为："+codeString);
		}
	}
	
	@RequestMapping("/weixin/unbind")
	public HashMap<String, Object> unbind(HttpServletRequest request,HttpServletResponse response) throws SQLException{
		TMember user=(TMember) request.getSession().getAttribute("user");
		TMember tMember=tMemberDAO.selectByPrimaryKey(user.getId());
		tMember.setOpenid(null);
		tMemberDAO.updateByPrimaryKey(tMember);
		return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
		
	}
}
