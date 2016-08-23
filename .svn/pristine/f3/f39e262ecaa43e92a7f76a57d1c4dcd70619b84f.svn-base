/**
 * Ajax上传图片
 */
function ajaxFileUpload(a) {
//	if($.trim($("#imageUploadFile").val())==""){
	if($.trim($("#file").val())==""){
		parent.alertMsg.error("请选择上传的图片");
		return;
	}
	$.ajaxFileUpload({
		url : a+'uploadPic/upload', // 需要链接到服务器地址
		secureuri : false,
//		fileElementId : 'imageUploadFile', // 文件选择框的id属性
		fileElementId : 'file', // 文件选择框的id属性
		dataType : 'text', // 服务器返回的格式，可以是json
		success : function(data, status){
			// ajaxfileupload不支持响应头ContentType为application/json的设置，并且IE也不支持这种格式
			data = jQuery.parseJSON(data);
			if(data.error==null){ // 上传成功
				$("#transitionImg").attr("src",data.fileDir);
				// 更新新的图片url和物理路径(S3上的物理路径)
				$("#picUrl").val(data.fileDir);
				$("#picPath").val(data.fileUrl);
			}else{
				parent.alertMsg.error(data.error);
			}
		},error: function (data, status, e){
            parent.alertMsg.error("系统错误，请联系管理员");
        }
	});
}