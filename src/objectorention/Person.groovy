package objectorention
/**
 * Person
 *
 * @description
 *
 * @author Fcscanf@樊乘乘
 * @date 上午 9:34 2018-09-04
 */
class Person {
    String name
    Integer age

    def increaseAge(Integer years) {
        this.name += years
    }

    /**
     * invokeMethod方法替代该类中不存在的方法
     *
     * @param name
     * @return
     * @author Fcscanf@樊乘乘
     * @date 上午 10:07 2018-09-04
     */
    def invokeMethod(String name, Object args) {
        return "the method is ${name},the params is ${args}"
    }

    def methodMissing(String name, Object args) {
        return "the method ${name} is missing"
    }
}
