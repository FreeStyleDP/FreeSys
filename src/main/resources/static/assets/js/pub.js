document.write("<link href='../../../static/sweetalert/sweet-alert.css' rel='stylesheet' />");
document.write("<script src='../../../static/sweetalert/sweet-alert.min.js'></script>");

/**
 * resultData:返回数据
 * flag : 标识
 * 		1:成功失败都alert
 * 		2:只alert失败
 * */
function alertReturnMsg(resultData,flag){
	if(resultData.status == 200){//成功
		if(flag == 1){
			sweetAlert("交易成功", resultData.msg,"success");
		}
	} else if(typeof(resultData.status) != 'undefined'){//失败
		sweetAlert("交易失败", resultData.msg,"error");
	}
}