var addCount = 1;
var rMenu;
var zTree;

$(document).ready(function() {
	/*버튼 Event 정의*/
	$("form").submit(function( event ) {
		event.preventDefault();
		var nodes = zTree.getNodes();
		var data = {};
		data.zTrees = nodes;
		var params = $.extend({}, doAjax_params_default);
		params['url'] = "ztrees";
		params['requestType'] = "POST";
		params['data'] = JSON.stringify(data);
		params['successCallbackFunction'] = _zTrees.submitSuccess;
		params['errorCallBackFunction'] = _zTrees.submitError;
		doAjax(params);
	});
	
	$.fn.zTree.init($("#demoZTree"), setting, zNodes);
	zTree = $.fn.zTree.getZTreeObj("demoZTree");
	//우클릭 Event
	rMenu = $("#rMenu");
	//Drag Event
	setCheck();
	
	//초기화 후 첫번째 노드 selected 상태로 변경
	if (zTree.getNodes().length>0) {
		zTree.selectNode(zTree.getNodes()[0]);
		onClick(null, null, zTree.getNodes()[0]);
	}
});

var _zTrees = {
		/**
		 * 메뉴 등록 submit 버튼 success
		 */
		submitSuccess : function(data) {
			//@Valid 검증 결과 error 존재할 경우
			//해당 error Message alert!
			//사용자가 setting한 successCallbackFunction은 미실행
			if(data.errorValidMsg.length > 0) {
				alert(data.errorValidMsg);
			} else {
				location.replace("/menus");
			}
		},
		/**
		 * 메뉴 등록 submit 버튼 error
		 */
		submitError : function(response) {
			const responseJSON = JSON.parse(response.response);
			const errorFields = responseJSON.errors;

			if (!errorFields) {
				alert(responseJSON.message);
				return;
			}
	
			var error, errorMsg = responseJSON.message + "\n";
			for (var i = 0, length = errorFields.length; i < length; i++) {
				error = errorFields[i];
				errorMsg += "\n" + error.field + " : " + error.defaultMessage; 
			}
			
			alert(errorMsg);
		}
}

/* zTree 환경설정 */
var setting = {
	edit : {
		enable : true,
		showRemoveBtn : true,
		showRenameBtn : true
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	view : {
		dblClickExpand : false,
		selectedMulti : false
	},
	callback : {
		onClick : onClick,
		onRightClick : onRightClick,
		onRename : onRename,
		beforeDrag : beforeDrag,
		beforeDrop : beforeDrop,
	}
};

/**
 * 우클릭후 Add Node 클릭 event
 * @returns
 */
function addTreeNode() {
	hideRMenu();
	var newNode = { name:"newNode " + (addCount++)};
	if (zTree.getSelectedNodes()[0]) {
		zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
	} else {
		zTree.addNodes(null, newNode);
	}
}

function beforeDrag(treeId, treeNodes) {
	for (var i=0,l=treeNodes.length; i<l; i++) {
		if (treeNodes[i].drag === false) {
			return false;
		}
	}
	return true;
}

function beforeDrop(treeId, treeNodes, targetNode, moveType) {
	return targetNode ? targetNode.drop !== false : true;
}

/**
 * 우클릭 display layer hide 처리
 * @returns
 */
function hideRMenu() {
	if (rMenu) rMenu.css({"visibility": "hidden"});
	/*$("body").unbind("mousedown", onBodyMouseDown);*/
}

/**
 * 우클릭 display layer 버튼 클릭 이벤트 설정
 * @param event
 * @returns
 */
function onBodyMouseDown(event){
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
		rMenu.css({"visibility" : "hidden"});
	}
}

/**
 * 클릭 event 설정
 * @param event
 * @param treeId
 * @param treeNode
 * @returns
 */
function onClick(event, treeId, treeNode) {
    if(treeNode.id !== undefined) {
    	parent.$("#menuId").val(treeNode.id);
    } else {
    	parent.$("#menuId").val("");
    	treeNode.useYn = "N"
    }
    parent.$("#menuNm").val(treeNode.name);
    parent.$("#url").val(treeNode.url);
    parent.$("#useYn").val(treeNode.useYn);
};

function onRename(event, treeId, treeNode, isCancel) {
	parent.$("#menuNm").val(treeNode.name);
}

/**
 * 우클릭 event 설정
 * @param event
 * @param treeId
 * @param treeNode
 * @returns
 */
function onRightClick(event, treeId, treeNode) {
	if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
		zTree.cancelSelectedNode();
		showRMenu("root", event.clientX, event.clientY);
	} else if (treeNode && !treeNode.noR) {
		zTree.selectNode(treeNode);
		showRMenu("node", event.clientX, event.clientY);
	}
}

/**
 * 우클릭후 Delete Node 클릭 event
 * @returns
 */
function removeTreeNode() {
	hideRMenu();
	var nodes = zTree.getSelectedNodes();
	if (nodes && nodes.length>0) {
		if (nodes[0].children && nodes[0].children.length > 0) {
			var msg = "If you delete this node will be deleted along with sub-nodes. \n\nPlease confirm!";
			if (confirm(msg)==true){
				zTree.removeNode(nodes[0]);
			}
		} else {
			zTree.removeNode(nodes[0]);
		}
	}
}

/**
 * 우클릭후 Resume zTree 클릭 event
 * @returns
 */
function resetTree() {
	hideRMenu();
	$.fn.zTree.init($("#demoZTree"), setting, zNodes);
}

/**
 * 환결 설정
 * @returns
 */
function setCheck() {
	zTree.setting.edit.drag.isCopy = true;
	zTree.setting.edit.drag.isMove = true;
	zTree.setting.edit.drag.prev = true;
	zTree.setting.edit.drag.inner = true;
	zTree.setting.edit.drag.next = true;
}

/**
 * 우클릭시 layer display
 * @param type
 * @param x
 * @param y
 * @returns
 */
function showRMenu(type, x, y) {
	$("#rMenu ul").show();
	if (type=="root") {
		$("#m_del").hide();
	} else {
		$("#m_del").show();
	}

    y += document.body.scrollTop;
    x += document.body.scrollLeft;
    rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});

	$("body").bind("mousedown", onBodyMouseDown);
}
