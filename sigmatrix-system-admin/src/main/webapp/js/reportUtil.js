//汇总显示项checkbox选中加载
function checkLoad(ck,checkboxName){
	//console.info("ck:"+ck);
	var checkItem = ck.replace(/\s+/g,"").split(",");
	var checkItems = document.getElementsByName(checkboxName);
	for ( var i = 0; i < checkItem.length; i++) {
		for ( var j = 0; j < checkItems.length; j++) {
		//console.info(checkItem[i]+"  "+checkItems[j].value);
			if (checkItem[i]==checkItems[j].value) {
				checkItems[j].checked = "checked";
			}
		}
	}
}
//合并单元格、数据加载
function doReport(tableId,ck,checkList,colNum){
	var tab = document.getElementById(tableId);
	//展示项数组
	var showList = ck.replace(/\s+/g,"").split(",");
	//console.info(":"+);
	//console.info("showList:"+showList);
	//展示项数组长度
	var showListNum = showList.length;
	//console.info("showListNum:"+showListNum);
	//非展示项数组
	var unShowList = [];
	for ( var i = 0; i < checkList.length; i++) {
		var obj = checkList[i];
		var isExist = false;
		for ( var j = 0; j < showListNum; j++) {
			var obj1 = showList[j];
			if (obj == obj1) {
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			unShowList.push(obj);
		}
	}
	//console.info("unShowList:"+unShowList);
	//表格行数
	var rows = tab.rows.length ;
	//表格列数
	var cells = tab.rows.item(0).cells.length ;
	//删除非展示列表项
	//console.info("unShowList.length:"+unShowList.length);
	if (unShowList.length != 0) {//非展示项不为空
		for(var i=0;i<rows;i++){
			for ( var j = 0; j < unShowList.length; j++) {
				var numVal = unShowList[j]-j-1
				//console.info("numVal:"+numVal);
				tab.rows[i].deleteCell(unShowList[j]-j-1);
			}
		}
	}
	//添加总计行
	addTotalRow(tableId, ck, checkList, colNum);
	//添加小计行
	addSubTotalRow(tableId,ck,checkList,colNum);
    var maxCol = showListNum, val, count, start;
    //console.info("maxCol:"+maxCol);
    for(var col = maxCol-1; col >= 0 ; col--){
        count = 1;
        val = "";
        for(var i=0; i<tab.rows.length; i++){
        	//console.info("count:"+count);
            if(val == tab.rows[i].cells[col].innerHTML){
                count++;
            }else{
                if(count > 1){ //合并
                	//console.info("col:"+col);
	                if (col == maxCol-1) { //计算积分总数和积分次数
						//起始行数
						start = i - count;
						//积分总数
						var sumNum = 0;
						//积分次数
						var sumCount = 0;
						var trClassName = tab.rows[start].className;
						if (trClassName != "subTotal") {//非小计、总计行
							if (col+1 < cells) {
								//计算积分总数并合并
								for ( var k = 0; k < count; k++) {
									var oneNum = tab.rows[start+k].cells[col+1].innerHTML;
									sumNum = sumNum + parseInt(oneNum);
								}
								for(var s=start+1; s<i; s++){
									tab.rows[s].cells[col+1].style.display = "none";
									tab.rows[s].cells[col+1].innerHTML = 0;
								}
								//console.info("sumNum:"+sumNum);
								tab.rows[start].cells[col+1].innerHTML=sumNum;
								tab.rows[start].cells[col+1].rowSpan = count;

							}
							if (colNum == 2 && col+2 < cells) {
								//计算积分次数并合并
								for ( var m = 0; m < count; m++) {
									var oneCount = tab.rows[start+m].cells[col+2].innerHTML;
									sumCount = sumCount + parseInt(oneCount);
								}
								for(var n=start+1; n<i; n++){
									tab.rows[n].cells[col+2].style.display = "none";
									tab.rows[n].cells[col+2].innerHTML = 0;
								}
								//console.info("sumCount:"+sumCount);
								tab.rows[start].cells[col+2].innerHTML=sumCount;
								tab.rows[start].cells[col+2].rowSpan = count;
							}
						}else {
							if (col+1 < cells) {
								for(var s=start+1; s<i; s++){
									tab.rows[s].cells[col+1].style.display = "none";
									tab.rows[s].cells[col+1].innerHTML = 0;
								}
								tab.rows[start].cells[col+1].rowSpan = count;
							}
							if (colNum == 2 && col+2 < cells) {
								for(var n=start+1; n<i; n++){
									tab.rows[n].cells[col+2].style.display = "none";
									tab.rows[n].cells[col+2].innerHTML = 0;
								}
								tab.rows[start].cells[col+2].rowSpan = count;
							}
						}
						
					}
                    start = i - count;
                    tab.rows[start].cells[col].rowSpan = count;
                    for(var j=start+1; j<i; j++){
                        tab.rows[j].cells[col].style.display = "none";
                    }
                    count = 1;
                }
                val = tab.rows[i].cells[col].innerHTML;
            }
        }
        if(count > 1 ){ //合并，最后几行相同的情况下
            start = i - count;
            tab.rows[start].cells[col].rowSpan = count;
            for(var j=start+1; j<i; j++){
                tab.rows[j].cells[col].style.display = "none";
            }
            if (col == maxCol-1) { //计算积分总数和积分次数
				//起始行数
				start = i - count;
				//积分总数
				var sumNum = 0;
				//积分次数
				var sumCount = 0;
				if (col+1 < cells) {
					//计算积分总数并合并
					for ( var k = 0; k < count; k++) {
						var oneNum = tab.rows[start+k].cells[col+1].innerHTML;
						sumNum = sumNum + parseInt(oneNum);
					}
					for(var s=start+1; s<i; s++){
						tab.rows[s].cells[col+1].style.display = "none";
						tab.rows[s].cells[col+1].innerHTML = 0;
					}
					//console.info("sumNum:"+sumNum);
					tab.rows[start].cells[col+1].innerHTML=sumNum;
					tab.rows[start].cells[col+1].rowSpan = count;

				}
				if (colNum == 2 && col+2 < cells) {
					//计算积分次数并合并
					for ( var m = 0; m < count; m++) {
						var oneCount = tab.rows[start+m].cells[col+2].innerHTML;
						sumCount = sumCount + parseInt(oneCount);
					}
					for(var n=start+1; n<i; n++){
						tab.rows[n].cells[col+2].style.display = "none";
						tab.rows[n].cells[col+2].innerHTML = 0;
					}
					//console.info("sumCount:"+sumCount);
					tab.rows[start].cells[col+2].innerHTML=sumCount;
					tab.rows[start].cells[col+2].rowSpan = count;
				}
			}
        }
    }
    //console.info("rows:"+tab.rows.length);
    
}
//展示选择项（不合并）
function showCheck(tableId,ck,checkList){
	var tab = document.getElementById(tableId);
	//展示项数组
	var showList = ck.replace(/\s+/g,"").split(",");
	//console.info(":"+);
	//console.info("showList:"+showList);
	//展示项数组长度
	var showListNum = showList.length;
	//console.info("showListNum:"+showListNum);
	//非展示项数组
	var unShowList = [];
	for ( var i = 0; i < checkList.length; i++) {
		var obj = checkList[i];
		var isExist = false;
		for ( var j = 0; j < showListNum; j++) {
			var obj1 = showList[j];
			if (obj == obj1) {
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			unShowList.push(obj);
		}
	}
	//console.info("unShowList:"+unShowList);
	//表格行数
	var rows = tab.rows.length ;
	//表格列数
	var cells = tab.rows.item(0).cells.length ;
	//删除非展示列表项
	//console.info("unShowList.length:"+unShowList.length);
	if (unShowList.length != 0) {//非展示项不为空
		for(var i=0;i<rows;i++){
			for ( var j = 0; j < unShowList.length; j++) {
				var numVal = unShowList[j]-j-1
				//console.info("numVal:"+numVal);
				tab.rows[i].deleteCell(unShowList[j]-j-1);
			}
		}
	}
}

//添加总计内容
function addTotalRow(tableId,ck,checkList,colNum){
	var tab = document.getElementById(tableId);
	//展示项数组
	var showList = ck.replace(/\s+/g,"").split(",");
	//console.info(":"+);
	//console.info("showList:"+showList);
	//展示项数组长度
	var showListNum = showList.length;
	//console.info("showListNum:"+showListNum);
	//非展示项数组
	var unShowList = [];
	for ( var i = 0; i < checkList.length; i++) {
		var obj = checkList[i];
		var isExist = false;
		for ( var j = 0; j < showListNum; j++) {
			var obj1 = showList[j];
			if (obj == obj1) {
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			unShowList.push(obj);
		}
	}
	//console.info("unShowList:"+unShowList);
	//表格行数
	var rows = tab.rows.length ;
	//表格列数
	var cells = tab.rows.item(0).cells.length ;
	//计算总计
	var maxCol = showListNum, val, count, start;
    //console.info("maxCol:"+maxCol);
    //console.info("rows:"+rows);
    //console.info("cells:"+cells);
    var total = 0;
    var totalNum = 0;
    for(var col = maxCol-1; col >= 0 ; col--){
    	for(var i=0; i<tab.rows.length; i++){
    		//console.info("col:"+col);
    		if (col == maxCol-1 && i+1 < rows) {
    			if (col+1 < cells) {
            		var oneTotal = tab.rows[i+1].cells[col+1].innerHTML;
                	total = total + parseInt(oneTotal);
        		}
            	if (colNum == 2 && col+2 < cells) {
        			var oneTotalNum = tab.rows[i+1].cells[col+2].innerHTML;
        			totalNum = totalNum + parseInt(oneTotalNum);
        		}
            	//console.info("oneTotal:"+oneTotal);
			}
    		continue;
        }
    }
    //console.info("total:"+total);
    //console.info("totalNum:"+totalNum);
    //添加一行
    var newTr = tab.insertRow(-1);
//    newTr.style.backgroundColor = "#DDDDDD";
    newTr.className = "subTotal";
    //添加两列
    if (colNum == 2) {
    	var newTd0 = newTr.insertCell();
	}
    var newTd1 = newTr.insertCell();
    var newTd2 = newTr.insertCell();
    var newTd3 = newTr.insertCell();
    var newTd4 = newTr.insertCell();
    var newTd5 = newTr.insertCell();
    var newTd6 = newTr.insertCell();
    //设置列内容和属性
    newTd6.style.display = "none";
    newTd6.innerHTML = "";
    newTd5.style.display = "none";
    newTd5.innerHTML = "";
    newTd4.style.display = "none";
    newTd4.innerHTML = "";
    newTd3.style.display = "none";
    newTd3.innerHTML = "";
    
    newTd2.colSpan = showListNum;
    newTd2.innerText = "总计";
    newTd2.style.color = "red";
    newTd2.className = "center";
    newTd2.style.textAlign = "left";
    
    newTd1.innerText = total;
    newTd1.style.color = "red";
    newTd1.className = "center";
    if (colNum == 2) {
	    newTd0.innerText = totalNum;
	    newTd0.style.color = "red";
	    newTd0.className = "center";
    }
}

//添加小计行
function addSubTotalRow(tableId,ck,checkList,colNum){
	var tab = document.getElementById(tableId);
	//展示项数组
	var showList = ck.replace(/\s+/g,"").split(",");
	//console.info(":"+);
	//console.info("showList:"+showList);
	//展示项数组长度
	var showListNum = showList.length;
	//console.info("showListNum:"+showListNum);
	//表格行数
	var rows = tab.rows.length ;
	//表格列数
	var cells = tab.rows.item(0).cells.length ;
	//计算小计
	var maxCol = showListNum, val, count, start;
    var total = 0;
    var totalNum = 0;
    var colCount = maxCol-1-1;
    for(var col = colCount; col >= 0 ; col--){
        count = 1;
        val = "";
        for(var i=0; i<rows; i++){
            if(val == tab.rows[i].cells[col].innerHTML){
                count++;
            }else{
                if(count > 1){ 
                	console.info("count:"+count);
                	console.info("i:"+i);
                    start = i - count;
                    //tab.rows[i].cells[col].rowSpan = count;
                    //计算小计的积分总数、次数
                    var subSumNum = 0;
                    var subTotalNum = 0;
                	for ( var q = 0; q < count; q++) {
                		var trClassName = tab.rows[start+q].className;
                		if (trClassName != "subTotal") {
                			var oneSubNum = tab.rows[start+q].cells[cells-colNum].innerHTML;
                			subSumNum = subSumNum + parseInt(oneSubNum);
						}
                	}
                	if (colNum == 2) {
                		for ( var r = 0; r < count; r++) {
                    		var trClassName = tab.rows[start+r].className;
                    		if (trClassName != "subTotal") {
                        		var oneSubTotalNum = tab.rows[start+r].cells[cells-1].innerHTML;
                        		subTotalNum = subTotalNum + parseInt(oneSubTotalNum);
                    		}
                    	}
					}
                    
                    //添加一行
                    var newTr = tab.insertRow(i);
//                    newTr.style.backgroundColor = "#E6E6E6";
                    newTr.className = "subTotal";
                    i++;
                    rows++;
                    console.info("i:"+i);
                    for ( var k = 0; k < cells; k++) {
                        //添加列
                    	var newTd = newTr.insertCell(k);
                    	if (colNum == 2) {
                    		if (k==cells-1) {
                        		newTd.innerHTML = subTotalNum;
                        	    newTd.style.color = "red";
    						}else if (k==cells-2) {
    							newTd.innerHTML = subSumNum;
                        	    newTd.style.color = "red";
    						}else if (k==cells-3) {
    							var text = tab.rows[start].cells[col].innerHTML;
    							newTd.innerHTML = text+" 小计";
    						    newTd.style.color = "red";
    						    newTd.colSpan = maxCol-col;
    						    newTd.style.textAlign = "left";
    						}else {
    							var subTotalText = tab.rows[start].cells[k].innerHTML;
    							newTd.innerHTML = subTotalText;
//    							console.info("subTotalText"+subTotalText);
    						}
						}else {
							if (k==cells-1) {
    							newTd.innerHTML = subSumNum;
                        	    newTd.style.color = "red";
    						}else if (k==cells-2) {
    							var text = tab.rows[start].cells[col].innerHTML;
    							newTd.innerHTML = text+" 小计";
    						    newTd.style.color = "red";
    						    newTd.colSpan = maxCol-col;
    						    newTd.style.textAlign = "left";
    						}else {
    							var subTotalText = tab.rows[start].cells[k].innerHTML;
    							newTd.innerHTML = subTotalText;
//    							console.info("subTotalText"+subTotalText);
    						}
						}
					}
                    //
                	for ( var m = maxCol-col-1-1; m >= 0; m--) {
                		newTr.cells[colCount-m].innerHTML = "";
                		newTr.cells[colCount-m].style.display = "none";
                	}
                    count = 1;
                }else {
                	if (i>1) {
                		start = i - count;
                		console.info("start:"+start);
                    	for ( var p = 0; p < col+1; p++) {
                    		//添加一行
                            var newTr = tab.insertRow(i);
                            i++;
                            rows++;
                            //console.info("i:"+i);
                            newTr.className = "subTotal";
//                            newTr.style.backgroundColor = "#E6E6E6";
                            for ( var k = 0; k < cells; k++) {
                                //添加列
                            	var newTd = newTr.insertCell(k);
                            	if (colNum == 2) {
                            		if (k==cells-1) {
                            			newTd.innerHTML = tab.rows[start].cells[cells-1].innerHTML;
                            			newTd.style.color = "red";
                            		}else if (k==cells-2) {
                            			newTd.innerHTML = tab.rows[start].cells[cells-2].innerHTML;
                            			newTd.style.color = "red";
                            		}else if (k==cells-3) {
                            			var text = tab.rows[start].cells[col].innerHTML;
                            			newTd.innerHTML = text+" 小计";
                            			newTd.style.color = "red";
                            			newTd.colSpan = maxCol-col;
                            			newTd.style.textAlign = "left";
                            		}else {
                            			var subTotalText = tab.rows[start].cells[k].innerHTML;
                            			newTd.innerHTML = subTotalText;
//        							console.info("subTotalText"+subTotalText);
                            		}
                            	}else {
                            		if (k==cells-1) {
                            			newTd.innerHTML = tab.rows[start].cells[cells-1].innerHTML;
                            			newTd.style.color = "red";
                            		}else if (k==cells-2) {
                            			var text = tab.rows[start].cells[col].innerHTML;
                            			newTd.innerHTML = text+" 小计";
                            			newTd.style.color = "red";
                            			newTd.colSpan = maxCol-col;
                            			newTd.style.textAlign = "left";
                            		}else {
                            			var subTotalText = tab.rows[start].cells[k].innerHTML;
                            			newTd.innerHTML = subTotalText;
                            		}
								}
        					}
                            //
                        	for ( var m = maxCol-col-1-1; m >= 0; m--) {
                        		newTr.cells[colCount-m].innerHTML = "";
                        		newTr.cells[colCount-m].style.display = "none";
                        	}
    					}
					}
				}
                val = tab.rows[i].cells[col].innerHTML;
            }
        }
        if(count > 1 ){ //合并，最后几行相同的情况下
            start = i - count;
//            tab.rows[i].cells[col].rowSpan = count;
        }
    }
    /*
	//添加一行
    var newTr = tab.insertRow(15);
    //添加两列
    var newTd0 = newTr.insertCell();
    var newTd1 = newTr.insertCell();
    var newTd2 = newTr.insertCell();
    var newTd3 = newTr.insertCell();
    var newTd4 = newTr.insertCell();
    var newTd5 = newTr.insertCell();
    var text5 = tab.rows[1].cells[0].innerHTML;
    var text4 = tab.rows[1].cells[1].innerHTML;
    var text3 = tab.rows[1].cells[2].innerHTML;
    console.info("text5:"+text5);
    console.info("text4:"+text4);
    console.info("text3:"+text3);
    //设置列内容和属性	
    //newTd5.style.display = "none";
    newTd5.innerHTML = text5;
    //newTd4.style.display = "none";
    newTd4.innerHTML = text4;
    //newTd3.style.display = "none";
    newTd3.innerHTML = text3;
    
    newTd2.innerHTML = "小计";
    newTd2.style.color = "red";
    newTd2.colSpan = 2;
    
    newTd1.innerHTML = "100";
    newTd1.style.color = "red";
    
    newTd0.innerHTML = "50";
    newTd0.style.color = "red";
    
     * */
    
}
function reportAgain(){
	var tab = document.getElementById("tab");
    var maxCol = 5, val, count, start;
    for(var col = maxCol-1; col >= 0 ; col--){
        count = 1;
        val = "";
        for(var i=0; i<tab.rows.length; i++){
            if(val == tab.rows[i].cells[col].innerHTML){
                count++;
            }else{
                if(count > 1){ //合并
                    start = i - count;
                    tab.rows[start].cells[col].rowSpan = count;
                    for(var j=start+1; j<i; j++){
                        tab.rows[j].cells[col].style.display = "none";
                    }
                    count = 1;
                }
                val = tab.rows[i].cells[col].innerHTML;
            }
        }
        if(count > 1 ){ //合并，最后几行相同的情况下
            start = i - count;
            tab.rows[start].cells[col].rowSpan = count;
            for(var j=start+1; j<i; j++){
                tab.rows[j].cells[col].style.display = "none";
            }
        }
    }
	
}