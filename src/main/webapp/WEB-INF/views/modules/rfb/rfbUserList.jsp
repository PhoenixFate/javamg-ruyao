<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
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
		<li class="active"><a href="${ctx}/rfb/rfbUser/">用户列表</a></li>
		<shiro:hasPermission name="rfb:rfbUser:edit"><li><a href="${ctx}/rfb/rfbUser/form">用户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="rfbUser" action="${ctx}/rfb/rfbUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>微信openid：</label>
				<form:input path="openid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>昵称：</label>
				<form:input path="nickName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>真实姓名：</label>
				<form:input path="realname" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>微信openid</th>
				<th>头像</th>
				<th>昵称</th>
				<th>性别</th>
				<th>真实姓名</th>
				<th>手机</th>
				<th>市</th>
				<th>最好成绩</th>
				<th>使用次数</th>
				<th>更新时间</th>
				<shiro:hasPermission name="rfb:rfbUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rfbUser">
			<tr>
				<td><a href="${ctx}/rfb/rfbUser/form?id=${rfbUser.id}">
					${rfbUser.openid}
				</a></td>
				<td>
					<img src="${rfbUser.avatarUrl}" style="width: 40px;height: 40px">
				</td>

				<td>
					${rfbUser.nickName}
				</td>
				<td>
					<c:if test="${rfbUser.gender==0}">
						未知
					</c:if>
					<c:if test="${rfbUser.gender!=0}">
						${fns:getDictLabel(rfbUser.gender, 'sex', '')}
					</c:if>
				</td>
				<td>
					${rfbUser.realname}
				</td>
				<td>
					${rfbUser.phone}
				</td>
				<td>
					${rfbUser.city}
				</td>
				<td>
					${rfbUser.bestScore}
				</td>
				<td>
					${rfbUser.useCount}
				</td>
				<td>
					<fmt:formatDate value="${rfbUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>

				<shiro:hasPermission name="rfb:rfbUser:edit"><td>
    				<a href="${ctx}/rfb/rfbUser/form?id=${rfbUser.id}">修改</a>
					<a href="${ctx}/rfb/rfbUser/delete?id=${rfbUser.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>