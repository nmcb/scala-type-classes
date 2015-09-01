package playground

// Defines a type-class able to create labels
trait LabelMaker[T] {
  self =>
  def toLabel(value: T): String
}

// Defines a companion object with implicit implementations
object LabelMaker {
  implicit object AddressLabelMaker extends LabelMaker[Address] {
    def toLabel(address: Address): String = {
      import address._
      "%d %s, %s, %s - %s".format(no, street, city, state, zip)
    }
  }

  // Defines ad-hoc polymorphic operations employing the type-class
  object ops {
    trait LabelOps[F] {
      def self: F
      implicit def F: LabelMaker[F]
      def label = F.toLabel(self)
    }

    implicit def withLabelOps[A](tpe: A)(implicit ev: LabelMaker[A]) =
      new LabelOps[A] {
        def self = tpe
        implicit def F: LabelMaker[A] = ev
      }
  }
}

