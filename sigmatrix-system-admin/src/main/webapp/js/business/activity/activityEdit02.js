window.onload = function()
    {
        CKEDITOR.replace('activity.comments',{
    	toolbar : 'MyToolbar'
    });
    
};

$(function () {
});
//按步跳转
function toStep(step,id){
	location = getUrl()+"activity/toEdit?activityId="+id+"&step="+step;
}
/**
 * 验证活动每天最大中奖次数
 * 规则:1、可同时为空,但一个有,另一个必填2、用户每天最大中奖数量最大为1000
 */
function validateUserDayPrizeCount(){
	var userDayMaxPrizeCount = $("#userDayMaxPrizeCount").val();
	var userMaxPrizeProcessType = $("#userMaxPrizeProcessType").val();
	if($.trim(userDayMaxPrizeCount)!=""){
		if(isNaN(userDayMaxPrizeCount)||userDayMaxPrizeCount>1000){
			parent.alertMsg.error("用户每天最大中奖数量为0-1000的整数");
			return false;
		}
		if(userMaxPrizeProcessType==""){
			parent.alertMsg.error("请选择用户达到中奖数量上限处理方式");
			return false;
		}
	}else{
		if(userMaxPrizeProcessType!=""){
			parent.alertMsg.error("请输入用户每天最大中奖数量");
			return false;
		}
	}
	return true;
}
//保存step2
function saveActivityInfo(){
	for ( instance in CKEDITOR.instances ) 
		CKEDITOR.instances[instance].updateElement(); 
	var detail = $("#comments").val().length;
	if (detail > 10000) {
		parent.alertMsg.error("活动详情输入过长");  
        return;
	}	
/*	var unactiviteProcessType = $("#unactiviteProcessTypeSel").val();
	if($.trim(unactiviteProcessType)==""){
		parent.alertMsg.error("请选择未激活处理方式");
		return;
	}*/
	//验证
	var reg1 = /^\d+$/;//正整数
	var activityTemplate = $("#activityTemplate").val();
	if($.trim(activityTemplate)==""){
		parent.alertMsg.error("请选择活动模板");  
    	return;
	}
	var isIntegral = $("#activityIsIntegral").val();
	if (isIntegral == 1||'1' == isIntegral) {
		var useIntegral = $("input[name='useIntegral']").val();
		if(!reg1.test(useIntegral)){
			parent.alertMsg.error("活动消耗积分需为正整数");  
	    	return;
		}	
	}
	if(validateUserDayPrizeCount()==false){
		return;
	} 
	var formData = $("#activityForm").serialize();
	$.post(getUrl()+"activity/saveActivityInfo",formData,function(data){
		if (data.statusCode == 200) {
			//parent.alertMsg.correct(data.message);
			location = getUrl()+data.forwardUrl;
		} else if(data.statusCode == 301){
			parent.alertMsg.error('会话超时,请重新登录', {
				okCall:function(){parent.DWZ.loadLogin();
			}});
		} else {
			parent.alertMsg.error(data.message);
		}
	},"json");
}