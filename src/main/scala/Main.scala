
package com.thenewmotion.akka.rabbitmq
package examples

import akka.actor.{ ActorRef, ActorSystem }
import concurrent.ExecutionContext.Implicits.global

object Main extends App {
  implicit val system = ActorSystem()
  val factory = new ConnectionFactory()
  val host = sys.props.get("rabbitmq.port.5672.tcp.addr") getOrElse "127.0.0.1"
  factory.setHost(host)
  val connection = system.actorOf(ConnectionActor.props(factory), "rabbitmq")
  val exchange = "amq.fanout"

  def setupMessageEventSubscriber(channel: Channel, self: ActorRef) {
    val queue = channel.queueDeclare("message-event",false,false,false,new java.util.HashMap[String,AnyRef]()).getQueue
    channel.queueBind(queue, exchange, "")
    val consumer = new DefaultConsumer(channel) {
      override def handleDelivery(consumerTag: String, envelope: Envelope, properties: BasicProperties, body: Array[Byte]) {
        println("received message event: " + fromBytes(body))
      }
    }
    channel.basicConsume(queue, true, consumer)
  }
  connection ! CreateChannel(ChannelActor.props(setupMessageEventSubscriber), Some("messageSubscriber"))

  def fromBytes(x: Array[Byte]) = new String(x, "UTF-8")
}
