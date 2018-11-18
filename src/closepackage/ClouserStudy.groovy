package closepackage
/**
 * ClouserStudy 闭包学习
 *
 * @description
 *
 * @author Fcscanf@樊乘乘
 * @date 上午 8:39 2018-09-03
 */

def clouser = {
    String name
        ->
    println("hello ${name}")
}
clouser.call("Kerry")
clouser('Groovy!')

/**
 * ${it} 默认的隐式参数
 *
 * @param
 * @return
 * @author Fcscanf@樊乘乘
 * @date 上午 8:48 2018-09-03
 */
def clouserNoCase = {
    println("hello ${it}")
}
def result = clouserNoCase('Groovy!')
println(result)

int x = fab(5)
println(x)
/**
 * 用来求Number的阶乘
 *
 * @param
 * @return
 * @author Fcscanf@樊乘乘
 * @date 上午 9:04 2018-09-03
 */
def fab(int number) {
    int result = 1
    1.upto(number,{
        num ->
        result *=num
    })
    return result
}

int y = fab2(5)
println(y)

int fab2(int number) {
    int result = 1
    number.downto(1){
        num -> result *=num
    }
    return result
}

/**
 * 累加
 *
 * @param
 * @return
 * @author Fcscanf@樊乘乘
 * @date 上午 9:10 2018-09-03
 */
int z = cal(101)
println(z)

int cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result
}

/**
 * 字符串与闭包结合使用
 *
 * @param
 * @return
 * @author Fcscanf@樊乘乘
 * @date 上午 9:14 2018-09-03
 */
String str = 'the 2 and 3 is 5'
//each的遍历
str.each {
    String temp -> print(temp.multiply(2))
}
//find来查找符合条件的第一个
println str.find{
    String s -> s.isNumber()
}

def list = str.findAll{
    String s -> s.isNumber()
}
println(list.toListString())

def result1 = str.any{
    String s -> s.isNumber()
}
println(result1)
println(str.every{
    String s -> s.isNumber()
})

def list1 = str.collect{
    it.toUpperCase()
}
println(list1.toListString())

/**
 * this 代表闭包定义的类
 * owner 代表闭包定义的类或者对象
 * delegate 代表任意对象
 *
 * @param
 * @return
 * @author Fcscanf@樊乘乘
 * @date 下午 14:40 2018-09-03
 */
def scriptClouser = {
    println("scriptClouser this:" + this)
    println("scriptClouser owner:" + owner)
    println("scriptClouser delegate:" + delegate)
}
scriptClouser.call()

/**
 * 内部类 
 *
 * @param
 * @return 
 * @author Fcscanf@樊乘乘
 * @date 下午 14:41 2018-09-03 
 */
class Person {
    def classClouser = {
        println("scriptClouser this:" + this)
        println("scriptClouser owner:" + owner)
        println("scriptClouser delegate:" + delegate)
    }

    def say() {
        def classClouser = {
            println("methodscriptClouser this:" + this)
            println("methodscriptClouser owner:" + owner)
            println("methodscriptClouser delegate:" + delegate)
        }
        classClouser.call()
    }
}

Person p = new Person()
p.classClouser.call()
p.say()

/**
 * 闭包中定义一个闭包 
 *
 * @param
 * @return 
 * @author Fcscanf@樊乘乘
 * @date 下午 14:57 2018-09-03 
 */
def nestClouser = {
    def innerClouser = {
        println("innerClouser this:" + this)
        println("innerClouser owner:" + owner)
        println("innerClouser delegate:" + delegate)
    }
    innerClouser.delegate = p //修改默认的delegate
    innerClouser.call()
}
nestClouser.call()

/**
 * 闭包的委托策略
 */
class Student {
    String name
    def pretty = {"My name is ${name}"}

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: 'Sarash')
def tea = new Teacher(name: 'Ondroid')
println(stu.toString())
//修改值还要修改其策略
stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println(stu.toString())