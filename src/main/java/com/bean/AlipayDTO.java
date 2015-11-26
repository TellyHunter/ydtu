package com.bean;

public class AlipayDTO {
	private String WIDout_trade_no;//商户订单号
	private String WIDsubject;//订单名称
	private String WIDtotal_fee;//付款金额
	private String WIDbody;//订单描述
	private String WIDshow_url;//商品展示地址
	private String WIDdefaultbank;//银行简码
	public String getWIDout_trade_no() {
		return WIDout_trade_no;
	}
	public void setWIDout_trade_no(String wIDout_trade_no) {
		WIDout_trade_no = wIDout_trade_no;
	}
	public String getWIDsubject() {
		return WIDsubject;
	}
	public void setWIDsubject(String wIDsubject) {
		WIDsubject = wIDsubject;
	}
	public String getWIDtotal_fee() {
		return WIDtotal_fee;
	}
	public void setWIDtotal_fee(String wIDtotal_fee) {
		WIDtotal_fee = wIDtotal_fee;
	}
	public String getWIDbody() {
		return WIDbody;
	}
	public void setWIDbody(String wIDbody) {
		WIDbody = wIDbody;
	}
	public String getWIDshow_url() {
		return WIDshow_url;
	}
	public void setWIDshow_url(String wIDshow_url) {
		WIDshow_url = wIDshow_url;
	}
	public String getWIDdefaultbank() {
		return WIDdefaultbank;
	}
	public void setWIDdefaultbank(String wIDdefaultbank) {
		WIDdefaultbank = wIDdefaultbank;
	}
	
	
}
