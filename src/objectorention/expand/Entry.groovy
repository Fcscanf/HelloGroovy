package objectorention.expand

import objectorention.PersonManager

/**
 * Entry
 *
 * @description
 *
 * @author Fcscanf@樊乘乘
 * @date 上午 10:29 2018-09-04
 */
class Entry {
    static void main(def args) {
        println("应用程序正在启动。。。")
        //初始化
        ApplicationManager.init()
        println("应用程序完成。。。")

        def person = PersonManager.createPerson('Fc',18)
        println("the person name is ${person.name} and the age is ${person.age}")
    }
}
