package com.sigmatrix.sc.svcEntity.req;


import org.codehaus.jackson.map.annotate.JsonSerialize;
/*
 * 当零钱宝的回调时候会返回的信息
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BidsServerSvcReq {
	private String apply_url;
	private String bids_platform_sid;
	private String back_url;
	public String getBack_url() {
		return back_url;
	}
	public void setBack_url(String back_url) {
		this.back_url = back_url;
	}
	
	public BidsServerSvcReq(String apply_url, String bids_platform_sid,
			String back_url, String decode_string_key) {
		super();
		this.apply_url = apply_url;
		this.bids_platform_sid = bids_platform_sid;
		this.back_url = back_url;
		this.decode_string_key = decode_string_key;
	}
	public BidsServerSvcReq() {
		super();
	}
	private String decode_string_key;
	public String getApply_url() {
		return apply_url;
	}
	public void setApply_url(String apply_url) {
		this.apply_url = apply_url;
	}
	public String getBids_platform_sid() {
		return bids_platform_sid;
	}
	public void setBids_platform_sid(String bids_platform_sid) {
		this.bids_platform_sid = bids_platform_sid;
	}
	public String getDecode_string_key() {
		return decode_string_key;
	}
	public void setDecode_string_key(String decode_string_key) {
		this.decode_string_key = decode_string_key;
	}
	@Override
	public String toString() {
		return "BidsServerSvcReq [apply_url=" + apply_url
				+ ", bids_platform_sid=" + bids_platform_sid + ", back_url="
				+ back_url + ", decode_string_key=" + decode_string_key + "]";
	}
	
	
  
}
