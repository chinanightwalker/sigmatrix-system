package com.sigmatrix.sc.global.init;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@SuppressWarnings("deprecation")
public class InitPublicPropertyConfigure extends PropertyPlaceholderConfigurer {

	private List<String> initPropertiesFile;

	public List<String> getInitPropertiesFile() {
		return initPropertiesFile;
	}

	public void setInitPropertiesFile(List<String> initPropertiesFile) {

		String filepath = "";
		InputStream in = null;
		Properties pros = new Properties();

		for (String pre : initPropertiesFile) {
			Properties properties = new Properties();
			if (null != pre && pre.startsWith("file:")) {
				filepath = pre.substring(5, pre.length());

				File file = new File(filepath);
				try {
					in = new BufferedInputStream(new FileInputStream(file));
				} catch (FileNotFoundException e) {
					logger.error(e);
					e.printStackTrace();
				}
			} else if (null != pre && pre.startsWith("classpath:")) {
				filepath = pre.substring(10, pre.length());
				ClassLoader cl = this.getClass().getClassLoader();

				if (cl != null) {
					in = cl.getResourceAsStream(filepath);
				} else {
					in = ClassLoader.getSystemResourceAsStream(filepath);
				}
			} else {
				System.out.println("******** Properties file path is not correct ********");
			}
			try {
				properties.load(in);
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					logger.error(e);
					e.printStackTrace();
				}
			}

			pros.putAll(properties);

			/* 加载serverinfo配置  */
			String httpurl = properties.getProperty("project.basic.config.url");
			System.out.println("serverinfo="+httpurl);
			Properties pro = this.getHttpProperties(httpurl);
			pros.putAll(pro);
		}

		this.setProperties(pros);
	}

	private Properties getHttpProperties(String url) {
		@SuppressWarnings({ "resource" })
		HttpClient hc = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse httpresponse;
		Properties pros = new Properties();
		try {
			httpresponse = hc.execute(httpget);

			// 获取返回数据
			HttpEntity entity = httpresponse.getEntity();
			String s = EntityUtils.toString(entity, "UTF-8");

			if (s == null || s.equals("")) {
				return pros;
			}

			JSONObject server_info = JSON.parseObject(s);
			for (String ser_key : server_info.keySet()) {
				/* 解析dyanmodb 表数组 */
				if (ser_key.equals("db.table")) {
					JSONObject dbtable = JSON.parseObject(server_info.getString(ser_key));
					for (String table : dbtable.keySet()) {
						pros.put(table, dbtable.getString(table));
					}
				} else {
					pros.put(ser_key, server_info.getString(ser_key));
				}
			}
		} catch (ClientProtocolException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
		
		System.out.println(JSONObject.toJSONString(pros));

		return pros;

	}

}
