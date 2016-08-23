package com.sigmatrix.sc.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductActivityExample;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.entity.v1.ScancodeTransitionExample;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.ProductBaseService;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.web.controller.common.BaseController;

@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController {
	@Autowired
	ProductBaseService productBaseService;
	private static Logger logger = Logger.getLogger(ProductController.class);

	/**
	 * 产品管理-查询
	 */
	@RequestMapping(value = "/list")
	public ModelAndView Productlist(HttpServletRequest request, ProductBase productbase) {
		Map<String, Object> map = new HashMap<String, Object>();
		productbase.setTablePrefix(getTablePrefix(request));
		PageBean<ProductBase> page = new PageBean<>(getPageNum(request));
		try {
			productbase.setStatus(1);
			page = productBaseService.getProductBaseList(page, productbase);
		} catch (Exception e) {
			logger.error("getProductList is fail ", e);
			e.printStackTrace();
		}
		map.put("page", page);
		map.put("productbase", productbase);
		logger.debug(map.toString());
		return new ModelAndView(JSP_PREFIX + "product/list", map);
	}

	/**
	 * 产品管理-增加
	 */
	@RequestMapping(value = "/addProduct")
	@RequiresPermissions("product:insert")
	public ModelAndView addView(HttpServletRequest request,ProductBase productBase) {
		ModelAndView mav = new ModelAndView(JSP_PREFIX + "product/input");
		System.out.println("增加回调的" +request.getParameter("productId"));
		productBase.setTablePrefix(request.getParameter("productId"));
		productBase.setProductCode(request.getParameter("productCode"));
		productBase.setProductName(request.getParameter("productName"));
		if(request.getParameter("productIntegrate")!=null){
			productBase.setProductIntegrate(Integer.valueOf(request.getParameter("productIntegrate")));
		} if(request.getParameter("isUserIntegrate")!=null){
			productBase.setIsUserIntegrate(Integer.valueOf(request.getParameter("isUserIntegrate")));
		}if(request.getParameter("shelfLife")!=null){
			productBase.setShelfLife(Integer.valueOf(request.getParameter("shelfLife")));
		}
		
		
		productBase.setProductInfo(request.getParameter("productInfo"));
		mav.addObject("productBase", productBase);
		return mav;
	}

	/**
	 * 产品管理-修改
	 */
	@RequestMapping(value = "/editProduct")
	@RequiresPermissions("product:update")
	public ModelAndView editView(Integer productId,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(JSP_PREFIX + "product/edit");
		System.out.println(productId);
		ProductBase productBase = new ProductBase();
		productBase.setTablePrefix(getTablePrefix(request));

		logger.debug(productId + "%%%%%%");
		if (productId != null) {
			try {
				productBase.setProductId(String.valueOf(productId));
				productBase = productBaseService.getProductBaseById(productBase);
			} catch (Exception e) {
				logger.error("editproduct is fail", e);
				e.printStackTrace();
			}
		}
		mav.addObject("productBase", productBase);
		return mav;
	}

	@Value("${usercenter.base.domain.name}")
	private static String userCenterBaseUrl;

	/**
	 * 产品管理-保存
	 */
	@RequestMapping(value = "/saveProduct")
	public @ResponseBody JsonEdit saveView(HttpServletRequest request, ProductBase productBase) {
		// 获取信息
		System.out.println("*&^^%%" +request.getParameter("productId"));
		productBase.setTablePrefix(getTablePrefix(request));
		productBase.setProductCode(request.getParameter("productBase.productCode"));
		productBase.setProductName(request.getParameter("productBase.productName"));
		productBase.setProductIntegrate(Integer.valueOf(request.getParameter("productBase.productIntegrate")));
		productBase.setIsUserIntegrate(Integer.valueOf(request.getParameter("productBase.isUserIntegrate")));
		productBase.setShelfLife(Integer.valueOf(request.getParameter("productBase.shelfLife")));
		productBase.setProductInfo(request.getParameter("productBase.productInfo"));
		ProductBase pb=new ProductBase();
		if(request.getParameter("productId")!=null){
		try {
			productBase.setProductId(request.getParameter("productId"));
			pb=productBaseService.getProductBaseById(productBase.getProductId(),productBase);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
		if(request.getParameter("productBase.productId")==null){//增加
			if (pb==null) {
				try {
					productBase.setProductCode(UUID.randomUUID().toString().trim().replaceAll("-", ""));
					productBase.setProductId(request.getParameter("productId"));
					productBase.setCreateTime(new Date());
					productBase.setStatus(1);
					productBaseService.insertAndsaveObject(productBase);				
				} catch (Exception e) {
					logger.error("saveProduct is fail ", e);
					return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
				
				}
		       } else {//id已经存在
		    	   return new JsonEdit(StateInfoEnum.DATA_Exsited,"product/addProduct?productId="+productBase.getProductId()+"&productCode="+
		    			   productBase.getProductCode()+"&productName="+productBase.getProductName()+"&productIntegrate="+productBase.getProductIntegrate() +
		    			   "&isUserIntegrate="+productBase.getIsUserIntegrate() +"&shelfLife="+productBase.getShelfLife()+"&productInfo="+productBase.getProductInfo()
		    			  );
			}
			
			
		}else{//修改更新
//			try {
//				pb=productBaseService.getProductBaseById(request.getParameter("productBase.productId"),productBase);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			if(pb==null){
				try {	
					productBase.setProductId(request.getParameter("productBase.productId"));
					productBase.setLastUpdateTime(new Date());
					productBaseService.updateAndsaveObject(productBase);
					return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "product/list");
				} catch (Exception e){
					logger.error("saveProduct is fail ", e);
					e.printStackTrace();
				}	
//				
//			}else {//id已经存在
//		    	   return new JsonEdit(StateInfoEnum.DATA_Exsited, "product/editProduct");
//			}
			
			
		}
		
		

		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "product/list");

	}

	/**
	 * 产品管理-删除
	 */
	@RequestMapping(value = "/deleteProduct{productId}")
	@RequiresPermissions("product:delete")
	public @ResponseBody JsonEdit deleteView(Integer productId,HttpServletRequest request) {
		System.out.println(productId);
		ProductBase productBase = new ProductBase();
		productBase.setTablePrefix(getTablePrefix(request));
		int i = 0;

		if (productId != null) {
			ScancodeTransitionExample esc=new ScancodeTransitionExample();
			esc.setTablePrefix(getTablePrefix(request));
			esc.createCriteria().andProductIdEqualTo(productId);
			ProductActivityExample pro=new ProductActivityExample();
			pro.setTablePrefix(getTablePrefix(request));
			pro.createCriteria().andProductIdEqualTo(productId);
			try {
				 List<ScancodeTransition> list=productBaseService.selectScancodeTransitionbyId(esc);
				 List<ProductActivity> list2= productBaseService.selecProductActivitybyProductId(pro);
				System.out.println("chaxunde ="+list.size());
				if(list.size()==0&&list2.size()==0){
					try {
						productBase.setProductId(String.valueOf(productId));
						productBase.setStatus(0);
						i = productBaseService.updateAndsaveObject(productBase);
						if (i > 0) {
							logger.error("deleteproduct is success");
							return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "product/list");
						} else {
							logger.error("deleteproduct is fail");
							return new JsonEdit(StateInfoEnum.DATA_FAILURE, "product/list");
						}

					} catch (Exception e) {
						logger.error("deleteproduct is fail", e);
						e.printStackTrace();
					}
				}else{
					logger.error("deleteproduct is fail");
					return new JsonEdit(StateInfoEnum.DATA_BeUsed, "product/list");
				}
			} catch (Exception e1) {
				logger.error("productID is use");
				e1.printStackTrace();
			}
			
			
		}
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "product/list");
	}
}
