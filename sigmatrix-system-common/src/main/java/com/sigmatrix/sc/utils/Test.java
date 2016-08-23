package com.sigmatrix.sc.utils;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		/** 
		 * 1 微信红包 2元        
		 * 2 微信红包 5元
		 * 3 微信红包10元
		 */
		PrizeConfig p1 = new PrizeConfig();
		p1.setPrizeCount(12);
		p1.setHasLotteryCount(0);
		p1.setHasPrizeCount(0);
		p1.setPrizeId(1);
		p1.setPrizeRate(1f);
		PrizeConfig p2 = new PrizeConfig();
		p2.setPrizeCount(3);
		p2.setHasLotteryCount(0);
		p2.setHasPrizeCount(0);
		p2.setPrizeId(2);
		p2.setPrizeRate(0.25f);
		PrizeConfig p3 = new PrizeConfig();
		p3.setPrizeCount(3);
		p3.setHasLotteryCount(0);
		p3.setHasPrizeCount(0);
		p3.setPrizeId(3);
		p3.setPrizeRate(0.25f);
		PrizeConfig p4 = new PrizeConfig();
		p4.setPrizeCount(3);
		p4.setHasLotteryCount(0);
		p4.setHasPrizeCount(0);
		p4.setPrizeId(4);
		p4.setPrizeRate(0.25f);
		List<PrizeConfig> boxList = new ArrayList<PrizeConfig>();
		
		boxList.add(p1);
//		boxList.add(p2);
//		boxList.add(p3);
//		boxList.add(p4);
		for (int i=0;i<12;i++){
			int id =PrizeUtils.lotterPrizeByScan(null, boxList, 1200000, 12);
			System.out.println(id);
			boxList.get(0).setHasLotteryCount(boxList.get(0).getHasLotteryCount()+1);
//			boxList.get(1).setHasLotteryCount(boxList.get(1).getHasLotteryCount()+1);
//			boxList.get(2).setHasLotteryCount(boxList.get(2).getHasLotteryCount()+1);
//			boxList.get(3).setHasLotteryCount(boxList.get(3).getHasLotteryCount()+1);
			if (id==1){
				
				boxList.get(0).setHasPrizeCount(boxList.get(0).getHasPrizeCount()+1);
			}else if(id==2){
				boxList.get(1).setHasPrizeCount(boxList.get(1).getHasPrizeCount()+1);
			}else if(id==3){
				boxList.get(2).setHasPrizeCount(boxList.get(2).getHasPrizeCount()+1);
			}else if(id==4){
				boxList.get(3).setHasPrizeCount(boxList.get(3).getHasPrizeCount()+1);
			}
			
		}
		/*
		List<PrizeConfig> list = new ArrayList<PrizeConfig>();
		
		PrizeConfig p1 = new PrizeConfig();
		PrizeConfig p2 = new PrizeConfig();
		
		p1.setPrizeId(1);
		p1.setPrizeRate(0.5f);
		p1.setPrizeCount(0);
		p1.setHasPrizeCount(0);
		p2.setPrizeId(2);
		p2.setPrizeRate(0.3333f);
		p2.setPrizeCount(0);
		p2.setHasPrizeCount(0);
	
		list.add(p1);
		list.add(p2);
	
		
		PrizeConfig p4 = new PrizeConfig();
		p4.setPrizeCount(2);
		p4.setHasLotteryCount(11);
		p4.setHasPrizeCount(1);
		p4.setPrizeId(5);
		p4.setPrizeRate(0f);
		List<PrizeConfig> boxList = new ArrayList<PrizeConfig>();
		boxList.add(p4);
		int a1=0;
		int a2=0;
		int a3=0;
		int a4=0;
		for (int i=0;i<1000000;i++){
			int id =PrizeUtils.lotterPrizeByScan(list, boxList, 1200000, 12);
			if (id ==1){
				a1++;
				list.get(0).setHasPrizeCount(a1);
			}else if (id == 2){
				a2++;
				list.get(1).setHasPrizeCount(a2);
			}else if (id == 5){
				a3++;
				//list.get(2).setHasPrizeCount(a3);
			}else{
				a4++;
			}
			
		
		}
		System.out.println("a1="+a1);
		System.out.println("a2="+a2);
		System.out.println("a3="+a3);
		System.out.println("a4="+a4);
		*/
	}

}
