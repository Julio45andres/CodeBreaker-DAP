package udea.dap.codebreaker {
	import scala.util.Random
	class CodeBreaker(code: Array[Int]){

		def this(){
			this(Array(Random.nextInt(9), Random.nextInt(9), Random.nextInt(9), Random.nextInt(9)))
		}

		def gest(tryCode: Array[Int]): String = {
			tryCode match {
				case Array(a, b, c, d) => {
					gestDigit(a,1) + gestDigit(b,2) +gestDigit(c,3) + gestDigit(d,4)
				}	
			}
		}

		def gestDigit(digit: Int, position: Int): String = {
			code match {
				// case Array(a, b, c, d) if (digit == a && position == 1) => "x"
				case Array(a, b, c, d) if (digit == a || digit == b || digit == c || digit == d) => {
					// println(digit + " " position)
					if (digit == a && position == 1) "x"
					else if (digit == b && position == 2) "x"
					else if (digit == c && position == 3) "x"
					else if (digit == d && position == 4) "x"
					else "_"
				}
				case _ => ""
			}
		}
	
	}

}