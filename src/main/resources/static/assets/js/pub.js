document.write("<script src='/static/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
document.write('<script src="/static/assets/js/bootstrap.min.js"></script>');
document.write('<script src="/static/assets/js/bootbox.min.js"></script>');

/**
 * resultData:返回数据
 * flag : 标识
 * 		1:成功失败都alert
 * 		2:只alert失败
 * */
function alertReturnMsg(resultData,flag){
	if(resultData.status == 200){//成功
		if(flag == 1){
			bootbox.alert( resultData.msg);
		}
	} else if(typeof(resultData.status) != 'undefined'){//失败
//		bootbox.alert( resultData.msg);
		bootbox.alert( resultData.msg);
	}
}