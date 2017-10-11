var doAjax_params_default = {
	'url' : null,
	'requestType' : "POST",
	//'contentType' : 'application/x-www-form-urlencoded; charset=UTF-8',
	//'contentType' : 'application/json; charset=UTF-8',
	'dataType' : 'json',
	'data' : {},
	'beforeSendCallbackFunction' : null,
	'successCallbackFunction' : null,
	'completeCallbackFunction' : null,
	'errorCallBackFunction' : null,
};

function doAjax(doAjax_params) {

	var url = doAjax_params['url'];
	var requestType = doAjax_params['requestType'];
	var contentType = doAjax_params['contentType'];
	var dataType = doAjax_params['dataType'];
	var data = doAjax_params['data'];
	var beforeSendCallbackFunction = doAjax_params['beforeSendCallbackFunction'];
	var successCallbackFunction = doAjax_params['successCallbackFunction'];
	var completeCallbackFunction = doAjax_params['completeCallbackFunction'];
	var errorCallBackFunction = doAjax_params['errorCallBackFunction'];

	// make sure that url ends with '/'
	/*
	 * if(!url.endsWith("/")){ url = url + "/"; }
	 */

	$.ajax({
		url : url,
		crossDomain : true,
		type : requestType,
		contentType : contentType,
		dataType : dataType,
		data : data,
		beforeSend : function(jqXHR, settings) {
			if (typeof beforeSendCallbackFunction === "function") {
				beforeSendCallbackFunction();
			}
		},
		success : function(data, textStatus, jqXHR) {
			debugger;
			if (typeof successCallbackFunction === "function") {
				successCallbackFunction(data);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			debugger;
			if (typeof errorCallBackFunction === "function") {
				errorCallBackFunction(errorThrown);
			}

		},
		complete : function(jqXHR, textStatus) {
			debugger;
			if (typeof completeCallbackFunction === "function") {
				completeCallbackFunction();
			}
		}
	});
}