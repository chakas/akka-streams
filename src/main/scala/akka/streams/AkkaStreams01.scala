package akka.streams

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ClosedShape}
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, RunnableGraph, Sink, Source}

import scala.concurrent.Future

object AkkaStreams01 extends App{
  // create actor system
  implicit val actorSystem = ActorSystem("actor-system")
  implicit val actorMaterializer = ActorMaterializer()
  //source
  // First Value Int -> Data type which source emits
  // Second value NotUsed -> Materialized value
  val source = Source(1 to 1000)
  val output = Sink.foreach[Int](i => println(i))

  val graph = RunnableGraph.fromGraph(
    GraphDSL.create(){implicit builder =>
      import GraphDSL.Implicits._

      builder.add(Broadcast[Int](2))
      ClosedShape
    }
  )
}
