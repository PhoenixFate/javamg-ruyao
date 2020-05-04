<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>擂台赛管理</title>
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
		<li class="active"><a href="${ctx}/rfb/rfbArena/">擂台赛列表</a></li>
		<shiro:hasPermission name="rfb:rfbArena:edit"><li><a href="${ctx}/rfb/rfbArena/form">擂台赛添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="rfbArena" action="${ctx}/rfb/rfbArena/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>擂台赛名称：</label>
				<form:input path="title" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>擂台赛名称</th>
				<th>赛事类型</th>
				<th>擂台赛介绍</th>
				<th>奖品名称</th>
				<th>赛事状态</th>
				<shiro:hasPermission name="rfb:rfbArena:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rfbArena">
			<tr>
				<td><a href="${ctx}/rfb/rfbArena/form?id=${rfbArena.id}">
					${rfbArena.title}
				</a></td>
				<td>
					${fns:getDictLabel(rfbArena.type, 'rfb_arena_type', '')}
				</td>
				<td>
					${rfbArena.intro}
				</td>
				<td>
					${rfbArena.awardTitle}
				</td>
				<td>
					${fns:getDictLabel(rfbArena.status, 'rfb_arena_status', '')}
				</td>

				<shiro:hasPermission name="rfb:rfbArena:edit"><td>
    				<a href="${ctx}/rfb/rfbArena/form?id=${rfbArena.id}">修改</a>
					<a href="${ctx}/rfb/rfbArena/delete?id=${rfbArena.id}" onclick="return confirmx('确认要删除该擂台赛吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>