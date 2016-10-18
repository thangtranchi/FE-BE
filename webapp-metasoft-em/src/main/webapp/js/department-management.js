var deptTable = [];

function openAddDepartmentForm(){
	$('#department-id').val('-1');
  	$('#department-name').val('');
  	$('#parent-name').val('');
  	$('#manager-name').val('');
  	hideErrorMessage('#addDepartment-error-msg');
	$('#departmentModal').modal('show');
	
}
function clickRoot(){
	var root = $('#root').is(':checked');
	if(root){
		$("#parent-name").prop('disabled', true);
	}else{
		$("#parent-name").prop('disabled', false);
	}
}
function addDepartment(){
	   var departmentName = $('#department-name').val();
	   var parentName = $('#parent-name').val();
	   var departmentId = $('#department-id').val();
	   var manager = $('#manager-name').val(); 
	   var root = $('#root').is(':checked');
	   hideErrorMessage('#addEmployee-error-msg');
	    if(!departmentName || $.trim(departmentName).length==0){
	    	showErrorMessage('#addSite-error-msg', 'Please enter department name'); 
	    	return;
	    }
	    if(root==true){
	    	parentName='';
	    }
	   var department ={
			   "departmentId":departmentId,
	    		"name":departmentName,
	    		"manager":manager,
	    		"additionalEmployee":'dump',
	    		
	    		"root":root,
	    		"parent":parentName
	    }
	   
	   $.ajax({
	        url : "ajax/checkDepartment",
	        global : true,
	        dataType : 'json',
	        contentType : 'application/json',
	        data : JSON.stringify(department),
	        type : "POST",
	        success : function(aaData) { 
	        	if(aaData==false){
	        		showErrorMessage('#addDepartment-error-msg', 'Your enterred department name is already existed!'); 
	    	    	return;
	        	}else{
	        		 $.ajax({
	        		        url : "ajax/addDepartment",
	        		        global : true,
	        		        dataType : 'json',
	        		        contentType : 'application/json',
	        		        data : JSON.stringify(department),
	        		        type : "POST",
	        		        success : function(aaData) { 
	        		        	$("#departmentModal").modal('toggle');
	        		        	var dataTable=[];
	        		        	
	        		        	 for(var i =0; i< aaData.length;i++){
	        		        		 var department =[4];
	        		        		 department[0] = aaData[i].name;
	        		        		 department[1] = aaData[i].manager;
	        		        		 department[2] = aaData[i].parent
	        		        		 department[3] = aaData[i].root;
	        		        		 department[4] = aaData[i].departmentId;
	        		        	   dataTable.push(department);
	        		        	 }
	        		        	 refreshTable(deptTable,dataTable);
	        		        	 $("#successfulModal").modal('toggle');
	        		        },
	        		        failed : function() {
	        		        }
	        		    });
	        	}
	        },
	        failed : function() {
	        }
	    });
}

function editDepartment(id){
	hideErrorMessage('#addDepartment-error-msg');
	$.ajax({
        url : "ajax/getDepartment",
        global : true,
       
        data : {
            "id" : $.trim(id)
        },
        type : "GET",
        success : function(data) { 
        	$('#departmentModal').modal('show');
        	$('#department-id').val(data.departmentId);
        	$('#department-name').val(data.name);
        	$('#parent-name').val(data.parent);  
        	$("#manager-name").val(data.manager);
        	tickCheckbox('#root',data.root);
        	if(data.root){
        		$("#parent-name").prop('disabled', true);
        	}
       	 
        },
        failed : function() {
        }
    });
}

function deleteDepartment(id){
	var id = $('#departmentId-hidden').val();
	$.ajax({
        url : "ajax/deleteDepartment",
        global : true,
       
        data : {
            "id" : $.trim(id)
        },
        type : "GET",
        success : function(aaData) { 
 
        	var dataTable=[];
        	
        	for(var i =0; i< aaData.length;i++){
       		 var department =[4];
       		 department[0] = aaData[i].name;
       		 department[1] = aaData[i].manager;
       		 department[2] = aaData[i].parent
       		 department[3] = aaData[i].root;
       		 department[4] = aaData[i].departmentId;
       	   dataTable.push(department);
       	 }
        	 refreshTable(deptTable,dataTable);
        	 $("#confirmDepartmentModal").modal('toggle');
        },
        failed : function() {
        }
    });
}

function createDepartmentTable(table1) {
	 
	deptTable = $('#departmentTable')
		.dataTable(
				{
					"aaData" : table1,
					"bAutoWidth" : true,
					"bFilter" : true,
					"bSort" : true,
					"pagingType" : "full_numbers",
					"oLanguage" : {
						"sZeroRecords" : "No department found"
					} ,
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
										"sClass" : "hidden-print data-cell",
										mRender : function(data, type, full) {

									return '<button type="button" class="btn btn-primary" onclick=editDepartment("'+data+'"); >Edit</button>&nbsp'
								      +'<button type="button" class="btn btn-primary" onclick=confirmDeleteDepartment("'+data+'"); >Delete</button>';
										}
									} ]
				});

};

function confirmDeleteDepartment (id){
	$("#confirmDepartmentModal").modal('show');
	$('#departmentId-hidden').val(id);
}
