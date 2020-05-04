<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>奖品管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/rfb/rfbAward/">奖品列表</a></li>
		<shiro:hasPermission name="rfb:rfbAward:edit"><li><a href="${ctx}/rfb/rfbAward/form">奖品添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="rfbAward" action="${ctx}/rfb/rfbAward/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>奖品名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>奖品名称</th>
				<th>奖品介绍</th>
				<th>规则</th>
				<th>更新时间</th>
				<shiro:hasPermission name="rfb:rfbAward:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rfbAward">
			<tr>
				<td><a href="${ctx}/rfb/rfbAward/form?id=${rfbAward.id}">
					${rfbAward.name}
				</a></td>
				<td>
					${rfbAward.content}
				</td>
				<td>
					${rfbAward.rule}
				</td>
				<td>
					<fmt:formatDate value="${rfbAward.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="rfb:rfbAward:edit"><td>
    				<a href="${ctx}/rfb/rfbAward/form?id=${rfbAward.id}">修改</a>
					<a href="${ctx}/rfb/rfbAward/delete?id=${rfbAward.id}" onclick="return confirmx('确认要删除该奖品吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>