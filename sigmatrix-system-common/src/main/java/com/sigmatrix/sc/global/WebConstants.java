package com.sigmatrix.sc.global;

import java.util.UUID;

public class WebConstants {

	public static final String RESULT_STATE_SUCCESS = "1000";
	public static final String RESULT_MSG_SUCCESS 	= "成功";
	public static final String RESULT_STATE_FAILURE = "9999";
	public static final String RESULT_MSG_FAILURE 	= "失败";
	public static final String RESULT_STATE_9101 	= "9101";
	public static final String RESULT_MSG_9101 		= "客户端body格式错误，jsonToBean失败";
	public static final String RESULT_STATE_9102 	= "9102";
	public static final String RESULT_MSG_9102 		= "客户端body有必输项为空值";
	public static final String RESULT_STATE_9103 	= "9103";
	public static final String RESULT_MSG_9103 		= "客户端body中value类型错误";

	public static final String RESULT_STATE_9201 	= "9201";
	public static final String RESULT_MSG_9201 		= "服务端响应body转换错误";
	public static final String RESULT_STATE_9202 	= "9202";
	public static final String RESULT_MSG_9202 		= "服务端持久化异常";

	public static final int LOGIN_TYPE_ACCOUNT 		= 0;
	public static final int LOGIN_TYPE_PHONE 		= 1;
	public static final int LOGIN_TYPE_EMAIL 		= 2;
	
	public static final int USER_STATUS_ACTIVATED = 1;
	
	//首次登录
	public static final int FIRST_LOGIN = 1;
	//普通登录
	public static final int NORMAL_LOGIN = 2;
	
	//箱码锁定
	public static final int BARCODE_LOCK=1;
	public static final int BARCODE_UNLOCK=0;
	
	//箱码激活
	public static final int BARCODE_ACTIVATE=1;
	public static final int BARCODE_INACTIVE=2;
	
	//客户类型
	public static final int CUSTOMER_TYPE_EN=0;
	public static final int CUSTOMER_TYPE_DEALER=1;
	public static final int CUSTOMER_TYPE_SHOP=2;
	
	//兑奖二维码订单状态
	public static final int EPO_STATUS_WAIT=0;
	public static final int EPO_STATUS_SUCCESS=1;
	public static final int EPO_STATUS_TIMEOUT=2;
	
	
	//分配箱码状态
	public static final int ALLOTCODE_NORMAL=0;
	public static final int ALLOTCODE_LOCK=1;
	public static final int ALLOTCODE_INACTIVE=2;
	public static final int ALLOTCODE_EMPTY=3;
	public static final int ALLOTCODE_USED=4;
	
	//订单状态 0 待确认 1收货方已收货  3已拒绝
	public static final int ORDER_STATE_UNCONFIRMED=0;
	public static final int ORDER_STATE_RECEIVING=1;
	public static final int ORDER_STATE_BACK=3;
	//终端店状态类型
	public static final int SHOP_STATUS_NORMAL=1;
	public static final int SHOP_STATUS_DELETE=2;
	public static final int SHOP_STATUS_LOCKED=3;
	
	//终端店补货订单操作类型1确认收货0退回
	public static final int SHOP_SUPPLY_ORDER_RECEIVING=1;
	public static final int SHOP_SUPPLY_ORDER_BACK=0;
	
	//消费者兑奖表兑奖方式类型
	public static final int BPC_GET_TYPE_WECHAT=1;
	public static final int BPC_GET_TYPE_COMPUTER=2;
	public static final int BPC_GET_TYPE_QCODE=3;
	
	//业务员版本
	public static final int SALESMAN_INIT_VERSION=0;
	public static final int SALESMAN_UPGRADE_VERSION=1;
	
	//产品状态
	public static final int PRODUCT_STATUS_NORMAL=1;
	public static final int PRODUCT_STATUS_DELETE=2;
	public static final int PRODUCT_STATUS_LOCK=3;
	public static final int PRODUCT_STATUS_TEMP=4;
	
	//通用正常状态
	public static final int STATUS_NORMAL = 1;
	//销售类型 1：销售，2：补货
	public static final int GOODS_TYPE_SALE = 1;
	public static final int GOODS_TYPE_EXCHANGE = 2;
	
	//订单是否代操作
	public static final int IS_OPERATE = 1;
	public static final int ISNOT_OPERATE = 0;
	
	// 兑奖码生成key
	public static final long BPC_INPUTCODE_KEY = 1;
	
	//短信发送类型
	public static final int SMS_SEND_TYPE_REGISTER = 1;
	public static final int SMS_SEND_TYPE_LOGIN = 2;
	public static final int SMS_SEND_TYPE_RETRIEVE = 3;
	public static final int SMS_SEND_TYPE_BPC_NOTICE = 4;
	public static final int SMS_SEND_TYPE_SEND_NOTICE = 5;
	
	//短信发送状态
    public static final int SMS_SEND_STATUS_WAIT = 0;
    public static final int SMS_SEND_STATUS_SUCCESS = 1;
    public static final int SMS_SEND_STATUS_FAIL = 2;
    public static final int SMS_SEND_STATUS_SENDING = 3;
    
    //业务员登录日志操作类型
    public static final int _SALESMAN_LOGIN_RECORD_OPTION_TYPE_LOGIN=1;
    public static final int _SALESMAN_LOGIN_RECORD_OPTION_TYPE_LOGOUT=2;
    public static final int _SALESMAN_LOGIN_RECORD_OPTION_TYPE_ADD=3;
    
    // 客户总帐表 1:经销商 2 终端店
    public static final int _CUSTOMER_TOTAL_TYPE_DEALERS = 1;
    public static final int _CUSTOMER_TOTAL_TYPE_SHOP = 2;
    // 消费者兑奖信息分页（因涉及到兑奖信息分类问题，因此需要一次取出用户全部中奖记录，单页数据量大）
    public static final int _CUSTOMER_PAGE_NUM = 200;
    
    //同步状态
    public static final int _SYNC_STATUS_WAIT = 0;
    public static final int _SYNC_STATUS_SUCCESS = 1;
    public static final int _SYNC_STATUS_FAIL = 2;
	//一级码 激活状态 一级码表
    public static final Integer A_CODE_ACTIVATE_YES = new Integer(1); //激活
    public static final Integer A_CODE_ACTIVATE_NO = new Integer(2); //未激活
    //一级码状态
    public static final Integer A_CODE_STATUS_ACT_YES = new Integer(1); //激活
    public static final Integer A_CODE_STATUS_ACT_NO = new Integer(2); //未激活
    public static final Integer A_CODE_STATUS_DATE_OUT = new Integer(3); //过期
    //一级码是否过期
    public static final Integer A_CODE_DATE_OUT_YES = new Integer(0);//过期
    public static final Integer A_CODE_DATE_OUT_NO = new Integer(1);//没有过期
	//二级码 激活状态 箱码
    public static final Integer B_CODE_ACTIVATE_YES = new Integer(1); //激活
    public static final Integer B_CODE_ACTIVATE_NO = new Integer(2); //未激活
	//二级码 是否存在
    public static final Integer B_CODE_EXIST_NO = new Integer(0); //不存在
    public static final Integer B_CODE_EXIST_YES = new Integer(1); //存在
    //二级码是否过期
    public static final Integer B_CODE_DATE_OUT_YES = new Integer(0);//过期
    public static final Integer B_CODE_DATE_OUT_NO = new Integer(1);//没有过期
	//辅料箱码 激活状态
    public static final Integer FL_CODE_ACTIVATE_YES = new Integer(1); //激活
    public static final Integer FL_CODE_ACTIVATE_NO = new Integer(2); //未激活
	//辅料箱码 是否过期
    public static final Integer FL_CODE_TIME_OUT_YES = new Integer(0); //过期
    public static final Integer FL_CODE_TIME_OUT_NO = new Integer(1); //没有过期
	//辅料箱码 是否存在
    public static final Integer FL_CODE_EXIST_NO = new Integer(0); //不存在
    public static final Integer FL_CODE_EXIST_YES = new Integer(1); //存在
    //辅料箱码 是否过期
    public static final Integer FL_CODE_DATE_OUT_YES = new Integer(0);//过期
    public static final Integer FL_CODE_DATE_OUT_NO = new Integer(1);//没有过期
	//未激活处理流程
    public static final Integer UNACTIVITE_PRODUCT = new Integer(0); //显示产品介绍 
    public static final Integer UNACTIVITE_MINPRIZE = new Integer(1); //选择最小的奖项
	//活动开关
    public static final Integer ACT_ISOPEN_OFF = new Integer(0); //关闭
    public static final Integer ACT_ISOPEN_ON = new Integer(1); //开启
    //活动是否删除 0 删除 1 没有删除
    public static final Integer ACT_STATUS_DEL_YES = new Integer(0); 
    public static final Integer ACT_ISOPEN_DEL_NO = new Integer(1);
	//活动区域开关
    public static final Integer ACT_AREA_OFF = new Integer(0); //关闭
    public static final Integer ACT_AREA_ON = new Integer(1); //开启
	//是否强制关注
    public static final Integer FORCE_COLLECT_NO = new Integer(0); //非强制关注
    public static final Integer FORCE_COLLECT_YES = new Integer(1); //强制关注
    //活动表 活动有效期判断方式1:按辅料箱码激活时间+产品有效期判断 2 按按活动有效期抽奖 3按成品箱码激活时间+产品有效期判断
    public static final Integer VALID_DATE_TYPE_FL = new Integer(1);
    public static final Integer VALID_DATE_TYPE_ACT = new Integer(2);
    public static final Integer VALID_DATE_TYPE_B = new Integer(3);
    //活动 是否过期
    public static final Integer ACT_DATE_OUT_YES = new Integer(0);//过期
    public static final Integer ACT_DATE_OUT_NO = new Integer(1);//没有过期
	//奖项类型
    public static final Integer PRIZE_TYPE_AGAIN = new Integer(1); //再来一瓶
    public static final Integer PRIZE_TYPE_RED = new Integer(2); //红包
    public static final Integer PRIZE_TYPE_POST = new Integer(3); //邮寄奖品
    public static final Integer PRIZE_TYPE_POINT = new Integer(4); //积分抽奖
    public static final Integer PRIZE_TYPE_SHOP = new Integer(5); //到店领取 
    /**********************************************************************/
    /**奖项正常状态1*/
    public static final Integer PRIZE_COMMON_STATUS = new Integer(1);
    /**奖项删除状态0*/
    public static final Integer PRIZE_DELETE_STATUS = new Integer(0);
    /**********************************************************************/
	//红包奖项类型
    public static final Integer RED_TYPE_FIXED = new Integer(1); //固定中奖金额
    public static final Integer RED_TYPE_BETWEEN = new Integer(2); //区间中奖金额
    public static final Integer RED_TYPE_SHARE = new Integer(3); //分享型红包
	//中奖状态
    public static final Integer ISPRIZE_NO = new Integer(0); //未中奖
    public static final Integer ISPRIZE_YES = new Integer(1); //中奖
	//消费者兑换记录表中 _is_status
    public static final Integer  BPC_STATUS_ALREADY = new Integer(0); //已抽奖
    public static final Integer  BPC_STATUS_RECEIVE = new Integer(1); //已领奖
    public static final Integer  BPC_STATUS_CASH = new Integer(2); //已兑奖
    public static final Integer  BPC_STATUS_ABANDON = new Integer(3); //放弃领奖
    public static final Integer  BPC_STATUS_RED_FAILURE = new Integer(4); //红包领取失败
    public static final Integer  BPC_STATUS_USURPRED_SHARING = new Integer(5); //霸占红包分享中
    public static final Integer  BPC_STATUS_USURPRED_ALL= new Integer(6); // 所有人已参与
	//消费者兑换记录表中 是否产品激活 _is_active
    public static final Integer  BPC_IS_ACTIVE_NO = new Integer(0); //0 未激活
    public static final Integer  BPC_IS_ACTIVE_YES = new Integer(1); //1 已激活
	//抽奖方式 奖项表
    public static final Integer PRIZE_BY_BOX = new Integer(1); //按箱抽奖
    public static final Integer PRIZE_BY_PRO = new Integer(2); //按产品抽奖
    //数据库抽奖方式
    public static final Integer LOTTERY_WAY_SCAN = new Integer(1); //扫码抽奖
    public static final Integer LOTTERY_WAY_INPUT = new Integer(2); //输入码抽奖
    //码是否是第一次扫
    public static final Integer CODE_FIRST_SCAN_NO = new Integer(0); //非首次
    public static final Integer CODE_FIRST_SCAN_YES = new Integer(1); //首次
	//码是否有效
    public static final Integer A_CODE_VALID_NO = new Integer(0); //无效
    public static final Integer A_CODE_VALID_YES = new Integer(1); //有效
	//码是否激活
    public static final Integer BARCODE_ACTIVATE_NO = new Integer(0); //未激活
    public static final Integer BARCODE_ACTIVATE_YES = new Integer(1); //激活
    //客户类型 1 扫码用户 2 一元换购用户
    public static final Integer CUST_TYPE_SCAN = new Integer(1); //扫码用户 
    public static final Integer CUST_TYPE_YIYUAN_CHANGE = new Integer(2); //一元换购用户
    //扫码日志表中的 码状态  0 无效  1 有效  2 未激活 3不存在
    public static final Integer SCAN_LOG_INVALID = new Integer(0); //无效
    public static final Integer SCAN_LOG_VALID = new Integer(1); //有效
    public static final Integer SCAN_LOG_AVTIVE_NO = new Integer(2); //未激活
    public static final Integer SCAN_LOG_ACODE_NOT_EXIST = new Integer(3); //不存在
    //用户达到中奖数量上限处理方式 0 不参与抽奖  1 抽奖但不中奖
    public static final Integer USER_MAX_PRIZE_WAY_BCYCJ = new Integer(0);
    public static final Integer USER_MAX_PRIZE_WAY_CJBZJ = new Integer(1);
    //用户达到中奖数量是否达到上限标识 0 否 1 是
    public static final Integer USER_MAX_PRIZE_LIMIT_NO = new Integer(0);
    public static final Integer USER_MAX_PRIZE_LIMIT_YES = new Integer(1);
    //用户抽奖方式
    public static final String LOTTERY_BY_SCAN = "1"; //扫码抽奖
    public static final String LOTTERY_BY_INPUT = "2"; //输入码抽奖
    //后台抽奖方式
    public static final String LOTTERY_NORMAL = "1"; //正常抽奖
    public static final String LOTTERY_MIN_PRIZE = "2"; //取区间红包的最小奖
    public static final String LOTTERY_INTEGRAL = "3"; //积分
    public static final String LOTTERY_MIN_FIXED_RED = "5";//取固定红包最小值
    		
    //未中奖是否需要处理
    public static final String NOT_WIN_WAY_NO = "0"; //不需要处理
    public static final String NOT_WIN_WAY_YES = "1"; //需要处理
    //是否是会员
    public static final String VIP_NO = "0"; //非会员
    public static final String VIP_YES = "1"; //是会员
    //是否首次抽奖
    public static final String FIRST_AWARD_NO = "0"; //非首次抽奖
    public static final String FIRST_AWARD_YES = "1"; //首次抽奖
    //是否首次中小于一元红包
    public static final String FIRST_LESS_YIYUAN_NO = "0"; //非首次
    public static final String FIRST_LESS_YIYUAN_YES = "1"; //首次
    //是否参与抽奖
    public static final String HAS_AWARD_NO = "0"; //没有抽奖
    public static final String HAS_AWARD_YES = "1"; //已经抽奖
    //用户是否首次参加活动 0 非首次 1 首次
    public static final String CUST_FIRST_ACT_NO = "0"; //非首次
    public static final String CUST_FIRST_ACT_YES = "1"; //首次
    //用户是否首次扫码 0 非首次 1 首次
    public static final String CUST_FIRST_SCAN_NO = "0"; //非首次
    public static final String CUST_FIRST_SCAN_YES = "1"; //首次
    //活动状态 活动开始间结束时间  1-未开始 2-进行中  3-已经结束
    public static final String ACT_NOT_BEG = "1"; //未开始
    public static final String ACT_IS_RUNNING = "2"; //进行中
    public static final String ACT_HAS_END = "3"; //已结束
    //扫码过渡页展示开始时间结束时间  1-未开始 2-进行中  3-已经结束
    public static final String SCT_NOT_BEG = "1"; //未开始
    public static final String SCT_IS_RUNNING = "2"; //进行中
    public static final String SCT_HAS_END = "3"; //已结束
	//活动是否有效
    public static final String ACT_VALID_ON = "0"; //无效
    public static final String ACT_VALID_YES = "1"; //有效
    //当前用户的openId是否和消费者兑换记录表中的openId相同 isCurrentOpenId;			 
    public static final String SAME_OPENID_NO = "0"; //不相同
    public static final String SAME_OPENID_YES = "1"; //相同
    //用户是否关注公众号
    public static final String CUST_IS_FOLLOW_NO = "0"; //没有关注
    public static final String CUST_IS_FOLLOW_YES = "1"; //已经关注
    //是否需要验证码 0 不需要 1 需要
    public static final String NEED_VALID_CODE_NO = "0"; //不需要
    public static final String NEED_VALID_CODE_YES = "1"; //需要
    //验证码是是否相同 0 不相同  1 相同
    public static final String SAME_VALID_CODE_NO = "0"; //不相同
    public static final String SAME_VALID_CODE_YES = "1"; //相同
    //获取openId和支付payOpenId标识 0 openId 1 payOpenId
    public static final String GET_OPENID = "0";
    public static final String GET_PAY_OPENID = "1";
    //业务代码
    public static final String BUSINESS_CODE_SMCJ = "smcj";//扫码抽奖
    public static final String BUSINESS_CODE_JFCJ = "jfcj";//积分抽奖
    //项目标识
    public static final String PROJECT_FLAG_HNYJ = "hnyj";//河南燕京
    public static final String PROJECT_FLAG_GDXH = "gdxh";//广东雪花
    //Cookie中的值
    public static final String COOKIE_PHONE = "phone";//消费者电话号码
    public static final String COOKIE_USERID = "user_id";//消费者ID 
    public static final String COOKIE_OPENID = "openId";//消费者openId
    public static final String COOKIE_PAYOPENID = "payOpenId";//支付payOpenId
    public static final String COOKIE_BARCODE = "barcode";//一级单品码
    public static final int COOKIE_MAX_AGE = 5*365*24*60*60;//cookie的生命周期
    public static final int COOKIE_MIN_AGE = 10*60;//cookie的生命周期
    //返回信息
    public static final String RETURN_CODE = "retCode";//返回码
    public static final String RETURN_INFO = "retInfo";//返回信息
    //调用微信参数
    public static final String SNSAPI_BASE = "snsapi_base"; //静默授权，只获取openId
    public static final String SNSAPI_USERINFO = "snsapi_userinfo"; //信息获取，获取openId和微信昵称和头像
    //从微信获取openId成功失败标识
    public static final String WX_OPENID_NO = "0"; //失败
    public static final String WX_OPENID_YES = "1"; //成功
    public static final String LOTTERY_OPENID = "2"; //抽奖
    //微信服务地址
    public static final String WECHATDDR = "wechatAddr";
    // 青岛啤酒中奖记录分页数量
    public static final Integer QP_PAGENUM = 10;
    //辅料码过期时间 210天
    public static final Integer FL_TIME_OUT_DATE = new Integer(210);
    //产品过期时间
    public static final Integer PRODUCT_TIME_OUT_DATE = new Integer(210);
    
    // 分享红包相关
    public static final Integer REDBAG_STATUS_PAY_YES = new Integer(1); // 已支付
    public static final Integer REDBAG_STATUS_PAY_NO = new Integer(0); // 未支付
    public static final Integer REDBAG_PAY_SCUESS = new Integer(1); // 支付成功
    public static final Integer REDBAG_PAY_ERROR = new Integer(0); // 支付失败
    
	//零钱订单的信息
    public static final String REDIRECT_BACKTYPE_VALUE_1="1";//在申请平台订单的时候需要返回的type值  1.直接返回第三方业务
    public static final String REDIRECT_BACKTYPE_VALUE_2="2";//在申请平台订单的时候需要返回的type值  2.继续零钱宝业务，并提供返回第三方业务入口
    public static final Integer BIDS_UN_TAKE=1;//零钱订单未领取
    public static final Integer BIDS_STATUS_UNSAVE=0;//零钱订单申请失败
    public static final Integer BIDS_STATUS_SAVED=1;//零钱订单申请成功
    public static final String BIDS_ACTIVITY_DESC="青岛啤酒零钱红包";//活动信息
    public static final Integer BIDS_RED_SEND_SUCCESS=3;//零钱订单领取成功！
    public static final Integer BIDS_RED_OUT_DATA=2;//零钱订单过期
    public static final Integer BIDS_RED_SEND_FAILURE=4;//零钱订单领取失败
    public static final Integer BIDS_RED_REFUND_SUCCESS=7;//零钱订单退款成功
    public static final Integer BIDS_BIG_DATA_UNAWARD=1;//大数据未兑换已领取
    public static final Integer BIDS_BIG_DATA_SUCCESS=2;//兑换记录兑换成功
    public static final Integer BIDS_BIG_OUT_DATA=3;//兑换记录兑换失败
    public static final Integer BIDS_BIG_DATA_FAILTURE=4;//兑换记录兑换失败
    public static final String SCAN_QR_CODE="2";//是否显示扫一扫按钮（不显示）
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	//系统默认模板路径,系统启动时加载
	public static String DEFAULT_ACT_TEMP_PATH = null;
	//河南燕京默认模板相对路径
	public static final String HNYJ_ACT_TEMP_PATH = "hnyj-ym/";
	//河南燕京过渡页默认路径
	public static final String HNYJ_TRANS_PATH = "hnyj-ym/hnyj-Transition";
	//默认红包提示语
	public static final String HONGBAO_TISHI = "鸿运当头啊";
	//广东雪花默认模板相对路径
	public static final String GDXH_ACT_TEMP_PATH = "xp/";
	
	//经销商兑付扣款记录表同步状态
    public static final int _DPR_SYNC_STATUS_WAIT = 0;
    public static final int _DPR_SYNC_STATUS_SUCCESS = 1;
    public static final int _DPR_SYNC_STATUS_FAIL = 2;

}
