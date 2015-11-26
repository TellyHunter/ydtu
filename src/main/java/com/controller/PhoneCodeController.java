package com.controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PhoneCode;
import com.bean.PhoneCodeExample;
import com.bean.PhoneCodeExample.Criteria;
import com.mapper.PhoneCodeMapper;
import com.util.DateUtil;
import com.util.RandomUtil;
import com.util.SmsBaseUtil;

@RestController
public class PhoneCodeController {

	@Autowired
	private PhoneCodeMapper phoneCodeDAO;
	
	public boolean sendCode(String phone) throws SQLException{
		String codeString=RandomUtil.getNum(4);
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 30);
		String timeString=DateUtil.getDate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
		PhoneCode phoneCode=new PhoneCode();
		phoneCode.setPhone(phone);
		phoneCode.setCode(codeString);
		phoneCode.setType(new Byte("1"));
		phoneCode.setValidtime(timeString);
		
		PhoneCodeExample phoneCodeExample=new PhoneCodeExample();
		Criteria cri_phone = phoneCodeExample.createCriteria();
		cri_phone.andPhoneEqualTo(phone);
		List<PhoneCode> phoneCodes=phoneCodeDAO.selectByExample(phoneCodeExample);
		
		if(phoneCodes!=null&&phoneCodes.size()>0){
			phoneCode.setId(phoneCodes.get(0).getId());
			phoneCodeDAO.updateByPrimaryKey(phoneCode);
		}
		else {
			phoneCodeDAO.insert(phoneCode);
		}
		SmsBaseUtil.SendSms(phone, "验证码："+codeString+",欢迎使用一道通停车");
		return true;
	}
	
	public boolean codeTest(String phone,String code) throws SQLException{
		PhoneCodeExample phoneCodeExample=new PhoneCodeExample();
		Criteria cri = phoneCodeExample.createCriteria();
		cri.andPhoneEqualTo(phone);
		cri.andCodeEqualTo(code);
		cri.andTypeEqualTo(new Byte("1"));
		cri.andValidtimeGreaterThanOrEqualTo(DateUtil.getDate());
		List<PhoneCode> list=phoneCodeDAO.selectByExample(phoneCodeExample);
		if(list!=null&&list.size()>0){
			phoneCodeDAO.deleteByExample(phoneCodeExample);
			return true;
		}
		else{
			return false;
		}
	}
}
