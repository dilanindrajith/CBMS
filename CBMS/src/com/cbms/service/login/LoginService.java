package com.cbms.service.login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.cbms.login.manager.LoginManager;

@ManagedBean(name = "LoginService")
@SessionScoped
public class LoginService implements Serializable {

	private static final long serialVersionUID = 1L;

	static final Logger logger = Logger.getLogger(LoginService.class);

	public boolean validateLogin(String userName, String password) {
		boolean loginState = false;
		logger.info("<-- userName-->" + userName);
		logger.info("<-- password-->" + password);

		LoginManager loginManager = new LoginManager();
		loginState = loginManager.validateLogin(userName, password);

		return loginState;
	}

	public MenuModel getAdminMenuModel() {
		MenuModel menuModel = null;
		try {
			logger.info("<--Execute Start DMS getMenuModel-->");

			DefaultSubMenu mainMenu = null;
			DefaultSubMenu subMenu = null;
			DefaultMenuItem function = null;

			menuModel = new DefaultMenuModel();

			mainMenu = new DefaultSubMenu("General");

			subMenu = new DefaultSubMenu("Product Catalog");

			function = new DefaultMenuItem("Product Catalog");
			function.setUrl("/pages/general/createProductCatalog.xhtml?param=create");
			function.setIcon("ui-icon-disk");
			function.setAjax(true);
			subMenu.addElement(function);

			mainMenu.addElement(subMenu);

			menuModel.addElement(mainMenu);

			mainMenu = new DefaultSubMenu("Customer");

			subMenu = new DefaultSubMenu("Customer Setup");

			function = new DefaultMenuItem("Customer Setup");
			function.setUrl("/pages/customer/createCustomer.xhtml?param=create");
			function.setIcon("ui-icon-disk");
			function.setAjax(true);
			subMenu.addElement(function);

			mainMenu.addElement(subMenu);

			subMenu = new DefaultSubMenu("Sales Invoice");

			function = new DefaultMenuItem("Sales Invoice");
			function.setUrl("/pages/customer/createSaleInv.xhtml?param=create");
			function.setIcon("ui-icon-disk");
			function.setAjax(true);
			subMenu.addElement(function);

			mainMenu.addElement(subMenu);

			menuModel.addElement(mainMenu);

			logger.info("<--Execute End getMenuModel-->");

		} catch (Exception e) {

			logger.fatal("--DynamicMenuView Error-->" + e);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Internal Error", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return menuModel;

	}

	public MenuModel getSalesRefMenuModel() {
		MenuModel menuModel = null;
		try {
			logger.info("<--Execute Start DMS getMenuModel-->");

			DefaultSubMenu mainMenu = null;
			DefaultMenuItem function = null;

			menuModel = new DefaultMenuModel();

			mainMenu = new DefaultSubMenu("Payment");

			function = new DefaultMenuItem("Create");
			function.setUrl("/pages/customer/createReceipt.xhtml?param=create");
			function.setIcon("ui-icon-disk");
			function.setAjax(true);
			mainMenu.addElement(function);

			function = new DefaultMenuItem("Modify");
			function.setUrl("/pages/customer/modifyReceipt.xhtml?param=modify");
			function.setIcon("ui-icon-check");
			function.setAjax(true);
			mainMenu.addElement(function);

			function = new DefaultMenuItem("Delete");
			function.setUrl("/pages/customer/deleteReceipt.xhtml?param=delete");
			function.setIcon("ui-icon-close");
			function.setAjax(true);
			mainMenu.addElement(function);

			function = new DefaultMenuItem("Search");
			function.setUrl("/pages/customer/viewReceipt.xhtml?param=view_print");
			function.setIcon("ui-icon-search");
			function.setAjax(true);
			mainMenu.addElement(function);

			menuModel.addElement(mainMenu);

			logger.info("<--Execute End getSalesRefMenuModel-->");

		} catch (Exception e) {

			logger.fatal("--DynamicSalesRefMenuView Error-->" + e);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Internal Error", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return menuModel;
	}

}
