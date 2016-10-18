<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="department-area" class="container">
	<h2>Department Management</h2>
	<div class="panel panel-shaded page-filter ">
		<div class="panel-body">
			<form id="department-form" role="form">
				 


				<div class="col-xs-12 col-md-12 hide-div customized-history-table">
					<table class="table table-striped table-hover text-center"
						id="departmentTable">
						<thead>
							<tr>
								<th class="text-center">Department Name</th>
								<th class="text-center">Manager</th>
								<th class="text-center">Parent Department</th>
								<th class="text-center">Is Root</th>
								<th class="text-center">Action</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				<div class="col-md-3 form-group">
					<button type="button" class="btn btn-primary" onclick="openAddDepartmentForm()">Add Department</button>
				</div>

			</form>
		</div>
	</div>
</div>
<div class="modal fade" id="departmentModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add new department</h4>
			</div>
			<input type="hidden" id="department-id" name="department-id" value=""/>
			<div class="modal-body">
			   <div id="addDepartment-error-msg"
					class="row top-buffer alert alert-danger hide"></div>
			    
			   <div class="row top-buffer">
				<div class="col-md-4 form-group">
					<label class="sitename">Department name*</label>
				</div>
				<div class="col-md-8 form-group">
						<input type="text" class="form-control" id="department-name" name="department-name"/>
				</div>
				 
			 </div>
			  <div class="row top-buffer">
				<div class="col-md-4 form-group">
					<label class="deparment-manager">Department manager*</label>
				</div>
				<div class="col-md-8 form-group">
					<select id="manager-name" name="manager-name" class="combobox">
					  <option value="">No Manager</option>
					  <c:forEach items="${allEmployees}" var="employee" >
					  <option value="${employee.firstName}${employee.lastName}">${employee.firstName} ${employee.lastName}</option>					  
					  </c:forEach>
					</select>
				</div>
				 
			 </div>
			 
			  <div class="row top-buffer">
			  <div class="col-md-1 form-group">
					<label class="root">Root</label>
				</div>
				<div class="col-md-1 form-group">
					<input style="margin: -5px 0 0;" type="checkbox" class="form-control" id="root" name="root" onclick="clickRoot()" />
				</div>
				<div class="col-md-3 form-group">
					<label class="parent-name">Parent name</label>
				</div>
				<div class="col-md-7 form-group">
					<input type="text" class="form-control" id="parent-name" name="parent-name"/>
				</div>
				
			 </div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-default" onclick="addDepartment();" >Save</button>
			</div>
		</div>

	</div>
</div>

<div class="modal fade" id="confirmDepartmentModal" role="dialog">
 	<input type="hidden" id="departmentId-hidden" name="departmentId-hidden"/>
	<div class="modal-dialog"> 
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Are you sure?</h4>
			</div>
			 <div class="modal-body">
			 </div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-default" onclick="deleteDepartment();">Confirm</button>
			</div>
		</div>

	</div>
</div>
 <div class="modal fade" id="successfulModal" role="dialog">
	<input type="hidden" id="employeeId-hidden" name="employeeId-hidden" />
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Successful!</h4>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
 <script>
$(document).ready(function () {
var dataTable = [];

<c:forEach items="${allDept}" var="dept" >
   var department =[4];
   department[0] = '${dept.name}';
   department[1] = '${dept.manager}';
   department[2] = '${dept.parent}'
   department[3] = '${dept.root}';
   department[4] = '${dept.departmentId}';
   dataTable.push(department);
</c:forEach>
    createDepartmentTable(dataTable);
    
});
</script>
 