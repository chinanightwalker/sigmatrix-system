package com.sigmatrix.sc.web.controller.code;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.entity.v1.BarcodeBLevel;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.BarcodeBLevelService;
import com.sigmatrix.sc.web.controller.common.BaseController;

@Controller
@RequestMapping(value = "/BarcodeBLevel")
public class BarcodeBLevelController extends BaseController {
	private static Logger logger = Logger.getLogger(BarcodeBLevelController.class);
	@Autowired
	private BarcodeBLevelService barcodeBLevelService;
	/**
	 * 成品箱码激活记录
	 */
	@RequestMapping(value = "/list")
	public ModelAndView BarcodeBLevelList(HttpServletRequest request,BarcodeBLevel barcodeBLevel){
		Map<String, Object> map = new HashMap<String, Object>();
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		PageBean<BarcodeBLevel> page=new PageBean<>(getPageNum(request));
		barcodeBLevel.setTablePrefix(getTablePrefix(request));
		try {
			page=barcodeBLevelService.getBarcodeBLeveLList(page,barcodeBLevel,startDateStr,endDateStr);
		} catch (Exception e) {
			logger.error("select BarcodeBLevelList is fail ",e);
		}
		map.put("page", page);
		map.put("startDate", startDateStr);
		map.put("endDate", endDateStr);
		//map.put("barcodeBLevel",barcodeBLevel);
		return new ModelAndView(JSP_PREFIX+"barcodeBLevel/list",map);
		
		
	}
}
