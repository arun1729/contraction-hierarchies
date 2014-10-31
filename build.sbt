name := "sparktest"

organization := "edu.stanford"

version := "0.1"

scalaVersion := "2.10.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
	"typesafe"				at		"http://repo.typesafe.com/typesafe/releases",
	"artifactory"			at		"http://scalasbt.artifactoryonline.com/scalasbt/",
	"Maven Central"			at		"http://repo1.maven.org/maven2/"
)

libraryDependencies ++= Seq(
	"com.lexicalscope.jewelcli"		%	"jewelcli"				%	"0.8.9",
	"joda-time"						%	"joda-time"				%	"2.3",
	"org.scalatest"					%%  "scalatest"				%   "2.1.7",
	"org.scalacheck"				%%  "scalacheck"			%	"1.11.4",
	"com.typesafe"                  %   "config"            	%   "1.0.0",
	"org.apache.spark" 				%	"spark-core_2.10"		%	"1.0.0",
	"org.apache.hadoop"				%	"hadoop-client"			%	"2.4.0"
)

scalariformSettings