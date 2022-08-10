## 2.0.0

* Update to Vaadin 23
  * Removed deprecated polymer-connector - replaced by ``executeJs``
* Fixed a problem where the map was not rendered/aligned correctly
* Don't load anything from remote servers that are not under control of the user
* Shrunk the jar
* Removed default leafletmap tile layer; has to be set manually due to usage policy
* Updated dependency versions