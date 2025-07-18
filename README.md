[![Published on Vaadin Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0?logo=vaadin)](https://vaadin.com/directory/component/leafletmap-for-vaadin)
[![Latest version](https://img.shields.io/maven-central/v/software.xdev/vaadin-maps-leaflet-flow?logo=apache%20maven)](https://mvnrepository.com/artifact/software.xdev/vaadin-maps-leaflet-flow)
[![Build](https://img.shields.io/github/actions/workflow/status/xdev-software/vaadin-maps-leaflet-flow/check-build.yml?branch=develop)](https://github.com/xdev-software/vaadin-maps-leaflet-flow/actions/workflows/check-build.yml?query=branch%3Adevelop)
![Vaadin 24+](https://img.shields.io/badge/Vaadin%20Platform/Flow-24+-00b4f0)

# LeafletMap for Vaadin
A Vaadin Flow Java API for [Leaflet](https://leafletjs.com/)

![demo](assets/demo.png)

## Usage

This API wraps the Leaflet API in a Vaadin friendly way.<br/>It uses a similar structure (classes, methods) as the [Leaflet JavaScript API](https://leafletjs.com/reference.html).

To get started it's recommended to have a look at the [demo](./vaadin-maps-leaflet-flow-demo), notably the [minimalistic example](./vaadin-maps-leaflet-flow-demo/src/main/java/software/xdev/vaadin/maps/leaflet/flow/demo/MinimalisticDemo.java).

> [!NOTE]
> **The API only supports sending instructions to the client**<br/>
> Due to data integrity retrieving client-side data (that can be modified by users) is not supported.
> 
> Event listeners can still be registered but this needs to be done manually. An example is available [in the demo](./vaadin-maps-leaflet-flow-demo/src/main/java/software/xdev/vaadin/maps/leaflet/flow/demo/EventDemo.java).
> 
> <details><summary>The following code snippet is a simplification of an even more <a href="./vaadin-maps-leaflet-flow-demo/src/main/java/software/xdev/vaadin/maps/leaflet/flow/demo/ComplexDemo.java#L251">complex example</a> which sends (unvalidated!) client side data back to the server (click to expand)</summary>
>
> ```java
> this.map.on("click", "e => document.getElementById('" + ID + "').$server.mapClicked(e.latlng.lat, e.latng.lng)");
> ...
> @ClientCallable
> public void mapClicked(double lat, double lng)
> {
>   LOG.info("Map clicked - lat: {}, lng: {}", lat, lng);
> }
> ```
> </details>

## Installation
[Installation guide of the latest release](https://github.com/xdev-software/vaadin-maps-leaflet-flow/releases/latest#Installation)

#### Static resources
Please note that Leaflet uses a few default icons for various components (e.g. Markers).<br/>
These are also shipped with the library and can be found inside [``META-INF/resources``](./vaadin-maps-leaflet-flow/src/main/resources/META-INF/resources/).<br/>
You might have to fine tune your security configuration to allow these.

#### Compatibility with Vaadin
| Vaadin version | vaadin-maps-leaflet-flow version |
| --- | --- |
| Vaadin 24+ (latest) | ``3+`` |

### Spring-Boot
* You may have to include ``software/xdev`` inside [``vaadin.allowed-packages``](https://vaadin.com/docs/latest/integrations/spring/configuration#configure-the-scanning-of-packages)

## Run the Demo
* Checkout the repo
* Run ``mvn install && mvn -f vaadin-maps-leaflet-flow-demo spring-boot:run``
* Open http://localhost:8080

<details>
  <summary>Show example</summary>
  
  ![demo](assets/demo.avif)
</details>

## Support
If you need support as soon as possible and you can't wait for any pull request, feel free to use [our support](https://xdev.software/en/services/support).

## Contributing
See the [contributing guide](./CONTRIBUTING.md) for detailed instructions on how to get started with our project.

## Dependencies and Licenses
View the [license of the current project](LICENSE) or the [summary including all dependencies](https://xdev-software.github.io/vaadin-maps-leaflet-flow/dependencies)
