package model;

import dao.UserDao;
import dao.DBManager;

public class LoginLogic {
	public boolean execute(Login login) {
		UserDao dao = new UserDao();
		User user = dao.findByLogin(login);
		return user != null;
	}
}
