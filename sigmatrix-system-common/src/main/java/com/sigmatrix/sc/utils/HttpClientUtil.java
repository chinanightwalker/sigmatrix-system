package com.sigmatrix.sc.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
public class HttpClientUtil {

	/**
	 * 
	 * Get请求
	 * 
	 * @param url
	 * 
	 * @param params没有请求头参数与请求体参数
	 * 
	 * @return
	 */
	public static String getForInter(String url) {
		return getForInter(url, null, null);
	}

	/**
	 * 
	 * Get请求
	 * 
	 * @param url
	 * 
	 * @param params没有请求头参数
	 * 
	 * @return
	 */
	public static String getForInter(String url, List<NameValuePair> params) {
		return getForInter(url, params, null);
	}
	
	/**
	 * 
	 * Get请求
	 * 
	 * @param url
	 * 
	 * @param params没有请求体参数
	 * 
	 * @return
	 */
	public static String getForInterBody(String url, List<NameValuePair> params) {
		return getForInter(url, null,params);
	}
	
	

	/**
	 * 
	 * Get请求
	 * 
	 * @param url
	 * 
	 * @param params
	 * 
	 * @return
	 */
	public static String getForInter(String url, List<NameValuePair> params,
			List<NameValuePair> headerParams) {
		@SuppressWarnings({ "resource" })
		HttpClient hc = new DefaultHttpClient();
		String body = null;
		try {
			// Get请求
			HttpGet httpget = new HttpGet(url);
			// 设置参数
			if (params != null && params.size() > 0) {
				String str = EntityUtils.toString(new UrlEncodedFormEntity(
						params));
				System.out.println(str);
				httpget.setURI(new URI(httpget.getURI().toString() + "/" + str));
			}
			if (headerParams != null) {
				for (NameValuePair param : headerParams) {
					if (param != null && param.getName() != null
							&& param.getValue() != null) {
						httpget.setHeader(param.getName(), param.getValue());
					}
				}
			}
			// 发送请求
			HttpResponse httpresponse = hc.execute(httpget);
			// 获取返回数据
			HttpEntity entity = httpresponse.getEntity();
			body = EntityUtils.toString(entity, "UTF-8");
			if (entity != null) {
				entity.consumeContent();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return body;
	}

	/**
	 * 
	 * Post请求
	 * 
	 * @param url
	 * 
	 * @param params
	 * 
	 * @return
	 */

	public static String post(String url, String sendBody) {
		return post(url, sendBody, null);
	}

	public static String post(String url, String sendBody,
			List<NameValuePair> headerParams) {
		if (sendBody == null) {
			sendBody = "";
		}
		@SuppressWarnings("resource")
		HttpClient httpClient = new DefaultHttpClient();
		String body = null;
		try {
			// Post请求
			HttpPost post = new HttpPost(url);
			StringEntity se = new StringEntity(sendBody, "UTF-8");
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json;charset=UTF-8"));
			post.setEntity(se);
			if (headerParams != null) {
				for (NameValuePair param : headerParams) {
					if (param != null && param.getName() != null
							&& param.getValue() != null) {
						post.setHeader(param.getName(), param.getValue());
					}
				}
			}
			try {
				// 发送请求
				HttpResponse httpresponse = httpClient.execute(post);
				// 获取返回数据
				HttpEntity entity = httpresponse.getEntity();
				// //得到实体输入流
				// InputStream inSm = entity.getContent();
				// Scanner inScn = new Scanner(inSm);
				// while(inScn.hasNextLine()){
				// System.out.println(inScn.nextLine());
				// }

//				body = EntityUtils.toString(entity);
				body = new String(EntityUtils.toByteArray(entity), "UTF-8");
				if (entity != null) {
					entity.consumeContent();
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} /*
		 * catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpClient.getConnectionManager().shutdown();
		return body;
	}

	// 服务内部调用 POST请求
	public static String postForInter(String url, String sendBody,
			List<NameValuePair> headerParams) {
		if (sendBody == null) {
			sendBody = "";
		}
		@SuppressWarnings("resource")
		HttpClient httpClient = new DefaultHttpClient();
		String body = null;
		try {
			// Post请求
			HttpPost post = new HttpPost(url);
			StringEntity se = new StringEntity(sendBody, "UTF-8");
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json;charset=UTF-8"));
			post.setEntity(se);
			if (headerParams != null) {
				for (NameValuePair param : headerParams) {
					if (param != null && param.getName() != null
							&& param.getValue() != null) {
						post.setHeader(param.getName(), param.getValue());
					}
				}
			}
			try {
				// 发送请求
				HttpResponse httpresponse = httpClient.execute(post);
				// 获取返回数据
				HttpEntity entity = httpresponse.getEntity();
				// //得到实体输入流
				// InputStream inSm = entity.getContent();
				// Scanner inScn = new Scanner(inSm);
				// while(inScn.hasNextLine()){
				// System.out.println(inScn.nextLine());
				// }

				body = EntityUtils.toString(entity, "UTF-8");
				if (entity != null) {
					entity.consumeContent();
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} /*
		 * catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpClient.getConnectionManager().shutdown();
		return body;
	}


	public static String putForInter(String url, String sendBody) {
		return putForInter(url, sendBody, null);
	}

	public static String putForInter(String url, String sendBody,
			List<NameValuePair> headerParams) {
		@SuppressWarnings("resource")
		HttpClient httpClient = new DefaultHttpClient();
		String body = null;
		try {
			// Put请求
			HttpPut httpput = new HttpPut(url);
			StringEntity se = new StringEntity(sendBody, "UTF-8");
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json;charset=UTF-8"));
			httpput.setEntity(se);
			if (headerParams != null) {
				for (NameValuePair param : headerParams) {
					if (param != null && param.getName() != null
							&& param.getValue() != null) {
						httpput.setHeader(param.getName(), param.getValue());
					}
				}
			}
			try {
				// 发送请求
				HttpResponse httpresponse = httpClient.execute(httpput);
				// 获取返回数据
				HttpEntity entity = httpresponse.getEntity();
				// //得到实体输入流
				// InputStream inSm = entity.getContent();
				// Scanner inScn = new Scanner(inSm);
				// while(inScn.hasNextLine()){
				// System.out.println(inScn.nextLine());
				// }

				body = EntityUtils.toString(entity, "UTF-8");
				if (entity != null) {
					entity.consumeContent();
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} /*
		 * catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpClient.getConnectionManager().shutdown();
		return body;
	}

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// String url4 =
		// "http://localhost:8080/smartair-ifserver/app/smartair/devices/C89346401393";
		// String body4 = put(url4,
		// "{\"accessToken\":\"e60IfTQ1FZ4lZNd97PYttqtBY/rqolco\",\"name\":\"测试\"}");
		// System.out.println(body4);
		//
		// String url6 =
		// "http://localhost:8080/smartair-ifserver/app/smartair/users/UH10251/devices";
		// List<NameValuePair> params = new ArrayList<NameValuePair>();
		// params.add(new BasicNameValuePair("accessToken",
		// "e60IfTQ1FZ4lZNd97PYttqtBY/rqolco"));
		// String body6 = get(url6, params, null);
		// System.out.println(body6);
		/*
		QueryPolicyListResponse xx = new QueryPolicyListResponse();
		xx.setRetCode("00000");
		xx.setRetInfo("成功");
		List<PolicyInfo> listPolicyInfo = new ArrayList<PolicyInfo>();
		PolicyInfo policyInfo = new PolicyInfo();
		policyInfo.setInsuranceId("11");
		policyInfo.setInsured("22");
		policyInfo.setTotalCount("33");
		listPolicyInfo.add(policyInfo);
		PolicyInfo policyInfo1 = new PolicyInfo();
		policyInfo1.setInsuranceId("11");
		policyInfo1.setInsured("22");
		policyInfo1.setTotalCount("33");
		listPolicyInfo.add(policyInfo1);
		ObjectMapper ibj = new ObjectMapper();
		ibj.setSerializationInclusion(JsonInclude.Include.NON_NULL);//有null值的属性不转换为json字符串
		xx.setListPolicyInfo(listPolicyInfo);
		
		System.out.println("------------>>"+ibj.writeValueAsString(xx));
		 */

		ObjectMapper ibj = new ObjectMapper();
		ibj.setSerializationInclusion(JsonInclude.Include.NON_NULL);//有null值的属性不转换为json字符串
	}
	

	@SuppressWarnings("unused")
	private static void readJsonMap(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<?, ?> map = mapper.readValue(json, Map.class);
			if (map.get("error") != null && map.get("error").equals("ERROR_OK")) {
				Map<?, ?> map2 = (Map<?, ?>) map.get("instant_weather");
				System.out.println(map2.get("temperature"));
				System.out.println(map2.get("humidy"));
				System.out.println(map2.get("wind"));
				System.out.println(map2.get("weather"));
			} else {

			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**角色删除get请求 方式添加
	 * 请求地址：/role/delete/{roleId}
	 */
	public static String sendget(String url, Integer params,
			List<NameValuePair> headerParams) {
		@SuppressWarnings({ "resource" })
		HttpClient hc = new DefaultHttpClient();
		String body = null;
		try {
			// Get请求
			HttpGet httpget = new HttpGet(url);
			// 设置参数

				httpget.setURI(new URI(httpget.getURI().toString() + "/"+params));

			if (headerParams != null) {
				for (NameValuePair param : headerParams) {
					if (param != null && param.getName() != null
							&& param.getValue() != null) {
						httpget.setHeader(param.getName(), param.getValue());
					}
				}
			}
			// 发送请求
			HttpResponse httpresponse = hc.execute(httpget);
			// 获取返回数据
			HttpEntity entity = httpresponse.getEntity();
			body = EntityUtils.toString(entity, "UTF-8");
			if (entity != null) {
				entity.consumeContent();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return body;
	}
}
