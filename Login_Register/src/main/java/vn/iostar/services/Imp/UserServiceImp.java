package vn.iostar.services.Imp;

import vn.iostar.dao.Imp.UserDaoImp;
import vn.iostar.models.User;
import vn.iostar.services.UserService;

public class UserServiceImp implements UserService {
	UserDaoImp userDao = new UserDaoImp();
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = this.findByUserName(username);
		if (user != null && password.trim().equals(user.getPassWord().trim())) {
			return user;
		}
		return null;
	}
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
		}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}
	@Override
	public boolean register(String email,String username,String fullname, String password,  String phone) {
		// TODO Auto-generated method stub
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new User(1, email, username, fullname,password,null,2,phone,date));
			return true;

	}
	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}
	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExistUsername(username);
	}
	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}
	@Override
	public User FindExitUserName(String username) {
	
		return this.findByUserName(username);
	}
	
	

}
