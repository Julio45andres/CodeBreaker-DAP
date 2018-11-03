import org.scalatest._
import udea.dap.codebreaker._

class CodeBreakerSpec extends FunSuite with DiagrammedAssertions {

	var breaker: CodeBreaker = null;

  test("all pass gest_1234 should be xxxx") {
    // arrange
		breaker = new CodeBreaker(Array(1, 2, 3, 4))
		// act
		val result: String = breaker.gest(Array(1, 2, 3, 4))
		// assert
		assert("xxxx" equals result)
  }

  test("all fall gest_9876 should be ''"){
	  // arrange
	  breaker = new CodeBreaker(Array(1,2,3,4))
	  // act
	  val result: String = breaker.gest(Array(9,8,7,6))
	  // assert
	  assert("" equals result)
  }

	test("one coincidence pass gest_1000 should be x") {
    // arrange
		breaker = new CodeBreaker(Array(1, 2, 3, 4))
		// act
		val result: String = breaker.gest(Array(1, 0, 0, 0))
		// assert
		assert("x" equals result)
  }

	test("two coincidence pass gest_1200 should be xx") {
    // arrange
		breaker = new CodeBreaker(Array(1, 2, 3, 4))
		// act
		val result: String = breaker.gest(Array(1, 2, 0, 0))
		// assert
		assert("xx" equals result)
  }

	test("three coincidence pass gest_1230 should be xxx") {
    // arrange
		breaker = new CodeBreaker(Array(1, 2, 3, 4))
		// act
		val result: String = breaker.gest(Array(1, 2, 3, 0))
		// assert
		assert("xxx" equals result)
  }

	test("one pass gestDigit diferent position should be _"){
	  // arrange
	  breaker = new CodeBreaker(Array(1,2,3,4))
	  // act
	  val result: String = breaker.gest(Array(0,1,0,0))
	  // assert
	  assert("_" equals result)
  }

	test("two pass gestDigit diferent position should be __"){
	  // arrange
	  breaker = new CodeBreaker(Array(1,2,3,4))
	  // act
	  val result: String = breaker.gest(Array(0,1,2,0))
	  // assert
	  assert("__" equals result)
  }
	test("three pass gestDigit diferent position should be ___"){
	  // arrange
	  breaker = new CodeBreaker(Array(1,2,3,4))
	  // act
	  val result: String = breaker.gest(Array(0,1,2,3))
	  // assert
	  assert("___" equals result)
  }

	test("four pass gestDigit diferent position should be ____"){
	  // arrange
	  breaker = new CodeBreaker(Array(1,2,3,4))
	  // act
	  val result: String = breaker.gest(Array(4,1,2,3))
	  // assert
	  assert("____" equals result)
  }
}