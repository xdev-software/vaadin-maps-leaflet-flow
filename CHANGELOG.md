## 3.0.1
* Updated dependencies
  * Updated leaflet to [``1.9.4``](https://github.com/Leaflet/Leaflet/blob/b6b56f6e707142c177fad2f67827a5007e56736a/CHANGELOG.md#194-2023-05-18) #247

## 3.0.0
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
* Update to Vaadin 23
  * Removed deprecated polymer-connector - replaced by ``executeJs``
* Fixed a problem where the map was not rendered/aligned correctly
* Don't load anything from remote servers that are not under control of the user
* Shrunk the jar
* Removed default leafletmap tile layer; has to be set manually due to usage policy
* Updated dependency versions
