package com.chf.service;

import java.util.List;

import com.chf.dao.UserDao;
import com.chf.entity.User;

public class UserService 
{
	UserDao userDao;
	public List<User> findUser(String userName)
	{
		userDao=new UserDao();
		List<User> list= userDao.selectByName(userName);
		for(User user:list)
		{
			System.out.println(user.getUserName());
		}
		return list;
	}
}
