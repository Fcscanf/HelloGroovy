package mapstruct
/**
 * MapStructsStudy
 *
 * @description
 *
 * @author Fcscanf@樊乘乘
 * @date 下午 23:09 2018-09-03
 */

//def map = new HashMap()
def colors = [red: 'ff00000',green: '00ff00',blue: '0000ff']
//索引方式
println(colors['red'])
println(colors.red)
//添加元素
colors.yellow = 'ffff00'
colors.complex = [a:1,b:2]
println(colors.toMapString())
println(colors.getClass())

/**
 * Map操作
 */
def students = [
        1:[number:'0001',name:'Bob',score:55,sex:'male'],
        2:[number:'0002',name:'Johnny',score:63,sex:'female'],
        3:[number:'0003',name:'Claire',score:75,sex:'female'],
        4:[number:'0004',name:'Amy',score:88,sex:'male'],
]
//遍历
students.each {
    def student ->
        println("the key is ${student.key}," + "the value is ${student.value}")
}
//带索引的遍历
students.eachWithIndex {
    def student,int index ->
        println("the index is ${index}," + "the key is ${student.key}," + "the value is ${student.value}")
}
//直接遍历key-value
students.each {
    key,value ->
        println("the key is ${key}," + "the value is ${value}")
}
//带索引的key-value遍历
students.eachWithIndex {
    key,value,index ->
        println("the index is ${index}," + "the key is ${key}," + "the value is ${value}")
}

//Map的查找
def entry = students.find {
    def student ->
        return student.value.score >= 60
}
println(entry)

def entrys = students.findAll {
    def student ->
        return student.value.score >= 60
}
println(entrys)

def count = students.count {
    def student ->
        return student.value.score >= 60 &&
                student.value.sex == 'male'
}

println(count)
def names = students.findAll {
    def student ->
        return student.value.score >= 60
}.collect {
    return it.value.name
}
println(names.toListString())

def group = students.groupBy {
    def student ->
        return student.value.score >= 60 ? '及格' : '不及格'
}
println(group.toMapString())

/**
 * Map的排序
 */
def sort = students.sort {
    def student1,def student2 ->
        Number score1 = student1.value.score
        Number score2 = student2.value.score
        return score1 == score2 ? 0 : score1 < score2 ? -1 : 1
}
println(sort.toMapString())