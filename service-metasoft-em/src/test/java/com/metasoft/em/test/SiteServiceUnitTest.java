package com.metasoft.em.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metasoft.em.model.SiteModel;
import com.metasoft.em.service.SiteService;

public class SiteServiceUnitTest extends AbstractUnitTestSetup {

	@Autowired
	private SiteService serviceSite;

	@Test
	public void testGetAll() {
		assertEquals(5, serviceSite.getAll().size());
	}

	@Test
	public void testCheckDuplicatedNameSaving() {
		SiteModel model = new SiteModel(-1, "Ha Noi", null, 0, 0, true);
		assertFalse(serviceSite.checkSiteIsExisted(model));
	}

	@Test
	public void testCheckDuplicatedNameUpdating() {
		SiteModel model = new SiteModel(8, "Ha Noi", null, 0, 0, true);
		assertFalse(serviceSite.checkSiteIsExisted(model));
	}

	@Test
	public void testGetSiteByKeyword() {
		assertEquals(1, serviceSite.getSitesByKeyword("Ha").size());
	}
	
	@Test
	public void testDelete() {
		serviceSite.deleteSite(8);
		assertEquals(4, serviceSite.getAll().size());
	}
}
