$(function () {
			//活动类型编辑
	$(".mychick").click(function(){
		$(".chick_flag").hide();
		$(this).next(".chick_flag").show();
		var activityType = $(this).attr('id');
		$("#activityType").val(activityType);
	});
	var checkForm = $("#activityType").val();
	if (checkForm != null && '' != checkForm) {
		$(".chick_flag").hide();
		$("#"+checkForm).next(".chick_flag").show();
	} else {
		$(".chick_flag").hide();
	}
	//是否为积分抽奖编辑
	$("input[name='isIntegral']").change(function(){
		var isIntegralVal = $(this).val();
		$("input[name='activity.isIntegral']").val(isIntegralVal);
	});
	var actIsIntegralVal = $("#activityIsIntegral").val();
	var isIntegral = $("input[name='isIntegral']").val();
	if (actIsIntegralVal != null && '' != actIsIntegralVal) {
		//循环radio
		$("input[name='isIntegral']").each(function(){
			var isIntegral = $(this).val();
			console.info(isIntegral);
			if (actIsIntegralVal == isIntegral) {
				$(this).attr('checked',true);
			}
		});
	} else {
		//不做处理
		$("input[name='activity.isIntegral']").val(0);
	}
});
//保存step1
function saveActivityByStep(){
	var type = $("#activityType").val();
	var isIntegral = $("#activityType").val();
	var activityId = $("#activityId").val();
	//var formData = $("#activityFormForm").serialize();
	$.post(getUrl()+"activity/saveActivityType",{'type':type,'isIntegral':isIntegral, 'activityId':activityId},function(data){
		if (data.statusCode == 200) {
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
//按步跳转
function toStep(step,id){
	location = getUrl()+"activity/toEdit?activityId="+id+"&step="+step;
}