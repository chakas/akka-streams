import java.util.concurrent.atomic.AtomicInteger

import akka.actor._
import com.typesafe.config.ConfigFactory

class CounterActor extends Actor with ActorLogging {
  var count = 0
  override def receive: Receive = {
    case "Increment" => count += 1
    case "Decrement" => count -= 1
    case "Print" => println(count)
  }
}

case class TestDb(loglevel: String)

object SampleApp extends App {
  val actorSystem = ActorSystem("actor-system")
  val propsActor = actorSystem.actorOf(Props[CounterActor])

  propsActor ! "Increment"
  propsActor ! "Increment"
  propsActor ! "Increment"
  propsActor ! "Decrement"
  propsActor ! "Print"

  val config = ConfigFactory.load()
  println(config.getConfig("test-db").getString("loglevel"))

  actorSystem.terminate()
}
