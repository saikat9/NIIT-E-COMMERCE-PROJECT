package com.niit.s190127.ecomm.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.s190127.ecomm.dao.GenericDao;

@Controller
public class LoginController {
	
	//Method to redirect to admin/user page based on user role
	
	@Autowired
	GenericDao categoryDAO;
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session,Model loginModel )
	{
		String loginPage="";
		boolean loggedIn=false;
		SecurityContext secContext=SecurityContextHolder.getContext();
		Authentication authentication=secContext.getAuthentication();
		String username=authentication.getName();
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
            switch (role.getAuthority()) {
			case "Admin":
			case "User":	
				loggedIn=true;
				loginPage="Home";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);				
				break;
			default:
				loggedIn=false;
				loginPage="Home";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);				
				break;
			}
		}
		List<Object> categoryList = categoryDAO.listing();
		loginModel.addAttribute("categoryList", categoryList);			
		return loginPage; 
	}
	
	
	//Handling authentication failure
	
	@RequestMapping(value="/login_failure")
	public String loginFailure(Model loginModel)
	{	
		loginModel.addAttribute("requesturl", "/login_failure");
		return "Login";
	}

}


