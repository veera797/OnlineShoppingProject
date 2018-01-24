package com.slokam.onlineFront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.Backend.DAO.CategoryDAO;
import com.slokam.Backend.DTO.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/contact")
	public ModelAndView contactUs()
	{
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","contact us");
		mv.addObject("userClickcontact", true);
		
		return mv;
		
	}
	
	
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","about us");
		mv.addObject("userClickabout", true);
		
		return mv;
		
	}

	
	@RequestMapping(value="show/all/products")
	public ModelAndView showAllproducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","showAllproducts");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		
		return mv;
		
	}
	
	
	@RequestMapping(value="show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","showAllproducts");
		Category category=null;
		category=categoryDAO.getId(id);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title", category.getName());
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
		
	}
	
}
