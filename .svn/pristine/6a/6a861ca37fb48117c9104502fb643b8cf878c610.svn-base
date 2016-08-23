package com.sigmatrix.sc.utils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.NameValuePair;

/**
 * httpclient上传文件
 * 
 * 
 */
public class HttpClientPut {

	@SuppressWarnings("deprecation")
	public static boolean put(List<NameValuePair> headerParams, String putUrl,byte[] bdata, String username, String password) {
		HttpClient httpClient = new HttpClient();
		PutMethod method = new PutMethod(putUrl);
		boolean bool = false;
		try {
			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
			httpClient.getState().setProxyCredentials(AuthScope.ANY, creds);
			// 设置http头
			List<Header> headers = new ArrayList<Header>();
			if (headerParams != null) {
				for (NameValuePair param : headerParams) {
					if (param != null && param.getName() != null && param.getValue() != null) {
						headers.add(new Header(param.getName(), param.getValue()));
					}
				}
			}
			// FileInputStream is=new FileInputStream(file);
			InputStream input = new ByteArrayInputStream(bdata);
			BufferedInputStream a = new BufferedInputStream(input);
			method.setRequestBody(a);
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler(3, false));
			int statusCode = httpClient.executeMethod(method);
			System.out.println("httpput: "+statusCode);
			if (statusCode == HttpStatus.SC_CREATED)
				bool = true;
		} catch (Exception e) {

		} finally {
			method.releaseConnection();
		}
		return bool;
	}

}
