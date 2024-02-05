object DomainReferenceValue
trait Type
trait ValueInformation
class ReferenceType extends Type
trait KnownValue extends ValueInformation
trait KnownTypeValue extends KnownValue
trait IsReferenceValue extends KnownTypeValue
trait Configuration
trait IntegerValuesDomain extends IntegerValuesFactory { domain => }
trait IntegerValuesFactory extends ValuesDomain { domain => }
trait TypedValueFactory { domain: ValuesDomain & ReferenceValuesFactory => }
trait Origin { domain: ValuesDomain =>
  import Origin.*
}
object Origin{}

trait ValuesDomain { domain =>
  type DomainReferenceValue >: Null <: ReferenceValue & DomainTypedValue[ReferenceType]
  type DomainTypedValue[+T <: Type] >: Null <: DomainValue
  type DomainValue >: Null <: Value & AnyRef

  trait ReferenceValue extends TypedValue[ReferenceType] with IsReferenceValue { this: domain.DomainReferenceValue => }
  trait Value extends ValueInformation { this: DomainValue => }
  trait TypedValue[+T <: Type] extends Value with KnownTypeValue { this: DomainTypedValue[T] => }
}

trait TypeLevelReferenceValues extends GeneralizedArrayHandling with AsJavaObject {
  domain: Configuration =>

  type AReferenceValue <: DomainReferenceValue with ReferenceValueLike

  trait ReferenceValueLike extends super.ReferenceValue {
    this: AReferenceValue =>
  }
}

trait AsJavaObject { domain: ReferenceValuesDomain => }
trait ReferenceValuesDomain extends ReferenceValuesFactory
trait ReferenceValuesFactory extends ExceptionsFactory { domain => }
trait ExceptionsFactory extends ValuesDomain { domain => }
trait DefaultExceptionsFactory extends ExceptionsFactory { this: ValuesDomain & ReferenceValuesFactory => }
trait GeneralizedArrayHandling extends ReferenceValuesDomain { this: ValuesDomain => }

trait DefaultTypeLevelReferenceValues
  extends DefaultSpecialDomainValueBinding
    with TypeLevelReferenceValues {
  domain: IntegerValuesDomain & TypedValueFactory & Configuration =>
}

trait ReferenceValues extends DefaultTypeLevelReferenceValues with Origin {
  domain: IntegerValuesDomain & TypedValueFactory & Configuration =>

  type AReferenceValue <: TheReferenceValue with DomainReferenceValue

  trait TheReferenceValue extends super.ReferenceValueLike {
    this: AReferenceValue =>
  }
}

trait DefaultReferenceValuesBinding extends ReferenceValues with DefaultExceptionsFactory {
  domain: IntegerValuesDomain & TypedValueFactory & Configuration =>

  override type AReferenceValue = TheReferenceValue
  override type DomainReferenceValue = AReferenceValue
}

trait DefaultSpecialDomainValueBinding extends ValuesDomain {
  override type DomainTypedValue[+T <: Type] = TypedValue[T]
  override type DomainValue = Value
}

trait Domain extends IntegerValuesDomain with ReferenceValuesDomain with TypedValueFactory with Configuration {}
trait CorrelationalDomain extends Domain

trait ConcreteIntegerValues { this: ValuesDomain => }
class DefaultConcreteArrayValuesBinding extends DefaultArrayValuesBinding with ConcreteArrayValues {
  domain: CorrelationalDomain & ConcreteIntegerValues =>
}

trait ConcreteArrayValues

trait DefaultArrayValuesBinding extends DefaultReferenceValuesBinding with ArrayValues {
  domain: CorrelationalDomain & ConcreteIntegerValues =>
}

trait ArrayValues extends ReferenceValues {
  domain: CorrelationalDomain & ConcreteIntegerValues =>
}