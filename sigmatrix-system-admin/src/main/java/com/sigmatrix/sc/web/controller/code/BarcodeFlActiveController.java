package com.sigmatrix.sc.web.controller.code;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sigmatrix.sc.entity.v1.BarcodeFlActiveInfo;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.BarcodeBLevelFlService;
import com.sigmatrix.sc.web.controller.common.BaseController;

@Controller
@RequestMapping(value = "/barcodeFlActiveInfo")
public class BarcodeFlActiveController extends BaseController {
	private static Logger logger = Logger.getLogger(BarcodeFlActiveController.class);
	@Autowired
	private BarcodeBLevelFlService barcodeService;

	/**
	 * 辅料箱码-查询
	 */
	@RequestMapping(value = "/list")
	public ModelAndView BarcodeBLevelFlList(HttpServletRequest request, BarcodeFlActiveInfo barcodeFlActiveInfos) {
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		PageBean<BarcodeFlActiveInfo> page = new PageBean<>(getPageNum(request));
		barcodeFlActiveInfos.setTablePrefix(getTablePrefix(request));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			page = barcodeService.getBarcodeFlList(page,barcodeFlActiveInfos,startDateStr,endDateStr);
		} catch (Exception e) {
			logger.error("select BarcodeBLevelFlInfoList is fail", e);
		
		}
		//查询激活成功，激活失败，激活重复的总数
		//激活成功
		PageBean<BarcodeFlActiveInfo> totalSuccesspage = new PageBean<>(getPageNum(request));
		totalSuccesspage = barcodeService.getBarcodeFlList(totalSuccesspage,1,getTablePrefix(request));
		//激活失败
		PageBean<BarcodeFlActiveInfo> totalFailpage = new PageBean<>(getPageNum(request));
		totalFailpage = barcodeService.getBarcodeFlList(totalFailpage ,2,getTablePrefix(request));
		//激活重复
		PageBean<BarcodeFlActiveInfo> totalRepeatpage = new PageBean<>(getPageNum(request));
		totalRepeatpage = barcodeService.getBarcodeFlList(totalRepeatpage,2,getTablePrefix(request));
		map.put("page", page);
		map.put("startDate", startDateStr);
		map.put("endDate", endDateStr);
		map.put("barcodeFlActiveInfos",barcodeFlActiveInfos);
		
		map.put("totalSuccessNumber",totalSuccesspage.getDataList().size());
		map.put("totalFailNumber",totalFailpage.getDataList().size());
		map.put("totalRepeatNumber",totalRepeatpage.getDataList().size());
		return new ModelAndView(JSP_PREFIX+"barcodeFlactive/list",map);

	}

}
