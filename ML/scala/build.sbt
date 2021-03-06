name := "iotstreamml"

version := "0.0.1"

scalaVersion := "2.11.8"
val sparkVersion = "2.4.0"

// additional libraries
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-streaming-kafka-0-8" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-streaming-kafka-assembly" % "1.6.3",
  "org.apache.bahir" %% "spark-streaming-mqtt" % "2.2.0",
  "org.slf4j" % "slf4j-log4j12" % "1.7.25",
  "com.amazonaws" % "aws-java-sdk" % "1.7.4",
  "org.apache.hadoop" % "hadoop-aws" % "2.7.3",
)

assemblyMergeStrategy in assembly := {
  case PathList("com", "sun", xs @ _*) => MergeStrategy.last
  case PathList("com", "thoughtworks", xs @ _*) => MergeStrategy.last
  case PathList("commons-beanutils", xs @ _*) => MergeStrategy.last
  case PathList("javax", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", "spark", "unused", "UnusedStubClass.class") => MergeStrategy.last
  case PathList("org", "apache", "avro", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", "commons", xs @ _*) => MergeStrategy.last
  case PathList("org", "codehaus", xs @ _*) => MergeStrategy.last
  case PathList("org", "tukaani", xs @ _*) => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
