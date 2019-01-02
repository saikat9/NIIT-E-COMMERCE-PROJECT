package com.niit.s190127.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.dao.UserDetailDao;
import com.niit.s190127.ecomm.model.UserDetail;

@Controller
public class HomePageController {
	
	@Autowired
	GenericDao categoryDAO;
	@Autowired
	UserDetailDao userDetailDAO;
   
	//Method to display login page
   @RequestMapping(value= {"/login","*/login"})
   public String loginPage()
   {
	   
	   return "Login";
	   
   }
   
   //Method to show registration page
   @RequestMapping(value= "/register")
   public String showRegistrationPage(Model userDetailModel)
   {
	   UserDetail userdetailsEmpty = new UserDetail();
	   userDetailModel.addAttribute("userdetails",userdetailsEmpty);
	   return "Register";
   }
   
   //Method to register user

   @RequestMapping(value= "/processregistration",method=RequestMethod.POST)
   public String registerPage(@ModelAttribute("userdetails")UserDetail userdetails,Model userDetailModel)
   {
	   //This method would store user's password in encrypted format in database
	   BCryptPasswordEncoder pwd= new BCryptPasswordEncoder();
	   String encPassword =pwd.encode(userdetails.getPassword());
	   userdetails.setPassword(encPassword);
	   userDetailDAO.registerUser(userdetails);
	   UserDetail userdetailsEmpty = new UserDetail();
	   userdetailsEmpty.setMessage(userdetails.getMessage());
	   userDetailModel.addAttribute("userdetails",userdetailsEmpty);
	   return "Register";
	   
   }
   
   //Method to display home page
   @RequestMapping(value="/home")
   public String homePage(Model home)
   {

		List<Object> categoryList = categoryDAO.listing();
		home.addAttribute("categoryList", categoryList);	   
	    return "Home";
	   
   }   
   
   //Method to display aboutus page
   @RequestMapping(value= {"/aboutus","*/aboutus"})
   public String aboutusPage(Model aboutUs)
   {

		List<Object> categoryList = categoryDAO.listing();
		aboutUs.addAttribute("categoryList", categoryList);	   
	    return "AboutUs";
	   
   }   
   
   //Method to display contact us page
   @RequestMapping(value= {"/contactus","*/contactus"})
   public String contactusPage(Model contactUs)
   {
	   List<Object> categoryList = categoryDAO.listing();
	   contactUs.addAttribute("categoryList", categoryList);	 	   
	   return "ContactUs";
	   
   } 
}