var seq = -1;
var img_num = 0;//图片数
var img_type = '';
function addImg(element){
	seq = $(element).attr("seq");
	if(seq==undefined||seq==null||seq==""){
		img_type="goodsListPic";//列表图片(单张)
	}else{
		img_type="";
	}
	img_num = $("#view_image").find("img").size();
	if(img_num>=4&&img_type!="goodsListPic"&&seq==-1){
		alertMsg.error("商品图片已达到上限4张！");
		return;
	}
	$("#file").click();
}

var goods_images = [];
function imgUpload(){
	$.ajaxFileUpload({
//        url:'upLoadImage.html?titlePicName='+titlePicName,//用于文件上传的服务器端请求地址
		url:'upLoadImage.html?from=goods',//用于文件上传的服务器端请求地址
        secureuri:false,//一般设置为false
        fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
        dataType: 'json',//返回值类型 一般设置为json
        success: function (data, status){  //服务器成功响应处理函数
           // alert(data.msg);//从服务器返回的json中取出message中的数据,其中message为在struts2中action中定义的成员变量
            if(data.result=='1'){
            	if(img_type=="goodsListPic"){//单图
            		$("#goodsListPic").val(data.fileUrl);
            		$("#view_image_list").css("display","block").find("img").attr("src",data.fileUrl);
            	}else{//列表多图
            		if(seq==-1){
		    			var $view_image = $("#view_image");
						goods_images.push(data.fileUrl);
						$view_image.append(picHtml(data.fileUrl));
						$("#picsStr").val(goods_images.join(";"));
	            	}else{
	            		goods_images[seq] = data.fileUrl;
	            		$("#pic_"+seq).replaceWith(picHtml(data.fileUrl));
	            		$("#picsStr").val(goods_images.join(";"));
	            	}
            	}
            }else {
            	alert(data.msg);
			}
        },
        error: function (data, status, e){//服务器响应失败处理函数
        	alert(data.msg);
        }
    });
}

function picHtml(src){
	var seq_html = (seq==-1) ? img_num : seq; 
	return '<div id="pic_'+seq_html+'">' +
	'<img src="'+src+'"/>' +
	'<span seq="'+seq_html+'" onclick="addImg(this)">更换</span><span onclick="removeImg('+seq_html+');">删除</span>' +
	'</div>';
}

function removeImg(seq){
	goods_images[seq] = '';
	$("#picsStr").val(goods_images.join(";"));
	$("#pic_"+seq).remove();
}