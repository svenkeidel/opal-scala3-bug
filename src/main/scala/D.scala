trait ReferenceValues {
  type DomainReferenceValue
  type AReferenceValue <: DomainReferenceValue

  trait TheReferenceValue
}

trait DefaultReferenceValuesBinding extends ReferenceValues {
  override type AReferenceValue = TheReferenceValue
  override type DomainReferenceValue = AReferenceValue
}

class DefaultConcreteArrayValuesBinding extends DefaultArrayValuesBinding

trait DefaultArrayValuesBinding extends DefaultReferenceValuesBinding with ReferenceValues {
  domain =>
}