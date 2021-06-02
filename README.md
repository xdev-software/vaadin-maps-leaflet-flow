[![Published on Vaadin Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/leafletmap-for-vaadin)
[![Latest version](https://img.shields.io/maven-central/v/com.xdev-software/vaadin-maps-leaflet-flow)](https://mvnrepository.com/artifact/com.xdev-software/vaadin-maps-leaflet-flow)
[![Build](https://img.shields.io/github/workflow/status/xdev-software/vaadin-maps-leaflet-flow/Check%20Build/develop)](https://github.com/xdev-software/vaadin-maps-leaflet-flow/actions/workflows/checkBuild.yml?query=branch%3Adevelop)

# vaadin-maps-leaflet-flow
Vaadin Flow Java API for [Leaflet Maps](https://leafletjs.com/) Component

<img src="demo.png" height=550></img>

## Installation
[Installation guide of the latest release](https://github.com/xdev-software/vaadin-maps-leaflet-flow/releases/latest#Installation)

## Run the Demo
* Checkout the repo
* Run ``mvn clean install``
* Navigate into ``vaadin-maps-leaflet-flow-demo`` 
* Run ``mvn jetty:run``
* Open http://localhost:8080

<details>
  <summary>Show example</summary>
  
  ![demo](demo.gif)
</details>


## Releasing [![Build](https://img.shields.io/github/workflow/status/xdev-software/vaadin-maps-leaflet-flow/Release?label=Release)](https://github.com/xdev-software/vaadin-maps-leaflet-flow/actions/workflows/release.yml)
If the ``develop`` is ready for release, create a pull request to the ``master``-Branch and merge the changes

When the release is finished do the following:
* Merge the auto-generated PR (with the incremented version number) back into the ``develop``
* Add the release notes to the [GitHub release](https://github.com/xdev-software/vaadin-maps-leaflet-flow/releases/latest)
* Upload the generated release asset zip into the [Vaadin Directory](https://vaadin.com/directory)

## Dependencies and Licenses
View the [license of the current project](LICENSE) or the [summary including all dependencies](https://xdev-software.github.io/vaadin-maps-leaflet-flow/dependencies/)
