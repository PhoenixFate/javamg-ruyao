<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>知识库管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/rfb/rfbKnowledge/">知识库列表</a></li>
		<li class="active"><a href="${ctx}/rfb/rfbKnowledge/form?id=${rfbKnowledge.id}">知识库<shiro:hasPermission name="rfb:rfbKnowledge:edit">${not empty rfbKnowledge.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rfb:rfbKnowledge:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="rfbKnowledge" action="${ctx}/rfb/rfbKnowledge/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">答题分类：</label>
			<div class="controls">
				<form:select path="type" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('rfb_knowledge')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">人员角色：</label>
			<div class="controls">
				<form:select path="role" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('rfb_knowledge_role')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">环节、节点：</label>
			<div class="controls">
				<form:select path="node" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('rfb_knowledge_node')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项：</label>
			<div class="controls">
				<form:input path="options" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">正确答案：</label>
			<div class="controls">
				<form:input path="bingo" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">知识拓展图片：</label>
			<div class="controls">
				<form:hidden id="linkImage" path="linkImage" htmlEscape="false" maxlength="500" class="input-xlarge"/>
				<sys:ckfinder input="linkImage" type="files" uploadPath="/rfb/rfbKnowledge" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">知识扩展文本：</label>
			<div class="controls">
				<form:textarea path="linkText" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标签：</label>
			<div class="controls">
				<form:select path="label" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('rfb_knowledge_label')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rfb:rfbKnowledge:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>