package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlipayBankCodeUtil {
			//储蓄卡
			static String[][] debitCard={
					{"CMB-DEBIT","招商银行"},
					{"CCB-DEBIT","中国建设银行"},
					{"ICBC-DEBIT","中国工商银行"},
					{"GDB-DEBIT","广发银行"},
					{"BOC-DEBIT","中国银行"},
					{"CEB-DEBIT","中国光大银行"},
					{"SPDB-DEBIT","上海浦东发展银行"},
					{"PSBC-DEBIT","中国邮政储蓄银行"},
					{"BJBANK","北京银行"},
					{"SHRCB","上海农商银行"},
					{"COMM","交通银行"},
					{"CMBC","中国民生银行"},
					{"BJRCB","北京农村商业银行"},
					{"SPA-DEBIT","平安银行"},
					{"CITIC-DEBIT","中信银行"},
					{"ABC","中国农业银行"},//后加
					{"HZCBB2C","杭州银行"},//后加
					{"CIB","兴业银行"}//后加
			};
			//信用卡
			static String[][] creditCard={
					{"BOCB2C","中国银行"},
					{"ICBCB2C","中国工商银行"},
					{"CMB","招商银行"},
					{"CCB","中国建设银行"},
					{"ABC","中国农业银行"},
					{"SPDB","上海浦东发展银行"},
					{"CIB","兴业银行"},
					{"GDB","广发银行"},
					{"HZCBB2C","杭州银行"},
					{"SHBANK","上海银行"},
					{"SPABANK","平安银行"},
					{"POSTGC","中国邮政储蓄银行"},
					{"BJRCB","北京农村商业银行"},//后加
					{"SHRCB","上海农商银行"},//后加
					{"CMBC","中国民生银行"},//后加
					{"COMM","交通银行"},//后加
					{"BJBANK","北京银行"},//后加
					{"CITIC-DEBIT","中信银行"}//后加
			};
			//支付名称
			static String[][] CodeAndName={
					{"0","微信支付"},
					{"1","支付宝支付"},
					{"CMB-DEBIT","招商银行"},
					{"CCB-DEBIT","中国建设银行"},
					{"ICBC-DEBIT","中国工商银行"},
					{"COMM-DEBIT","交通银行"},
					{"GDB-DEBIT","广发银行"},
					{"BOC-DEBIT","中国银行"},
					{"CEB-DEBIT","中国光大银行"},
					{"SPDB-DEBIT","上海浦东发展银行"},
					{"PSBC-DEBIT","中国邮政储蓄银行"},
					{"BJBANK","北京银行"},
					{"SHRCB","上海农商银行"},
					{"WZCBB2C-DEBIT","温州银行"},
					{"COMM","交通银行"},
					{"CMBC","中国民生银行"},
					{"BJRCB","北京农村商业银行"},
					{"SPA-DEBIT","平安银行"},
					{"CITIC-DEBIT","中信银行"},
					{"BOCB2C","中国银行"},
					{"ICBCB2C","中国工商银行"},
					{"CMB","招商银行"},
					{"CCB","中国建设银行"},
					{"ABC","中国农业银行"},
					{"SPDB","上海浦东发展银行"},
					{"CIB","兴业银行"},
					{"GDB","广发银行"},
					{"FDB","富滇银行"},
					{"HZCBB2C","杭州银行"},
					{"SHBANK","上海银行"},
					{"NBBANK","宁波银行"},
					{"SPABANK","平安银行"},
					{"POSTGC","中国邮政储蓄银行"}
			};
			public static HashMap<String, String> getCodeName(){
				HashMap<String, String> map=new HashMap<String, String>();;
				for (int i = 0; i < CodeAndName.length; i++) {
					map.put(CodeAndName[i][0], CodeAndName[i][1]);
				}
				return map;
			}
			public static void main(String[] args) {
				System.out.println(getCodeName());
			}
			
}
