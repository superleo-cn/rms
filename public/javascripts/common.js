//checkbox
function checkStatus(obj){
	if($(obj).attr("checked")){
		$("input[name='ids']").attr("checked", true);
	}else{
		$("input[name='ids']").attr("checked", false);
	}
}

function deleteRecord(url){
	if($("input:checked[name='ids']").length > 0){
		$("#frm").attr("action", url);
		$("#frm").submit();
	}else{
		$("#deleteDialog").dialog('close');
		$("#noRecordDialog").dialog({});
		$("#noRecordDialog").dialog('open');
	}
}

function deleteSingleRecord(url){
	window.location.href = url;
}

function goBack(url){
	window.location.href=url;
}

function isNumeric(input){
    var RE = /^-{0,1}\d*\.{0,1}\d+$/;
    return (RE.test(input));
}

function disabledEnter(obj){
	$(obj).bind("keypress", function(e) {
		  if (e.keyCode == 13) return false;
	});
}

function readonlyAttr(obj){
	$(obj).attr("readonly","true"); 
}


function moveElements(fromSelect,toSelect)
{
	var to_remove_counter=0; //number of options that were removed (num selected options)

	fromSelect = fromSelect.get(0);
	toSelect = toSelect.get(0);
	//move selected options to right select box (to)
	for (var i=0;i<fromSelect.options.length;i++)
	{
		if (fromSelect.options[i].selected==true)
		{
			var addtext=fromSelect.options[i].text;
			var addvalue=fromSelect.options[i].value;
			toSelect.options[toSelect.options.length]=new Option(addtext,addvalue);
			fromSelect.options[i].selected=false;
			++to_remove_counter;
		}
		else
		{
			fromSelect.options[i-to_remove_counter].selected=false;
			fromSelect.options[i-to_remove_counter].text=fromSelect.options[i].text;
			fromSelect.options[i-to_remove_counter].value=fromSelect.options[i].value;
		}
	}

	//now cleanup the last remaining options 
	var numToLeave=fromSelect.options.length-to_remove_counter;
	for (i=fromSelect.options.length-1;i>=numToLeave;i--) 
	{ 
		fromSelect.options[i]=null;
	}
}