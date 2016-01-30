package com.chf.dao;

import java.util.ArrayList;
import java.util.List;

import com.chf.entity.User;

public class UserDao 
{
	public List<User> selectByName(String userName)
	{
		List<User> list=new ArrayList<User>();
		User user=null;
		user=new User();

		user.setUserName("Zhang");
		user.setPassword("1234");
		list.add(user);
		
		user=new User();
		user.setUserName("Li");
		user.setPassword("3344");
		list.add(user);

		user=new User();
		user.setUserName("Wang");
		user.setPassword("6677");
		list.add(user);
		return list;
	}
}
