import udea.dap.codebreaker._
import udea.dap.server._
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.Done
import akka.actor.Status.Success
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol
import spray.json.DefaultJsonProtocol._
import spray.json._

import scala.util.parsing.json._
import scala.io.StdIn
import scala.concurrent.Future

object dojo {
	// machete 1
	implicit val system = ActorSystem()
	implicit val materializer = ActorMaterializer()
	implicit val executionContext = system.dispatcher
	// machete 2
	implicit val codeFormat = jsonFormat1(Code)
	// object CodeBreakerProtocol extends DefaultJsonProtocol {
	// 	implicit val codeProtocol = jsonFormat(Code.apply)
	// }
	def main(args: Array[String]): Unit = {

		val route: Route = get {
			pathPrefix("guess" / IntNumber) {
				gess => 
					val maybeGuess: Future[Option[Code]] = WebServer.fetchGuess(gess.toString)

					onSuccess(maybeGuess){
						case Some(some: Code) => {
							val breaker = new CodeBreaker()
							println("Ingrese un código de 4 dígitos:")
							val input = some.value
							var response = ""
							if (input.length == 4){
								val a:Int = input.charAt(0).asDigit
								val b = input.charAt(1).asDigit
								val c = input.charAt(2).asDigit
								val d = input.charAt(3).asDigit
								val result: String = breaker.gest(Array(a, b, c, d))
								response = "Resultado: " + result + " : " + a + b + c + d
							}
							else response = "No válido"
							complete(response)
						}
						case None => complete(StatusCodes.NotFound)
					
				}
			}
		}

		val bindFuture = Http().bindAndHandle(route, "localhost", 8080)
		println(s"Server online at http://localhost:8080/\nPress Return to stop")
		StdIn.readLine()
		bindFuture
		.flatMap(_.unbind())
      	.onComplete(_ => system.terminate())
	    // val breaker = new CodeBreaker()
		// println("Ingrese un código de 4 dígitos:")
		// val input = readLine()
		// if (input.length == 4){
		// 	val a:Int = input(0).asDigit
		// 	val b = input(1).asDigit
		// 	val c = input(2).asDigit
		// 	val d = input(3).asDigit
		// 	val result: String = breaker.gest(Array(a, b, c, d))
		// 	println("Resultado: " + result + " : " + a + b + c +d)
		// }
    }
}