function showHide() {
	var valueSelected =  document.getElementById('comboColecao');
	if(valueSelected){
		txtVolume.style.visibility = 'visible';
	} else {
		txtVolume.style.visibility = 'hidden';
	}
	
}

function show() {
	var txtVolume = document.getElementById('volume');
	txtVolume.style.visibility = 'visible';
}