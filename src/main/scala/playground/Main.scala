package playground

// See LabelMaker.scala for the example.
object Main extends App {

  // depicts the usage of an existing label maker type-class
  import LabelMaker._
  def label(t: Address) = implicitly[LabelMaker[Address]].toLabel(t)
  println(label(new Address(66, "Route", "Brussels", "BXL", "1000")))

  // depicts the usage of an existing label maker type-class employing operation semantics)
  import LabelMaker.ops._
  println(new Address(101, "Types", "Amsterdam", "NH", "1000AA").label)

  // depicts the usage of a label maker type-class employing ad-hoc polymorphism)
  implicit val personLabelMaker = new LabelMaker[Person] {
    override def toLabel(person: Person): String = {
      import person._
      "%s %s, %s [%s]".format(firstName, lastName, title.getOrElse(""), nick)
    }
  }
  println(new Person("Jon", "Osterman", Some("Dr."), "Manhattan").label)
}
