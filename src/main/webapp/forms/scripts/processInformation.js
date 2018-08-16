var variableManager = camForm.variableManager;

var names = ["hello", "my", "name", "is", "i", "dont", "know", "why"];

/*
camForm.on('form-loaded', function() {
    variableManager.fetchVariable('varNames');
	$scope.varNames = variableManager.variableValue('varNames');
	for(var v: $scope.varNames){
		variableManager.fetchVariable(v);
		addToHtml(variableManager.variableValue(v));
	}
    });
	
*/

	function getAndCreateVars(){
		for(var v : names){
			
		}
	}
	
	
	
	function addToHtml(){
		var paragraph = document.getElementById("results");
		var div = document.createElement('div');
		div.id = arguments[0];
		div.innerHTML = arguments[0];
		div.className = "resultDiv";
		paragraph.appendChild(div);
	}
	
	
