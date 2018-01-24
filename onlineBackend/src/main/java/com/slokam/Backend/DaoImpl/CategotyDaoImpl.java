package com.slokam.Backend.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slokam.Backend.DAO.CategoryDAO;
import com.slokam.Backend.DTO.Category;

@Repository("categoryDAO")
@Transactional
public class CategotyDaoImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {

		String activeCategories="from Category where active= :active";
	
		Query query=sessionFactory.getCurrentSession().createQuery(activeCategories);
		query.setParameter("active", true);
		return query.getResultList();
	}

	// getting the single category based on id

	@Override
	public Category getId(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// updating the category in the table
	@Override
	public boolean update(Category category) {

		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
   //Deleting a single category in the table
	@Override
	public boolean delete(Category category) {
		//deactive status of the category
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
