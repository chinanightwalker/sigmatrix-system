/**
 * 获得项目名称
 * @returns {String}
 */
function getProjectName(){
	return "sigmatrix-system-admin";
}

/**
 * 获取域名
 * @returns {String}
 */
function getUri() {
	var domainUrl = location.protocol + "//" + location.host + "/";
	//alert(domainUrl);
	if(domainUrl.indexOf("http://localhost")>-1){ // 本地环境
		domainUrl = domainUrl + getProjectName() + "/";
	}
	return domainUrl;
}

function getUrl() {
	var domainUrl = location.protocol + "//" + location.host + "/";
	//alert(domainUrl);
	if(domainUrl.indexOf("http://localhost")>-1){ // 本地环境
		domainUrl = domainUrl + getProjectName() + "/";
	}
	return domainUrl;
}

