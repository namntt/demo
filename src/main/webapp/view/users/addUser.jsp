<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="addUser" method="post">
	<s:textfield name="user.id" type="hidden"></s:textfield>
	<s:textfield name="user.username" label="Username"></s:textfield>
	<s:textfield name="user.first_name" label="Firstname"></s:textfield>
	<s:textfield name="user.last_name" label="Lastname"></s:textfield>
	<s:submit value="Submit"></s:submit>
</s:form>
