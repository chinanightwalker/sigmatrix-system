package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.BarcodeALevel;

/**
 * @Description: 一级单品码表
 * @author zzw
 * @date 2016年7月14日 下午2:41:36
 */
public interface BarcodeALevelService {
	/**
	 * @Method: getBarcodeALevel
	 * @Description: 根据一级码 或者输入码 查询一级码信息
	 * @param encryptBarcodeALevel
	 * @param inputCode
	 * @return
	 * @throws Exception
	 * @return BarcodeALevel
	 * @author zzw
	 * @date 2016年7月14日 下午1:25:49
	 */
    public BarcodeALevel getBarcodeALevel(String encryptBarcodeALevel,String inputCode,String tablePrefix) throws Exception;
    
    /**
     * @Method: getBarcodeALevelByACode
     * @Description: 根据一级码  查询一级码信息
     * @param encryptBarcodeALevel
     * @return
     * @throws Exception
     * @return BarcodeALevel
     * @author zzw
     * @date 2016年7月14日 下午1:26:01
     */
    public BarcodeALevel getBarcodeALevelByACode(String encryptBarcodeALevel,String tablePrefix) throws Exception;
    
    /**
     * @Method: getBarcodeALevelByInputCode
     * @Description: 根据输入码 查询一级码信息
     * @param inputCode
     * @return
     * @throws Exception
     * @return BarcodeALevel
     * @author zzw
     * @date 2016年7月14日 下午1:26:12
     */
    public BarcodeALevel getBarcodeALevelByInputCode(String inputCode,String tablePrefix) throws Exception;

	public BarcodeALevel getBarcodeALevelById(String encryptBarcodeALevel, String tablePrefix) throws Exception;

}