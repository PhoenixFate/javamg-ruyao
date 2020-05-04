<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>知识库管理</title>
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
		<li class="active"><a href="${ctx}/rfb/rfbKnowledge/">知识库列表</a></li>
		<shiro:hasPermission name="rfb:rfbKnowledge:edit"><li><a href="${ctx}/rfb/rfbKnowledge/form">知识库添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="rfbKnowledge" action="${ctx}/rfb/rfbKnowledge/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>答题分类</th>
				<th>人员角色</th>
				<th>环节、节点</th>
				<th style="max-width: 200px;overflow:hidden;text-overflow: ellipsis;white-space: nowrap;">标题</th>
				<th>创建者</th>
				<shiro:hasPermission name="rfb:rfbKnowledge:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rfbKnowledge">
			<tr>
				<td><a href="${ctx}/rfb/rfbKnowledge/form?id=${rfbKnowledge.id}">
					${fns:getDictLabel(rfbKnowledge.type, 'rfb_knowledge', '')}
				</a></td>
				<td>
					${fns:getDictLabel(rfbKnowledge.role, 'rfb_knowledge_role', '')}
				</td>
				<td>
					${fns:getDictLabel(rfbKnowledge.node, 'rfb_knowledge_node', '')}
				</td>
				<td style="max-width: 200px;overflow:hidden;text-overflow: ellipsis;white-space: nowrap;">
					${rfbKnowledge.title}
				</td>
				<td>
					${rfbKnowledge.createBy.name}
				</td>
				<shiro:hasPermission name="rfb:rfbKnowledge:edit"><td>
    				<a href="${ctx}/rfb/rfbKnowledge/form?id=${rfbKnowledge.id}">修改</a>
					<a href="${ctx}/rfb/rfbKnowledge/delete?id=${rfbKnowledge.id}" onclick="return confirmx('确认要删除该知识库吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>