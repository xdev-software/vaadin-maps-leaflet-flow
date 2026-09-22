# BOM - [Bill of Materials](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Bill_of_Materials_.28BOM.29_POMs)

Add it like this
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>software.xdev.vaadin.maps-leaflet</groupId>
            <artifactId>bom</artifactId>
            <version>...</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
