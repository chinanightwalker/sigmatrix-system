package com.sigmatrix.sc.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sigmatrix.sc.entity.v1.ActivityPrize;
/**
 * 奖项VO,供页面使用
 * @author youjun
 *
 */
public class ActivityPrizeVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4420974197853641057L;
	/**
	 * 奖项对象
	 */
	private ActivityPrize activityPrize;
	/**
	 * 定时红包时使用,代表时间段集合,最终映射到 ActivityPrize实体的timeslotInfo属性中
	 */
	private List<TimeslotInfo> timeslotInfos;
	/**
	 * 奖项类型
	 */
	private String prizeTypeStr;
	/**奖项剩余金额=奖项投放总金额prizeTotalAmount-已中此奖项金额prizeLuckyAmount*/
	private Long balance;
	/**奖项剩余数量=奖项总投放量prizeCount-已中此奖项数量luckyCount*/
	private Integer lessCount;
	/**定额红包中奖率表示:*/
	private String timingRedPrizeRate;
	/**
	 * 获得奖项对象
	 * @return
	 */
	public ActivityPrize getActivityPrize() {
		return activityPrize;
	}

	/**
	 * 设置奖项对象
	 * @param activityPrize
	 */
	public void setActivityPrize(ActivityPrize activityPrize) {
		this.activityPrize = activityPrize;
	}

	/**
	 * 获得奖项类型文字表述
	 * @return
	 */
	public String getPrizeTypeStr() {
		if (activityPrize.getPrizeType() == null) {
			return "";
		}else {
			switch (activityPrize.getPrizeType()) {
				case 1: return "再来一瓶";
				case 2: return "红包奖品";
				case 3: return "邮寄奖品";
				case 4: return "积分奖品";
				case 5: return "到店领取奖品";
				case 6: return "定时红包";
				case 7: return "现金券";
				default: return "未知类型奖品";
			}
		}
	}

	public void setPrizeTypeStr(String prizeTypeStr) {
		this.prizeTypeStr = prizeTypeStr;
	}

	
	public static void main(String[] args) {
		long a = Long.MAX_VALUE;
		long b = Long.MIN_VALUE;
		
		System.out.println("Long最大值:"+a);
		System.out.println("Long最小值:"+a);
	}

	/**
	 * 获得奖项剩余金额=奖项投放总金额prizeTotalAmount-已中此奖项金额prizeLuckyAmount
	 * @return
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * 设置奖项剩余金额=奖项投放总金额prizeTotalAmount-已中此奖项金额prizeLuckyAmount
	 * @param balance
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	/**
	 * 获得奖项剩余数量=奖项总投放量prizeCount-已中此奖项数量luckyCount
	 * @return
	 */
	public Integer getLessCount() {
		return lessCount;
	}

	/**
	 * 设置奖项剩余数量=奖项总投放量prizeCount-已中此奖项数量luckyCount
	 * @param lessCount
	 */
	public void setLessCount(Integer lessCount) {
		this.lessCount = lessCount;
	}

	/**
	 * 获得定时红包时使用,代表时间段集合,最终映射到 ActivityPrize实体的timeslotInfo属性中
	 * @return
	 */
	public List<TimeslotInfo> getTimeslotInfos() {
		return timeslotInfos;
	}

	/**
	 * 设置定时红包时使用,代表时间段集合,最终映射到 ActivityPrize实体的timeslotInfo属性中
	 * @param timeslotInfos
	 */
	public void setTimeslotInfos(List<TimeslotInfo> timeslotInfos) {
		this.timeslotInfos = timeslotInfos;
	}

	public String getTimingRedPrizeRate() {
		String mode = "";
		String periodCount = activityPrize.getPrizePeriodCount()+"";
		if (activityPrize.getPrizePeriodMode() == null) {
			return "";
		}else {
			switch (activityPrize.getPrizePeriodMode()) {
				case 1:
					mode = "天";
					break;
				case 2: 
					mode = "周";
					break;
				case 3: 
					mode = "月";
					break;
				case 4: 
					mode = "时段";
					break;
				default: 
					mode = "未知模式";
					break;
			}
			return periodCount+"/"+mode;
		}
		
	}

	public void setTimingRedPrizeRate(String timingRedPrizeRate) {
		this.timingRedPrizeRate = timingRedPrizeRate;
	}

}
