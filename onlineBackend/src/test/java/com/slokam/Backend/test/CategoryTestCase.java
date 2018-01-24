package com.slokam.Backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.slokam.Backend.DAO.CategoryDAO;
import com.slokam.Backend.DTO.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.slokam.Backend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test
	 *  public void testAddCategory() { 
	 *  category=new Category();
	 * category.setName("Television");
	 * category.setDescription("This is the Discription about television");
	 * category.setImgURL("cat_1");
	 * 
	 * assertEquals("Successfully added a category inside a table",true,
	 * categoryDAO.add(category)); }
	 */

	/*
	 * @Test 
	 * public void testGetCategory() {
	 *  category=categoryDAO.getId(1);
	 * 
	 * 
	 * assertEquals("Successfully fetch a single category from a table"
	 * ,"Television",category.getName()); }
	 */

	/*
	 * @Test
	 *  public void testUpdatetCategory() { 
	 *  category =categoryDAO.getId(1);
	 *   category.setName("TV");
	 * 
	 * assertEquals("Successfully update a single category in the  table", true,
	 * categoryDAO.update(category)); }
	 */

	/*@Test
	public void testAllCategory() {
		

		assertEquals("Successfully fetch all categories in the  a table", 1, categoryDAO.list().size());
	}*/
	
	
	@Test
	public void testCurdOperationWithCategory() {
		//Add a category in the table
		category = new Category();
		category.setName("Television");
		category.setDescription("This is the Discription about television");
		category.setImgURL("cat_1");
        assertEquals("Successfully added a category inside a table", true, categoryDAO.add(category));
        
        category = new Category();
		category.setName("Laptop");
		category.setDescription("This is the Discription about Laptop");
		category.setImgURL("cat_2");
        assertEquals("Successfully added a category inside a table", true, categoryDAO.add(category));
        
        //update the data in the table
		category = categoryDAO.getId(1);
		category.setName("TV");
		assertEquals("Successfully update a single category in the  table", true, categoryDAO.update(category));
		
		
		//delete the data in the table
		category = categoryDAO.getId(1);
		assertEquals("Successfully update a single category in the  table", true, categoryDAO.delete(category));
		
		//fetch all the data in the table
		assertEquals("Successfully fetch all categories in the  a table", 1, categoryDAO.list().size());

		
	}
	
	

}