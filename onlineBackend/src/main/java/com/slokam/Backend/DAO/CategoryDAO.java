package com.slokam.Backend.DAO;

import java.util.List;

import com.slokam.Backend.DTO.Category;

public interface CategoryDAO {
	Category getId(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	

	
}
