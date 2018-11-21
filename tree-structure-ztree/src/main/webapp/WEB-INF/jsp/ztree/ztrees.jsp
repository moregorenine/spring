<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tree Structure zTree</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/zTree_v3/css/demo.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery.ztree.exedit.js"></script>
<SCRIPT type="text/javascript">
	<!--
	var setting = {
		edit: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeDrag: beforeDrag
		}
	};

	var zNodes =[
		{ id:1, pId:0, name:"parent node 1", open:true},
		{ id:11, pId:1, name:"leaf node 1-1"},
		{ id:12, pId:1, name:"leaf node 1-2"},
		{ id:13, pId:1, name:"leaf node 1-3"},
		{ id:2, pId:0, name:"parent node 2", open:true},
		{ id:21, pId:2, name:"leaf node 2-1"},
		{ id:22, pId:2, name:"leaf node 2-2"},
		{ id:23, pId:2, name:"leaf node 2-3"},
		{ id:3, pId:0, name:"parent node 3", open:true },
		{ id:31, pId:3, name:"leaf node 3-1"},
		{ id:32, pId:3, name:"leaf node 3-2"},
		{ id:33, pId:3, name:"leaf node 3-3"}
	];

	function beforeDrag(treeId, treeNodes) {
		return false;
	}
	
	function setEdit() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		remove = $("#remove").attr("checked"),
		rename = $("#rename").attr("checked"),
		removeTitle = $.trim($("#removeTitle").get(0).value),
		renameTitle = $.trim($("#renameTitle").get(0).value);
		zTree.setting.edit.showRemoveBtn = remove;
		zTree.setting.edit.showRenameBtn = rename;
		zTree.setting.edit.removeTitle = removeTitle;
		zTree.setting.edit.renameTitle = renameTitle;
		showCode(['setting.edit.showRemoveBtn = ' + remove, 'setting.edit.showRenameBtn = ' + rename,
			'setting.edit.removeTitle = "' + removeTitle +'"', 'setting.edit.renameTitle = "' + renameTitle + '"']);
	}
	function showCode(str) {
		var code = $("#code");
		code.empty();
		for (var i=0, l=str.length; i<l; i++) {
			code.append("<li>"+str[i]+"</li>");
		}
	}
	
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		setEdit();
		$("#remove").bind("change", setEdit);
		$("#rename").bind("change", setEdit);
		$("#removeTitle").bind("propertychange", setEdit)
		.bind("input", setEdit);
		$("#renameTitle").bind("propertychange", setEdit)
		.bind("input", setEdit);
	});
	//-->
</SCRIPT>
</head>
<body>
<h1>Tree Structure zTree</h1>
<h6>[ 메뉴 정보 예제 ]</h6>
<!-- <div id="out"> -->
	<div class="content_wrap" style="margin: 0 auto;">
		<div class="zTreeDemoBackground left">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		<div class="right">
			<ul class="info">
				<li class="title"><h2>1. Explanation of setting</h2>
					<ul class="list">
						<li>왼쪽 트리에 활성화된 노드의 상세 정보를 보여준다.</li>
						<li>메뉴에 대한 추가, 수정, 삭제, 이동은 submit 버튼을 통해 하나의 transaction으로 처리된다.</li>
					</ul>
					<br>
					<div>
						<table>
							<tr>
								<td>
									<label for="menuId">ID</label>
								</td>
								<td>
									<input type="text" name="menuId" id="menuId" value=""
									placeholder="The system will automatically generate an 'ID'"
									disabled="disabled" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="menuNm">Name</label>
								</td>
								<td>
									<input type="text" name="menuNm" id="menuNm" value=""
									placeholder="Name" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="useYn">Use</label>
								</td>
								<td>
									<select name="useYn" id="useYn">
										<option value="Y">Yes</option>
										<option value="N">No</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<label for="url">URL</label>
								</td>
								<td>
									<input type="text" name="url" id="url" value=""
									placeholder="URL" />
								</td>
							</tr>
						</table>
					</div>
				</li>
			</ul>
			<hr />
			<input type="submit" value="submit" id="btnSubmit" />
		</div>
	</div>
<!-- </div> -->
</body>
</html>