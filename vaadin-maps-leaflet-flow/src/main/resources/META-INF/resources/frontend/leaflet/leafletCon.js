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
            id: {
                type: String
            },
            map: {
                type: Object,
                notify: true
            },
            items: {
                type: Array,
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

    _initMap() {
        super.ready();
        this.map = new L.map(this.$.divMap);

        var tile = L.tileLayer(
            "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
                attribution: '© <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>',
                maxZoom: 18
            }
        ).addTo(this.map);

        this.items = new Array();
    }

    addMarker(obj, icon, divicon) {
        var defaultIcon = new L.Icon({
            iconUrl: "https://unpkg.com/leaflet@1.6.0/dist/images/marker-icon.png",
            iconRetinaUrl: "https://unpkg.com/leaflet@1.6.0/dist/images/marker-icon-2x.png",
            iconSize: [25, 41],
            iconAnchor: [12, 41],
            popupAnchor: [1, -34],
            shadowUrl: "https://unpkg.com/leaflet@1.6.0/dist/images/marker-shadow.png",
            shadowSize: [41, 41]
        });

        var customIcon;
        if (icon !== undefined && divicon == true) {
            customIcon = new L.divIcon(icon.icon);
        } else if (icon !== undefined && divicon == false) {
            customIcon = new L.Icon(icon.icon);
        }

        var item = L.geoJson(obj, {
            pointToLayer: function (feature, latlng) {
                if (icon === undefined) {
                    return L.marker(latlng, {
                        icon: defaultIcon
                    });
                } else {
                    return L.marker(latlng, {
                        icon: customIcon
                    });
                }
            }
        }).addTo(this.map);
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