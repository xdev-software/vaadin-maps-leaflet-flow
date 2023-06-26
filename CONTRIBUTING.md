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
* Java 17 - should be as unmodified as possible (Recommended: [Eclipse Adoptium](https://adoptium.net/temurin/releases/))
* Maven

### Recommended setup
* Install ``IntelliJ`` (Community Edition is sufficient)
  * Install the following plugins:
    * [Save Actions](https://plugins.jetbrains.com/plugin/22113) - Provides save actions, like running the formatter or adding ``final`` to fields
    * [SonarLint](https://plugins.jetbrains.com/plugin/7973-sonarlint) - CodeStyle/CodeAnalysis
    * [Checkstyle-IDEA](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea) - CodeStyle/CodeAnalysis
  * Import the project
  * Ensure that everything is encoded in ``UTF-8``
  * Ensure that the JDK/Java-Version is correct


## Releasing [![Build](https://img.shields.io/github/actions/workflow/status/xdev-software/standard-maven-template/release.yml?branch=master)](https://github.com/xdev-software/standard-maven-template/actions/workflows/release.yml)

Before releasing:
* Consider doing a [test-deployment](https://github.com/xdev-software/standard-maven-template/actions/workflows/test-deploy.yml?query=branch%3Adevelop) before actually releasing.
* Check the [changelog](CHANGELOG.md)

If the ``develop`` is ready for release, create a pull request to the ``master``-Branch and merge the changes

When the release is finished do the following:
* Merge the auto-generated PR (with the incremented version number) back into the ``develop``
