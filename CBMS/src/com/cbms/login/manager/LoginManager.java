package com.cbms.login.manager;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cbms.model.entity.SysUser;
import com.cbms.model.util.HibernateUtil;

public class LoginManager {

	static final Logger logger = Logger.getLogger(LoginManager.class);

	public LoginManager() {

	}

	public boolean validateLogin(String userName, String password) {

		boolean loginState = false;
		Session session = null;
		Transaction transaction = null;
		try {

			logger.info("<--Execute validateLogin-->");
			logger.info("--userName-->" + userName);
			logger.info("--password-->" + password);

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM SysUser S WHERE S.statCode = :statCode and S.userName = :userName and S.password = :password";
			Query query = session.createQuery(hql);

			query.setParameter("statCode", new Short((short) 1));
			query.setParameter("userName", new String(userName));
			query.setParameter("password", new String(password));

			SysUser sysuser = (SysUser) query.uniqueResult();

			if (sysuser.getUserName().equals(userName) && sysuser.getPassword().equals(password)) {

				loginState = true;

			} else {
				loginState = false;
			}
		} catch (Exception e) {
			transaction.rollback();
			logger.error("--Error: validateLogin-->" + e);
		} finally {
			if (session != null)
				session.close();
		}
		return loginState;
	}
}
