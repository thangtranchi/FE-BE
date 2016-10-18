var siteTable = [];

function openAddSiteForm(){
	 hideErrorMessage('#addSite-error-msg')
	$('#site-id').val('-1');
  	$('#site-name').val('');
	$('#longtitude').val('');        	
	$('#latitude').val(''); 

	$('#houseno-site').val('');
	$('#street-site').val('');
	$('#postcode-site').val('');
	$('#city-site').val('');  
	$('#siteModal').modal('show');
	
}

function addSite(){
	   var houseno = $('#houseno-site').val();
	   var street = $('#street-site').val();
	   var postcode = $('#postcode-site').val();
	   var city = $('#city-site').val();
	   var currentName = $('#site-current').val();
	   
	   var sitename = $('#site-name').val();
	   var external = $('#external-site').is(':checked');
	   var longtitude = $('#longtitude').val();
	   var latitude = $('#latitude').val();
	   var siteid = $('#site-id').val();
	   hideErrorMessage('#addSite-error-msg');
	    if(!sitename || $.trim(sitename).length==0){
	    	showErrorMessage('#addSite-error-msg', 'Please enter site name'); 
	    	return;
	    }
	    if(longtitude && !isNumeric(longtitude)){
	    	showErrorMessage('#addSite-error-msg', 'Please enter a valid longitude'); 
	    	return;
	    }
	    if(latitude && !isNumeric(latitude)){
	    	showErrorMessage('#addSite-error-msg', 'Please enter a valid latitude'); 
	    	return;
	    }
	   var site ={
			   "siteId":siteid,
	    		"name":sitename,
	    		"external":external,
	    		"longitude":longtitude,
	    		"lattitude":latitude,
	    		"address":{"addressId":"-1","houseNumber":houseno,"street":street,"postCode":postcode,"city":city}
	    }
	   
	   
	   $.ajax({
	        url : "ajax/checkSite",
	        global : true,
	        dataType : 'json',
	        contentType : 'application/json',
	        data : JSON.stringify(site),
	        type : "POST",
	        success : function(aaData) { 
	        	if(aaData==false){
	        		showErrorMessage('#addSite-error-msg', 'Your enterred site name is already existed!'); 
	    	    	return;
	        	}else{
	        		$.ajax({
	        	        url : "ajax/addSite",
	        	        global : true,
	        	        dataType : 'json',
	        	        contentType : 'application/json',
	        	        data : JSON.stringify(site),
	        	        type : "POST",
	        	        success : function(aaData) { 
	        	        	$("#siteModal").modal('toggle');
	        	        	var dataTable=[];
	        	        	
	        	        	 for(var i =0; i< aaData.length;i++){
	        	        		 var site =[4];
	        	        	   site[0] = aaData[i].name;
	        	        	   site[1] = aaData[i].address.houseNumber + ' '+ aaData[i].address.street +'-'+aaData[i].address.city;
	        	        	   if(aaData[i].longitude==0 || aaData[i].lattitude==0){
	        	        		   site[3] ='Not defined';
	        	        	   }else{
	        	        		   site[3] = aaData[i].longitude+';'+aaData[i].lattitude;
	        	        	   }
	        	        	   site[2] = aaData[i].external==true?'Yes':'No';
	        	        	   site[4] = aaData[i].siteId;
	        	        	   dataTable.push(site);
	        	        	 }
	        	        	 refreshTable(siteTable,dataTable);
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

function editSite(id){
	hideErrorMessage('#addSite-error-msg');
	$.ajax({
        url : "ajax/getSite",
        global : true,
        data : {
            "id" : $.trim(id)
        },
        type : "GET",
        success : function(data) { 
        	$('#siteModal').modal('show');
        	$('#site-id').val(data.siteId);
        	$('#site-name').val(data.name);
        	$('#longtitude').val(data.longitude);        	
        	$('#latitude').val(data.lattitude);
        	tickCheckbox('#external-site',data.external);
        	$('#houseno-site').val(data.address.houseNumber);
        	$('#street-site').val(data.address.street);
        	$('#postcode-site').val(data.address.postCode);
        	$('#city-site').val(data.address.city);        	 
        },
        failed : function() {
        }
    });
}

function deleteSite(){
	var id = $('#siteId-hidden').val();	
	$.ajax({
        url : "ajax/deleteSite",
        global : true,
       
        data : {
            "id" : $.trim(id)
        },
        type : "GET",
        success : function(aaData) { 
 
        	var dataTable=[];
        	
        	 for(var i =0; i< aaData.length;i++){
        		 var site =[4];
        	   site[0] = aaData[i].name;
        	   site[1] = aaData[i].address.houseNumber + ' '+ aaData[i].address.street +'-'+aaData[i].address.city;
        	   if(aaData[i].longitude==0 || aaData[i].lattitude==0){
        		   site[3] ='Not defined';
        	   }else{
        		   site[3] = aaData[i].longitude+';'+aaData[i].lattitude;
        	   }
        	   site[2] = aaData[i].external==true?'Yes':'No';
        	   site[4] = aaData[i].siteId;
        	   dataTable.push(site);
        	 }
        	 refreshTable(siteTable,dataTable);
        	 $("#confirmSiteModal").modal('toggle');
        },
        failed : function() {
        }
    });
}

function createSiteTable(table1) {
	siteTable = $('#siteTable')
	.dataTable(
		{
			"aaData" : table1,
			"bAutoWidth" : true,
			"bFilter" : true,
			"bSort" : true,
			"pagingType" : "full_numbers",
			"oLanguage" : {
				"sZeroRecords" : "No site found"
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

				return '<button type="button" class="btn btn-primary" onclick=editSite("'+data+'"); >Edit</button>&nbsp'
			      +'<button type="button" class="btn btn-primary" onclick=confirmDeleteSite("'+data+'"); >Delete</button>';
					}
				} ]
		});
};
function confirmDeleteSite (id){
	$("#confirmSiteModal").modal('show');
	$('#siteId-hidden').val(id);
}

