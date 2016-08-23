
/**
 * 事件封装（跨浏览器解决方案）
 * @param {Object} element: node节点
 * @param {Object} type	: 事件名称，如'click'、'blur'
 * @param {Object} handler : 将执行的方法
 */
var EventUtil = {
	//添加事件
	addHanler :　function(element,type,handler){
		if(element.addEventListener){
			element.addEventListener(type,handler,false);
		}else if(element.attachEvent){
			element.attachEvent("on"+type,handler);
		}else{
			element["on"+type] = handler;
		}
	},
	//移除事件
	removeHandler : function(element,type,handler){
		if(element.removeEventListener){
			element.removeEventListener(type,handler,false);
		}else if(element.detachEvent){
			element.attachEvent("on"+type,handler);
		}else{
			element["on"+type] = null;
		}
	},
	//获取事件对象
	getEvent : function(event){
		return event ? event : window.event;
	},
	//获取事件目标
	getTarget : function(event){
		return event.target || event.srcElement;
	},
	//阻止默认事件
	preventDefault : function(event){
		if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
	},
	//阻止冒泡
	stopPropagation : function(event){
		if(event.stopPropagation){
			event.stopPropagation();
		}else{
			event.cancelBubble = true;
		}
	}
}