package com.sigmatrix.sc.utils;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;//与org.codehaus.jackson.map.ObjectMapper有冲突，只能使用一种
import com.sigmatrix.sc.global.BaseResponse;
import com.sigmatrix.sc.global.WebConstants;

public class HttpUtils {

	public static String requestUrl(HttpServletRequest request) {
		String requestUrl = request.getScheme() + "://" + request.getServerName()
				+ ("http".equals(request.getScheme()) && request.getServerPort() == 80
						|| "https".equals(request.getScheme()) && request.getServerPort() == 443 ? ""
								: ":" + request.getServerPort())
				+ request.getRequestURI() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
		return requestUrl;
	}

	public static Object jsonToBean(String requestJson, Object o) {
		return JSONObject.toJavaObject(JSON.parseObject(requestJson), o.getClass());
	}

	public static String responseResult(BaseResponse result) {
		String mapper = null;
		try {
			ObjectMapper om = new ObjectMapper();
			om.setSerializationInclusion(JsonInclude.Include.NON_NULL);// 有null值的属性不转换为json字符串
			mapper = om.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultState(WebConstants.RESULT_STATE_9201);
			result.setResultMsg(WebConstants.RESULT_MSG_9201);
		}
		return mapper;
	}
}
