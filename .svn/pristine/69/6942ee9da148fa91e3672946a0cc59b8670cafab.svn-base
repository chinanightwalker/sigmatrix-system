 function UnboundProduct(productActivityId, activityId){
		   parent.alertMsg.confirm('确定解绑此项活动产品？',{
				okCall: function(){
			      $.ajax({
			  		url:getUrl()+'activity/removeProductBindActivity?productActivityId='+productActivityId + "&activityId="+activityId,
					type:'POST',
					dataType:'json',
					async:'false',
					cache:'false',
					success:function(data){	
					    if (data.statusCode == 200) {
					    	$("#unboundProductId"+productActivityId).remove();
						   $("#products").append("<div style='width: 95%;margin: 0px auto;padding: 5px 0px;'><input type='checkbox' value='"+data.productBase.productId+"' name='productId' />"+data.productBase.productName
						  +"</div>" );
						} else if(data.statusCode == 301){
							parent.alertMsg.error('会话超时,请重新登录', {
								okCall:function(){parent.DWZ.loadLogin();
							}});
						} else {
							parent.alertMsg.error(data.message);
						}
					},
			        error:function(){
			     	}
				  })	
				},
	  			cancelCall : function() {
				}
	  		});
	       
	   }
		   
 	//保存step4
	function saveActivityByStep(){
		var citys = [];
         var products =[];
         var activityId = $("#activityId").val();
        $('input[name="productId"]:checked').each(function(){ 
                  products.push($(this).val());
         });
		$.ajax({
	  		url:getUrl()+'activity/saveProduct?activityId='+activityId+'&productIds='+products,
			type:'POST',
			dataType:'json',
			async:'false',
			cache:'false',
			success:function(data){	
			    if (data.statusCode == 200) {
					location = getUrl()+data.forwardUrl;
				} else if(data.statusCode == 301){
					parent.alertMsg.error('会话超时,请重新登录', {
						okCall:function(){parent.DWZ.loadLogin();
					}});
				} else {
					parent.alertMsg.error(data.message);
				}
			}
		})
	}
	//按步跳转
	function toStep(step,id){
		location = getUrl()+"activity/toEdit?activityId="+id+"&step="+step;
	}