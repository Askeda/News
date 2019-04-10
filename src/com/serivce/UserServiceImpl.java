package com.serivce;

import com.Dao.UserDao;
import com.Dao.UserDaoImpl;
import com.entity.User;

public class UserServiceImpl implements UserService {
	UserDao ud=new UserDaoImpl();
	@Override
	public boolean login(User user) {
		return ud.login(user);
	}

	@Override
	public boolean reg(User user) {
		return ud.reg(user);
	}

	@Override
	public boolean useryan(User user) {
		// TODO Auto-generated method stub
		return ud.useryan(user);
	}

	@Override
	public boolean Um(User user) {
		// TODO Auto-generated method stub
		return ud.Um(user);
	}

}
