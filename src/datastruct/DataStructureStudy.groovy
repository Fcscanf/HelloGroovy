package datastruct
/**
 * DataStructureStudy
 *
 * @description
 *
 * @author Fcscanf@樊乘乘
 * @date 下午 21:13 2018-09-03
 */

//def list = new ArrayList()
def list = [1,2,3,4,5]
println(list.class)
println(list.size())

def array = [1,2,3,4,5] as int[]
int[] array1 = [1,2,3,4,5]

//list.remove((java.lang.Object) 7)
//list.removeAt(7)
//list.removeElement(6)
//list.removeAll { return it % 2 ==0 }
//println(list - [6,7])
//println(list.toListString())

/**
 * 列表的排序
 */
def sortList = [6,-3,9,2,-7,1,5]
//Groovy提供的排序
sortList.sort{
    a,b -> a ==b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}
//普通的Java排序
//Comparator mc = {
//    a,b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
//}
//Collections.sort(sortList)
println(sortList)

def sortStringList = ['abc','z','hello','groovy','java']
sortStringList.sort {it -> return it.size()}
println(sortStringList)

/**
 * 列表的查找
 */
def findList = [-3,9,6,2,-7,1,5]
int result = findList.find {return it % 2 == 0}
println(result)
def result1 = findList.findAll {return it % 2 != 0}
println(result1.toListString())
def result2 = findList.any {return it % 2 != 0}
def result3 = findList.every {return it % 2 != 0}
println(result2)
println(result3)
println(findList.min {return Math.abs(it)})
println(findList.max {return Math.abs(it)})
println(findList.count {return it % 2 == 0})

def range = 1..10
println('range范围内的第二个数是：' + range[1])
//包含-返回boolean
println(range.contains(10))
//范围起始
println(range.from)
//范围截止
println(range.to)
//遍历范围
range.each {
    println(it)
}
for (i in range) {
    println(i)
}

def getGrade(Number number) {
    def result
    switch (number) {
        case 0..60:
            result = '不及格'
            break
        case 60..70:
            result = '及格'
            break
        case 70..80:
            result = '良好'
            break
        case 80..100:
            result = '优秀'
            break
    }
    return result
}
println(getGrade(75))