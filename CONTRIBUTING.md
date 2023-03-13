## Contributing

We would absolutely love to get the community involved, and we welcome any form of contributions – comments and questions on different communication channels, issues and pull request in the repositories, and anything that you build and share using our components.

### Get in touch with the team

Twitter: https://twitter.com/xdevsoftware 
<br/>
Mail: opensource@xdev-software.de

### Some ways to help:

- **Report bugs**: File issues on GitHub.
- **Send pull requests**: If you want to contribute code, check out the development instructions below.

We encourage you to read the [contribution instructions by GitHub](https://guides.github.com/activities/contributing-to-open-source/#contributing) also.

## Developing

### Software Requirements
You should have the following things installed:
* Git
* Java 11 or 17 - should be as unmodified as possible (Recommended: [Eclipse Adoptium](https://adoptium.net/temurin/releases/))
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
  You can control this behavior with the ``vaadin.devmode.liveReload.enabled`` property (default: ``true``).

## Releasing [![Build](https://img.shields.io/github/actions/workflow/status/xdev-software/vaadin-addon-template/release.yml?branch=master)](https://github.com/xdev-software/vaadin-addon-template/actions/workflows/release.yml)

Before releasing:
* Consider doing a [test-deployment](https://github.com/xdev-software/vaadin-addon-template/actions/workflows/test-deploy.yml?query=branch%3Adevelop) before actually releasing.
* Check the [changelog](CHANGELOG.md)

If the ``develop`` is ready for release, create a pull request to the ``master``-Branch and merge the changes

When the release is finished do the following:
* Merge the auto-generated PR (with the incremented version number) back into the ``develop``
* Ensure that [Vaadin Directory](https://vaadin.com/directory) syncs the update and maybe update the component / version there
