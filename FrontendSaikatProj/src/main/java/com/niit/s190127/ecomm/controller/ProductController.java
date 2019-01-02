package com.niit.s190127.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.s190127.ecomm.dao.CartItemDao;
import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.model.CartItem;
import com.niit.s190127.ecomm.model.Category;
import com.niit.s190127.ecomm.model.Product;

@Controller
public class ProductController {

	@Autowired
	GenericDao productDAO;
	@Autowired
	GenericDao categoryDAO;
	@Autowired
	CartItemDao cartItemDAO;	
	
	
	
	//Method to display existing products
	@RequestMapping(value={"/listproducts","*/listproducts"})
	public String displayProduct(Model productModel)
	{
		List<Object> productList=productDAO.listing();
		productModel.addAttribute("productList", productList);
		Product product=new Product();
		productModel.addAttribute("product", product);
		productModel.addAttribute("categoryListMap", this.fetchCategoryList(categoryDAO.listing()));
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);		
		return "Product";
		
	}
	
	//Method to add product
	@RequestMapping(value= {"/includeproduct","*/includeproduct"},method=RequestMethod.POST)
    public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile productImage,Model productModel)
    {

		productDAO.addition(product);
		String path="C:\\Users\\DELL\\eclipse-workspace\\FrontendSaikatProj\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
		//Image filename is stored as product name concatenated with product id
		path=path+String.valueOf(product.getProductName()+product.getProductId())+".jpg";
		File imageFile=new File(path);
		if(!productImage.isEmpty())
		{
			try
			{
				byte[] imageBuffer=productImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(imageBuffer);
				bos.close();
			}
			catch (Exception ex) {
  				productModel.addAttribute("Error","Exception occured during product image upload"+ex);
			}
		}
		else {
			productModel.addAttribute("Error","Exception occured during product image upload");
		}
		
		Product product1=new Product();
		productModel.addAttribute("product", product1);
		List<Object> productList=productDAO.listing();
		productModel.addAttribute("productList", productList);
		productModel.addAttribute("categoryListMap", this.fetchCategoryList(categoryDAO.listing()));
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);	
		return "Product";
    }	
	
	//Method to display update product page
	@RequestMapping(value= {"/amendProduct/{productId}","*/amendProduct/{productId}"})
    public String amendProduct(@PathVariable("productId")int productId,Model productModel)
    {
		Product product=(Product)productDAO.retrieval(productId);
		productModel.addAttribute("product", product);
		List<Object> productList=productDAO.listing();
		productModel.addAttribute("productList", productList);
		productModel.addAttribute("categoryListMap", this.fetchCategoryList(categoryDAO.listing()));
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);	
		return "ModifyProduct";		
		
    }
	
	//Method to update product 
	@RequestMapping(value= {"/modifyProduct","*/modifyProduct"},method=RequestMethod.POST)
    public String modifyProduct(@ModelAttribute("product")Product product,Model productModel)
    {
		productDAO.updation(product);
		List<Object> productList = productDAO.listing();
		productModel.addAttribute("productList", productList);
		Product product1=new Product();
		productModel.addAttribute("product", product1);		
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);	
		return "Product";
    }		
	
	//Method to delete product from product list
	@RequestMapping(value= {"/{productId}/removeProduct","*/{productId}/removeProduct"})
    public String removeProduct(@PathVariable("productId")int productId,Model productModel)
    {
		Product product=(Product)productDAO.retrieval(productId);
		productDAO.deletion(product);
		Product product1=new Product();
		productModel.addAttribute("product", product1);
		List<Object> productList=productDAO.listing();
		productModel.addAttribute("productList", productList);	
		productModel.addAttribute("categoryListMap", this.fetchCategoryList(categoryDAO.listing()));
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);	
		return "Product";
    } 	
	
	//Method to fetch list of categories w.r.t product
    public LinkedHashMap<Integer, String> fetchCategoryList(List<Object> categoryList)
    {
    	LinkedHashMap<Integer, String> listCategories=new LinkedHashMap<Integer, String>();
    	
    	for(Object category1:categoryList)
    	{
    		Category category=(Category)category1;
    		listCategories.put(category.getCategoryId(),category.getCategoryName());
    		
    	}
    	return listCategories;
    } 	
    
    //Method to display product images
    @RequestMapping(value={"/showproductimage","*/showproductimage"})
    public String displayProductImage(Model productModel)
    {
    	List<Object> productList=productDAO.listing();
    	productModel.addAttribute("productList", productList);	
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);	
    	return "ProductImage";
    }
    
    //Method to display product images category wise
    @RequestMapping(value="/showproductscategorywise/{categoryId}")
    public String displayProductCategoryWise(@PathVariable("categoryId")int categoryId,Model productModel)
    {
    	List<Object> productList=productDAO.listingCategoryWise(categoryId);
    	productModel.addAttribute("productList", productList);	
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);	
    	return "ProductImage";
    }    
    
    //Method to display product information
    @RequestMapping(value={"/productinfo/{productId}","*/productinfo/{productId}"})
    public String displayProductInfo(@PathVariable("productId")int productId,Model productModel,HttpSession httpSession)
    {
    	Product product=(Product)productDAO.retrieval(productId);
    	productModel.addAttribute("product", product);	
		List<Object> categoryList = categoryDAO.listing();
		productModel.addAttribute("categoryList", categoryList);
		String userName=(String)httpSession.getAttribute("username");
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		productModel.addAttribute("listCartItems", listCartItems); 		
    	return "ProductInfo";
    }    
    
}
