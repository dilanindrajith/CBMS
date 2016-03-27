package com.cbms.web.login;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.menu.MenuModel;

import com.cbms.model.entity.UserType;
import com.cbms.service.login.LoginService;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(LoginBean.class);

	private String userName;
	private String userType;
	private String password;
	private boolean loggedIn;

	private Integer selectedTypeId;
	private List<UserType> typeList;
	private UserType typeObj;

	@ManagedProperty(value = "#{NavigationBean}")
	private NavigationBean navigationBean;

	@ManagedProperty(value = "#{LoginService}")
	private LoginService loginService;

	private MenuModel menuModel;

	@PostConstruct
	public void init() {

		// typeList =
		// getLoginService().getTypeService().loadDisplayList(ActionTypeEnum.EXTERNAL.getActionType());

	}

	public String doLogin() {
		try {
			logger.info("<--Execute doLogin-->");
			String validationMsg = validater();
			String msgArr[] = validationMsg.split("@");
			if (!msgArr[0].contains("SEVERITY_ERROR")) {

				logger.info("<-- getUserName-->" + getUserName());
				logger.info("<-- getPassword-->" + getPassword());

				boolean loginState = loginService.validateLogin(getUserName(), getPassword());

				logger.info("<-- loginState-->" + loginState);

				if (loginState) {
					logger.info("<-- Login-->");
					setLoggedIn(true);
					setMenuModel(loginService.getAdminMenuModel());
					return navigationBean.redirectIndex();

				} else {
					logger.info("<-- Login Fail-->");
					return navigationBean.redirectToLogin();
				}
			} else {
				logger.info("<-- else-->");
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgArr[1], "");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				return navigationBean.redirectToLogin();

			}
		} catch (Exception e) {
			logger.error("--doLogin-->" + e);
			return navigationBean.redirectToLogin();
		}

	}

	public String doLogout() throws IOException {
		logger.info("<--Execute LoginBean Logout()-->");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("LoginBean");
		this.menuModel = null;
		return navigationBean.redirectToLogin();
	}

	public String doHome() {
		logger.info("<--Execute LoginBean doHome()-->");
		return navigationBean.redirectIndex();
	}

	public String doActivate() {
		return null;
	}

	private String validater() {
		String rtnMsg = "SEVERITY_INFO@OK";

		if (getUserName() == null && getUserName().equals("")) {
			rtnMsg = "SEVERITY_ERROR@User Name is Required";
			return rtnMsg;
		}

		if (getPassword() == null && getPassword().equals("")) {
			rtnMsg = "SEVERITY_ERROR@Password is Required";
			return rtnMsg;
		}

		return rtnMsg;
	}

	public void onUserTypeChange() {
		logger.info("<--Execute onUserTypeChange-->");
		try {
			if (getSelectedTypeId() != null && getTypeList() != null && !getTypeList().isEmpty()) {
				Iterator<UserType> iterator = getTypeList().iterator();
				while (iterator.hasNext()) {
					UserType userType = iterator.next();
					if (userType != null && userType.getId() == getSelectedTypeId()) {
						this.typeObj = userType;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error : onUserTypeChange-->" + e);
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Integer getSelectedTypeId() {
		return selectedTypeId;
	}

	public void setSelectedTypeId(Integer selectedTypeId) {
		this.selectedTypeId = selectedTypeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}

	public List<UserType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<UserType> typeList) {
		this.typeList = typeList;
	}

	public UserType getTypeObj() {
		return typeObj;
	}

	public void setTypeObj(UserType typeObj) {
		this.typeObj = typeObj;
	}

}
