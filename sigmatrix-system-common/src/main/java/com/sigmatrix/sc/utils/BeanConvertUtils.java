package com.sigmatrix.sc.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;

import com.alibaba.fastjson.JSONObject;

public class BeanConvertUtils {

	/**
	 * 前台form表单request请求中的key-value值填充到后台bean中
	 * 
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */

	public static void populate(Object bean, Map<?, ?> properties)
			throws IllegalAccessException, InvocationTargetException {
		DateConverterUtils dateConverterUtils = new DateConverterUtils();
		// dtConverter.setPattern(df_datetime);
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
		convertUtilsBean.deregister(Date.class);
		convertUtilsBean.register(dateConverterUtils, Date.class);

		BeanUtilsBean beanUtilsBean = new BeanUtilsBean(convertUtilsBean, new PropertyUtilsBean());
		beanUtilsBean.populate(bean, properties);
	}

	public static String beanToString(Object obj) {
		return JSONObject.toJSONString(obj);
	}
}
