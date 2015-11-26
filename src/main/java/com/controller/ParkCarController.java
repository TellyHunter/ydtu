package com.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CarPayRule;
import com.bean.CarPayRuleExample;
import com.bean.Page;
import com.bean.TCompanyPark;
import com.bean.TMember;
import com.bean.TMemberCar;
import com.bean.TMemberCarExample;
import com.bean.TParkCar;
import com.bean.TParkCarExample;
import com.mapper.CarPayRuleMapper;
import com.mapper.ChargeMapper;
import com.mapper.TCompanyParkMapper;
import com.mapper.TMemberCarMapper;
import com.mapper.TParkCarMapper;
import com.service.auth.Permission;
import com.util.ContantUtil;
import com.util.DateUtil;
import com.util.LogUtils;
import com.util.ResultHandleUtil;

@RestController
public class ParkCarController {
	
	@Autowired
	private TCompanyParkMapper tCompanyParkDAO;
	@Autowired
	private CarPayRuleMapper carPayRuleDAO;
	@Autowired
	private TParkCarMapper tParkCarDAO;
	@Autowired
	private TMemberCarMapper tMemberCarDAO;
	
	/**
	 * 
	 * @描述:  停车场月卡缴费列表
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/tparkcar/getList")
	public HashMap<String, Object> getList(HttpServletRequest request, Page page) throws SQLException {
		TMember member = (TMember)request.getSession().getAttribute("user");
		
		TParkCarExample parkExample = new TParkCarExample();
		parkExample.createCriteria().andMemberIdEqualTo(member.getId());
		/*查询条件*/
		
		int count = tParkCarDAO.countByExample(parkExample);
		page.setCount(count);
		parkExample.setLimitStart(page.getStart());
		parkExample.setLimitEnd(page.getPageSize());
		
		List<TParkCar> parkCarList = tParkCarDAO.selectByExample(parkExample);
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, parkCarList, page);
	}
	

	/**
	 * 
	 * @描述:  根据id得到月卡
	 * @作者: john
	 */
	@RequestMapping("/tparkcar/getBean")
	public HashMap<String, Object> getBean(int id){
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, tParkCarDAO.selectByPrimaryKey(id));
	}
//	/**
//	 * 
//	 * @描述: 停车场月卡申请
//	 * @作者: john
//	 */
//	@Permission
//	@RequestMapping("/tparkcar/save")
//	public HashMap<String, Object> save(TParkCar parkCar, HttpServletRequest request) throws SQLException {
//		TMember member = (TMember)request.getSession().getAttribute("user");
//		parkCar.setStatus(new Byte("2"));
//		//获取物业公司id
//		int parkId = parkCar.getParkId();
//		TCompanyPark companyPark = tCompanyParkDAO.selectByPrimaryKey(parkId);
//		if(null != companyPark){
//			int companyId = companyPark.getCompanyId();
//			parkCar.setCompanyId(companyId);
//		}
//		
//		//获取汽车id
//		String carPlate = parkCar.getCarPlate();
//		TMemberCarExample memberCar = new TMemberCarExample();
//		memberCar.createCriteria().andCarPlateEqualTo(carPlate);
//		List<TMemberCar> list = tMemberCarDAO.selectByExample(memberCar);
//		if(ResultHandleUtil.listIsNotNull(list)){
//			TMemberCar car = (TMemberCar)list.get(0);
//			int carId = car.getId();
//			//得到月卡缴费规则
//			CarPayRuleExample ruleExample = new CarPayRuleExample();
//			ruleExample.createCriteria().andParkIdEqualTo(parkId).andTypeEqualTo(car.getCarType());
//			List<CarPayRule> ruleList = carPayRuleDAO.selectByExample(ruleExample);
//			if(null != ruleList && ruleList.size() > 0){
//				CarPayRule payRule = (CarPayRule)ruleList.get(0);
//				parkCar.setPayRule(payRule.getId());
//			}
//			parkCar.setCarId(carId+"");
//		}
//		//获取当前时间，设置创建时间，初始化更新时间
//		String currentTime = DateUtil.getDate("yyyy-MM-dd HH:mm:ss");
//		parkCar.setCreateTime(currentTime);
//		parkCar.setUpdateTime(currentTime);
//		parkCar.setMemberId(member.getId());
//		LogUtils.infoDatabase("保存月卡", parkCar);
//		return ResultHandleUtil.dataUpdateResult(tParkCarDAO.insert(parkCar));
//	}
//
//	/**
//	 * 防止用户重复申请,物业还未添加月卡规则,用户同样不能申请
//	 * 
//	 * @param parkId
//	 * @param carPlate
//	 * @param response
//	 * @return 
//	 * @throws SQLException
//	 */
//	@RequestMapping("/tparkcar/check")
//	public HashMap<String, Object> payment_check(int parkId, String carPlate, HttpServletResponse response) throws SQLException{
//		
//		TParkCarExample example = new TParkCarExample();
//		example.createCriteria().andParkIdEqualTo(parkId).andCarPlateEqualTo(carPlate);
//		int count = tParkCarDAO.countByExample(example);
//		
//		TMemberCarExample carExample = new TMemberCarExample();
//		carExample.createCriteria().andCarPlateEqualTo(carPlate);
//		List<TMemberCar> list = tMemberCarDAO.selectByExample(carExample);
//		
//		if(count >= 1){
//			return ResultHandleUtil.resultHandle(ContantUtil.FAIL, "REPEAT");
//		}	
//		
//		if(list.size() > 0){
//			TMemberCar car = (TMemberCar)list.get(0);
//			//得到月卡缴费规则
//			CarPayRuleExample ruleExample = new CarPayRuleExample();
//			ruleExample.createCriteria().andParkIdEqualTo(parkId).andTypeEqualTo(car.getCarType());
//			List<CarPayRule> ruleList = carPayRuleDAO.selectByExample(ruleExample);
//			if(ruleList.size() == 0){
//				return ResultHandleUtil.resultHandle(ContantUtil.FAIL, "NORULE");
//			}
//		}
//		
//		return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
//	}
	
	
//	/**
//	 * 
//	 * @描述: 月卡缴费
//	 * @作者: john
//	 */
//	@RequestMapping("/tparkcar/charge")
//	public HashMap<String, Object> payment_charge(Charge charge,String new_endDate_hidden,String companyId,String tParkCar_id, HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException{
//		TMember member = (TMember)request.getSession().getAttribute("user");
//		String orderId = DateUtil.getDate("yyyyMMddHHmmss")+RandomUtil.getNum(4);
//		BigDecimal amount = charge.getAmount();
//		String payway = charge.getType();
//		String codeurl = "";
//		
//		//插入数据到charge表
//		charge.setAmount(amount);
//		//设置订单号
//		charge.setOrderId(orderId);
//		//设置支付类型
//		charge.setType(payway);
//		//设置订单时间
//		charge.setOrderTime(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
//		//设置支付状态
//		charge.setResult("0");
//		//设置外部订单号
//		charge.setOutTradeNo("");
//		//设置用户id
//		charge.settMemberId(member.getId());
//		charge.setCompanyId(Integer.parseInt(companyId));
//		chargeDAO.insert(charge);
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		try{
//			if("0".equals(payway)){
//				InetAddress netAddress = InetAddress.get list.size() > 0();
//				String  list.size() > 0String = netAddress.getHostAddress();
//				//微信支付接口
//				WxPayDto tpWxPay1 = new WxPayDto();
//				tpWxPay1.setBody("充值");
//				tpWxPay1.setOrderId(orderId);
//				tpWxPay1.setSpbillCreateIp( list.size() > 0String);
//				tpWxPay1.setTotalFee(amount.toString());
//				tpWxPay1.setAttach("1,"+ charge.getId());
//				codeurl = WeixinUtil.getCodeurl(tpWxPay1);
//				if(StringUtil.isNotEmpty(codeurl)){
//					map.put("codeurl", codeurl);
//					map.put("amount", amount);
//					map.put("orderId", orderId);
//				}else{
//					map.put("msg", "error2");
//				}
//				return CommonUtil.resultHandle(ContantUtil.SUCCESS, map);
//			}else if("1".equals(payway)){
//				AlipayDTO alipayDTO=new AlipayDTO();
//				alipayDTO.setWIDout_trade_no(orderId);
//				alipayDTO.setWIDtotal_fee(String.valueOf(amount));
//				alipayDTO.setWIDbody(new String("一道通停车".getBytes("utf-8"), "ISO-8859-1"));
//				alipayDTO.setWIDsubject(new String("一道通停车".getBytes("utf-8"), "ISO-8859-1"));
//				alipayDTO.setWIDshow_url("");
//				String ssString=AlipayUtil.alipay_pc(alipayDTO, response);
//				OutUtil.ajax_return(response, ssString);
//				return null;
//			}
//		}catch(Exception e){
//			return null;
//		}
//		return null;
////		TParkCar tParkCar=new TParkCar();
////		tParkCar.setId(Integer.valueOf(tParkCar_id));
////		tParkCar.setEndDate(new_endDate_hidden);
////		tParkCarDAO.updateByPrimaryKeySelective(tParkCar);
//		
//	}
	
//	/**
//	 * 
//	 * @throws SQLException 
//	 * @描述: 月卡删除
//	 * @作者: john
//	 */
//	@Permission
//	@RequestMapping("/tparkcar/delete")
//	public HashMap<String, Object> monthcar_delete(int id, HttpServletResponse response) throws SQLException{
//		TParkCar parkCar = tParkCarDAO.selectByPrimaryKey(id);
//		if(parkCar.getEndDate().compareTo(DateUtil.getDate("yyyy-MM-dd")) > 0){
//			return ResultHandleUtil.resultHandleNoData("NOEXPIRE");
//		}else{
//			return ResultHandleUtil.dataUpdateResult(tParkCarDAO.deleteByPrimaryKey(id));
//		}
//	}
	
	/**
	 * 
	 * @描述: 异步返回用户拥有的月卡数量
	 * @作者: john
	 */
	@RequestMapping("/tparkcar/getCount")
	public HashMap<String, Object> getCount(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		TMember member = (TMember)request.getSession().getAttribute("user");
		TParkCarExample example = new TParkCarExample();
		example.createCriteria().andMemberIdEqualTo(member.getId());
		return ResultHandleUtil.countHandleResult(ContantUtil.SUCCESS, tParkCarDAO.countByExample(example));
	}
	public static void main(String[] args) {
		String s = DateUtil.getDate("yyyy-MM-dd");
		System.out.println(s);
		int a = s.compareTo("2015-11-10");
		int b = s.compareTo("2015-03-05");
		System.out.println(a);
		System.out.println(b);
	}
}
