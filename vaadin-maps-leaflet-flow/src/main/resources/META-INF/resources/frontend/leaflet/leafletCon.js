import {html,PolymerElement} from "@polymer/polymer/polymer-element.js";
import "leaflet/dist/leaflet.js";

export class LeafletMap extends PolymerElement {
    static get template() {
        return html `
      <link
        rel="stylesheet"
        href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
      />

      <style>
        #map-container {
          width: 100%;
          height: 100%;
        }
        #divMap {
          width: 100%;
          height: 100%;
        }
      </style>
      <div id="divMap"></div>
    `;
    }

    static get properties() {
        return {
            map: {
                type: Object,
                notify: true
            },
            items: {
                type: Array,
                notify: true
            },
            tile: {
                type: Object,
                notify: true
            }
        };
    }

    ready() {
        this._initMap();
    }

    setViewPoint(obj) {
        this.map.setView(obj.point.coordinates, obj.point.zoom);
    }
    
    setTileLayer(layer)
    {     
        this.tile = L.tileLayer(layer.tile.link,{attribution: layer.tile.attribution, maxZoom: layer.tile.zoom, id: layer.tile.id}).addTo(this.map);
        this.tile.bringToFront();
    }

    setZoomLevel(zoom)
    {
        this.map.setZoom(zoom);
    }

    _initMap() {
        super.ready();
        this.map = new L.map(this.$.divMap);

        this.tile = L.tileLayer(
            "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
                attribution: '© <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>',
                maxZoom: 18
            }
        ).addTo(this.map);

        this.items = new Array();
    }

    addMarker(obj) {
      
        var leafIcon;
        if (obj.properties.icon.type == 'DivIcon') {
            leafIcon = new L.divIcon(obj.properties.icon);
        } else {
            leafIcon = new L.Icon(obj.properties.icon);
        }    
        var item = L.marker(obj.geometry.coordinates, {icon: leafIcon}).addTo(this.map);
       
        if (obj.properties.popup != null) {
            item.bindPopup(obj.properties.popup);
        }

        this.items.push(item);
    }

    deleteItem(index) {
        var delItem = this.items[index];
        delItem.remove();
        this.items.splice(index, 1);
    }

    addPolygon(obj) {
        var item = L.polygon(obj.geometry.coordinates, obj.properties).addTo(
            this.map
        );

        if (obj.properties.popup != null) {
            item.bindPopup(obj.properties.popup);
        }

        this.items.push(item);
    }

    addCircle(obj) {
        var item = L.circle(obj.geometry.coords, obj.properties).addTo(this.map);
        if (obj.properties.popup != null) {
            item.bindPopup(obj.properties.popup);
        }

        this.items.push(item);
    }
}

customElements.define("leaflet-map", LeafletMap);