LSPADD = function(HTMLContent) {
	
	var addBg;
	var add;
	
	this.init = function() {
		this.createAdd(HTMLContent);
		this.displayAdd();
	};
	
	this.createAdd = function(HTMLContent) {
		addBg = document.createElement('div');
		addBg.setAttribute('class', 'add-panel-background');
		add = document.createElement('div');
		add.setAttribute('class', 'add-panel');
		add.setAttribute('id', 'login-advertisement');
		var content = document.createElement('div');
		content.setAttribute('class', 'add-panel-content');
		content.innerHTML=HTMLContent;
		var exitButton = document.createElement('div');
		exitButton.setAttribute('class', 'add-exit-button');
		exitButton.setAttribute('onclick', 'addObject.removeAdd()');
		var exitImage = document.createElement('img');
		exitImage.alt='Close';
		exitImage.src='/html/common/advertising/images/application-exit.png';
		exitButton.appendChild(exitImage);
		add.appendChild(content);
		add.appendChild(exitButton);
	};
	
	this.displayAdd = function() {
		document.body.appendChild(addBg);
		document.body.appendChild(add);
	};
	
	this.removeAdd = function() {
		document.body.removeChild(add);
		document.body.removeChild(addBg);
	};
	
	this.init();
	
}