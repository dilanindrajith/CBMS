
package com.cbms.service.login;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.cbms.login.manager.UserTypeManager;
import com.cbms.model.entity.UserType;

@ManagedBean(name = "TypeService")
@ViewScoped
public class TypeService implements Serializable {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(TypeService.class);

	public TypeService() {

	}

	// Load Customer
	public List<UserType> loadDisplayList(String actionType) {
		UserTypeManager userTypeManager = new UserTypeManager();
		List<UserType> userTypeList = userTypeManager.loadUserType(actionType);

		return userTypeList;
	}

}
