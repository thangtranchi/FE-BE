function showErrorMessage(id, msg) {
    $(id).removeClass('hide');
    $(id).empty();
    $(id).append(msg);
};
function showSuccessMessage(id, msg) {
    $(id).removeClass('hide');
    $(id).empty();
    $(id).append(msg);
};
function hideErrorMessage(id) {
    $(id).addClass('hide');
};
function validateEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}
function validatePhone(value){
	if(!value || $.trim(value).length==0){
		return true;
	}else if($.trim(value).length<10){
		return false;
	}
	else{
		return /^\d+$/.test(value);
	}
}
function tickCheckbox(id,value){
	if(value){
		$(id).prop('checked', true);
	}else{
		$(id).prop('checked', false);
	}
}

function isNumeric(value) {
	  var RE = /^\d*\.?\d*$/;
	    if(RE.test(value)){
	       return true;
	    }else{
	       return false;
	    }
};

var refreshTable = function(table, aaData) {
    oSettings = table.fnSettings();
    table.fnClearTable(this);

    for (var i = 0; i < aaData.length; i++) {
        table.oApi._fnAddData(oSettings, aaData[i]);
    }

    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
    table.fnDraw();
};