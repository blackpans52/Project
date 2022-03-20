const pos = document.getElementsByName("pos");
setInterval(checked_select, 15000);

function resetInterval(num) {
	clearInterval(num);
	setInterval(checked_select, 15000);
}

function checked_select() {
	for (let i = 0; i < pos.length; i++) {
		if (pos[i].checked == true) {
			fade_slide(i);
			break;
		}
	}
}

function fade_slide(num) {
	pos[num].checked = false;

	if (num == pos.length - 1) {
		pos[0].checked = true;
	} else {
		pos[num + 1].checked = true;
	}
}