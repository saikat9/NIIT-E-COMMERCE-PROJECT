package com.niit.s190127.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.model.Category;



@Controller
public class CategoryController {
	
	@Autowired
	GenericDao categoryDAO;
	
	//Method to display existing categories
	@RequestMapping(value= {"/listcategories","*/listcategories"})
    public String displayCategory(Model categoryModel)
    {
		List<Object> categoryList = categoryDAO.listing();
		categoryModel.addAttribute("categoryList", categoryList);
		return "Category";
    }
	
	//Method to add category
	@RequestMapping(value= {"/includecategory","*/includecategory"},method=RequestMethod.POST)
    public String insertCategory(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model categoryModel)
    {
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.addition(category);
		List<Object> categoryList = categoryDAO.listing();
		categoryModel.addAttribute("categoryList", categoryList);	
		return "Category";
		
    }
	
	//Method to delete category from category list
	@RequestMapping(value= {"/{categoryId}/removeCategory","*/{categoryId}/removeCategory"})
    public String removeCategory(@PathVariable("categoryId")int categoryId,Model categoryModel)
    {
		Object category = categoryDAO.retrieval(categoryId);
		categoryDAO.deletion(category);
		List<Object> categoryList = categoryDAO.listing();
		categoryModel.addAttribute("categoryList", categoryList);	
		return "Category";
    } 
	
	//Method to display update category page
	@RequestMapping(value= {"/amendCategory/{categoryId}","*/amendCategory/{categoryId}"})
    public String amendCategory(@PathVariable("categoryId")int categoryId,Model categoryModel)
    {
		Object category = categoryDAO.retrieval(categoryId);
		categoryModel.addAttribute("category", category);	
		List<Object> categoryList = categoryDAO.listing();
		categoryModel.addAttribute("categoryList", categoryList);			
		return "ModifyCategory";
    }	
		
	//Method to update category 
	@RequestMapping(value= {"/modifyCategory","*/modifyCategory"},method=RequestMethod.POST)
    public String modifyCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model categoryModel)
    {
		Object categoryObj = categoryDAO.retrieval(categoryId);
		Category category =(Category)categoryObj;
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.updation(category);
		List<Object> categoryList = categoryDAO.listing();
		categoryModel.addAttribute("categoryList", categoryList);	
		return "Category";
    }	
}	