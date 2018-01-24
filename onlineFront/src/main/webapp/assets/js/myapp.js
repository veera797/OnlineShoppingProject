
	
	// solving the active menu problem
	switch (menu) {

	case 'about us':
		$('#about').addClass('active');
		break;
	case 'contact us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#viewProducts').addClass('active');
		break;
	case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;		
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

								