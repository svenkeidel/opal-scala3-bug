package C
trait ValuesDomain { domain =>
  type DomainReferenceValue <: ReferenceValue
  type DomainValue <: Value with AnyRef

  trait ReferenceValue { this: domain.DomainReferenceValue => }
  trait Value { this: DomainValue => }
}

trait TypeLevelReferenceValues extends ValuesDomain {
  domain =>

  type AReferenceValue <: DomainReferenceValue with ReferenceValueLike

  trait ReferenceValueLike extends super.ReferenceValue {
    this: AReferenceValue =>
  }
}

trait DefaultTypeLevelReferenceValues
  extends DefaultSpecialDomainValueBinding
    with TypeLevelReferenceValues {
  domain =>
}

trait DefaultSpecialDomainValueBinding extends ValuesDomain {
  override type DomainValue = Value
}

trait ReferenceValues extends DefaultTypeLevelReferenceValues {
  domain =>

  type AReferenceValue <: TheReferenceValue with DomainReferenceValue

  trait TheReferenceValue extends super.ReferenceValueLike {
    this: AReferenceValue =>
  }
}

trait DefaultReferenceValuesBinding extends ReferenceValues {
  domain =>

  override type AReferenceValue = TheReferenceValue
  override type DomainReferenceValue = AReferenceValue
}

class DefaultConcreteArrayValuesBinding extends DefaultArrayValuesBinding {
  domain =>
}

trait DefaultArrayValuesBinding extends DefaultReferenceValuesBinding with ArrayValues {
  domain =>
}

trait ArrayValues extends ReferenceValues {
  domain =>
}