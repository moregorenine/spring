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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/ztrees.js"></script>
<SCRIPT type="text/javascript">
	var zNodes = "${ztrees}";
</SCRIPT>
</head>
<body>
<h1>Tree Structure zTree</h1>
<h6>[ 메뉴 정보 예제 ]</h6>
<!-- <div id="out"> -->
	<form method="post" action="menus">
	<div class="content_wrap" style="margin: 0 auto;">
		<div class="zTreeDemoBackground left">
			<ul id="demoZTree" class="ztree"></ul>
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
	</form>
<!-- </div> -->
	<!-- ztree 우클릭 메뉴 -->
	<div id="rMenu">
		<ul>
			<li id="m_add" onclick="addTreeNode();">Add Node</li>
			<li id="m_del" onclick="removeTreeNode();">Delete Node</li>
			<!-- <li id="m_check" onclick="checkTreeNode(true);">Check Node</li> -->
			<!-- <li id="m_unCheck" onclick="checkTreeNode(false);">Uncheck Node</li> -->
			<li id="m_reset" onclick="resetTree();">Resume zTree</li>
		</ul>
	</div>
</body>
</html>