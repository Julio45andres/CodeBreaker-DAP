package udea.dap.server {
	import akka.actor.ActorSystem
	import akka.http.scaladsl.Http
	import akka.stream.ActorMaterializer
	import akka.Done
	import akka.actor.Status.Success
	import akka.http.scaladsl.server.Route
	import akka.http.scaladsl.server.Directives._
	import akka.http.scaladsl.model.StatusCodes
	import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
	import scala.concurrent.Future
	import udea.dap.codebreaker._

	case class Code(value: String)
	object WebServer {
		implicit val system = ActorSystem()
  		implicit val materializer = ActorMaterializer()
	  	implicit val executionContext = system.dispatcher

		var codeBreaker: CodeBreaker = _

		def fetchGuess(code: String): Future[Option[Code]] = Future {
			println("dd")
			val _code: Code = Code(value = code)
			Option(_code)
		}
	}
}