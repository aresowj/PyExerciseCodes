// 1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero. Write a function that computes this value.
def signum(n: Double): Int = {
  var sign = 0
  if (n > 0) sign = 1
  if (n < 0) sign = -1
  sign
}

signum(123)   // 1
signum(-12939)// -1
signum(0)     // 0

// 2. What is the value of an empty block expression {}? What is its type?
{}  // Outputs nothing in REPL, and it has a type of Unit and value of void ().

// 3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
// When x is of type Unit

// 4. Write a Scala equivalent for the Java loop
// for (int i = 10; i >= 0; i--) System.out.println(i);
for (i <- 10 to 0 by -1) println(i)

// 5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
def countdown(n: Int) {
  for (i <- n to 0 by -1) println(i)
}

// 6. Write a for loop for computing the product of the Unicode codes of all letters in a string. 
// For example, the product of the characters in "Hello" is 9415087488L.
var string = "Hello"
var product = 1L
for (ch <- string) product *= ch.toInt
println(product)

// 7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
product = 1
string foreach (product*=_)
println(product)

// 8. Write a function product(s : String) that computes the product, as described in the preceding exercises.
def product(s: String): Long = {
  if (s.isEmpty) 1
  else s.head.toLong * stringProduct(s.tail)
}

// 9. Make the function of the preceding exercise a recursive function.
// Already done in 8

// 10. Write a function that computes pow(x, n), where n is an integer. Use the following recursive definition:
//  xn = y · y if n is even and positive, where y = xn / 2.
//  xn = x · xn – 1 if n is odd and positive.
//  x0 = 1.
//  xn = 1 / x–n if n is negative.
// Don’t use a return statement.
def pow(x: Double, n: Int): Double = {
  if (n == 0) 1
  else if (n < 0) (1 / pow(x, -n))
  else if (n % 2 == 0) pow(x, n / 2) * pow(x, n / 2)
  else pow(x, n - 1) * x
}

// 11. Define a string interpolator date so that you can define a java.time.LocalDate as date"$year-$month-$day". 
// You need to define an “implicit” class with a date method
import java.time.LocalDate

implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = {
      LocalDate.of(args(0).toString.toInt, args(1).toString.toInt, args(2).toString.toInt)
  }
}

var year = 2017
var month = 1
var day = 1
date"$year-$month-$day"   // Prints "java.time.LocalDate = 2017-01-01"
