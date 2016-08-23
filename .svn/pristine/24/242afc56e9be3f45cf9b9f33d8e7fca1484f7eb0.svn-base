var prizeType = 0;
$(function() {
	// 奖项类型选择js效果并赋值
	$(".myclick").click(function() {
		$(".myclick_g").hide();
		$(this).next(".myclick_g").show();
		var type = $(this).attr('type');
		//alert(type);
		if (type == "1") {
			prizeType = 1;
		} else if (type == "2") { // 红包
			prizeType = 2;
		} else if (type == "3") {
			prizeType = 3;
		} else if (type == "4") {
			prizeType = 4;
		} else if (type == "5") {
			prizeType = 5;
		} else if (type == "6") { // 定时红包
			prizeType = 6;
		} else if (type == "7") { // 定时红包
			prizeType = 7;
		} else {
			prizeType = type;
		}
	});
});
/**
 * 按步跳转
 * @param step
 * @param id
 */
function toStep(step,id){
	location = getUrl()+"activity/toEdit?activityId="+id+"&step="+step;
}
/**
 * 添加奖项弹出层
 */
function toAdd(isOpen) {
	// 活动开启时不能添加
	if (isOpen == '1') {
		parent.alertMsg.error("活动已开启，不能添加奖项");
		return;
	} else {
		$("#addPrize_mask").show();
	}
}

/**
 * 关闭奖项弹出层
 */
function closePrizeType(activityId) {
	$("#addPrize_mask").hide();
	location.href = getUrl()+"prize/list?activityId=" + activityId;
}

/**
 * 根据奖项类型跳转到相应的奖项里进行奖项添加
 */
function subPrizeType(activityId) {
	if(prizeType==0){
		parent.alertMsg.error("请选择奖项类型");
		return;
	}
	var prizeUrl = ""; // 奖项url
	$("#addPrize_mask").hide();
	prizeUrl = getUrl() + "prize/input?activityId="+activityId+"&prizeType="+prizeType;
	//alert(prizeUrl);
	location.href = prizeUrl;
}

/**
 * 奖项列表下一步跳转
 */
function saveActivityByStep(activityId,step) {
	// 未激活处理方式
	var unactiviteProcessType = $("#unactiviteId").val();
	$.ajax({
		type : "post",
		url : getUrl() + "activity/prizeNext",
		data : {
			activityId : activityId,
			unactiviteProcessType : unactiviteProcessType
		},
		dataType : "json",
		success : function(data) {
			if (data.statusCode == "200") { 
				//parent.alertMsg.correct("操作成功！");
				var prizeUrl = getUrl() + "activity/toEdit?activityId="+activityId+"&step="+step;
				location.href = prizeUrl;
			}else if(data.statusCode == 301){
				parent.alertMsg.error('会话超时,请重新登录', {
					okCall:function(){parent.DWZ.loadLogin();
				}});
			}  else if(data.statusCode == "3001"){ // 活动未设置奖项
				parent.alertMsg.error(data.message);
			}
		},
		error : function() {
			parent.alertMsg.error("网络异常,请稍后重试");
		}
	});
	
}

/**
 * 奖项编辑
 * @param prizeId 奖项id
 * @param aId 活动id
 * @param type
 */
function editPrize(prizeId, isOpen) {
	// 活动开启不能编辑
	if (isOpen == '1') {
		parent.alertMsg.error("活动已开启，不能编辑");
		return;
	}
	var prizeInputUrl = getUrl() + "prize/input?prizeId=" + prizeId;
	location.href = prizeInputUrl;
}
/**
 * 总投放量(type=1)/总金额(type=2)编辑
 * @param obj 当前编辑的对象
 * @param activityId 活动id
 * @param prizeId 奖项id
 * @param prizeType 奖项类型
 * @param type 类型,1投放量,2总金额
 * @param oldPrizeCount 编辑前的值
 */
function toAddCount(obj,activityId, prizeId,prizeType, type, oldPrizeCount) {
	var prizeCount = obj.value;
	if ($.trim(prizeCount) == "") { // 为空取回原值
		$(obj).val(oldPrizeCount);
		return;
	}
	if (type == "1") { // 总投放量
		var reg3 = /^\+?[1-9][0-9]*$/;// 非零正整数
		// 投放量验证
		if (!reg3.test(prizeCount)) {
			parent.alertMsg.error("投放量格式不正确，需填写非零正整数！");
			$("#pCount" + prizeId).val(oldPrizeCount);
			return;
		}
		if (prizeCount > 100000000) {
			parent.alertMsg.error("总投放量不能超过1亿！");
			$("#pCount" + prizeId).val(oldPrizeCount);
			return;
		}
		if (prizeCount == oldPrizeCount) { // 修改的值和原值相等,不触发后台修改
			return;
		}
	} else if (type == "2") { // 总金额
		if (!validatePrizeMoney(prizeCount)) {
			parent.alertMsg.error("总金额格式不正确,形如0.01");
			$(obj).val(oldPrizeCount);
			return;
		} else if (prizeCount < 0) {
			parent.alertMsg.error("总金额不能小于0");
			$(obj).val(oldPrizeCount);
			return;
		} else if (Number(prizeCount) > 20000000) { // 必须小于2000万元
			parent.alertMsg.error("总金额不能大于20000000元");
			$(obj).val(oldPrizeCount);
			return;
		}
		if (Number(prizeCount) == Number(oldPrizeCount)) { // 修改的值和原值相等,不触发后台修改
			return;
		}
	}
	$.post(getUrl()+"prize/toAddCount", {
		'activityId':activityId,
		'prizeId' : prizeId,
		'prizeUpdateVal' : prizeCount,
		'type' : type,
		'prizeType':prizeType
	}, function(data) {
		if (data.statusCode == '200') {
			parent.alertMsg.correct(data.message);
			location.href = getUrl() + "prize/list?activityId="
					+ activityId;
		}else if(data.statusCode == 301){
			parent.alertMsg.error('会话超时,请重新登录', {
				okCall:function(){parent.DWZ.loadLogin();
			}});
		}  else {
			parent.alertMsg.error(data.message);
			// 出错改回原值
			$(obj).val(oldPrizeCount);
		}
	}, "json");

}
/**
 * 设置首次中奖奖项
 */
function saveFirstPrizeId(activityId,isOpen) {
	var firstPrize = $("#firstPrizeId").val();
	if (isOpen == '1') {
		parent.alertMsg.error("活动已开启，不能编辑");
		return;
	} else {
		var firstPrizeUrl = getUrl() + "activity/saveFirstPrizeId";
		$.ajax({
			type : "post",
			url : firstPrizeUrl,
			data : {
				activityId : activityId,
				prizeId : firstPrize
			},
			dataType : "json",
			success : function(data) {
				if (data.statusCode == "200") {
					parent.alertMsg.correct(data.message);
				} else if(data.statusCode == 301){
					parent.alertMsg.error('会话超时,请重新登录', {
						okCall:function(){parent.DWZ.loadLogin();
					}});
				} else{
					$("#firstPrizeId").val(""); // 让其选中"--请选择--"
					parent.alertMsg.error(data.message);
				}
			},
			error : function() {
				$("#firstPrizeId").val(""); // 让其选中"--请选择--"
				parent.alertMsg.error("网络异常,请稍后重试");
			}
		});
	}
}
/**
 * 删除奖项
 * @param activityId 活动id
 * @param prizeId 奖项id
 * @param isOpen 活动是否开启,1代表开启
 */
function deletePrize(activityId,prizeId, isOpen) {
	// 活动开启不能删除
	if (isOpen == '1') {
		parent.alertMsg.error("活动已开启，不能删除");
		return;
	}
	var postUrl = getUrl()+ "prize/delete";
	
	parent.alertMsg.confirm('确认删除此奖项？', {
		okCall : function() {
			$.post(postUrl, {
				'prizeId' : prizeId,
				'activityId' : activityId
			}, function(data) {
				if (data.statusCode == '200') {
					parent.alertMsg.correct(data.message);
					location.href = getUrl() + "prize/list?activityId="
							+ activityId;
				} else if(data.statusCode == 301){
					parent.alertMsg.error('会话超时,请重新登录', {
						okCall:function(){parent.DWZ.loadLogin();
					}});
				} else {
					parent.alertMsg.error(data.message);
				}
			}, "json");
		},
		cancelCall : function() {

		}
	});
}
/**
 * 金额条件：两位小数,eg:0.00
 * @param money
 * @returns {Boolean}
 */
function validatePrizeMoney(money) {
	if (isNaN(money)) {
		return false;
	}
	var reg = /^\d+(\.\d{1,2}){0,1}$/;// 保留两位小数
	if (!reg.test(money)) {
		return false;
	}
	return true;
}
