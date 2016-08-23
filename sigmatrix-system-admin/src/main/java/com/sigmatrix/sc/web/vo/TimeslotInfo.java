package com.sigmatrix.sc.web.vo;

import java.io.Serializable;

/**
 * 用于临时封装ActivityPrize的定时红包奖项的时间段,即timeslotInfo属性
 * 
 * @author youjun
 *
 */
public class TimeslotInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5006434605485789177L;
	/** 开始时间,eg:10:00:00 */
	private String starttime;
	/** 结束时间,eg:12:00:00 */
	private String endtime;

	public TimeslotInfo() {

	}

	public TimeslotInfo(String starttime, String endtime) {
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
}
