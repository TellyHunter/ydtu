package com.util;

import java.util.HashMap;
import java.util.List;

import com.bean.Page;

public class ResultHandleUtil {

	/**
     * 
     * @Description: 判断list不为空
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static boolean listIsNotNull(List list){
    	if(list!=null&&list.size()>0){
    		return true;
    	}
    	else {
			return false;
		}
    }
    /**
     * 
     * @Description: 新增数据和更新数据返回结果处理
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static HashMap<String, Object> dataUpdateResult(Integer  integer){
    	LogUtils.infoResult(integer);
    	if(integer>0){
    		return resultHandleNoData(ContantUtil.SUCCESS);
    	}
    	else {
    		return resultHandleNoData(ContantUtil.FAIL);
		}
    }
    /**
     * 
     * @Description: 返回数据个数结果处理
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static HashMap<String, Object> countHandleResult(String result,int count)  {
    	LogUtils.infoResult(result,count);
    	HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("result", result);
		hashMap.put("data", count);
		return hashMap;
    }
    /**
     * 
     * @Description: 返回数据列表结果处理
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static HashMap<String, Object> listHandleResult(String result,List list,Page page){
    	LogUtils.infoResult(result,list,page);
    	HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("result",result);
		hashMap.put("data",list);
		hashMap.put("page",page);
		return hashMap;
    }
    
    /**
     * 
     * @Description: 返回数据列表结果处理
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static HashMap<String, Object> objectHandleResult(String result,Object ob,Page page){
    	LogUtils.infoResult(result,ob,page);
    	HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("result",result);
		hashMap.put("data",ob);
		hashMap.put("page",page);
		return hashMap;
    }
    
    /**
     * 
     * @Description: 返回对象结果处理
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static HashMap<String, Object> beanHandleResult(String result,Object object){
    	LogUtils.infoResult(result,object);
    	HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("result",result);
		hashMap.put("data",object);
		return hashMap;
    }
    /**
     * 
     * @Description: 通用带数据结果处理
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static HashMap<String, Object> resultHandle(String result,Object object){
    	LogUtils.infoResult(result,object);
    	HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("result",result);
		hashMap.put("data",object);
		return hashMap;
    }
    /**
     * 
     * @Description: 通用不带数据结果处理
     * @author: Hunter
     * @date: 2015年9月20日 上午9:34:28
     */
    public static HashMap<String, Object> resultHandleNoData(String result){
    	LogUtils.infoResult(result);
    	HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("result",result);
		return hashMap;
    }
}
