
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
   		            '<input class="w3-input" id="cfg-recp-firm" type="number" ng-model="$ctrl.parcelsize.length"></input>'+
                '</div>'+
                '<div class="w3-row">'+
   		            '<label>Breite</label>'+
   		            '<input class="w3-input" id="cfg-recp-firm" type="number" ng-model="$ctrl.parcelsize.width"></input>'+
                '</div>'+
                '<div class="w3-row">'+
   		            '<label>Höhe</label>'+
   		            '<input class="w3-input" id="cfg-recp-firm" type="number" ng-model="$ctrl.parcelsize.depth"></input>'+
   		        '</div>'+
            '</form>'+
            '<button style="margin-top:20px" class="w3-button w3-teal" ng-click="$ctrl.calcSize()">Größe berechnen</button>'+
            '<p>Paketgröße: {{ $ctrl.parcelsize.size }}</p>'+
        '</div>',
      
  controller: function ParcelSizeController() {
      
      this.parcelsize = {
          length: 0,
          width: 0,
          depth: 0,
          size: ''
      };
    
      this.calcSize = function(){
        this.parcelsize.size = 'S';
    }
  }
});