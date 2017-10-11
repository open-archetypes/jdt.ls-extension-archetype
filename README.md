JDT.LS Extension Maven archetype
================================

This Maven archetype will help you bootstrap the development of a [JDT.LS](https://github.com/eclipse/eclipse.jdt.ls/) extension, by creating a project with a nested structure :

     __artifactId__    : parent pom project
     |
     |---__artifactId__.core   : Core extension
     |
     |---__artifactId__.test   : Test extension (Fragment project)
     |
     |---__artifactId__.site : p2 update site

The generated plugin extends the JDT.LS by [contributing a custom command](https://github.com/eclipse/eclipse.jdt.ls/wiki/Contribute-an-extension-bundle), implementing `org.eclipse.jdt.ls.core.internal.IDelegateCommandHandler` 

Pre-Requisites :
-------------------

* Java 1.8
* maven 3.0 or later
* Eclipse Oxygen with PDE or later
* m2e 1.8 or later
* m2eclipse-tycho 0.8 or later

Accessing the archetype from Eclipse
-------------------
In Eclipse, first add the Open Archetypes catalog :

1. On the Archetypes Preferences page (Windows: `Window` > `Preferences`; OS X: `Eclipse`> `Preferences` or `⌘,`), open `Maven` > `Archetypes`, click on the `Add Remote Catalog...` button

    - Catalog file : http://open-archetypes.github.com/maven-repo/releases/
    - Description : `Open Archetypes`

2. Click `OK` to close the dialog
3. Click `OK` to close the preferences
 
Accessing the archetype from command line
-------------------
Open your terminal or Windows CMD:

1. Execute `mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -DarchetypeCatalog=http://open-archetypes.github.com/maven-repo/releases/ -DarchetypeGroupId=org.openarchetypes -DarchetypeArtifactId=jdt.ls-extension-archetype`
2. Enter the groupId
3. Enter the artifactId
4. Enter the name of the package under which your code will be created
5. Enter the version of your project
6. Confirm

Creating a new project in Eclipse, using the Maven wizard
-------------------

1. Create a new Maven project
* Click `Next` to land on the Archetype page
* Select the `Open Archetypes` catalog
* Select `jdt.ls-extension` and click Next
* Enter the Group Id, Artifact Id and Version informations. Eclipse requires the version to follow a Major.Minor.Micro pattern, so you should use 1.0.0-SNAPSHOT instead of 1.0-SNAPSHOT
* You can change the required properties if needed :
    - java_version : The Java version to be used for compiling the plugins. Supported values are `1.8`, `9`. Defaults to `1.8`
    - tycho_version : the tycho version that will be used to build the project in command line. Defaults to `1.0.0`
    - eclipse_platform : the Eclipse platform, will drive what eclipse update site will be used to resolve the Eclipse dependencies.
    Supported values are : `oxygen`, `photon`. Defaults to `oxygen` .
* Hit `Finish`
* Wait for awesomeness

Once the projects are created, you'll just have to start coding ...

Building the project with Maven
-------------------
You can then build your projects in command line, in a terminal, by issuing :

    mvn clean verify

A zipped update site will be created as `<project.parent>/<project.site>/target/<project.site>-<project.version>-site.zip`.

Signed artifacts
-------------------
If the project was created with the `eclipse_org_signing` property set to `true`, then a `sign` profile to sign the generated jars will be available to use, when building the project on the Eclipse.org infrastructure, using :

    mvn package -Psign


