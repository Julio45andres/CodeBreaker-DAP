import udea.dap.codebreaker._

object dojo {
	def main(args: Array[String]): Unit = {
	    val breaker = new CodeBreaker()
		println("Ingrese un código de 4 dígitos:")
		val input = readLine()
		if (input.length == 4){
			val a:Int = input(0).asDigit
			val b = input(1).asDigit
			val c = input(2).asDigit
			val d = input(3).asDigit
			val result: String = breaker.gest(Array(a, b, c, d))
			println("Resultado: " + result + " : " + a + b + c +d)
		}
    }
}