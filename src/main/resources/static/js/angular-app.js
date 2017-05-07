angular.module("CondominioAPI", []);
angular.module("CondominioAPI").controller("APIController", function($scope, $http){
	
	$scope.app = "CondominioAPI";
	$scope.tag = false;
	$scope.digital = false;
	$scope.portaria = false;
	$scope.garagem = false;
	$scope.externos = false;
	
	var allFalse = function(){
		$scope.tag = false;
		$scope.digital = false;
		$scope.portaria = false;
		$scope.garagem = false;
		$scope.externos = false;
	}
	
	$scope.acessoTag = function(){
		$http({
			method: 'GET',
			url: 'http://localhost:8080/AcessosMorador'
		}).then(function(success){
			$scope.acessos = success.data;
			$scope.acessos = $scope.acessos.filter(function(acesso){
				if(acesso.tipo == 1) return acesso;
			});			
			allFalse();
			$scope.tag = true;
			$scope.titulo = "Acessos com a Tag";
			$('#tables').fadeIn();
		},function(error){
			$scope.erroAcesso = "Houve um erro, tente novamente!";
		});
	}
	
	$scope.acessoDigital = function(){
		$http({
			method: 'GET',
			url: 'http://localhost:8080/AcessosMorador'
		}).then(function(success){
			$scope.acessos = success.data;
			$scope.acessos = $scope.acessos.filter(function(acesso){
				if(acesso.tipo == 2) return acesso;
			});			
			allFalse();
			$scope.digital = true;
			$scope.titulo = "Acessos com a Digital";
			$('#tables').fadeIn();
		},function(error){
			$scope.erroAcesso = "Houve um erro, tente novamente!";
		});
	}
	
	$scope.acessoPortaria = function(){
		$http({
			method: 'GET',
			url: 'http://localhost:8080/AcessosPortaria'
		}).then(function(success){
			$scope.acessos = success.data;
			allFalse();
			$scope.portaria = true;
			$scope.titulo = "Acessos pela Portaria";
			$('#tables').fadeIn();
		},function(error){
			$scope.erroAcesso = "Houve um erro, tente novamente!";
		});
	}
	
	$scope.acessoGaragem = function(){
		$http({
			method: 'GET',
			url: 'http://localhost:8080/AcessosGaragem'
		}).then(function(success){
			$scope.acessos = success.data;
			allFalse();
			$scope.garagem = true;
			$scope.titulo = "Acessos pela Garagem";
			$('#tables').fadeIn();
		},function(error){
			$scope.erroAcesso = "Houve um erro, tente novamente!";
		});
	}
	
	$scope.acessoExterno = function(){
		$http({
			method: 'GET',
			url: 'http://localhost:8080/AcessosExterno'
		}).then(function(success){
			$scope.acessos = success.data;
			allFalse();
			$scope.externos = true;
			$scope.titulo = "Acessos de Externos";
			$('#tables').fadeIn();
		},function(error){
			$scope.erroAcesso = "Houve um erro, tente novamente!";
		});
	}
	
});