function changeStatus(id,status){
	 var btn = $("#btn"+id).find("span");
	 if(btn.attr("class") == 'on') {
	 parent.alertMsg.confirm('活动已开启，是否要关闭活动？',{
			okCall: function(){
				$.post(getUrl()+"activity/openOrClose",{'activityId':id,'isOpen':0},function(data){
					if (data.statusCode == 200) {
						parent.alertMsg.correct(data.message);
						$("#btn"+id).find("input").val("1");
				    	$("#btn"+id).css("background","#bfbebe");
				    	btn.toggleClass('on'); 
					} else if(data.statusCode == 301){
						parent.alertMsg.error('会话超时,请重新登录', {
							okCall:function(){parent.DWZ.loadLogin();
						}});
					}else {
						parent.alertMsg.error(data.message);
					}
				},"json");
				}
			}); 
	 } else { 
		 parent.alertMsg.confirm('活动已关闭，是否要开启活动？',{
			okCall: function(){
			 	$.post(getUrl()+"activity/openOrClose",{'activityId':id,'isOpen':1},function(data){
					if (data.statusCode == 200) {
						parent.alertMsg.correct(data.message);
						$("#btn"+id).find("input").val("0");
				    	$("#btn"+id).css("background","#48dc6c");
				    	btn.toggleClass('on'); 
					}else if(data.statusCode == 301){
						parent.alertMsg.error('会话超时,请重新登录', {
							okCall:function(){parent.DWZ.loadLogin();
						}});
					} else {
						parent.alertMsg.error(data.message);
					}
				},"json");
				}
			}); 
	 } 
}
// 删除
function deleteActivity(id){
	parent.alertMsg.confirm('确定要删除活动？',{
		okCall: function(){
			$.post(getUrl()+"activity/delete",{'activityId':id},function(data){
				if (data.statusCode == 200) {
					parent.alertMsg.correct(data.message);
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
	});	
}
// 新增
function toAdd(step){
	location = getUrl()+"activity/toEdit?step="+step;
}
// 编辑
function toEdit(id,step){
	if (step == 5) {
		location = getUrl()+"activity/toEdit?activityId="+id+"&step=1&editFlag=2";
	} else {
		location = getUrl()+"activity/toEdit?activityId="+id+"&step="+step+"&editFlag=1";
	}
}