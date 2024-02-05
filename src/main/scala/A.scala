//
//trait S {
//
//  type T
//
//  def getT: T
//}
//
//trait A extends S {
//  type T = String
//  override def getT: String = "hello"
//}
//
//trait B extends S {
//  type T = Int
//  override def getT: Int = 1
//}
//
//object Main {
//  def foo1(t: A with B) = {
//    val x: Int = t.getT
//    println(x)
//  }
//
//  def foo2(t: B with A) = {
//    // Scala 2.12: t.getT: String
//    // Scala 3: t.getT: String & Int
//    val x: Int = t.getT
//    println(x)
//  }
//
//  def main(args: Array[String]) = {
//    foo1(new A with B {})
//  }
//}