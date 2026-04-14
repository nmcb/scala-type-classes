package playground

// See LabelMaker.scala for the example.
case class Person(firstName: String, lastName: String, title: Option[String], nick: String)
case class Address(no: Int, street: String, city: String, state: String, zip: String)

object Address {
  implicit object AddressLabelMaker extends LabelMaker[Address] {
    def toLabel(address: Address): String = {
      import address._
      "%d %s, %s, %s - %s".format(no, street, city, state, zip)
    }
  }
}

