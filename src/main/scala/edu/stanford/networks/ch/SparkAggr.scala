package edu.stanford.networks.ch

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SparkAggr {
  def main(args: Array[String]) {
    //val logFile = "hdfs://localhost:9000/test/tsv-test-input-set1.txt" // Should be some file on your system
    val logFile = "resources/cal.cedge"
    val conf = new SparkConf().setAppName("Test")
      .setMaster("local[8]")
      .set("spark.executor.memory", "1g")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}