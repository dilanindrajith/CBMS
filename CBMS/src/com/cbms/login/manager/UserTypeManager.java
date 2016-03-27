/**
 * PRODUCT        : CBMS
 * FUNCTION       : WebFilter
 * AUTHOR         : Dilan Indrajith
 * CREATED DATE   : February 2016
 * VERSION        : 1.0
 * REMARKS        :  
 */

package com.cbms.login.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cbms.common.ActionTypeEnum;
import com.cbms.model.entity.UserType;
import com.cbms.model.util.HibernateUtil;

public class UserTypeManager {

	static final Logger logger = Logger.getLogger(UserTypeManager.class);

	public UserTypeManager() {

	}

	public List<UserType> loadUserType(String actionType) {
		logger.info("<--Execute loadUserType()-->");

		List<UserType> userTypeList = null;
		Session session = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = null;
			if (actionType.equalsIgnoreCase(ActionTypeEnum.MODIFY.getActionType()) || actionType.equalsIgnoreCase(ActionTypeEnum.DELETE.getActionType()) || actionType.equalsIgnoreCase(ActionTypeEnum.EXTERNAL.getActionType())) {
				hql = "FROM UserType C WHERE C.statCode = :statCode ORDER BY C.id";
			} else {
				hql = "FROM UserType C ORDER BY C.id";
			}
			Query query = session.createQuery(hql);
			if (actionType.equalsIgnoreCase(ActionTypeEnum.MODIFY.getActionType()) || actionType.equalsIgnoreCase(ActionTypeEnum.DELETE.getActionType()) || actionType.equalsIgnoreCase(ActionTypeEnum.EXTERNAL.getActionType())) {
				query.setParameter("statCode", new Short((short) 1));
			}
			userTypeList = query.list();
		} catch (Exception ex) {
			logger.error("--Error : loadUserType()-->" + ex);
		} finally {
			if (session != null)
				session.close();
		}

		return userTypeList;
	}

}
