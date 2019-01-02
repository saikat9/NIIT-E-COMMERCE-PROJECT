package com.niit.s190127.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.s190127.ecomm.dao.CartItemDao;
import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.model.CartItem;
import com.niit.s190127.ecomm.model.Product;

@Controller
public class CartController {

	@Autowired
	CartItemDao cartItemDAO;
	
	@Autowired
	GenericDao productDAO;
	@Autowired
	GenericDao categoryDAO;	
	
	//Method to display cartItems for user 
	@RequestMapping(value="/cartitems")
	public String showCart(HttpSession httpSession,Model cartModel )
	{
		String userName=(String)httpSession.getAttribute("username");
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		cartModel.addAttribute("listCartItems", listCartItems); 
		cartModel.addAttribute("cartTotalPrice", this.cartPriceSum(listCartItems)); 
		List<Object> categoryList = categoryDAO.listing();
		cartModel.addAttribute("categoryList", categoryList);	  
		return "Cart";
	}
	
	//Method to add cartItem from user input
	@RequestMapping(value= {"/addtocart/{productId}","*/addtocart/{productId}"},method=RequestMethod.POST)
    public String insertCartItem(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model cartModel,HttpSession httpSession )
    {
	
		CartItem cartItem=new CartItem();
		String userName=(String)httpSession.getAttribute("username");
		Product product=(Product)productDAO.retrieval(productId);
		cartItem.setProductId(productId);
		cartItem.setPrice(product.getPrice());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setStatus("Created");
		cartItem.setUserName(userName);
		cartItemDAO.amendCartItem(cartItem);
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		cartModel.addAttribute("listCartItems", listCartItems); 
		cartModel.addAttribute("cartTotalPrice", this.cartPriceSum(listCartItems)); 
		List<Object> categoryList = categoryDAO.listing();
		cartModel.addAttribute("categoryList", categoryList);		
		return "Cart";
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
	
	//Method to display update cart page
	@RequestMapping(value= {"/amendcartitem/{cartId}","*/amendcartitem/{cartId}"})
    public String amendCartItem(@PathVariable("cartId")int cartId,Model cartModel)
    {
		CartItem cartItem= cartItemDAO.retrieveCartItem(cartId);
        cartModel.addAttribute("cartItem", cartItem);	
		List<Object> categoryList = categoryDAO.listing();
		cartModel.addAttribute("categoryList", categoryList);        
		return "ModifyCart";
    }		
	
	//Method to update cart item by user
	@RequestMapping(value= {"/modifyCart","*/modifyCart"})
	public String modifyCart(@RequestParam("cartId")int cartId,@RequestParam("quantity")int quantity,Model cartModel,HttpSession httpSession)
	
	{
		String userName=(String)httpSession.getAttribute("username");
		CartItem cartItem= cartItemDAO.retrieveCartItem(cartId);
		cartItem.setQuantity(quantity);
		List<CartItem> lstCartItems = cartItemDAO.listCartItems(userName);
		int qty=quantity;
		for (CartItem crtItem:lstCartItems) 
		{
		    if ((crtItem.getProductId()==cartItem.getProductId())
		    	&& crtItem.getCartId()!=cartItem.getCartId())
		       {
		    	  qty=qty+crtItem.getQuantity();
		       }
		}
		Product product=(Product)productDAO.retrieval(cartItem.getProductId());
		if(qty > product.getStock())
		{
	        cartModel.addAttribute("cartItem", cartItem);	
			List<Object> categoryList = categoryDAO.listing();
			cartModel.addAttribute("categoryList", categoryList);    			
			cartModel.addAttribute("warning", "Amended quantity is more than product stock"); 
			return "ModifyCart";
		}
		else
		{	
		    cartItemDAO.amendCartItem(cartItem);
		    List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		    cartModel.addAttribute("listCartItems", listCartItems);
		    cartModel.addAttribute("cartTotalPrice", this.cartPriceSum(listCartItems));
		    List<Object> categoryList = categoryDAO.listing();
		    cartModel.addAttribute("categoryList", categoryList);
		    return "Cart";
		}
	}
	
	//Method to delete cart item by user
	@RequestMapping(value= {"/removecartitem/{cartId}","*/removecartitem/{cartId}"})
	public String removeCartItem(@PathVariable("cartId")int cartId,Model cartModel,HttpSession httpSession)
	{
		String userName=(String)httpSession.getAttribute("username");
		CartItem cartItem= cartItemDAO.retrieveCartItem(cartId);
		cartItemDAO.removeCartItem(cartItem);
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		cartModel.addAttribute("listCartItems", listCartItems);
		cartModel.addAttribute("cartTotalPrice", this.cartPriceSum(listCartItems));		
		List<Object> categoryList = categoryDAO.listing();
		cartModel.addAttribute("categoryList", categoryList);
		return "Cart";
	}
	
	//Method to process checkout	
	@RequestMapping(value="/checkout")
	public String prepareOrder(Model cartModel,HttpSession httpSession)
	{
		String userName=(String)httpSession.getAttribute("username");
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		cartModel.addAttribute("listCartItems", listCartItems);
		cartModel.addAttribute("cartTotalPrice", this.cartPriceSum(listCartItems));		
		List<Object> categoryList = categoryDAO.listing();
		cartModel.addAttribute("categoryList", categoryList);
		return "PaymentConfirmation";		
	}
}
