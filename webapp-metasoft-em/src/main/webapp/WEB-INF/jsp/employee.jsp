<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="config-area" class="container">
	<h2>Employee Management</h2>
	<div class="panel panel-shaded page-filter ">
		<div class="panel-body">
				<input type="hidden" id="employeeId-hidden" name="employeeId-hidden" />

				<div class="col-xs-12 col-md-12 hide-div customized-history-table">
					<table class="table table-striped table-hover text-center"
						id="employeeTable">
						<thead>
							<tr>
								<th class="text-center">First Name</th>
								<th class="text-center">Last Name</th>
								<th class="text-center">Gender</th>
								<th class="text-center">DOB</th>
								<th class="text-center">Email</th>
								<th class="text-center">Entry Date</th>
								<th class="text-center">Action</th>
							</tr>
						</thead>
						<tbody id="employeeBody">

						</tbody>
					</table>
				</div>
				<div class="col-md-3 form-group">
					<button type="button" class="btn btn-primary"
						onclick="openAddEmployeeForm();">Add Employee</button>
				</div>
				<form:form action="downloadCSV" method="post" id="downloadCSV">
				<div class="col-md-3 form-group">
					<button id="addEmployee"  
						type="submit" class="btn btn-primary ">Export CSV</button>
				</div>
				</form:form>
				 
		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="employeeModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add new employee</h4>
				 
			</div>

			<div class="modal-body">
				<div id="addEmployee-error-msg"
					class="row top-buffer alert alert-danger hide"></div>
				<input type="hidden" id="employeeId" name="employeeId" value="-1" />
				<input type="hidden" id="addressId" name="addressId" value="-1" />
				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="firstname">First name / Last Name<span
							class="txt-danger">*</span></label>
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="firstname"
							name="firstName" />
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="lastname"
							name="lastName" />
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="dob">Date Of Birth<span
							class="txt-danger">*</span></label>
					</div>
					<div class="col-md-4 form-group">
						<input class="datepicker form-control" name="dob" id="dob" />
					</div>
					<div class="col-md-2 form-group">
						<label class="gender">Male</label>
					</div>
					<div class="col-md-2 form-group">
						<input type="checkbox" name="gender" id="gender" />
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="email">Email<span
							class="txt-danger">*</span></label>
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="email" name="email" />
					</div>
					<div class="col-md-2 form-group">
						<label class="external">External</label>
					</div>
					<div class="col-md-2 form-group">
						<input type="checkbox" name="external" id="external" />
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="phone">Business Phone / Mobile Phone</label>
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="businessPhone"
							name="businessPhone" maxlength="10" />
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="mobileNumber"
							name="mobileNumber" maxlength="10" />
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="entrydate">Entry Date<span
							class="txt-danger">*</span> / Leave Date
						</label>
					</div>
					<div class="col-md-4 form-group">
						<input class="datepicker form-control" name="entryDate"
							id="entryDate" />
					</div>
					<div class="col-md-4 form-group">
						<input class="datepicker form-control" name="leaveDate"
							id="leaveDate" />
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="houseno">House No / Street</label>
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="houseno"
							name="houseno" maxlength="10" />
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="street" name="street"
							maxlength="100" />
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="postcode">Postcode / City</label>
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="postcode"
							name="postcode" maxlength="8" />
					</div>
					<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="city" name="city" />
					</div>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-default"
					onclick="addnewEmployee();">Save</button>
			</div>
		</div>

	</div>
</div>
<div class="modal fade" id="assignModal" role="dialog">
	<div class="modal-dialog">
		<input type="hidden" id="selected-emp" name="selected-emp" />
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Assign to Site or Department</h4>
			</div>
			<div class="modal-body">

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="firstname">Departments*</label>
					</div>
					<div class="col-md-4 form-group">
						<select id="department-combobox" name="department-combobox"
							class="combobox">
							<option value="-1">Select Department</option>
							<c:forEach items="${allDeparments}" var="dept">
								<option value="${dept.departmentId}">${dept.name}</option>

							</c:forEach>
						</select>
					</div>
					<div class="col-md-4 form-group">
						<button type="button" class="btn btn-default"
							onclick="assignToDepartment()">Assign</button>
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-12 form-group">
						<label id="list-department"></label>
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-4 form-group">
						<label class="firstname">Site*</label>
					</div>
					<div class="col-md-4 form-group">
						<select id="site-combobox" name="site-combobox" class="combobox">
							<option value="-1">Select Site</option>
							<c:forEach items="${allSites}" var="site">
								<option value="${site.siteId}">${site.name}</option>

							</c:forEach>
						</select>
					</div>
					<div class="col-md-4 form-group">
						<button type="button" class="btn btn-default"
							onclick="assignToSite();">Assign</button>
					</div>
				</div>

				<div class="row top-buffer">
					<div class="col-md-12 form-group">
						<label id="list-site"></label>
					</div>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>

<div class="modal fade" id="confirmEmployeeModal" role="dialog">
	<input type="hidden" id="employeeId-hidden" name="employeeId-hidden" />
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Are you sure?</h4>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-default"
					onclick="deleteEmployee();">Confirm</button>
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
	$(document).ready(function() {
		var dataTable = [];
		<c:forEach items="${allEmployees}" var="employee" >
		var employee = [ 6 ];
		var d = Date.parse('${employee.dob}');

		employee[0] = '${employee.firstName}';
		employee[1] = '${employee.lastName}';
		employee[2] = '${employee.gender}' === 'true' ? 'Male' : 'Female';
		employee[3] = '${employee.dobStr}';
		employee[4] = '${employee.email}';
		employee[5] = '${employee.entryDateStr}';
		employee[6] = '${employee.employeeId}';
		dataTable.push(employee);
		</c:forEach>
		createTable(dataTable);
		$('.datepicker').datepicker({
			dateFormat : 'yy-mm-dd'
		})
	});
</script>