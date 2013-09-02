/****************************************************************
* Date:		10 May 2011
* Version:	1.0
* Purpose:	Restrict alpha characters and other special characters other than - symbol for date inputs.
* 			
****************************************************************/
function restrictCharacters(myfield, e, restrictionType) {
			if (!e) var e = window.event
			if (e.keyCode) code = e.keyCode;
			else if (e.which) code = e.which;
			var character = String.fromCharCode(code);

			// if they pressed esc... remove focus from field...
			if (code==27) { this.blur(); return false; }
			
			// ignore if they are press other keys			
			if (!e.ctrlKey && code!=9 && code!=8 && code!=36 && code!=37 && code!=38 && (code!=39 || (code==39 && character=="'")) && code!=40) {
				if (character.match(restrictionType)) {
					return true;
				} else {
					return false;
				}
				
			}
		}
