$(document).ready(function() {
	// isBox();
	// 判断当前加载的红包类型,默认是定额红包
	changeRedType($("#redBagTypeHid"), "1", "", false);
});
/**
 * 切换红包类型时处理其余红包类型div数据
 * 
 * @param changeRedBagType
 *            切换成红包类型
 * @param edit
 *            1代表当前是新增操作,其他代表修改奖项操作
 * @param currRedBagType
 *            修改奖项时的原始红包类型,只在修改操作时有用
 */
function clearDivData(changeRedBagType, edit, currRedBagType) {
	if (edit == 1) { // 新增
		if (changeRedBagType == 1) { // 切换成定额红包
			$("#redIntervalDiv").find("input").val("0");
			$("#redForciblyDiv").find("input").val("0");
			$("#redPubBalanceDiv").find("input").val("0");
		} else if (changeRedBagType == 2) { // 切换成区间红包
			$("#rp_red").val("0.0"); // 红包金额归0
			$("#rp_red").change(); // rp_red定义了onchange事件,进行触发
			$("#redForciblyDiv").find("input").val("0"); // 霸占型红包input归0
		} else if (changeRedBagType == 3) { // 切换成霸占型红包
			$("#rp_red").val("0.0"); // 红包金额归0
			$("#rp_red").change(); // rp_red定义了onchange事件,进行触发
			$("#redIntervalDiv").find("input").val("0"); // 区间红包input归0
		}
	} else { // 修改
		if (changeRedBagType == 1) { // 切换成定额红包
			if (currRedBagType == 2) { // 原来的红包类型为区间红包
				$("#rp_red").val("0.0"); // 红包金额归0
				$("#rp_red").change(); // rp_red定义了onchange事件,进行触发
				$("#redForciblyDiv").find("input").val("0"); // 霸占型红包input归0
			} else if (currRedBagType == 3) { // 原来的红包类型为霸占型红包
				$("#rp_red").val("0.0"); // 红包金额归0
				$("#rp_red").change(); // rp_red定义了onchange事件,进行触发
				$("#redIntervalDiv").find("input").val("0"); // 区间红包input归0
			}
		} else if (changeRedBagType == 2) { // 切换成区间红包
			if (currRedBagType == 1) { // 原来的红包类型为定额红包,保留定额红包input数据
				$("#redIntervalDiv").find("input").val("0"); // 区间红包input归0
				$("#redForciblyDiv").find("input").val("0"); // 霸占型红包input归0
				$("#redPubBalanceDiv").find("input").val("0");
			} else if (currRedBagType == 3) { // 原来的红包类型为霸占型红包
				$("#rp_red").val("0.0"); // 红包金额归0
				$("#rp_red").change(); // rp_red定义了onchange事件,进行触发
				$("#redIntervalDiv").find("input").val("0"); // 区间红包input归0
			}
		} else if (changeRedBagType == 3) { // 切换成霸占型红包
			if (currRedBagType == 1) { // 原来的红包类型为定额红包,保留定额红包input数据
				$("#redIntervalDiv").find("input").val("0"); // 区间红包input归0
			} else if (currRedBagType == 2) { // 原来的红包类型为区间红包
				$("#rp_red").val("0.0"); // 红包金额归0
				$("#rp_red").change(); // rp_red定义了onchange事件,进行触发
				$("#redForciblyDiv").find("input").val("0"); // 霸占型红包input归0
			}
		}
	}
}
/**
 * 编辑红包\页面初始化\改变红包类型时操作
 * 注意：修改时不能修改红包类型,比如：当前红包是定时红包不能变成区间红包或霸占型红包
 * 
 * @param obj
 *            操作对象
 * @param edit
 *            为1新增奖项非1则为修改奖项
 * @param currRedBagType
 *            为修改奖项时此奖项的原始红包类型
 * @param isClear
 *            是否调用clearDivData函数,清理数据
 */
function changeRedType(obj, edit, currRedBagType, isClear) {
	var redBagType = $(obj).val();
	redBagType = (redBagType == "" || redBagType == null) ? "1" : redBagType;
	if (redBagType == 1) { // 定额红包
		$("#redIntervalDiv").hide();
		$("#redForciblyDiv").hide();
		$("#redPubBalanceDiv").hide();
		$("#redPacketsPrice").show();
		$("#redBagTypeHid").val("1");
		if (isClear == "true" || isClear == true) {
			clearDivData(redBagType, edit, currRedBagType);
		}
	} else if (redBagType == 2) { // 区间红包
		$("#redIntervalDiv").show();
		$("#redForciblyDiv").hide();
		$("#redPubBalanceDiv").show();
		$("#redPacketsPrice").hide(); // 区间红包和霸占型红包不显示红包金额
		$("#redBagTypeHid").val("2");
		if (isClear == "true" || isClear == true) {
			clearDivData(redBagType, edit, currRedBagType);
		}
	} else if (redBagType == 3) { // 霸占型红包
		$("#redIntervalDiv").hide();
		$("#redForciblyDiv").show();
		$("#redPubBalanceDiv").show();
		$("#redPacketsPrice").hide();
		$("#redBagTypeHid").val("3");
		if (isClear == "true" || isClear == true) {
			clearDivData(redBagType, edit, currRedBagType);
		}
	}
}

/**
 * 金额条件：两位小数,eg:0.00
 */
function validateMoney(money) {
	if (isNaN(money)) {
		return false;
	}
	var reg = /^\d+(\.\d{1,2}){0,1}$/;// 保留两位小数
	if (!reg.test(money)) {
		return false;
	}
	return true;
}

/**
 * 把当前的金额(元)转换成分放入对应的隐藏表单域,页面金额显示单位为元,入库时为分
 * 
 * @param obj
 * @param hidId
 *            对应的隐藏表单域id
 */
function changeHidMoney(obj, hidId) {
	var money = $(obj).val();
	if (validateMoney(money)) { // 符合金额条件的:两位小数
		$("#" + hidId).val(accMul(money, 100));
	}
}


/**
 * 验证是否是整数（包括负数,eg:-1,0,1,2）
 */
function isInteger(obj) {
	reg = /^[-]?\d+$/;
	if (!reg.test(obj)) {
		return false;
	} else {
		return true;
	}
}
// 投放量
function prizeCount() {
	var prizeCount = $("#rp_prizeCount").val();
	if (null == prizeCount || "" == prizeCount) {
		parent.alertMsg.error("请填写总投放量");
		return;
	} else if (!isInteger(prizeCount) || prizeCount > 100000000
			|| prizeCount < 0) {
		parent.alertMsg.error("总投放量请输入0~100000000之间的整数");
		return;
	}
}
// 总量
function totalCount() {
	var totalCount = $("#rp_totalCount").val();
	if (totalCount == null || "" == totalCount) {
		parent.alertMsg.error("请填写总量");
		return;
	} else if (!isInteger(totalCount) || totalCount > 999999 || totalCount < 0) {
		parent.alertMsg.error("总量请输入0~999999之间的整数");
		return;
	}
}

/**
 * 同步红包金额隐藏表单域
 * @param obj
 */
function syncRedPrizeAmount(obj) {
	var redAmountVal = obj.value;
	if (validateMoney(redAmountVal)) {
		$("#red_prizeAmount").val(accMul(redAmountVal, 100));
	}
}
/**
 * 清除初始值,若有关联的元素也清空(relateId参数即为关联元素id),规则:若文本框的值等于val则情况
 * 
 * @param obj
 * @param val
 *            等于该val时清空
 * @param relateId
 *            关联的元素id
 */
function clickClearData(obj, val, relateId) {
	var inputVal = $(obj).val();
	if ($.trim(inputVal) != "" && isNaN(inputVal) == false) {
		if (Number(inputVal) == Number(val)) {
			$(obj).val("");
			if (relateId != "") {
				$("#" + relateId).val("");
			}
		}
	}
}

/**
 * 返回奖项列表
 * @param activityId
 */
function closePrizeEdit(activityId) {
	var prizeListUrl = getUrl()+"prize/list?activityId=" + activityId;
	//alert(prizeListUrl);
	location.href = prizeListUrl;
}

/**
 * 红包奖项表单提交验证
 */
function saveRedPrizeInfo() {
	// 1、使提交按钮不可用
	//$("#redSubmitBtn").attr("disabled",true);
	// 2、验证各项表单
	if (checkProductName() == false || red() == false || validatePrizeCount() == false || validatePrizeRate() == false
			|| validateIntegration() == false || validateOtherType() == false || prizeRedHint() == false
			|| prizeDesc() == false) {
		// 验证不通过恢复提交按钮可用状态,让其更改后再次点击提交
		//$("#redSubmitBtn").removeAttr("disabled");
		return;
	}
	
	// 提交前清理数据,按新增时的清理方式
	clearDivData($("#redBagTypeSel").val(), "1", "");
	
	
	// 3、验证中奖率是否超出100%,传递的prizeRate是填写值,eg:10%传递10,90%传递90
	var validatePrizeRateUrl = getUrl() + "prize/validatePrizeRateIsFull";
	var prizeRate = $("#rp_prizeRate").val(); // 页面填写的中奖率
	var activityId = $("#activityIdHid").val(); // 奖项id
	var prizeId = $("#prizeIdHid").val(); // 奖项id,可为空,添加的时候就为空
	$.ajax({
		type : "post",
		url : validatePrizeRateUrl,
		data : {
			activityId : activityId,
			prizeId : prizeId,
			prizeRate:prizeRate
		},
		dataType : "json",
		async : false, // 采用同步请求
		success : function(data) {
			if (data.statusCode == "200") {
				// 4、所有验证通过后提交表单
				$("#rp").submit();
			}else if(data.statusCode == 301){
				parent.alertMsg.error('会话超时,请重新登录', {
					okCall:function(){parent.DWZ.loadLogin();
				}});
			}  else{
				parent.alertMsg.error(data.message);
				$("#rp_prizeRate").select();
			}
		},
		error : function() {
			parent.alertMsg.error("网络异常,请稍后重试");
		}
	});
}

/**********************************表单验证开始*********************************************************/
/**
 * 奖品名称验证
 * @returns {Boolean}
 */ 
function checkProductName() {
	var prizeName = $("#rp_prizeName").val();
	if ($.trim(prizeName) == "") {
		parent.alertMsg.error("请填写奖项名称！");
		$("#rp_prizeName").focus();
		return false;
	} else if (prizeName.length > 20) {
		parent.alertMsg.error("奖项名称长度不得超过20个字符！");
		$("#rp_prizeName").focus();
		return false;
	}
	return true;
}
/**
 * 红包金额验证
 */ 
function red() {
	// 只有定额红包类型才有红包金额
	var redBagTypeHid = $("#redBagTypeHid").val();
	redBagTypeHid = (redBagTypeHid == "" || redBagTypeHid == null) ? "1" : redBagTypeHid;
	if (redBagTypeHid != 1) { // 当前不是定额红包类型直接返回true
		return true;
	}
	var redPrice = $("#rp_red").val();
	// var reg = /^-?\d+\.?\d{0,2}$/;//保留两位小数
	var reg = /^\d+(\.\d{1,2}){0,1}$/;// 保留两位小数
	var example = "8.88或者100";
	// alert("redPrice:"+redPrice);
	if ($.trim(redPrice) == "") {
		parent.alertMsg.error("请填写红包金额！");
		$("#redBagTypeHid").focus();
		return false;
	}
	if (!reg.test(redPrice)) {
		parent.alertMsg.error("红包金额格式不正确,例如" + example);
		$("#redBagTypeHid").focus();
		return false;
	} else if (redPrice > 200) {
		parent.alertMsg.error("红包金额不得超过200");
		$("#redBagTypeHid").focus();
		return false;
	} else if (redPrice <= 0) {
		parent.alertMsg.error("红包金额最低0.01元");
		$("#redBagTypeHid").focus();
		return false;
	}
	return true;
}
/**
 * 投放量验证
 */
function validatePrizeCount(){
	var prizeCount = $("#rp_prizeCount").val();
	if (null == prizeCount || "" == prizeCount) {
		parent.alertMsg.error("请填写总投放量");
		$("#rp_prizeCount").focus();
		return false;
	} else if (!isInteger(prizeCount) || prizeCount > 100000000
			|| prizeCount <= 0) {
		parent.alertMsg.error("总投放量请输入1~100000000之间的整数");
		$("#rp_prizeCount").focus();
		return false;
	}
	return true;
}
/**
 * 中奖率验证
 * @returns {Boolean}
 */ 
function validatePrizeRate() {
	var prizeRate = $("#rp_prizeRate").val();
	// var reg = /^-?\d+\.?\d{0,4}$/;//保留两位小数
	var reg = /^\d+(\.\d{1,4}){0,1}$/;// 保留4位小数
	if ($.trim(prizeRate) == "") {
		parent.alertMsg.error("请输入奖项中奖率");
		$("#rp_prizeRate").focus();
		return false;
	} else if (!reg.test(prizeRate) || prizeRate > 100 || prizeRate < 0) {
		parent.alertMsg.error("中奖率格式不正确,例如10%、9.9%或9.9999%");
		$("#rp_prizeRate").focus();
		return false;
	} else if (prizeRate <= 0) {
		parent.alertMsg.error("中奖率必须大于0");
		$("#rp_prizeRate").focus();
		return false;
	}
	return true;
}
/**
 * 积分验证
 * @returns {Boolean}
 */
function validateIntegration() {
	var integration = $("#rp_integration").val();
	if ($.trim(integration)!="") {
		if (!isInteger(integration) || integration > 999999 || integration < 0) {
			parent.alertMsg.error("积分请输入0~999999之间的整数");
			$("#rp_integration").focus();
			return false;
		}
	}
	return true;
}
/**
 * 区间红包和霸占型红包的验证
 * @returns {Boolean}
 */
function validateOtherType() {
	var redBagType = $("#redBagTypeSel").val();
	if (redBagType == 2) { // 区间红包
		var rp_minAmount = $("#rp_minAmount").val(); // 最小红包金额
		var rp_maxAmount = $("#rp_maxAmount").val(); // 最大红包金额
		var rp_firstMinAmount = $("#rp_firstMinAmount").val(); // 首次中奖最小金额
		if ($.trim(rp_minAmount) == "") {
			parent.alertMsg.error("请输入最小红包金额");
			$("#rp_minAmount").focus();
			return false;
		} else if (!validateMoney(rp_minAmount)) {
			parent.alertMsg.error("最小红包金额格式不正确");
			$("#rp_minAmount").focus();
			return false;
		} else if (rp_minAmount <= 0) {
			parent.alertMsg.error("最小红包金额最低0.01元");
			$("#rp_minAmount").focus();
			return false;
		}
		if ($.trim(rp_maxAmount) == "") {
			parent.alertMsg.error("请输入最大红包金额");
			$("#rp_maxAmount").focus();
			return false;
		} else if (!validateMoney(rp_maxAmount)) {
			parent.alertMsg.error("最大红包金额格式不正确");
			$("#rp_maxAmount").focus();
			return false;
		} else if (rp_maxAmount <= 0) {
			parent.alertMsg.error("最大红包金额最低0.01元");
			$("#rp_maxAmount").focus();
			return false;
		} else if (rp_maxAmount < rp_minAmount) {
			parent.alertMsg.error("最大红包金额不能小于最小红包金额");
			$("#rp_maxAmount").focus();
			return false;
		}
		if ($.trim(rp_firstMinAmount) != "") { // 首次中奖最小金额可为空
			if (!validateMoney(rp_firstMinAmount)) {
				parent.alertMsg.error("首次中奖最小金额格式不正确");
				$("#rp_firstMinAmount").focus();
				return false;
			}
		}
	}
	if (redBagType == 3) { // 霸占型红包
		var rp_prizeForciblyCount = $("#rp_prizeForciblyCount").val(); // 参与人数
		var rp_prizeForciblyAmount = $("#rp_prizeForciblyAmount").val(); // 每人分到的金额
		if ($.trim(rp_prizeForciblyCount) == "") {
			parent.alertMsg.error("请输入霸占型红包参与人数");
			$("#rp_prizeForciblyCount").focus();
			return false;
		} else if (rp_prizeForciblyCount <= 0) {
			parent.alertMsg.error("霸占型红包参与人数应大于0");
			$("#rp_prizeForciblyCount").focus();
			return false;
		}
		if ($.trim(rp_prizeForciblyAmount) == "") {
			parent.alertMsg.error("请输入每人分到的金额");
			$("#rp_prizeForciblyAmount").focus();
			return false;
		} else if (!validateMoney(rp_prizeForciblyAmount)) {
			parent.alertMsg.error("每人分到的金额格式不正确");
			$("#rp_prizeForciblyAmount").focus();
			return false;
		} else if (rp_prizeForciblyAmount < 1) {
			parent.alertMsg.error("每人分到的金额不能小于1元");
			$("#rp_prizeForciblyAmount").focus();
			return false;
		}
	}
	if (redBagType == 2 || redBagType == 3) {
		var rp_balance = $("#rp_balance").val(); // 剩余金额
		if ($.trim(rp_balance) == "") {
			parent.alertMsg.error("请输入总剩余金额");
			$("#rp_balance").focus();
			return false;
		} else if (!validateMoney(rp_balance)) {
			parent.alertMsg.error("总剩余金额格式不正确");
			$("#rp_balance").focus();
			return false;
		} else if (rp_balance <= 0) {
			parent.alertMsg.error("总剩余金额必须大于0");
			$("#rp_balance").focus();
			return false;
		} else if (rp_balance > 20000000) { // 必须小于2000万元
			parent.alertMsg.error("总剩余金额必须小于20000000元");
			$("#rp_balance").focus();
			return false;
		}
	}
	return true;
}
/**
 * 奖项提示语验证
 * @returns {Boolean}
 */
function prizeRedHint() {
	var redbagHint = $("#prizeRedHint").val();
	if ($.trim(redbagHint) == "") {
		parent.alertMsg.error("请输入奖项提示语");
		$("#prizeRedHint").focus();
		return false;
	}
	if (redbagHint.length > 20 || redbagHint.length < 4) {
		parent.alertMsg.error("奖项提示语为4-20个字符");
		$("#prizeRedHint").focus();
		return false;
	}
	return true;
}
/**
 * 奖项描述验证
 * @returns {Boolean}
 */
function prizeDesc() {
	var prizeDesc = $("#rp_prizeDesc").val();
	if (null != prizeDesc) {
		if (prizeDesc.length > 1024) {
			parent.alertMsg.error("奖项描述不得超过1024个字符");
			$("#rp_prizeDesc").focus();
			return false;
		}
	}
	return true;
}
/**********************************表单验证结束*********************************************************/