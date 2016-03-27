package com.cbms.web.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "PageBinder")
@SessionScoped
public class PageBinder implements Serializable {

	private static final long serialVersionUID = 1L;
	private String page = "home";

	public PageBinder() {

	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
