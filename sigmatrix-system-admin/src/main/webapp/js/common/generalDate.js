/*
 * 通用的JS日期处理
 */
/**
 * 格式化日期 formatDate(number) number为数字时反回当前系统日期+number天，如果为负数则减number天，如果为0则返回今天
 * formatDate(string) string格式为2010-2-2或2010-02-05，反回string参数的下一天
 */
function formatDate(n, z) {
	if (typeof (z) == "undefined") {
		z = 1;
	}
	if (typeof (n) == "number") {
		var uom = new Date();
		uom.setDate(uom.getDate() + n);
		var y = uom.getFullYear();
		var m = (uom.getMonth() + 1);
		var d = uom.getDate();
		m = m > 9 ? m : '0' + m;
		d = d > 9 ? d : '0' + d;
		uom = y + "-" + m + "-" + d;
	}
	if (typeof (n) == "string") {
		var chs = new Array();
		chs = n.split("-");
		var years = new Date(chs[0], chs[1] - 1, chs[2]);
		var strTimes = new Date(years - 0 + z * 86400000);
		var y = strTimes.getFullYear();
		var m = (strTimes.getMonth() + 1);
		var d = strTimes.getDate();
		m = m > 9 ? m : '0' + m;
		d = d > 9 ? d : '0' + d;
		uom = y + "-" + m + "-" + d;
	}
	return uom;
}