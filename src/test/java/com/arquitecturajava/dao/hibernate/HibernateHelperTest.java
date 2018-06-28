package com.arquitecturajava.dao.hibernate;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.utils.UtilSpring;

public class HibernateHelperTest {
	SessionFactory factoria = null;

	@Before
	public void setUp() throws Exception {
		factoria = (SessionFactory)UtilSpring.getBean("sessionFactory");
	}

	//@Test
	public void test() {
		assertNotNull(factoria);
	}

}
