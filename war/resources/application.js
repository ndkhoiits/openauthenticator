$(document).on('pagecreate', '#main', function() {
	
	var storageService = new gauth.StorageService();
	// Construct JSON object
	var account = {
		'name': 'ndkhoi168@gmail.com',
		'secret': 'JBSWY3DPEHPK3PXP'
	};

	// Persist new object
	var accounts = storageService.getObject('accounts');
	if (!accounts) {
		// if undefined create a new array
		accounts = [];
	}
	accounts.push(account);
	storageService.setObject('accounts', accounts);
	
	// Use exports from locally defined module
	
	var keysController = new gauth.KeysController();
	
	keysController.init();
});