<%@ taglib prefix="s" uri="/struts-tags"%>
<s:a action="newUser">Add new user</s:a>
<div class="row ">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<s:text name="users.index.panel_title" />
				</h3>
				<div class="pull-right">
					<span class="clickable filter" data-toggle="tooltip"
						title="Toggle table filter" data-container="body"> <i
						class="glyphicon glyphicon-filter"></i>
					</span>
				</div>
			</div>
			<div class="panel-body">
				<input type="text" class="form-control" id="dev-table-filter"
					data-action="filter" data-filters="#dev-table"
					placeholder="Filter Developers" />
			</div>
			<div>
				<s:form action="list" method="get">
					<s:textfield name="keyWord"></s:textfield>
					<s:submit value="search"></s:submit>
				</s:form>
			</div>
			<table class="table table-hover" id="dev-table">
				<thead>
					<tr>
						<th>#</th>
						<th><s:text name="users.index.first_name" /></th>
						<th><s:text name="users.index.last_name" /></th>
						<th><s:text name="users.index.username" /></th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="users" status="incr">
						<s:url action="getUserById" var="urlTag">
							<s:param name="id">${id}</s:param>
						</s:url>
						
						<s:url action="deleteUser" var="deleteTag">
							<s:param name="id">${id}</s:param>
						</s:url>
						
						<s:url action="newUser" var="updateTag">
							<s:param name="id">${id}</s:param>
						</s:url>
						
						

						<tr>
							<td>${id}</td>
							<td>${first_name}</td>
							<td>${last_name}</td>
							<td>${username}</td>
							<td><s:a href="%{urlTag}">Details</s:a></td>
							<td><s:a href="%{updateTag}">Edit</s:a></td>
							<td><s:a href="%{deleteTag}">Delete</s:a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</div>