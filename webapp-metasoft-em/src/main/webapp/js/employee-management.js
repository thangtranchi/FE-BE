var employeeTable = [];

function openAddEmployeeForm(){
	$('#employeeModal').modal('show');
	
	$('#employeeId').val('-1');
	$('#addressId').val('');        	
	$('#firstname').val('');
	$('#lastname').val('');
	$('#email').val('');
	$('#dob').val('');
	$('#gender').val('');
	$('#mobileNumber').val('');
	$('#businessPhone').val('');
	$('#entryDate').val('');
	$('#leaveDate').val('');
	$('#houseno').val('');
	$('#street').val('');
	$('#postcode').val('');
	$('#city').val('');
}

function addnewEmployee(){
	var employeeId = $('#employeeId').val();
    var firstname = $('#firstname').val();
    var lastname = $('#lastname').val();
    var email = $('#email').val();
    var dob =$('#dob').val();
    var external = $('#external').is(':checked');
    var mobileNumber = $('#mobileNumber').val();
    var gender =  $('#gender').is(':checked');
    var businessPhone = $('#businessPhone').val();
    var entryDate = $('#entryDate').val();
    var leaveDate = $('#leaveDate').val();
    var houseno = $('#houseno').val();
    var street = $('#street').val();
    var postcode = $('#postcode').val();
    var city = $('#city').val();
    hideErrorMessage('#addEmployee-error-msg');
    if(!firstname || $.trim(firstname).length==0){
    	showErrorMessage('#addEmployee-error-msg', 'Please enter first name'); 
    	return;
    }
    if(!lastname || $.trim(lastname).length==0){
    	showErrorMessage('#addEmployee-error-msg', 'Please enter last name'); 
    	return;
    }
    if(!dob || $.trim(dob).length==0){
    	showErrorMessage('#addEmployee-error-msg', 'Please enter your date of birth'); 
    	return;
    }
    if(!email || !validateEmail(email) ){
    	showErrorMessage('#addEmployee-error-msg', 'Please enter a valid email'); 
    	return;
    }
    if(!entryDate || $.trim(entryDate).length==0 ){
    	showErrorMessage('#addEmployee-error-msg', 'Please enter entry date'); 
    	return;
    }
    if(!validatePhone(businessPhone)){
    	showErrorMessage('#addEmployee-error-msg', 'Please enter valid phone number'); 
    	return;
    }
    var employee ={
    		"employeeId":employeeId,
    		"firstName":firstname,
    		"lastName":lastname,
    		"email":email,
    		"external":external,
    		"dob":dob,
    		"gender":gender,
    		"mobileNumber":mobileNumber,
    		"businessPhone":businessPhone,
    		"fax":businessPhone,
    		"entryDate":entryDate,
    		"leaveDate":leaveDate,
    		"dobStr":"",
    		"entryDateStr":"",
    		"leaveDateStr":"",
    		"address":{"addressId":"-1","houseNumber":houseno,"street":street,"postCode":postcode,"city":city}
    }
    $.ajax({
        url : "ajax/addEmployee",
        global : true,
        dataType : 'json',
        contentType : 'application/json',
        data : JSON.stringify(employee),
        type : "POST",
        success : function(aaData) { 
        	$("#employeeModal").modal('toggle');
        	 
        	var dataTable=[];
        	
        	 for(var i =0; i< aaData.length;i++){
        	 var employee =[6];
        	   employee[0] = aaData[i].firstName;
        	   employee[1] = aaData[i].lastName;
        	   employee[2] = aaData[i].gender==true?'Male':'Female';
        	   employee[3] = aaData[i].dobStr;
        	   employee[4] = aaData[i].email;
        	   employee[5] = aaData[i].entryDateStr;
        	   employee[6] = aaData[i].employeeId;
        	   dataTable.push(employee);
        	 }
        	 refreshTable(employeeTable,dataTable);
        	 $("#successfulModal").modal('toggle');
        },
        failed : function() {
        }
    });
}

function editEmployee(id){
	hideErrorMessage('#addEmployee-error-msg');
	$.ajax({
        url : "ajax/getEmployee",
        global : true,
       
        data : {
            "id" : $.trim(id)
        },
        type : "GET",
        success : function(data) { 
        	$('#employeeModal').modal('show');
        	$('#employeeId').val(data.employeeId);
        	$('#addressId').val(data.address.addressId);        	
        	$('#firstname').val(data.firstName);
        	$('#lastname').val(data.lastName);
        	$('#email').val(data.email);
        	$('#dob').val(data.dobStr);
        	tickCheckbox('#gender',data.gender);
        	tickCheckbox('#external',data.external);
        	$('#mobileNumber').val(data.mobileNumber);
        	$('#businessPhone').val(data.businessPhone);
        	$('#entryDate').val(data.entryDateStr);
        	$('#leaveDate').val(data.leaveDateStr);
        	$('#houseno').val(data.address.houseNumber);
        	$('#street').val(data.address.street);
        	$('#postcode').val(data.address.postCode);
        	$('#city').val(data.address.city);        	 
        },
        failed : function() {
        }
    });
}

function deleteEmployee(){
	var id = $('#employeeId-hidden').val();	
	$.ajax({
        url : "ajax/deleteEmployee",
        global : true,
       
        data : {
            "id" : $.trim(id)
        },
        type : "GET",
        success : function(aaData) { 
        	var dataTable=[];
       	 
       	 for(var i =0; i< aaData.length;i++){
       	 var employee =[6];
       	   employee[0] = aaData[i].firstName;
       	   employee[1] = aaData[i].lastName;
	       	if(aaData[i].gender==true){
	 		   employee[2] ='Male'
	 	   }else{
	 		   employee[2] ='Female'
	 	   }
       	   employee[3] = aaData[i].dobStr;
       	   employee[4] = aaData[i].email;
       	   employee[5] = aaData[i].entryDateStr;
       	   employee[6] = aaData[i].employeeId;
       	   dataTable.push(employee);
       	 }
       	 refreshTable(employeeTable,dataTable);
       	$("#confirmEmployeeModal").modal('toggle');
        },
        failed : function() {
        }
    });
}
 

function createTable(table1) {
	 
	employeeTable = $('#employeeTable')
			.dataTable(
					{
						"aaData" : table1,
						"bAutoWidth" : true,
						"bFilter" : true,
						"bSort" : true,
						"pagingType" : "full_numbers",
						"oLanguage" : {
							"sZeroRecords" : "No employee found"
						},
						"aoColumns" : [
								{
									"aTargets" : [ 0 ],
									"sClass" : "hidden-print data-cell"
								},
								{
									"aTargets" : [ 1 ],
									"sClass" : "hidden-print data-cell"
								},
								{
									"aTargets" : [ 2 ],
									"sClass" : "hidden-print data-cell"
								},
								{
									"aTargets" : [ 3 ],
									"sClass" : "hidden-print data-cell"
								},
								{
									"aTargets" : [ 4 ],
									"sClass" : "hidden-print data-cell"
								},
								{
									"aTargets" : [ 5 ],
									"sClass" : "hidden-print data-cell"
								},
								{
									"aTargets" : [ 6 ],
									"sClass" : "hidden-print data-cell",
									mRender : function(data, type, full) {

								return '<div class="dropdown"><button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Action</button>'
							    +'<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">'
							     + '<li ><button type="button" class="btn btn-primary" onclick=assignTo("'+data+'"); >Assign to</button></li>'
							     + '<li ><button type="button" class="btn btn-primary" onclick=editEmployee("'+data+'"); >Edit</button></li>'
							      +'<li ><button type="button" class="btn btn-primary" onclick=confirmDeleteEmployee("'+data+'"); >Delete</button></li>'
							    +'</ul><div class="dropdown">';
									}
								} ]
					});

};
function assignTo(id){
	
	$('#selected-emp').val(id);
	$.ajax({
        url : "ajax/getEmployee",
        global : true,
       
        data : {
            "id" : $.trim(id)
        },
        type : "GET",
        success : function(data) { 
        	$('#assignModal').modal('show');
        	var assignDepartment='This user is not assigned to any department';
        	var assignSite='This user is not assigned to any site';
        	
        	if(data.departmentList.length>0){
        		assignDepartment='This user is assigned to '+ data.departmentList;
        		var depts = [];
        		depts = data.departmentList;
        		for(var i =0; i <depts.length;i++){
        				$('#department-combobox option').each(function() {
        				    if ( $(this).text() == depts[i] ) {
        				        $(this).remove();
        				    }
        				});
        		} 
        	}
        	if(data.siteList.length>0){
        		assignSite='This user is assigned to '+ data.siteList;
        		var sites = [];
        		sites = data.siteList;
        		for(var i =0; i <sites.length;i++){
        				$('#site-combobox option').each(function() {
        				    if ( $(this).text() == sites[i] ) {
        				        $(this).remove();
        				    }
        				});
        		}
        	}
        	$('#list-department').text(assignDepartment);
        	$('#list-site').text(assignSite);
        },
        failed : function() {
        }
    });
	
}
function assignToSite(){
	var siteId = $('#site-combobox').val();
	var employeeId = $('#selected-emp').val();
	//validation must be select site here
	
	$.ajax({
        url : "ajax/assignToSite",
        global : true,
       
        data : {
            "employeeId" : $.trim(employeeId),
            "siteId":$.trim(siteId)
        },
        type : "GET",
        success : function(data) { 
        	$("#assignModal").modal('toggle');
        	$("#successfulModal").modal('toggle');
        },
        failed : function() {
        }
    });
}

function assignToDepartment(){
	var departmentId = $('#department-combobox').val();
	var employeeId = $('#selected-emp').val();
	//validation must be select site here
	
	$.ajax({
        url : "ajax/assignToDepartment",
        global : true,
       
        data : {
            "employeeId" : $.trim(employeeId),
            "departmentId":$.trim(departmentId)
        },
        type : "GET",
        success : function(data) { 
        	$("#assignModal").modal('toggle');
        	$("#successfulModal").modal('toggle');
        	
        },
        failed : function() {
        }
    });
}
function confirmDeleteEmployee (id){
	$("#confirmEmployeeModal").modal('show');
	$('#employeeId-hidden').val(id);
}