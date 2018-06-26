package com.arquitecturajava.dao.hibernate;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

public class HibernateHelperTest {
	SessionFactory factory = null;

	@Before
	public void setUp() throws Exception {
		factory = HibernateHelper.getSessionFactory();
	}

	@Test
	public void test() {
		assertNotNull(factory);
	}

}
