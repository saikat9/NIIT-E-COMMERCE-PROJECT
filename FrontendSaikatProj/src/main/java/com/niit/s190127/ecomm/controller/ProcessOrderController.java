package com.niit.s190127.ecomm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.s190127.ecomm.dao.CartItemDao;
import com.niit.s190127.ecomm.dao.CustomerOrderDao;
import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.dao.UserDetailDao;
import com.niit.s190127.ecomm.model.CartItem;
import com.niit.s190127.ecomm.model.CustomerOrder;
import com.niit.s190127.ecomm.model.Product;
import com.niit.s190127.ecomm.model.UserDetail;

@Controller
public class ProcessOrderController 
{
	@Autowired
	CartItemDao cartItemDAO;
	@Autowired
	CustomerOrderDao customerOrderDAO;
	@Autowired
	UserDetailDao userDetailDAO;
	@Autowired
	GenericDao categoryDAO;	
	@Autowired
	GenericDao productDAO;
	
	//This page would be displayed initially with payment mode
	//radio button, in case cash payment is selected it would 
	//be redirected to receipt page but if card payment is opted 
	//it would be redirected to same page with additional card related 
	//fields and once resubmitted would be taken to receipt page 
	@RequestMapping(value="/orderprocessing",method=RequestMethod.POST)
	public String processCashOrder(@RequestParam("paymentMode")String paymentMode,@RequestParam("cardDetailsIND")String cardDetailsIND,Model orderModel,HttpSession session)
	{
		
		if(paymentMode.contains("cashPayment") || cardDetailsIND.contains("ON"))	
		 {
		   if (cardDetailsIND.contains("ON"))
		     {
			    paymentMode="cardPayment";
		     }
		   String userName=(String) session.getAttribute("username");
		   List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		   CustomerOrder customerOrder=new CustomerOrder();
		   customerOrder.setUserName(userName);
		   customerOrder.setDateOfOrder(new Date());
		   customerOrder.setPaymentMode(paymentMode);
		   customerOrder.setOrderPrice(this.cartPriceSum(listCartItems));
		   if(customerOrderDAO.updateCartStatus(userName))
		    {
		       customerOrderDAO.orderProcess(customerOrder);
		       orderModel.addAttribute("listCartItems", listCartItems);
		       orderModel.addAttribute("customerOrder", customerOrder);
		       UserDetail userDetail=userDetailDAO.fetchUser(userName);
		       orderModel.addAttribute("userDetail",userDetail);
		    }
		   List<Object> categoryList = categoryDAO.listing();
		   orderModel.addAttribute("categoryList", categoryList);	
	       this.productStockUpdate(listCartItems);	
		   return "PaymentReceipt";
		 }  
		else
		 {	
		   String userName=(String)session.getAttribute("username");
		   List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		   orderModel.addAttribute("listCartItems", listCartItems);
		   orderModel.addAttribute("cartTotalPrice", this.cartPriceSum(listCartItems));		
		   List<Object> categoryList = categoryDAO.listing();
		   orderModel.addAttribute("categoryList", categoryList);			
		   orderModel.addAttribute("cardDetailsInd", "on");
		   return "PaymentConfirmation";
		 }
	}
	

	//Calculate total price of cart items
	public int cartPriceSum(List<CartItem> listCartItems)
	{
		int totalPrice=0; 
		int counter=0;
		while (counter<listCartItems.size()) 
		{
			
			CartItem cartItem=listCartItems.get(counter);
			totalPrice=totalPrice+(cartItem.getQuantity()*cartItem.getPrice());
			counter++;
		}
		return totalPrice;
	}
	
	//Update product stock after placing order
	public void productStockUpdate(List<CartItem> listCartItems)
	{
		
		int counter=0;
		while (counter<listCartItems.size()) 
		{
			
			CartItem cartItem=listCartItems.get(counter);
			Object productObj=productDAO.retrieval(cartItem.getProductId());
		    Product product=(Product) productObj;
			product.setStock(product.getStock()-cartItem.getQuantity());
			productDAO.updation(product);
			counter++;
		}
	
	}	
}
