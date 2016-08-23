package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.entity.v1.BarcodeALevel;
import com.sigmatrix.sc.entity.v1.BarcodeBLevel;
import com.sigmatrix.sc.entity.v1.BarcodeBLevelFl;
import com.sigmatrix.sc.svcEntity.res.LotteryPrizeSvcRes;

//抽奖公共service
public interface LotteryPrizeCommonService {
    
    //是否首次中小于一元红包
	public String isFirstWinLessYiYuan(Integer actId,String openId);
	
	//活动是否有效校验 0无效 1有效  如果无效 设置活动信息
	public String checkActivityDate(LotteryPrizeSvcRes response,Activity activity);
	
	//获取真正的中奖金额
	public int getRealPrizeAmount(ActivityPrize ap,LotteryPrizeSvcRes response,Integer actId,String openId);
	
	//是否超过 投放量投放或者 投放金额 超过返回flase
	public boolean isGreaterTotalAmountAndPrizeCount(ActivityPrize ap,int realPrizeAmount);
	
	//中奖金额+当前中奖金额 > 投放总金额 判断 大于返回true
	public boolean isLuckyAmountGreaterTotalAmount(ActivityPrize ap,int realPrizeAmount);
	
	//中奖数量+当前中奖数量 (+1) > 投放量 判断   大于返回true
	public boolean isLuckCountGreaterPrizeCount(ActivityPrize ap);
	
	/**
	 * @Method: checkActivityStatus
	 * @Description: 活动是否存在  开启关闭校验  并设置响应信息
	 * @param lpRes
	 * @param activity
	 * @return 0 活动无效  1 活动有效
	 * @return String
	 * @author zzw
	 * @date 2016年6月28日 上午11:02:02
	 */
  	public String checkActivityStatus(LotteryPrizeSvcRes lpRes,Activity activity);

    /**
     * @Method: getACodeAcvtivityStatus
     * @Description: 一级码是否激活判断
     * @param barcodeALevel 一级码
     * @param barcodeBLevel 二级码
     * @param barcodeBlevelFl 辅料码
     * @param lpRes 响应信息
     * @param projectFlag  项目标识
     * @return 一级码激活状态  1激活  2未激活
     * @throws Exception
     * @author zzw
     * @date 2016年6月28日 下午2:19:35
     */
    public Integer getACodeAcvtivityStatus(BarcodeALevel barcodeALevel,BarcodeBLevel barcodeBLevel,BarcodeBLevelFl barcodeBlevelFl,
    		LotteryPrizeSvcRes lpRes,String projectFlag) ;
    /**
     * @Method: isBCodeDateOut
     * @Description: 二级箱码是否过期判断
     * @param barcodeBLevel
     * @param shelfLife
     * @return Integer
     * @author zzw
     * @date 2016年6月28日 下午6:08:00
     */
    public Integer isBCodeDateOut(BarcodeBLevel barcodeBLevel,Integer shelfLife);
    
    /**
     * @Method: isFLCodeDateOut
     * @Description: 辅料箱码是否过期
     * @param barcodeBlevelFl
     * @param shelfLife
     * @return Integer
     * @author zzw
     * @date 2016年6月28日 下午6:18:01
     */
    public Integer isFLCodeDateOut(BarcodeBLevelFl barcodeBlevelFl,Integer shelfLife);
    
	/**
	 * @Method: isActivityDateOut
	 * @Description: 判断活动是否过期
	 * @param lpRes
	 * @param act
	 * @param barcodeBLevel
	 * @param barcodeBlevelFl
	 * @param shelfLife
	 * @return Integer
	 * @author zzw
	 * @date 2016年6月28日 下午7:19:15
	 */
	public Integer isActivityDateOut(LotteryPrizeSvcRes lpRes,Activity act,
			BarcodeBLevel barcodeBLevel,BarcodeBLevelFl barcodeBlevelFl,Integer shelfLife);
    	
}
