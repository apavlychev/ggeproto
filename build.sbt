ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val packagePrefix = "ru.ggeproto"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(main, admin)
  .aggregate(main, admin)

//apps
lazy val main = (project in file("apps/main"))
    .enablePlugins(PlayScala)
    .settings(
        name := """main""",
        idePackagePrefix := Some(packagePrefix + ".apps.main"),
        libraryDependencies ++= Seq(
            guice
        )
    )
    .dependsOn(async, counter, api)

lazy val admin = (project in file("apps/admin"))
    .enablePlugins(PlayScala)
    .settings(
        name := """admin""",
        idePackagePrefix := Some(packagePrefix + ".apps.admin"),
        libraryDependencies ++= Seq(
            guice
        )
    )
    .dependsOn(entity, api, uiCommon, async, counter)

//models
lazy val entity: Project = (project in file("models/entity"))
    .enablePlugins(PlayScala)
    .settings(
        name := """entity""",
        idePackagePrefix := Some(packagePrefix + ".models.entity"),
        libraryDependencies ++= Seq(
            guice
        )
    )

//infrastructure
lazy val common = (project in file("inf/common"))
    .enablePlugins(PlayScala)
    .settings(
        name := """common""",
        idePackagePrefix := Some(packagePrefix + ".inf.common"),
        libraryDependencies ++= Seq(
            guice
        )
    )

lazy val uiCommon = (project in file("inf/uiCommon"))
    .enablePlugins(PlayScala)
    .settings(
        name := """uiCommon""",
        idePackagePrefix := Some(packagePrefix + ".inf.ui.common"),
        libraryDependencies ++= Seq(
            guice
        )
    )
    .dependsOn(common, entity, api)

//domain
lazy val api: Project = (project in file("domain/api"))
    .enablePlugins(PlayScala)
    .settings(
        name := """api""",
        idePackagePrefix := Some(packagePrefix + ".domain.api"),
        libraryDependencies ++= Seq(
            guice
        ),
        aggregateReverseRoutes := Seq(async, counter)
    )
    .dependsOn(entity)

lazy val async = (project in file("domain/async"))
    .enablePlugins(PlayScala)
    .settings(
        name := """async""",
        idePackagePrefix := Some(packagePrefix + ".domain.async"),
        libraryDependencies ++= Seq(
            guice
        )
    )
    .dependsOn(entity, api, uiCommon)

lazy val counter = (project in file("domain/counter"))
    .enablePlugins(PlayScala)
    .settings(
        name := """counter""",
        idePackagePrefix := Some(packagePrefix + ".domain.counter"),
        libraryDependencies ++= Seq(
            guice
        )
    )
    .dependsOn(entity, api, uiCommon)

