/**
 * 把当前的金额(元)转换成分放入对应的隐藏表单域,页面金额显示单位为元,入库时为分
 * @param obj 
 * @param hidId 对应的隐藏表单域id
*/
function changeHidMoney(obj,hidId){
	var money = $(obj).val();
	if(validateMoney(money)){ // 符合金额条件的:两位小数
		$("#"+hidId).val(accMul(money,100));
	}else{ // 不符合条件的话清空,让后台去验证
		$("#"+hidId).val("");
	}
}

function validateMoney(money){
	var reg = /^(-){0,1}\d+(\.\d{1,2}){0,1}$/;// 保留两位小数，可以输入负数
	var example = "-100.20或8.88或100";
	if ($.trim(money)=="") {
		parent.alertMsg.error("请填写充值金额！");
		return false;
	}
	if(isNaN(money)){
		parent.alertMsg.error("请填写正确的充值金额");
		return false;
	}
	if (!reg.test(money)) {
		parent.alertMsg.error("充值金额格式不正确，例如："+example);
		return false;
	}else if (money > 20000000 ){
		parent.alertMsg.error("充值金额不能超过2千万");
		return false;
	}else if (money < -20000000 ){
		parent.alertMsg.error("红冲时充值金额不能小于-2千万");
		return false;
	}
	return true;
}