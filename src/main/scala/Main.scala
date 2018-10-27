import udea.dap.codebreaker._

object dojo {
	def main(args: Array[String]): Unit = {
	    val breaker = new CodeBreaker()
		val result: String = breaker.gest(Array(1, 2, 3, 4))
		println("Resultado: " + result)
    }
}