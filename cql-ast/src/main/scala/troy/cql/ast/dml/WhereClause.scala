package troy.cql.ast.dml

import troy.cql.ast.{ Identifier, Term, TupleLiteral }

case class WhereClause(relations: Seq[WhereClause.Relation])
object WhereClause {
  trait Relation
  object Relation {
    case class Simple(columnName: Identifier, operator: Operator, term: Term) extends Relation
    case class Tupled(columnNames: Seq[Identifier], operator: Operator, term: TupleLiteral) extends Relation
    case class Token(columnNames: Seq[Identifier], operator: Operator, term: Term) extends Relation
  }
}

trait Operator
object Operator {
  case object Equals extends Operator
  case object LessThan extends Operator
  case object GreaterThan extends Operator
  case object LessThanOrEqual extends Operator
  case object GreaterThanOrEqual extends Operator
  case object NotEquals extends Operator
  case object In extends Operator
  case object Contains extends Operator
  case object ContainsKey extends Operator
}