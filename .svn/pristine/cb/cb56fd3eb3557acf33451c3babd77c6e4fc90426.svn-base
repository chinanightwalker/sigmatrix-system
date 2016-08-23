
function createInput(parentId){  
    var str = '<dl><dd style="width:60px;padding-left:5px;">邮箱名：</dd>' 
    	+ '<dt style="width:280px;"><input class="required email" type="text" '+
    ' name="sysMail.targetMails" style="width: 220px"/><input type="button" value="删除" onclick="removeInput(event,\''+parentId+'\')" /></dt>'+'</dl>';  
    document.getElementById(parentId).insertAdjacentHTML("beforeEnd",str);  
}  

function removeInput(evt, parentId){  
   var el = evt.target == null ? evt.srcElement : evt.target;  
   var div = el.parentNode.parentNode;  
   var cont = document.getElementById(parentId);         
   if(cont.removeChild(div) == null){  
    return false;  
   }  
   return true;  
}