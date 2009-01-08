function slideDiv(a) {
	$(a)
		.next()
			.slideToggle(200)
		.end()
		.toggleClass('r-arr')
		.toggleClass('d-arr');
	return false;
}