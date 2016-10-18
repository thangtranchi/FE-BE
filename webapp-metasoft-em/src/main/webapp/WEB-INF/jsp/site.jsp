<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="site-area" class="container">
	<h2>Site Management</h2>
	<div class="panel panel-shaded page-filter ">
		<div class="panel-body">
			<form id="site-form" role="form">
				<div class="col-xs-12 col-md-12 hide-div customized-history-table">
					<table class="table table-striped table-hover text-center"
						id="siteTable">
						<thead>
							<tr>
								<th class="text-center">Site Name</th>
								<th class="text-center">Address</th>
								<th class="text-center">External</th>
								<th class="text-center">Location</th>
								 <th class="text-center">Action</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				<div class="col-md-3 form-group">
					<button type="button" class="btn btn-primary"
						onclick="openAddSiteForm()">Add Site</button>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="modal fade" id="siteModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add new site</h4>
			</div>
 			<input type="hidden" id="site-id" name="site-id" value=""/>
			<div class="modal-body">
			<div id="addSite-error-msg"
					class="row top-buffer alert alert-danger hide"></div>
			   <div class="row top-buffer">
				<div class="col-md-4 form-group">
					<label class="sitename">Site name*</label>
				</div>
				<div class="col-md-4 form-group">
						<input type="text" class="form-control" id="site-name" name="site-name" maxlength="100"/>
				</div>
				<div class="col-md-2 form-group">
					<label class="external-site">External*</label>
				</div>
				<div class="col-md-2 form-group">
					<input type="checkbox" name="external-site" id="external-site" />
				</div>
			 </div>
			 
			  <div class="row top-buffer">
				<div class="col-md-4 form-group">
					<label class="longtitude">Longitude/Latitude</label>
				</div>
				<div class="col-md-4 form-group">
					<input type="text" class="form-control" id="longtitude" name="longtitude"/>
				</div>
				<div class="col-md-4 form-group">
					<input type="text" class="form-control" id="latitude" name="latitude"/>
				</div>
			 </div>
			 
			  <div class="row top-buffer">
				<div class="col-md-4 form-group">
					<label class="houseno">House No / Street*</label>
				</div>
				<div class="col-md-4 form-group">
					<input type="text" class="form-control" id="houseno-site" name="houseno-site" maxlength="10"/>
				</div>
				<div class="col-md-4 form-group">
					<input type="text" class="form-control" id="street-site" name="street-site"/>
				</div>
			 </div>
			 
			 <div class="row top-buffer">
				<div class="col-md-4 form-group">
					<label class="postcode">Postcode / City*</label>
				</div>
				<div class="col-md-4 form-group">
					<input type="text" class="form-control" id="postcode-site" name="postcode-site"/>
				</div>
				<div class="col-md-4 form-group">
					<input type="text" class="form-control" id="city-site" name="city-site"/>
				</div>
			 </div>
			 
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-default" onclick="addSite();" >Save</button>
			</div>
		</div>

	</div>
</div>
 <div class="modal fade" id="confirmSiteModal" role="dialog">
 	<input type="hidden" id="siteId-hidden" name="siteId-hidden"/>
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
				<button type="button" class="btn btn-default" onclick="deleteSite();">Confirm</button>
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

<c:forEach items="${allSites}" var="site" >
   var site =[4];
   site[0] = '${site.name}';
   site[1] = '${site.address.houseNumber}' +' '+'${site.address.street}'+'-'+'${site.address.city}';
   site[3] = '${site.longitude}'+' ; '+'${site.lattitude}';
   site[2] = '${site.external}'==='true'?'Yes':'No';
   site[4] = '${site.siteId}';
   dataTable.push(site);
</c:forEach>
    createSiteTable(dataTable);
    
});
</script>