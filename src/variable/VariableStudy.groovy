package variable
/**
 * VariableStudy
 *
 * @description
 *
 * @author Fcscanf@樊乘乘
 * @date 下午 23:54 2018-09-02
 */

/**
 * def 类型根据变量的值来判断类型，单引号相当于双引号，转义符使用\输出
 */
def name = 'a single \' a \' string'
println(name)

/**
 * 三引号的变量可以得到有格式的变量
 */
def thupleName = '''\
line one 
line two
line three
'''
println(thupleName)

def doubleName = "this is common String"
println(doubleName)

/**
 * 双引号的内容可取值，三引号的内容不可变
 */
def age = 20
def message = "Hello: ${age}"
println(message)
println(message.class)

def sum = "The sun of 2 and 3 equals ${2+3}"
println(sum)

def result = echo(sum)
println(result)

String echo(String message) {
    return message
}

/**
 * =============================字符串的方法==============================
 */

/**
 * 字符串的center方法可以从当前字符串向两边填充字符串，参数为指定的长度和填充的内容，无填充的字符默认为空格
 */
def str = "groovy hello"
println(str.center(8,'a'))
println(str.padLeft(8,'a'))
println(str.padRight(8,'a'))

/**
 * 直接快速比较
 */
def str1 = 'hello'
println(str > str1)

/**
 * 快速索引取值，也可以指定范围取值
 */
println(str1[1])
println(str1[0..1])

/**
 * 字符串的减法：第一个字符串将第二个包含的减去
 */
println(str.minus(str1))
println(str - str1)

/**
 * 倒序操作
 */
println(str.reverse())

/**
 * 首字母大写
 */
println(str.capitalize())
