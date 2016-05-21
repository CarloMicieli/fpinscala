// Copyright (C) 2016 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package fpinscala.samples.chapter01

case class CreditCard(holder: String, number: Int)
case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge = {
    if (cc == other.cc) {
      Charge(cc, amount + other.amount)
    } else {
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
