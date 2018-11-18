package objectorention

/**
 * 设置全局注入可用
 */
ExpandoMetaClass.enableGlobally()

def person = new Person(name: 'Fc',age: 18)
println("the name is ${person.name},the age is ${person.age}")
person.increaseAge(10)
println(person.cry())

//为类动态的添加属性
Person.metaClass.sex = 'male'
def person1 = new Person(name: 'Fc',age: 18)
println(person1.sex)
person1.sex = 'female'
println("the new sex is ${person1.sex}")

//为类动态的添加方法
Person.metaClass.sexUpperCase = { -> sex.toUpperCase()}
def person2 = new Person(name: 'Fc',age: 18)
println(person2.sexUpperCase())

//为类动态的添加静态方法
Person.metaClass.static.createPerson = {
    String name,int age ->
        new Person(name: name,age: age)
}
def person3 = Person.createPerson('Fc',17)
println(person3.name + " and " + person3.age)