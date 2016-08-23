package com.sigmatrix.sc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sigmatrix.sc.web.controller.common.BaseController;

@Controller
public class UnauthorizedController extends BaseController {

	@RequestMapping(value = "/unauthorized")
	public String unauthorized() {
		return "WEB-INF/pages/unauthorized";
	}

}
