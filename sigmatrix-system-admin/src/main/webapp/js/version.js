//新增方法
    	function create(obj){
    		if(obj==1){
    			createText();
    		}else if(obj==2){
    			createPic();
    		}
    	}
    	//新增文本
	function createText(){
		if(getaAllTextTotal()>=5){
			alert("只允许拥有5个版本模板！");
			return;
		}else{
			/* $("#versionDivIdNew"+total).show();
			total++; */			
			if($("#versionDivIdNew"+(getShowVersionDivIdNew()+1)).length>0){
			$("#versionDivIdNew"+(getShowVersionDivIdNew()+1)).show();
			textCount = textCount+1;
			}
		}		
	}
	
	//获得所有的文本个数
	function getaAllTextTotal(){
		return getOldVersionDivNumber()+getShowVersionDivIdNew();
	}
	
    //获取可见新增文本数   
    function getShowVersionDivIdNew(){
    	var showNumber = 0;
    	var allCount  = getAllversionDivIdNewCount();
    	for(var i=0;i<allCount;i++){
    		if($("#versionDivIdNew"+(i+1)).is(":visible")){
    			showNumber=showNumber+1;
    		}
    	}
    	return showNumber;
    }
    
    //获取所有新增文本数
    function getAllversionDivIdNewCount(){
    	return $("#versionDivAllNew").children().length;
    }
    
    
    //获得原来的文本个数
	function getOldVersionDivNumber(){
		return $("#versionDivAllOld").children().length;
	}
    
    //删除文本版本
    function deleteVersion(obj){   	
        var arrValue = $(obj).attr("id");  	
    	var xh =  arrValue.replaceAll("[a-zA-Z]", "");    	
    	//var xh = type.id.charAt(type.id.length - 1);//获得新增版本当前的序号
		var xsgs = getShowVersionDivIdNew();//获得当前新增版本的显示个数
		if(arrValue.replaceAll("[^a-z^A-Z]", "").substring(13,16)=="New"){
			//循环赋值
			for(var i=xh;i<=xsgs;i++){
				setVersionInfo(i,parseInt(i)+1,xsgs);//当前要删除的序号、下个要显示的序号、当前显示的个数
			}
		}else if(arrValue.replaceAll("[^a-z^A-Z]", "").substring(13,16)=="Old"){
			var gs = getOldVersionDivNumber();//原来的版本个数
			$("#versionDivIdOld"+(xh)).remove();//删除当前原来版本
			var xh = parseInt(xh)+1;
			for(var i=xh;i<=gs;i++){//从当前下一个原来版本开始循环，更新剩余原来版本的id
				$("#versionDivIdOld"+i).attr("id","versionDivIdOld"+(i-1));
				$("#versionIdOld"+i).attr("id","versionIdOld"+(i-1));
				$("#versionNameOld"+i).attr("id","versionNameOld"+(i-1));
				$("#versionContentOld"+i).attr("id","versionContentOld"+(i-1));
				$("#versionDeleteOld"+i).attr("id","versionDeleteOld"+(i-1));
			}
		}
    }
    
    
    
    //删除（隐藏）新增文本
	function setVersionInfo(xh,nextXh,xsgs){//当前要删除的序号、下一个要显示的序号、当前显示的个数		
		if(nextXh<=xsgs){//判断当前序号的下一个序号小于等于显示的个数的话，将下一个序号的值赋值给当前序号
			$("#versionIdNew"+xh).val($("#versionIdNew"+nextXh).val());
			$("#versionNameNew"+xh).val($("#versionNameNew"+nextXh).val());
			$("#versionContentNew"+xh).val($("#versionContentNew"+nextXh).val());
		}else{//如果下一个序号大于显示个数，将当前序号的值赋值为空
			$("#versionIdNew"+xh).val("0");
			$("#versionNameNew"+xh).val("");
			$("#versionContentNew"+xh).val("");
		}
		//最终将最后的显示新增版本删除（隐藏）
		$("#versionDivIdNew"+xsgs).hide();
		if(textCount!=0){
			textCount = textCount-1;
		}
	}
    
    function demo(){    	
    	var error = 0;
		var infoT = '[';
		var infoC = '';
		var infoW = ']';
		var info = '';
		for(var i=1;i<=getOldVersionDivNumber();i++){
			var $id = $.trim($("#versionIdOld"+i).val());//主键序号
			var $name = $.trim($("#versionNameOld"+i).val());//版本名称
			var $con = $("#versionContentOld"+i).val().replace(/"/g,"'");//版本内容（富文本内容）
			var $iss = 0;
			if($("#isStartOld"+i).attr("checked")){
				$iss = 1;
			}
			/*if($name==""){
				error = 1;
			}*/
			infoC = infoC + '{"id": ' + $id + ',"name": "' + $name + '","con": "' + $con + '","iss": ' + $iss + '},';				
		}
		/* for(var i=1;i<=getShowVersionDivIdNew();i++){ */
		for(var i=1;i<=textCount;i++){
			var $id = $.trim($("#versionIdNew"+i).val());//主键序号
			var $name = $.trim($("#versionNameNew"+i).val());//版本名称
			var $con = $("#versionContentNew"+i).val().replace(/"/g,"'");//版本内容（富文本内容）
			var $iss = 0;
			if($("#isStartNew"+i).attr("checked")){
				$iss = 1;
			}
			/*if($name==""){
				error = 1;
			}*/
			infoC = infoC + '{"id": ' + $id + ',"name": "' + $name + '","con": "' + $con + '","iss": ' + $iss + '},';				
		}
		/*if(error==1){
			alert("请输入名称");
			return;
		}*/
		info = infoT+infoC.substring(0,(infoC.length-1))+infoW;
		
		
		var errorPic = 0;
		var infoTPic = '[';
		var infoCPic = '';
		var infoWPic = ']';
		var infoPic = '';
		//旧的图片信息
		for(var j=1;j<=getOldPicVersionDivNumber();j++){
			var $idPic = $.trim($("#versionPicIdOld"+j).val());//主键序号
			var $namePic = $.trim($("#versionPicNameOld"+j).val().replace(/[ ]/g,""));//名称
			var $urlPic = $("#versionPicImgOld"+j).attr("src");//图片url
			var $issPic = 0;
			if($("#isPicStartOld"+j).attr("checked")){
				$issPic = 1;
			}
			/*if($namePic==""){
				errorPic = 1;
			}*/
			infoCPic = infoCPic + '{"id": ' + $idPic + ',"name": "' + $namePic + '","url": "' + $urlPic + '","iss": ' + $issPic + '},';							
		}
		//新的图片信息
		/* for(var j=1;j<=getShowPicVersionDivIdNew();j++){ */
		for(var j=1;j<=picCount;j++){
			var $idPic = $.trim($("#versionPicIdNew"+j).val());//主键序号
			var $namePic = $.trim($("#versionPicNameNew"+j).val().replace(/[ ]/g,""));//名称
			var $urlPic = $("#versionPicImgNew"+j).attr("src");//图片url
			var $issPic = 0;
			if($("#isPicStartNew"+j).attr("checked")){
				$issPic = 1;
			}
			/*if($namePic==""){
				errorPic = 1;
			}*/
			infoCPic = infoCPic + '{"id": ' + $idPic + ',"name": "' + $namePic + '","url": "' + $urlPic + '","iss": ' + $issPic + '},';							
		}
		/*if(errorPic==1){
			alert("请输入名称！");
			return;
		}*/
		infoPic = infoTPic+infoCPic.substring(0,(infoCPic.length-1))+infoWPic;
		$("#imgInfo").val(infoPic);	
		
		//alert("info=="+info);
		//alert("infoPic=="+infoPic);
		$("#textInfo").val(info);
		$("#imgInfo").val(infoPic);
		$("#productCheckInfoForm").submit();
		return;
    }
    
    
    
    
  //新建图片版本
	function createPic(){
		if(getaAllPicTotal()>=5){
			alert("只允许拥有5个版本模板！");
			return;
		}else{		
			if($("#versionPicDivIdNew"+(getShowPicVersionDivIdNew()+1)).length>0){
				$("#versionPicDivIdNew"+(getShowPicVersionDivIdNew()+1)).show();
				picCount = picCount + 1;
			}
		}	
	}
	
	//获得所有的图片个数
	function getaAllPicTotal(){
		return getOldPicVersionDivNumber()+getShowPicVersionDivIdNew();
	}
	
	//获得原来的图片个数
	function getOldPicVersionDivNumber(){
		return $("#versionPicDivAllOld").children().length;
	}
	
	//获取可见新增图片数   
	function getShowPicVersionDivIdNew(){
		var showNumber = 0;
		var allCount  = getAllPicversionDivIdNewCount();
		for(var i=0;i<allCount;i++){
			if($("#versionPicDivIdNew"+(i+1)).is(":visible")){
				showNumber=showNumber+1;
			}
		}
		return showNumber;
	}

	 //获取所有新增图片数
	function getAllPicversionDivIdNewCount(){
		return $("#versionPicDivAllNew").children().length;
	 	}
	 	
	 	//图片上传
function imgUpload(fiPre){
	//var dom = document.getElementById(fiPre.id);  
	  var fileSize = fiPre.files[0].size;//文件的大小，单位为字节B
	  if(fileSize>1024000){
		  alert("上传图片大小不允许超过1M！");
		  return;
	  }

	var versionHrefImg = $(fiPre).parent().children().eq(1);
	var versionImg = $(fiPre).parent().children().eq(1).children().eq(0);
	//将所有元素为file的ID与NAME都改为fileIdTem
    $(":file").attr({id:"fileIdTem"});
	$(":file").attr({name:"fileNameTem"}); 		
	//将当前的file控件的id与name改为file
	$(fiPre).attr({id:"file"});
	$(fiPre).attr({name:"file"});
	$.ajaxFileUpload({
		url:'uploadImg.html',//用于文件上传的服务器端请求地址
        secureuri:false,//一般设置为false
        fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
        dataType: 'json',//返回值类型 一般设置为json
        success: function (data, status){  //服务器成功响应处理函数
        	 if(null==data.error && !'null'!=data.error){
        		versionHrefImg.attr("href",data.fileUrl);
        		versionImg.css("display","block").attr("src",data.fileUrl);
        	 }else{
        		 alert(data.error);
        	 }
        },
        error: function (data, status, e){//服务器响应失败处理函数
        	alert(data.error);
        }
    });
}
//修改过上传按钮样式的图片上传
function imgUploadNew(fiPre){		
	// alert($(fiPre).val());
	var fileSize = fiPre.files[0].size;//文件的大小，单位为字节B
	if(fileSize>1024000){
		 alert("上传图片大小不允许超过1M！");
		 return;
	 }
	var versionHrefImg = $(fiPre).parent().parent().parent().children().eq(1);
	var versionImg = $(fiPre).parent().parent().parent().children().eq(1).children().eq(0);
	var fileName = $(fiPre).parent().parent().children().eq(1);
	//将所有元素为file的ID与NAME都改为fileIdTem
    $(":file").attr({id:"fileIdTem"});
	$(":file").attr({name:"fileNameTem"}); 		
	//将当前的file控件的id与name改为file
	$(fiPre).attr({id:"file"});
	$(fiPre).attr({name:"file"});
	$.ajaxFileUpload({
		url:'uploadImg.html',//用于文件上传的服务器端请求地址
        secureuri:false,//一般设置为false
        fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
        dataType: 'json',//返回值类型 一般设置为json
        success: function (data, status){  //服务器成功响应处理数
        	 if(null==data.error && !'null'!=data.error){
        		versionHrefImg.attr("href",data.fileUrl);
        		versionImg.css("display","block").attr("src",data.fileUrl);
        	 }else{
        		 alert(data.error);
        	 }
        	 var upFileName = $(fiPre).val();
        	 if(upFileName.lastIndexOf('\\')>0)
        	{
        		 upFileName = upFileName.substring(upFileName.lastIndexOf('\\')+1,upFileName.length);
        	}
        	 var upShowFileName;
        	 if(upFileName.length >25)
        	{
        	//	 upShowFileName = upFileName.substring(0,12)+'...' +upFileName.substring(upFileName.length-12,upFileName.length);
        		 upShowFileName = upFileName.substring(0,20)+'... ...';
        	}else{
        		upShowFileName = upFileName;
        	}
        	 $(fileName).html(upShowFileName);
        },
        error: function (data, status, e){//服务器响应失败处理函数
        	alert(data.error);
        }
    });
	
}

 //删除图片
function deletePicVersion(obj){   	
    var arrValue = $(obj).attr("id");  	
	var xh =  arrValue.replaceAll("[a-zA-Z]", "");    	
	//var xh = type.id.charAt(type.id.length - 1);//获得新增版本当前的序号
	var xsgs =  getShowPicVersionDivIdNew();//获得当前新增版本的显示个数
	if(arrValue.replaceAll("[^a-z^A-Z]", "").substring(16,19)=="New"){
		//循环赋值
		for(var i=xh;i<=xsgs;i++){
			setVersionInfoPic(i,parseInt(i)+1,xsgs);//当前要删除的序号、下个要显示的序号、当前显示的个数
		}
	}else if(arrValue.replaceAll("[^a-z^A-Z]", "").substring(16,19)=="Old"){
		var gs = getOldPicVersionDivNumber();//原来的版本个数
		$("#versionPicDivIdOld"+(xh)).remove();//删除当前原来版本
		var xh = parseInt(xh)+1;
		for(var i=xh;i<=gs;i++){//从当前下一个原来版本开始循环，更新剩余原来版本的id
			$("#versionPicDivIdOld"+i).attr("id","versionPicDivIdOld"+(i-1));
			$("#versionPicIdOld"+i).attr("id","versionPicIdOld"+(i-1));												   
			$("#versionPicNameOld"+i).attr("id","versionPicNameOld"+(i-1));												
			$("#versionPicFileOld"+i).attr("id","versionPicFileOld"+(i-1));
			$("#versionPicImgHrefOld"+i).attr("id","versionPicImgHrefOld"+(i-1));
			$("#versionPicImgOld"+i).attr("id","versionPicImgOld"+(i-1));
			$("#isPicStartOld"+i).attr("id","isPicStartOld"+(i-1));
			$("#versionPicDeleteOld"+i).attr("id","versionPicDeleteOld"+(i-1));
		}
	}
}

//删除（隐藏）新增图片
function setVersionInfoPic(xh,nextXh,xsgs){//当前要删除的序号、下一个要显示的序号、当前显示的个数
	if(nextXh<=xsgs){//判断当前序号的下一个序号小于等于显示的个数的话，将下一个序号的值赋值给当前序号
		$("#versionPicIdNew"+xh).val($("#versionPicIdNew"+nextXh).val());
		$("#versionPicNameNew"+xh).val($("#versionPicNameNew"+nextXh).val());
		/* $("#ccicBarcodeNew"+xh).val($("#ccicBarcodeNew"+nextXh).val());
		$("#versionContentNew"+xh).val($("#versionContentNew"+nextXh).val()); */
		$("#versionPicImgHrefNew"+xh).attr("href",$("#versionPicImgHrefNew"+nextXh).attr("href"));
		$("#versionPicImgNew"+xh).attr("src",$("#versionPicImgNew"+nextXh).attr("src"));
		$("#versionPicImgNew"+xh).css("display",$("#versionPicImgNew"+nextXh).css("display"));
		if($("#isPicStartNew"+nextXh).attr("checked")){
			$("#isPicStartNew"+xh).prop("checked",true);
		}else{
			$("#isPicStartNew"+xh).prop("checked",false);
		}
	}else{//如果下一个序号大于显示个数，将当前序号的值赋值为空
		$("#versionPicIdNew"+xh).val("0");
		$("#versionPicNameNew"+xh).val("");
		/* $("#versionPicFileNew"+xh).val(""); */
		/* $("#versionContentNew"+xh).val(""); */
		$("#versionPicImgHrefNew"+xh).attr("href","");
		$("#versionPicImgNew"+xh).attr("src","");
		$("#versionPicImgNew"+xh).css("display","none");
		$("#isPicStartNew"+xh).prop("checked",true);
	}
	//最终将最后的显示新增版本删除（隐藏）
	$("#versionPicDivIdNew"+xsgs).hide();
	if(picCount!=0){
		picCount = picCount-1;
	}
	
	
	/* $("#imgVcodeNew"+xh).css("display","none").attr("src",""); */
}