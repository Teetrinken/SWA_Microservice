
angular.
  module('parcelConfig').
  component('parcelSize', {
    transclude: true,
    template:
        '<div class="w3-panel w3-card-2">'+
            '<div class="w3-container w3-teal">'+
                '<h2>Paketgröße</h2>'+
            '</div>' +
            '<form class="w3-container">'+
                '<div class="w3-row">'+
   		            '<label>Länge</label>'+
   		            '<input class="w3-input" id="cfg-recp-firm" type="number" ng-model="$ctrl.request.length"></input>'+
                '</div>'+
                '<div class="w3-row">'+
   		            '<label>Breite</label>'+
   		            '<input class="w3-input" id="cfg-recp-firm" type="number" ng-model="$ctrl.request.width"></input>'+
                '</div>'+
                '<div class="w3-row">'+
   		            '<label>Höhe</label>'+
   		            '<input class="w3-input" id="cfg-recp-firm" type="number" ng-model="$ctrl.request.height"></input>'+
   		        '</div>'+
            '</form>'+
            '<button style="margin-top:20px" class="w3-button w3-teal" ng-click="$ctrl.calcSize()">Größe berechnen</button>'+
            '<p>Paketgröße: {{ $root.parcelsize }}</p>'+
        '</div>',
      
  controller: function ParcelSizeController($rootScope, $http) {
      
    this.request = {
        length: 0,
        width: 0,
        height: 0,
        size: ''
    };  
    
    this.calcSize = function(){
        this.jsonObject = angular.toJson(this.request, false);
        console.log("JSON-Object: ", this.jsonObject);

        $http({
            url: "http://localhost:8000/parcel/size/calculate", 
            method: "POST",
            data: this.jsonObject,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response) {
            console.log("Response: ", response);
            $rootScope.parcelsize = response.data.size;
        });
    }
  }
});