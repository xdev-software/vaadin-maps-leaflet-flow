[![Published on Vaadin Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/vaadin-addon-template)
[![Latest version](https://img.shields.io/maven-central/v/com.xdev-software/vaadin-addon-template)](https://mvnrepository.com/artifact/com.xdev-software/vaadin-addon-template)
[![Build](https://img.shields.io/github/actions/workflow/status/xdev-software/vaadin-addon-template/checkBuild.yml?branch=develop)](https://github.com/xdev-software/vaadin-addon-template/actions/workflows/checkBuild.yml?query=branch%3Adevelop)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=xdev-software_vaadin-addon-template&metric=alert_status)](https://sonarcloud.io/dashboard?id=xdev-software_vaadin-addon-template)
![Vaadin 23+](https://img.shields.io/badge/Vaadin%20Platform/Flow-23+-00b4f0.svg)

# vaadin-addon-template
A Vaadin Template Repo

![demo](assets/demo.png)


## Installation
[Installation guide for the latest release](https://github.com/xdev-software/vaadin-addon-template/releases/latest#Installation)


## Run the Demo
* Checkout the repo
* Run ``mvn install && mvn -f vaadin-addon-template-demo spring-boot:run``
* Open http://localhost:8080


<details>
  <summary>Show example</summary>
  
  ![demo](assets/demo.gif)
</details>


## Dependencies and Licenses
View the [license of the current project](LICENSE) or the [summary including all dependencies](https://xdev-software.github.io/vaadin-addon-template/dependencies/)


## Releasing [![Build](https://img.shields.io/github/actions/workflow/status/xdev-software/vaadin-addon-template/release.yml?branch=master)](https://github.com/xdev-software/vaadin-addon-template/actions/workflows/release.yml)

Before releasing:
* Consider doing a [test-deployment](https://github.com/xdev-software/vaadin-addon-template/actions/workflows/test-deploy.yml?query=branch%3Adevelop) before actually releasing.
* Check the [changelog](CHANGELOG.md)

If the ``develop`` is ready for release, create a pull request to the ``master``-Branch and merge the changes

When the release is finished do the following:
* Merge the auto-generated PR (with the incremented version number) back into the ``develop``
* Upload the generated release asset zip into the [Vaadin Directory](https://vaadin.com/directory) and update the component there


## Developing

### Software Requirements
You should have the following things installed:
* Git
* Java 11 - should be as unmodified as possible (Recommended: [Eclipse Adoptium](https://adoptium.net/temurin/releases/))
* Maven

### Recommended setup
* Install ``IntelliJ`` (Community Edition is sufficient)
  * Install the following plugins:
    * [Save Actions](https://plugins.jetbrains.com/plugin/7642-save-actions) - Provides save actions, like running the formatter or adding ``final`` to fields
    * [SonarLint](https://plugins.jetbrains.com/plugin/7973-sonarlint) - CodeStyle/CodeAnalysis
    * [Checkstyle-IDEA](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea) - CodeStyle/CodeAnalysis
  * Import the project
  * Ensure that everything is encoded in ``UTF-8``
  * Ensure that the JDK/Java-Version is correct
  * To enable AUTOMATIC reloading/restarting while developing and running the app do this (further information in "
    SpringBoot-Devtools" section below; [Source](https://stackoverflow.com/q/33349456)):
    * ``Settings > Build, Execution, Deployment > Compiler``:<br/>
      Enable [``Build project automatically``](https://www.jetbrains.com/help/idea/compiling-applications.html#auto-build)
    * ``Settings > Advanced Settings``:<br/>
    Enable [``Allow auto-make to start even if developed application is currently running``](https://www.jetbrains.com/help/idea/advanced-settings.html#advanced_compiler)
  * To launch the Demo execute the predefined (launch) configuration ``Run Demo``

#### [SpringBoot-Developer-Tools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools) 
... should automatically be enabled.<br/>
If you are changing a file and build the project, parts of the app get  restarted.<br/>
Bigger changes may require a complete restart.
  * [Vaadin automatically reloads the UI on each restart](https://vaadin.com/docs/latest/configuration/live-reload/spring-boot).<br/>
  You can control this behavior with the ``vaadin.devmode.liveReload.enabled`` property (default: ``true``).<br/>