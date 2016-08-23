package com.sigmatrix.sc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.web.controller.common.BaseController;

/** 
 * @author  zln:
 * @date 创建时间：2016年8月8日 下午1:02:04 
 * @parameter   
 * @return 
 */
@Controller
public class HealthcheckController extends BaseController {
	
	@RequestMapping(value = "/healthcheck")
	public ModelAndView healthcheck(HttpServletRequest request) {
		return new ModelAndView("healthcheck");
	}
}
