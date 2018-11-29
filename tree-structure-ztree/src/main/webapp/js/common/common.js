/*function initLoading() {
	var loading = $(
			'<div id="loading" class="loading"></div><img id="loading_img" alt="loading" src="/images/viewLoading.gif" />')
			.appendTo(document.body).hide();

	$(window).ajaxStart(function() {
		loading.show();
	}).ajaxStop(function() {
		loading.hide();
	});
}*/

var doAjax_params_default = {
	'url' : null,
	'requestType' : "POST",
	'async' : true,
	//'contentType' : 'application/x-www-form-urlencoded; charset=UTF-8',
	'contentType' : 'application/json; charset=UTF-8',
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
	var async = doAjax_params['async'];
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
		async : async,
		contentType : contentType,
		dataType : dataType,
		data : data,
		beforeSend : function(jqXHR, settings) {
			if (typeof beforeSendCallbackFunction === "function") {
				beforeSendCallbackFunction();
			}
		},
		success : function(data, textStatus, jqXHR) {
			if (typeof successCallbackFunction === "function") {
				
				var errorValidMsg = "";
				if(data.errors.length > 0) {
					errorValidMsg += "error Message : " + data.errors[0].defaultMessage;
					errorValidMsg += "\n\nerror Object : ";
					for ( var i in data.errors[0].codes) {
						errorValidMsg += "\n" + data.errors[0].codes[i];
					}
				}
				data.errorValidMsg = errorValidMsg;
				
				successCallbackFunction(data);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			if (typeof errorCallBackFunction === "function") {
				errorCallBackFunction(jqXHR);
			} else {
				alert("ajax error!\n" + jqXHR);
			}

		},
		complete : function(jqXHR, textStatus) {
			if (typeof completeCallbackFunction === "function") {
				completeCallbackFunction();
			}
		}
	});
}