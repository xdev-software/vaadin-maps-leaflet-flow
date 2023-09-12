## 4.0.0
⚠️<i>This release contains breaking changes</i>

* The complete API got reworked and now has the [same structure as Leaflet](https://leafletjs.com/reference.html).
* Implemented a lot of new Leaflet APIs - Currently around 90% of the Leaflet API are implemented. These include the most useful bits:
  * GeoLocation
  * A lot of new methods for Map
  * Tooltips & Popups
  * Image, Video and SVG-Overlays
  * Rectangles
  * Controls for Scale, Layers, ...
  * and much more
* Abstracted the elements similar to how this is done inside Leaflet itself so that they can easily be extended
* The API only supports sending instructions to the client. Retrieving client side data is not supported as it can't be data integrity guaranteed (data on client can be modified).
  * Event listeners can still be registered but this needs to be done manually. A example is available in the demo.
* All Leaflet elements are now tracked on the client and on the server and can therefore be modified/reused.
  * Before it was only possible to create an element and then send it to the client
  * However keep in mind when creating a lot of elements that you may have to free up memory on the client (manually)

## 3.0.2
* Added support for Polyline #266 (thanks to @blitzdose)

## 3.0.1
* Fixed ``divIcon`` being displayed incorrectly [due to a default ``iconSize`` of ``12px``](https://github.com/Leaflet/Leaflet/issues/4238) #246
* Updated dependencies
  * Updated leaflet to [``1.9.4``](https://github.com/Leaflet/Leaflet/blob/b6b56f6e707142c177fad2f67827a5007e56736a/CHANGELOG.md#194-2023-05-18) #247

## 3.0.0
⚠️<i>This release contains breaking changes</i>

* Adds support for Vaadin 24+, drops support for Vaadin 23<br/>
  <i>If you are still using Vaadin 23, use the ``2.x`` versions.</i>
  * Requires Java 17+

## 2.0.4
* Added method ``centerAndZoom`` in ``LMap``
* Fixed a problem where an invalid ``iconSize`` was transferred to leaflet which caused a client side exception (#199)
* Updated various dependencies

## 2.0.3
* Updated dependencies
* Fixed problem with setting lon/lan in LMarker
* Added constructors for LMap

## 2.0.2
* Updated dependencies

## 2.0.1
* Updated dependencies
  * Vaadin 23.2

## 2.0.0
⚠️<i>This release contains breaking changes</i>

* Update to Vaadin 23
  * Removed deprecated polymer-connector - replaced by ``executeJs``
* Fixed a problem where the map was not rendered/aligned correctly
* Don't load anything from remote servers that are not under control of the user
* Shrunk the jar
* Removed default leafletmap tile layer; has to be set manually due to usage policy
* Updated dependency versions
