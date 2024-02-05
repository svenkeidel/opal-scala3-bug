package E

trait A {
  type T1
  type T2 <: T1
}

trait B extends A {
  final override type T1 = T2
  final override type T2 = Unit
}

trait C extends A

trait D extends B with C {

}

class E extends D


// DomainReferenceValue: super[ReferenceValues].TheReferenceValue & super[ReferenceValues].AReferenceValue
// AReferenceValue: super[ReferenceValues].TheReferenceValue & super[ReferenceValues].AReferenceValue