package edu.stanford.networks.ch

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import org.apache.spark.util.BoundedPriorityQueue

object GraphTest {
  def main(args: Array[String]) {
    val roadNetwork = "resources/cal.cedge"
    val conf = new SparkConf().setAppName("Test")
      .setMaster("local[8]")
      .set("spark.executor.memory", "1g")
    val sc = new SparkContext(conf)

    val edges: RDD[Edge[String]] =
      sc.textFile(roadNetwork).map { line =>
        val fields = line.split(" ")
        Edge(fields(1).toLong, fields(2).toLong, fields(1))
      }

    val graph : Graph[Any, String] = Graph.fromEdges(edges, "defaultProperty")
    graph.subgraph(epred, vpred)
    println("edges:"+graph.edges.count())
    println("vertices"+graph.vertices.count())
//    val que = new BoundedPriorityQueue[String](5)
    

  }
}