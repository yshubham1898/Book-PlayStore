
name := """BookStore"""
organization := "com.shubham"

version := "1.0-SNAPSHOT"

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.8"

libraryDependencies += guice


