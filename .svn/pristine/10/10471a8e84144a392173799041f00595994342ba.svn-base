var doc = document;
	//文本框光标定位
	function moveEnd(obj) {
		obj.focus();
		var len = obj.value.length;
		if (document.selection) {
			var sel = obj.createTextRange();
			sel.moveStart('character', len);
			sel.collapse();
			sel.select();
		} else if (typeof obj.selectionStart == 'number'
				&& typeof obj.selectionEnd == 'number') {
			obj.selectionStart = obj.selectionEnd = len;
		}
	}
		
	function sAlert(str){
		var msgw,msgh,bordercolor;
		msgw=400;//提示窗口的宽度
		msgh=100;//提示窗口的高度
		titleheight=25 //提示窗口标题高度
		bordercolor="#165895";//提示窗口的边框颜色#336699
		titlecolor="#99CCFF";//提示窗口的标题颜色
		var sWidth,sHeight;
		sWidth=document.body.offsetWidth;//浏览器工作区域内页面宽度
		sHeight=screen.height-77;//屏幕高度（垂直分辨率）
		//背景层（大小与窗口有效区域相同，即当弹出对话框时，背景显示为放射状透明灰色）
		var bgObj=document.createElement("div");//创建一个div对象（背景层）
		//定义div属性，即相当于
		//<div id="bgDiv" style="position:absolute; top:0; background-color:#777; filter:progid:DXImagesTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75); opacity:0.6; left:0; width:918px; height:768px; z-index:10000;"></div>
		bgObj.setAttribute('id','bgDiv');
		bgObj.style.position="absolute";
		bgObj.style.top="0";
		bgObj.style.background="#777";
		bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
		bgObj.style.opacity="0.6";
		bgObj.style.left="0";
		bgObj.style.width="100%";
		bgObj.style.height="100%";
		bgObj.style.zIndex = "10000";
		document.body.appendChild(bgObj);//在body内添加该div对象
		var msgObj=document.createElement("div")//创建一个div对象（提示框层）
		//定义div属性，即相当于
		//<div id="msgDiv" align="center" style="background-color:white; border:1px solid #336699; position:absolute; left:50%; top:50%; font:12px/1.6em Verdana,Geneva,Arial,Helvetica,sans-serif; margin-left:-225px; margin-top:npx; width:400px; height:100px; text-align:center; line-height:25px; z-index:100001;"></div>
		msgObj.setAttribute("id","msgDiv");
		msgObj.setAttribute("align","center");
		msgObj.style.background="white";
		msgObj.style.border="1px solid " + bordercolor;
		msgObj.style.position = "absolute";
		msgObj.style.left = "50%";
		msgObj.style.top = "50%";
		msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
		msgObj.style.marginLeft = "-225px" ;
		msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
		msgObj.style.width = msgw + "px";
		msgObj.style.height =msgh + "px";
		msgObj.style.textAlign = "center";
		msgObj.style.lineHeight ="25px";
		msgObj.style.zIndex = "10001";
		var title=document.createElement("h4");//创建一个h4对象（提示框标题栏）
		//定义h4的属性，即相当于
		//<h4 id="msgTitle" align="right" style="margin:0; padding:3px; background-color:#336699; filter:progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100); opacity:0.75; border:1px solid #336699; height:18px; font:12px Verdana,Geneva,Arial,Helvetica,sans-serif; color:white; cursor:pointer;" onclick="">关闭</h4>
		title.setAttribute("id","msgTitle");
		title.setAttribute("align","right");
		title.style.margin="0";
		title.style.padding="3px";
		title.style.background=bordercolor;
		title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100,finishY=100,style=1,opacity=75,finishOpacity=100);";
		title.style.opacity="0.75";
		title.style.border="1px solid rgb(184,208,214)";
		title.style.height="18px";
		title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
		title.style.cursor="pointer";
		title.innerHTML="关闭";
		title.onclick=removeObj;
		
		function removeObj(){//点击标题栏触发的事件
			document.body.removeChild(bgObj);//删除背景层Div
			document.getElementById("msgDiv").removeChild(title);//删除提示框的标题栏
			document.body.removeChild(msgObj);//删除提示框层
		}
		document.body.appendChild(msgObj);//在body内添加提示框div对象msgObj
		document.getElementById("msgDiv").appendChild(title);//在提示框div中添加标题栏对象title
		var txt=document.createElement("p");//创建一个p对象（提示框提示信息）
		//定义p的属性，即相当于
		//<p style="margin:1em 0;" id="msgTxt">烈火网-网页特效效果</p>
		txt.style.margin="1em 0";
		txt.style.fontSize="14px";
		txt.setAttribute("id","msgTxt");
		txt.innerHTML=str;//来源于函数调用时的参数值
		document.getElementById("msgDiv").appendChild(txt);//在提示框div中添加提示信息对象txt
	}
	
	function removeObj(){//点击标题栏触发的事件
		$("#bgDiv").remove();
		$("#msgDiv").remove();
		$("#msgTitle").remove();
		$("#msgTxt").remove();
	}

    function loginMsg( msgNum){
      removeObj();
      switch( msgNum ){
        case "1":
          sAlert("登录失败：验证码错误！");
          break;
        case "2":
          sAlert("登录失败：非企业用户！");
          break;
        case "3":
            sAlert("登录失败：账号无效！");
            break;
        case "4":
        	  sAlert("登录失败：账号被冻结，请联系企业管理员！");
        	  break;
        case "5":
        	  sAlert("登录失败：密码错误！");
        	  break;
        default:
          break;
      }
    }
      
   
     
    function check(){
		var result = true;
		var errorMsg = "";
		removeObj();
		if($("#loginName").val()==""){
			errorMsg = "登录失败：请填写登录账户！";
			result = false;
		}
		else if($("#password").val()==""){
			errorMsg = "登录失败：请填写登录密码！";
			result = false;
		}
		else if($("#validCode").val()=="" || $("#validCode").val()=="验证码"){
			errorMsg = "登录失败：请填写验证码！";
			result = false;
		}
		if(!result){
			sAlert(errorMsg);
		}
		return result;
	} 
	
     function Submit(){
		if(check()){
	   	  	$("#LoginForm").submit();
	   	}
     }
       
       $(document).keydown(function(e){
		var e = e || event,
		keycode = e.which || e.keyCode;
	    if (keycode == 37) {
	        return false;
	    }
	    if (keycode == 38) {
	        return false;
	    }
	    if (keycode == 39) {
	        return false;
	    }
	});
	function change(num){
        $("#"+num).find("img").attr("src","<%=request.getContextPath() %>/images-login/login-pic-"+num+".png");
	}
	function back(num){
	    $("#"+num).find("img").attr("src","<%=request.getContextPath() %>/images-login/login-pic-"+num+"X.png");
	}
	function  detectCapsLock(event){
          var e = event||window.event;
          var o = e.target||e.srcElement;
          var oTip = o.nextSibling;
          var keyCode  =  e.keyCode||e.which; // 按键的keyCode 
          var isShift  =  e.shiftKey ||(keyCode  ==   16 ) || false ; // shift键是否按住
          if (
                 ((keyCode >=   65   &&  keyCode  <=   90 )  &&   !isShift) // Caps Lock 打开，且没有按住shift键 
                 || ((keyCode >=   97   &&  keyCode  <=   122 )  &&  isShift)// Caps Lock 打开，且按住shift键
                 )
               {
                    $("#capsLock").show();
               }
          else{
                    $("#capsLock").hide();
          } 
      }
      
      function loginBug(){
      		var loginName = document.getElementsByName("loginName")[0].value;
      		var LoginForm = document.getElementsByName("LoginForm")[0];
      		removeObj();
			for(i=0;i<loginName.length;i++){
				if(loginName.charCodeAt(i)==39){
					sAlert("用户名或密码错误");
					return false;
				}
			}
			return Validator.Validate(LoginForm,2);
      }