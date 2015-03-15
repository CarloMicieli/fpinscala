package fpinscala.samples.chapter01

case class CreditCard(holder: String, number: Int)
case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge = {
    if (cc == other.cc) {
      Charge(cc, amount + other.amount)
    }
    else {
      throw new Exception("Can't combine charges to different cards")
    }
  }
}
case class Coffee(price: Double) {
  def this() = this(100.0)
}

object Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee
    (cup, Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchase: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchase.unzip
    (coffees, charges.reduce(_.combine(_)))
  }

  def coalesce(charges: List[Charge]): List[Charge] =
    charges.groupBy(_.cc).values
      .map(charges => charges.reduce((c1, c2) => c1.combine(c2))).toList
}
