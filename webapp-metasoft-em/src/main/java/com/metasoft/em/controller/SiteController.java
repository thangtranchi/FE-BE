package com.metasoft.em.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.metasoft.em.model.SiteModel;
import com.metasoft.em.restclient.RestClientService;

@Controller
public class SiteController {

	@Autowired
	private RestClientService restService;

	@RequestMapping(value = "/site", method = RequestMethod.GET)
	public ModelAndView handleGet() {
		ModelAndView view = new ModelAndView("site");
		view.addObject("allSites", restService.getAllSites());
		return view;
	}

	@RequestMapping(value = "/ajax/getSite", method = RequestMethod.GET)
	@ResponseBody
	public SiteModel getSiteById(@QueryParam("id") String id) {
		return restService.getSiteById(id);
	}

	@RequestMapping(value = "/ajax/addSite", method = RequestMethod.POST, headers = "Accept=*/*")
	@ResponseBody
	public SiteModel[] addSite(@RequestBody SiteModel site) {
		restService.saveSite(site);
		return restService.getAllSites();
	}

	@RequestMapping(value = "/ajax/checkSite", method = RequestMethod.POST, headers = "Accept=*/*")
	@ResponseBody
	public Boolean checkSite(@RequestBody SiteModel site) {
		return restService.checkSite(site);
	}

	@RequestMapping(value = "/ajax/deleteSite", method = RequestMethod.GET)
	@ResponseBody
	public SiteModel[] deleteSite(@QueryParam("id") String id) {
		restService.deleteSite(id);
		return restService.getAllSites();
	}

}
