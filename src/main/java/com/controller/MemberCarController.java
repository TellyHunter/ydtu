package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Page;
import com.bean.TMember;
import com.bean.TMemberCar;
import com.bean.TMemberCarExample;
import com.bean.TParkCar;
import com.bean.TParkCarExample;
import com.bean.TMemberCarExample.Criteria;
import com.google.gson.Gson;
import com.bean.TParkInOut;
import com.bean.TParkInOutExample;
import com.mapper.TMemberCarMapper;
import com.mapper.TParkCarMapper;
import com.mapper.TParkInOutMapper;
import com.service.auth.Permission;
import com.util.Base64ImgUtil;
import com.util.ContantUtil;
import com.util.DateUtil;
import com.util.MD5Util;
import com.util.PathUtil;
import com.util.RandomUtil;
import com.util.ResultHandleUtil;
import com.util.StreamTool;
import com.util.StringUtil;


@RestController
public class MemberCarController {
	@Autowired
	private TMemberCarMapper tMemberCarDAO;
	@Autowired
	private TParkInOutMapper tParkInOutDAO;
	@Autowired
	private TParkCarMapper tParkCarDAO;
	
	/**
	 * 
	 * @描述: 车牌号(车辆)列表页
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/tmembercar/getList")
	public HashMap<String, Object> getList(HttpServletRequest request, Page page) throws SQLException{
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		TMemberCarExample example = new TMemberCarExample();
		com.bean.TMemberCarExample.Criteria criteria = example.createCriteria();
		criteria.andMemberIdEqualTo(tMember.getId());
		/*查询条件*/
		int count = tMemberCarDAO.countByExample(example);
		page.setCount(count);
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getPageSize());
		List<TMemberCar> memberCarList = tMemberCarDAO.selectByExample(example);
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, memberCarList, page);
	}	
	
	/**
	 * 
	 * @描述: 车牌号(车辆)更新
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/update")
	public HashMap<String, Object> update(HttpServletRequest request, TMemberCar memberCar, String driverImage, String carImage) throws SQLException {
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		memberCar.setDriverImg(driverImage);
		memberCar.setCarImg(carImage);
		memberCar.setStatus("1");
		
		String carPlate = memberCar.getCarPlate();
		TParkCarExample example = new TParkCarExample();
		example.createCriteria().andCarPlateEqualTo(carPlate);
		List<TParkCar> list = tParkCarDAO.selectByExample(example);
		if(list.size() > 0){
			for(TParkCar t : list){
				t.setMemberId(tMember.getId());
				tParkCarDAO.updateByPrimaryKey(t);
			}
		}
		return ResultHandleUtil.dataUpdateResult(tMemberCarDAO.updateByPrimaryKeySelective(memberCar));
	}
	
	/**
	 * 
	 * @描述: 车牌号(车辆)更新
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/update2")
	public HashMap<String, Object> update(TMemberCar memberCar) throws SQLException {
		return ResultHandleUtil.dataUpdateResult(tMemberCarDAO.updateByPrimaryKeySelective(memberCar));
	}
	/**
	 * 
	 * @描述:车牌号(车辆)添加
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/save")	
	public HashMap<String, Object> save(HttpServletRequest request, TMemberCar memberCar, String driverImage, String carImage){
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		memberCar.setDriverImg(driverImage);
		memberCar.setCarImg(carImage);
		memberCar.setStatus("1");
		memberCar.setMemberId(tMember.getId());
		
		//如果改车牌下有相应的月卡信息，更新月卡carplate与memberId
		String carPlate = memberCar.getCarPlate();
		TParkCarExample example = new TParkCarExample();
		example.createCriteria().andCarPlateEqualTo(carPlate);
		List<TParkCar> list = tParkCarDAO.selectByExample(example);
		if(list.size() > 0){
			for(TParkCar t : list){
				t.setMemberId(tMember.getId());
				tParkCarDAO.updateByPrimaryKey(t);
			}
		}
		return ResultHandleUtil.dataUpdateResult(tMemberCarDAO.insert(memberCar));
	}
	
	/**
	 * 判断车牌号(车辆)是否已添加
	 * 
	 * @param carPlate
	 * @param request
	 * @param response
	 * @throws SQLException
	 */
	@RequestMapping("/tmembercar/add_check")
	public HashMap<String, Object> add_check(TMemberCar memberCar, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		TMemberCarExample example = new TMemberCarExample();
		com.bean.TMemberCarExample.Criteria criteria = example.createCriteria();
		String carPlate = memberCar.getCarPlate();
		criteria.andCarPlateEqualTo(carPlate);
//		if(memberCar.getId() != null){
//			//编辑状态
//			criteria.andMemberIdNotEqualTo(tMember.getId());
//		}
		List<TMemberCar> list = tMemberCarDAO.selectByExample(example);
		if(list.size() > 0){
			TMemberCar t = list.get(0);
			Integer memberId = t.getMemberId();
			if(null != memberId){
				if(!memberId.equals(tMember.getId())){
					return ResultHandleUtil.resultHandleNoData(ContantUtil.REPEAT);
				}
			}
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
		return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
	}

	
	/**
	 * 
	 * @描述: 车牌号(车辆)详情页面
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/getBean")
	public HashMap<String, Object>  getBean(int id, HttpServletRequest request) throws SQLException {
		TMemberCar memberCar = tMemberCarDAO.selectByPrimaryKey(id);       
		if(null != memberCar){
			return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, memberCar) ;
		}else{
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL) ;
		}
 	}

	/**
	 * 
	 * @throws SQLException 
	 * @描述: 车牌号(车辆)删除
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/delete")
	public HashMap<String, Object>  tmembercar_delete(int id, HttpServletResponse response){
		TMemberCar memberCar = tMemberCarDAO.selectByPrimaryKey(id);
		TParkCarExample carExample = new TParkCarExample();
		carExample.createCriteria().andCarPlateEqualTo(memberCar.getCarPlate());
		List list = tParkCarDAO.selectByExample(carExample);
		if(list.size() > 0){
			return ResultHandleUtil.resultHandleNoData("BUNDED");
		}else{
			return ResultHandleUtil.dataUpdateResult(tMemberCarDAO.deleteByPrimaryKey(id));
		}
	}
	
	/**
	 * 
	 * @描述: 异步返回用户拥有的车牌数量
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/getCount.htm")
	public HashMap<String, Object> getCarNums(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		TMember member = (TMember)request.getSession().getAttribute("user");
		TMemberCarExample carExample = new TMemberCarExample();
		carExample.createCriteria().andMemberIdEqualTo(member.getId());
		return ResultHandleUtil.countHandleResult(ContantUtil.SUCCESS, tMemberCarDAO.countByExample(carExample));
	}
	
	/**
	 * 
	 * @描述: 异步加载停车实况
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/parkingSituation")
	public HashMap<String, Object> parkingSituation(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException{
		TMember tMember = (TMember) request.getSession().getAttribute("user");
		//获取会员id号 
		int memberId =tMember.getId();
		TMemberCarExample tMemberCarExample = new TMemberCarExample();
		com.bean.TMemberCarExample.Criteria criteria = tMemberCarExample.createCriteria();
		criteria.andMemberIdEqualTo(memberId);
		//得到会员的所有车辆
		List<TMemberCar> tMemberCars = tMemberCarDAO.selectByExample(tMemberCarExample);
		//所有在停车的车辆
		List<TParkInOut> parkingList=new ArrayList<TParkInOut>();
		if(tMemberCars.size() > 0){
			for(TMemberCar t : tMemberCars){
				TParkInOutExample tParkInOutExample = new TParkInOutExample();
				//所有正在停车的车辆
				tParkInOutExample.createCriteria().andInCarPlateEqualTo(t.getCarPlate());
				tParkInOutExample.setOrderByClause("id desc");
				tParkInOutExample.setLimitStart(0);
				tParkInOutExample.setLimitEnd(1);
				List<TParkInOut> tparks = tParkInOutDAO.selectByExample(tParkInOutExample);
				if(tparks.size() > 0 && StringUtil.stringIsEmpty(tparks.get(0).getOutTime())){
					TParkInOut inOut = tparks.get(0);
					String todayTime = DateUtil.getDate();
					//已停车时长
					String stateTime = DateUtil.diff_time(inOut.getInTime(), todayTime);
					inOut.setStopTime(stateTime);
					parkingList.add(inOut);
				}
			}
		}
		return ResultHandleUtil.resultHandle(ContantUtil.SUCCESS, parkingList);
	}
	
	/**
	 * 
	 * @描述:通过车牌号找到会员车辆
	 * @作者:testpc
	 */
	@RequestMapping("/tmembercar/getBeanByCarPlate")
	public HashMap<String, Object> getBeanByCarPlate(HttpServletResponse response,HttpServletRequest request,String carPlate)throws SQLException{
		TMemberCarExample tMemberCarExample = new TMemberCarExample();
		Criteria criteria = tMemberCarExample.createCriteria();
		criteria.andCarPlateEqualTo(carPlate);
		List<TMemberCar> list = tMemberCarDAO.selectByExample(tMemberCarExample);//获取基础数据
		if(list!=null&&list.size()>0){
			return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, list.get(0));
		}
		else{
			return ResultHandleUtil.beanHandleResult(ContantUtil.FAIL, "");
		}
	}
	
	@RequestMapping("/tmembercar/saveWithImg")
	public HashMap<String, Object> ge_img(String driverImg,String carImg ,String carPlate,HttpServletRequest request){
		TMemberCar tMemberCar=new TMemberCar();
		tMemberCar.setDriverImg(driverImg);
		tMemberCar.setCarImg(carImg);
		tMemberCar.setCarPlate(carPlate);
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		String path=PathUtil.getPath()+"/ydtu/tmembercar/";
		File file =new File(path);    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    file .mkdirs();    
		} 
		String driverImgString=path+RandomUtil.getOrderId()+".jpg";
		String carImgString=path+RandomUtil.getOrderId()+".jpg";
		Base64ImgUtil.GenerateImage(tMemberCar.getDriverImg(),driverImgString);
		Base64ImgUtil.GenerateImage(tMemberCar.getCarImg(),carImgString);
		tMemberCar.setDriverImg(driverImgString);
		tMemberCar.setCarImg(carImgString);
		tMemberCar.setMemberId(tMember.getId());
		tMemberCar.setStatus("1");
		
		TMemberCarExample tMemberCarExample=new TMemberCarExample();
		tMemberCarExample.createCriteria().andCarPlateEqualTo(carPlate);
		tMemberCarDAO.deleteByExample(tMemberCarExample);
		
		return ResultHandleUtil.dataUpdateResult(tMemberCarDAO.insert(tMemberCar));
	}
	
	@RequestMapping("/tmembercar/updateWithLock")
	public HashMap<String, Object> updateWithLock(TMemberCar memberCar) throws IOException {
		String carPlate = memberCar.getCarPlate();
		// 1解锁2锁车
		String lockType = memberCar.getStatus();
		String message = "carPlate=" + carPlate + "&lockType=" + lockType;
		String sign = MD5Util.MD5Encode(message + "&key=" + ContantUtil.KEY, "utf-8").toUpperCase();
		message = message + "&sign=" + sign;
		String path = "http://www.dmzparking.com/ydto/app/carLock.htm?" + message;
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		InputStream inStream = conn.getInputStream();
		byte[] data = StreamTool.stream2Byte(inStream);
		String result = new String(data, "UTF-8");
		HashMap<String, String> map = new Gson().fromJson(result, HashMap.class);
		System.out.println("接收到的返回：" + map);
		String result1 = map.get("result");

		if (result1.equals(ContantUtil.SUCCESS)) {
			
		} else {

		}
		return ResultHandleUtil.dataUpdateResult(tMemberCarDAO.updateByPrimaryKeySelective(memberCar));
	}
	
	/**
	 * 
	 * @描述：验证车牌是否已添加
	 * @作者:testpc
	 */
	@RequestMapping("/tmembercar/checkIsVerify")
	public HashMap<String, Object> checkIsVerify(String carPlate, HttpServletRequest request){
		TMember tMember = (TMember) request.getSession().getAttribute("user");
		int id = tMember.getId();
		TMemberCarExample example = new TMemberCarExample();
		example.createCriteria().andMemberIdEqualTo(id).andCarPlateEqualTo(carPlate).andStatusEqualTo("3");
		int count = tMemberCarDAO.countByExample(example);
		if(count > 0){
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}else{
			return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
		}
	}
}
