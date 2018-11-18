package objectorention.expand

import objectorention.Person

/**
 * ApplicationManager
 * 应用管理类
 *
 * @description
 *
 * @author Fcscanf@樊乘乘
 * @date 上午 10:37 2018-09-04
 */
class ApplicationManager {
    static void init() {
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
        Person.metaClass.static.caeatePerson = {
            String name ,int age ->
                new Person(name: name,age: age)
        }
    }
}
