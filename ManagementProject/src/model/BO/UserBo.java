package model.BO;

import entities.User;
import model.DAO.UserDao;

public class UserBo {
	private final UserDao userDao;
	
	public UserBo() {
		userDao = new UserDao();
	}
	
	public User checkLogin(String email, String password) {
		return userDao.checkLogin(email, password);
	}
}
