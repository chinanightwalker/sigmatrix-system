package com.sigmatrix.sc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抽奖的工具类
 * 
 * @author tmh
 *
 */
public class PrizeUtils {

	/**
	 * 抽奖接口
	 * 
	 * @param batchList
	 *            批量抽奖的List
	 * @param boxList
	 *            按箱抽奖的List
	 * @param totalCount
	 *           预估参与人数
	 * @param boxTotalCount 一箱的总数量，如果没有按箱抽奖，此项填0
	 * @return 中奖的奖项ID，-1 表示没有中奖
	 */
	public  static Integer lotterPrizeByScan(List<PrizeConfig> batchList, List<PrizeConfig> boxList, int totalCount,int boxTotalCount) {

		if (null != boxList && !boxList.isEmpty() && (batchList == null || batchList.isEmpty())){// 只有按箱抽奖
			
			int allCount = 0;
			List<Integer> rndList = new ArrayList<Integer>();
			List<Integer> prizeIdList = new ArrayList<Integer>();
			
			for (PrizeConfig prizeConfig:boxList){
				
				int prizeCount = prizeConfig.getPrizeCount();
				if (prizeCount <= 0){
					prizeCount = (int)(prizeConfig.getPrizeRate()*boxTotalCount);
				}
				if (prizeCount-prizeConfig.getHasPrizeCount()<=0){//已经中奖数满了
					continue;
					
				}
				if (prizeCount - prizeConfig.getHasPrizeCount()>= (boxTotalCount-prizeConfig.getHasLotteryCount())){
					return prizeConfig.getPrizeId();
				}
				rndList.add(prizeCount);
				prizeIdList.add(prizeConfig.getPrizeId());
				allCount+=prizeCount;
					
			}
			if (allCount<=0){
				return -1;
			}
			
			int rnd = (int) ( Math.random()*allCount) +1;
			int min = 0; 
			int max = 0;
			for(int i = 0;i<rndList.size();i++){
				
				if (i==0){
					min = 1;
					max = rndList.get(i);
				}else{
					
					min = max+1;
					max = min+rndList.get(i)-1;
				}
				if (rnd>=min && rnd <=max){
					
					return prizeIdList.get(i);
					
				}
			}
			return -1;
			
			
		}
		if(null != boxList && !boxList.isEmpty()){//有按箱抽奖的奖项 ，例如扫码抽奖
			for (PrizeConfig prizeConfig:boxList){
				int prizeCount = prizeConfig.getPrizeCount();
				if (prizeCount <= 0){
					prizeCount = (int)(prizeConfig.getPrizeRate()*boxTotalCount);
				}
				
				if (isPrize(boxTotalCount,prizeConfig.getHasLotteryCount(),prizeConfig.getHasPrizeCount(),prizeCount)){
					return prizeConfig.getPrizeId();
				}
				
			}
			
		}
		
		float remainRate = 1f;
		if (null != boxList && !boxList.isEmpty()){
			for (PrizeConfig prizeConfig:boxList){
				remainRate = remainRate- ((float)prizeConfig.getPrizeCount())/((float)boxTotalCount);
			}
		}
		
		if (null == batchList){
			return -1;
		}
		//按批次抽奖流程开始
		List<Integer> rndList = new ArrayList<Integer>();
		
		
		for (PrizeConfig prizeConfig:batchList){
			
			//没抽过奖的数量
			int rate = 0;
			if (prizeConfig.getPrizeRate() != null && prizeConfig.getPrizeRate()>0 ){//按中奖率抽奖
				rate = (int)(prizeConfig.getPrizeRate()*1000000);
			}else{//按预估参与人数计算中奖率
				if (totalCount == 0){
					return -1;
				}
				rate = (int)(((float)prizeConfig.getPrizeCount()/totalCount)*1000000);
			}
			rate = (int)(rate/remainRate);
			rndList.add(rate);
			
		}
		 
		
			
			int rnd = (int) ( Math.random()*1000000) +1;
			int min = 0; 
			int max = 0;
			for(int i = 0;i<rndList.size();i++){
				
				if (i==0){
					min = 1;
					max = rndList.get(i);
				}else{
					
					min = max+1;
					max = min+rndList.get(i)-1;
				}
				if (rnd>=min && rnd <=max){
					if (batchList.get(i).getPrizeCount()>0  && batchList.get(i).getPrizeCount()<=batchList.get(i).getHasPrizeCount()){
						return -1;
					}else{
						if (batchList.get(i).getPrizeCount()>0  && batchList.get(i).getHasPrizeCount()>=batchList.get(i).getPrizeCount()){
							return -1;
						}
						return batchList.get(i).getPrizeId();
					}
				}
			}
			
		
		
		
		
		return -1;
	}
	/**
	 * 首次中奖率抽奖
	 * @param prizeRate 中奖率，0-1000000之间的数值
	 * @param totalCount
	 * @return
	 */
	public static boolean firsetLotteryPrize(float prizeRate){
		
		int rate =  (int)prizeRate*1000000;
		if (rate>=1000000){
			return true;
		}
		int rnd = (int) ( Math.random()*1000000) +1;
		
		if (rnd<=prizeRate){
			return true;
		}
		return false;
	}
	public static boolean isPrize(int totalCount, int hasLotteryCount, int hasPrizeCount, int prizeCount){
		
		if (totalCount<=0){
			return false;
		}
		//没抽过奖的数量
		int unLotteryCount = totalCount-hasLotteryCount;
		
		int remainPrizeCount = prizeCount-hasPrizeCount;
		if (unLotteryCount<=0 || remainPrizeCount<=0){
			return false;
		}
		
		if (remainPrizeCount>=unLotteryCount){//剩余投放量大于等于没抽过奖的数量，设置为成功
			return true;
		}
		int rnd = (int) ( Math.random()*unLotteryCount) +1;
		
		if (rnd<=remainPrizeCount){
			return true;
		}
		return false;
		
	}
	/**
	 * 获得指定区间的随机值
	 * @param min 最小值
	 * @param max 最大值
	 * @return
	 */
	public static int getRandomBetween(int min, int max){
		
		Random r = new Random();
		return r.nextInt((max-min+1))+ min;
	}
	
}


