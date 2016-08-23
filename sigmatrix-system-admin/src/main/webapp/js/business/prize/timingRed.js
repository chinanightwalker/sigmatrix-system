$(document).ready(function() {
	// isBox();
});
var currentNum = 0;
/**
 * 增加时间段
 * @param obj 当前a标签对象
 * @param trIdPrefix 当前tr的id的前缀
 * @param num 当前tr的id的后缀
 */
function addTimeslotInfo(obj,trIdPrefix,num){
	//alert(num);
	if(Number(currentNum)==0){
		currentNum = num;
	}
	//alert(currentNum);
	//currentNum = Number($("tr[id^='timeslotInfoTr']").size()+currentNum);
	currentNum = Number(currentNum) + 1;
	//alert(currentNum);
	//var currentNum = Number(num)+1;
	var trContent = '<tr id="timeslotInfoTr'+currentNum+'"><td><input type="text" name="timeslotInfos['+currentNum+'].starttime" class="Wdate" id="starttime'+currentNum+'" onfocus="WdatePicker({dateFmt:\'H:mm:ss\'})"/>'
	+'至<input type="text" name="timeslotInfos['+currentNum+'].endtime" class="Wdate" id="endtime'+currentNum+'" onfocus="WdatePicker({dateFmt:\'H:mm:ss\'})"/>'
	+'<span style="color: #f91142;">&nbsp;*&nbsp;</span><a class="cursor_user" onclick="removeTimeslotInfo(this,\''+trIdPrefix+'\',\''+currentNum+'\')">删除</a></td><tr>';
	$(obj).closest("table").append(trContent);
}
/**
 * 移除当前时间段
 * @param obj 当前a标签对象
 * @param trIdPrefix 当前tr的id的前缀
 * @param num 当前tr的id的后缀
 */
function removeTimeslotInfo(obj,trIdPrefix,num){
	//$(obj).closest("tr").remove();
	$("#"+trIdPrefix+num).remove();
}
/**
 * 改变定时红包的奖项模式,如果模式为"按时段"的话则显示时间段添加的div
 * @param obj
 */
function changeMode(obj){
	var modeVal = $(obj).val();
	//alert(modeVal);
	if(modeVal==4){
		$("#timeslotInfoDev").show();
	}else{
		$("#timeslotInfoDev").hide();
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
 * 同步定时红包金额隐藏表单域
 * @param obj
 */
function syncRedPrizeAmount(obj) {
	var redAmountVal = obj.value;
	if (validateMoney(redAmountVal)) {
		$("#prizeAmountHid").val(accMul(redAmountVal, 100));
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
 * 验证是否是整数,包括负数,eg:-1,-32,0,1,23
 * @param obj 将要验证的值
 * @returns {Boolean}
 */
function isInteger(obj) {
	reg = /^[-]?\d+$/;
	if (!reg.test(obj)) {
		return false;
	} else {
		return true;
	}
}
/**
 * 取消提交表单,跳转到奖项列表
 * @param activityId
 */
function closePrizeEdit(activityId) {
	var prizeListUrl = getUrl()+"prize/list?activityId=" + activityId;
	location.href = prizeListUrl;
}

/**
 * 提交表单
 */
function saveTimingRedInfo() {
	// 1、使提交按钮不可用
	//$("#timingRedBtn").attr("disabled",true);
	// 2、验证各项表单
	if(validatePrizeName()==false || validateTimingRed()==false || validateStartEndDate()==false
			|| validatePrizePeriodMode()==false || validatePrizePeriodCount()==false 
			|| validatePrizeFactor()==false || validatePrizeRedHint()==false 
			|| validatePrizeDesc()==false){
		// 验证不通过恢复提交按钮可用状态,让其更改后再次点击提交
		//$("#timingRedBtn").removeAttr("disabled");
		return;
	}
	// 3、所有验证通过后提交表单
	$("#tk").submit();
}
/**********************************表单验证开始*********************************************************/
/**
 * 验证定时红包名称
 */
function validatePrizeName(){
	var prizeName = $("#tk_prizeName").val();
	if ($.trim(prizeName)=="") {
		parent.alertMsg.error("请填写定时红包奖品名称！");
		$("#tk_prizeName").focus();
		return false;
	} else if (prizeName.length > 20) {
		parent.alertMsg.error("定时红包奖品名称长度不得超过20个字符！");
		$("#tk_prizeName").focus();
		return false;
	}
	return true;
}
/**
 * 定时红包金额验证
 */ 
function validateTimingRed() {
	var redPrice = $("#timingRed").val();
	// var reg = /^-?\d+\.?\d{0,2}$/;//保留两位小数
	var reg = /^\d+(\.\d{1,2}){0,1}$/;// 保留两位小数
	var example = "8.88或者100";
	// alert("redPrice:"+redPrice);
	if ($.trim(redPrice) == "") {
		parent.alertMsg.error("请填写定时红包金额！");
		$("#timingRed").focus();
		return false;
	}
	if (!reg.test(redPrice)) {
		parent.alertMsg.error("定时红包金额格式不正确,例如" + example);
		$("#timingRed").focus();
		return false;
	} else if (redPrice > 200) {
		parent.alertMsg.error("定时红包金额不得超过200");
		$("#timingRed").focus();
		return false;
	} else if (redPrice <= 0) {
		parent.alertMsg.error("定时红包金额最低0.01元");
		$("#timingRed").focus();
		return false;
	}
	return true;
}
/**
 * 验证定时红包起始日期
 * @returns {Boolean}
 */
function validateStartEndDate(){
	var beginDate = $("#beginDate").val();
	var endDate = $("#endDate").val();
	if($.trim(beginDate)==""){
		parent.alertMsg.error("请输入定时红包开始日期");
		$("#beginDate").foucs();
		return false;
	}
	if($.trim(endDate)==""){
		parent.alertMsg.error("请输入定时红包结束日期");
		$("#endDate").foucs();
		return false;
	}
	return true;
}
/**
 * 如果定时红包的奖项模式为"按时段"的话,必填
 * @returns {Boolean}
 */
function validatePrizePeriodMode(){
	var prizePeriodMode = $("#prizePeriodMode").val();
	//alert(prizePeriodMode);
	var isTrue = true;
	if(prizePeriodMode==4){ // 代表按时段
		$("tr[id^=timeslotInfoTr]").each(function(){
			var trId = $(this).attr("id");
			//alert(trId);
			// 取后缀
			var suffixNum = trId.substring("timeslotInfoTr".length);
			//alert(suffixNum);
			// 判断时间段的值必填
			if(!validateTimeslotInfos('starttime','endtime',suffixNum)){
				isTrue = false;
				return false; // 跳出each循环
			}
		});
	}
	return isTrue;
}
/**
 * 验证时间段,验证通过返回true,否则返回false
 * @param starttimePrefix 时间段的开始时间前缀
 * @param endtimePrefix 时间段的结算时间前缀
 * @param suffixNum 时间段的后缀(开始和结束时间的后缀都相同)
 * @returns {Boolean}
 */
function validateTimeslotInfos(starttimePrefix,endtimePrefix,suffixNum){
	var starttime = $("#"+starttimePrefix+suffixNum).val();
	var endtime = $("#"+endtimePrefix+suffixNum).val();
	if($.trim(starttime)==""){
		parent.alertMsg.error("请输入时间段的开始时间！");
		//$("#"+starttimePrefix+suffixNum).focus();
		return false;
	}
	if($.trim(endtime)==""){
		parent.alertMsg.error("请输入时间段的结束时间！");
		//$("#"+endtimePrefix+suffixNum).focus();
		return false;
	}
	return true;
}
/**
 * 验证奖项周期投放量
 * @returns {Boolean}
 */
function validatePrizePeriodCount(){
	var prizePeriodCount = $("#prizePeriodCount").val();
	if($.trim(prizePeriodCount)==""){
		parent.alertMsg.error("请填写定时红包周期投放量");
		$("#prizePeriodCount").focus();
		return false;
	}
	if(!isInteger(prizePeriodCount)||prizePeriodCount > 100000000
			|| prizePeriodCount <= 0){
		parent.alertMsg.error("总投放量请输入1~100000000之间的整数");
		$("#prizePeriodCount").focus();
		return false;
	}
	return true;
}
/**
 * 验证中奖因子>=1的整数
 * @returns {Boolean}
 */
function validatePrizeFactor(){
	var prizeFactor = $("#prizeFactor").val();
	if($.trim(prizeFactor)==""){
		parent.alertMsg.error("请填写定时红包中奖因子");
		$("#prizeFactor").focus();
		return false;
	}
	if(!isInteger(prizeFactor)||prizeFactor < 1){
		parent.alertMsg.error("定时红包中奖因子必须填写大于等于1的整数");
		$("#prizeFactor").focus();
		return false;
	}
	return true;
}
/**
 * 奖项提示语验证
 * @returns {Boolean}
 */
function validatePrizeRedHint() {
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
 * 验证奖项描述
 */
function validatePrizeDesc(){
	var prizeDesc = $("tk_prizeDesc").val();
	if ($.trim(prizeDesc)!="") {
		if (prizeDesc.length > 1024) {
			parent.alertMsg.error("奖项描述不得超过1024个字符");
			$("tk_prizeDesc").focus();
			return;
		}
	}
}

/**********************************表单验证结束*********************************************************/