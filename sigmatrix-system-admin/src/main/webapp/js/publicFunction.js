function selAll(obj, tObj) {

	try {
		len = tObj.length;

		for (i = 0; i < len; i++) {
			if (obj.checked) {
				tObj[i].checked = true;
			} else {
				tObj[i].checked = false;
			}
		}
	} catch (ee) {
	} finally {
		if (obj.checked) {
			tObj.checked = true;
		} else {
			tObj.checked = false;
		}
	}
}

function openWindow(URL, w, h) {
	window.open(URL, "win", "width=" + w + ",height=" + h);
}

//字符串去空格
function trim(str){
	while(str.indexOf(" ")>=0){
		str = str.replace(" ","");
	}
	return str;
}

//字符串最大长度验证
function checkStrOverMax(str,len,msg){
	if(str.length>len){
		alert(msg);
		return true;
	}
	return false;
}

//字符串最小长度验证
function checkStrOverMin(str,len,msg){
	if(str.length<len){
		alert(msg);
		return true;
	}
	return false;
}

//字符串非空验证
function checkStrIsNull(str,msg){
	if(trim(str).length==0){
		alert(msg);
		return true;
	}
	return false;
}

//字符串必须全都为数字验证（正数）
function checkNotNumCode(str,msg){
	for(i=0;i<str.length;i++){
		codeNum = str.charCodeAt(i);
		if (codeNum < 48 || codeNum > 57){
			alert(msg);
			return true;
		}
	}
	return false;
}

//字符串必须全都为数字验证（可以为负数）
function checkNotNumBarcode(str,msg){
	for(i=0;i<str.length;i++){
		codeNum = str.charCodeAt(i);
		if(i==0){
			if ((codeNum < 48&&codeNum!=45) || codeNum > 57){
				alert(msg);
				return true;
			}	
		}
		if(i>0){
			if (codeNum < 48 || codeNum > 57){
				alert(msg);
				return true;
			}
		}
	}
	return false;
}

//字符串开头和结尾不能为空格验证
function nameTrim(str,msg){
	for(i=0;i<str.length;i++){
		codeNum = str.charCodeAt(i);
		if(codeNum != 32){
			break;
		}else{
			alert(msg);
			//str.replace(str.charAt(i),"");
			return true;
		}
	}
	var arr=[];
	str1 = "";
	for(i=0;i<str.length;i++){
		arr[i] = str.charAt(i);
		str1 = arr[i]+str1;
	}
	for(i=0;i<str1.length;i++){
		codeNum = str1.charCodeAt(i);
		if(codeNum != 32){
			break;
		}else{
			//str.replace(str1.charAt(i),"");
			alert(msg);
			return true;
		}
	}
	return false;
}


//字符串必须为字母或数字或者英文标点符号验证
function checkNotAndLitter(str,msg){
	for(i=0;i<str.length;i++){
		codeNum = str.charCodeAt(i);
		if (codeNum > 47 && codeNum < 58 ||codeNum > 64 &&codeNum < 91 || codeNum > 96 && codeNum < 123){

		}else{
			var reg = /^[\u4E00-\u9FA5]+$/; 
			if(!reg.test(str)){ 
				alert(msg);
				return true;
			} 

		}
	}
	return false;
}

//400电话验证
function phone400(str){
	if(str.indexOf("400")==0){
		if(str.length==10){
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}

//把时间转换成数字（以方便比较）
function numTime(str){
	var num = "";
	for(i=0;i<str.length;i++){
		codeNum = str.charCodeAt(i);
		if (codeNum > 47 && codeNum < 58){
			num = num+str.charAt(i);
		}
	}
	return num;
}


//隔行变色
function pageColor(){
	var listTable = document.getElementsByTagName("table");
	for(i=0;i<listTable.length;i++){
		if(listTable[i].className=="TableList"){
			var needTable = listTable[i];
			break;
		}
	}
	var listTbody = needTable.getElementsByTagName("tbody")[0];
	var listTR = listTbody.getElementsByTagName("tr");
	for(j=0;j<listTR.length;j++){
		if(j%2==0){
			listTR[j].style.backgroundColor="#E3EFF3";
		}else{
			listTR[j].style.backgroundColor="#FFFFFF";
		}
		var oldcolor;
		listTR[j].onmouseover=function() {
			oldcolor=this.style.backgroundColor;
			this.style.backgroundColor="#F7E7D0";
		}
		listTR[j].onmouseout=function(j) {
			this.style.backgroundColor=oldcolor;
		}
	}
}