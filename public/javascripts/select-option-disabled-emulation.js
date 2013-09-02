/****************************************************************
* Date:		29 March 2011
* Version:	1.0
* Purpose:	Emulate the disabled attribute for the <option> 
*			element in Internet Explorer.
****************************************************************/

window.onload = function() {
	if (document.getElementsByTagName) {
		var s = document.getElementsByTagName("select");

		if (s.length > 0) {
			window.select_current = new Array();

			for (var i=0, select; select = s[i]; i++) {
				if(s[i].getAttribute("id") != 'assetTransactionType'){
				select.onfocus = function(){ window.select_current[this.id] = this.selectedIndex; }
				select.onchange = function(){ restore(this);}
				emulate(select);
				}
			}
		}
	}
}

function restore(e) {
	//alert('restore');
	if (e.options[e.selectedIndex].disabled) {
		e.selectedIndex = window.select_current[e.id];
	}
}

function emulate(e) {
	//alert('emulate');
	for (var i=0, option; option = e.options[i]; i++) {
		if (option.disabled) {
			option.style.color = "graytext";
		}
		else {
			option.style.color = "menutext";
		}
	}
}