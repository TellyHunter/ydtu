package com.util.redis;

import java.io.Serializable;

public class Bean implements Serializable {//需要实现序列化接口
	  private String name;
	  private String pwd;
	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	  
	}
