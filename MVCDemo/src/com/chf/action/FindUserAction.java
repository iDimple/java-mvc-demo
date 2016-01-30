package com.chf.action;

import java.util.List;

import com.chf.entity.User;
import com.chf.service.UserService;

public class FindUserAction extends Action
{
	private UserService userService;
	private String userName;
	@Override
	public String execute()
	{
		userName=request.getParameter("userName");
		userService=new UserService();
		List<User> users=userService.findUser(userName);
		request.setAttribute("users",users);
		return "showUsers.jsp";
	}
}
