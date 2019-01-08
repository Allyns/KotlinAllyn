package com.allyn.demos.kotlinallyndemo

/**
 * Created by Allyn on 2019/01/09 0009.
url:https://github.com/Allyns
类的继承案例
 */
class ClassBig {
    //被继承需要在前面加open关键字，否则通过不了编译
    open class ClassA(var name: String, var sex: Int) {
        //函数需要被实现也需要加open
        protected open fun fangfa1(): String {
            return ""
        }

        //此方法无法被子类重写
        protected fun fangfa2() {

        }
    }

    //继承
    open class ClassB(name: String = "a", sex: Int = 0) : ClassA(name, sex) {
        override fun fangfa1(): String {
            return name + sex
        }
    }

    class ClassC : ClassA("a", 0) {
        override fun fangfa1(): String {
            return ""
        }
    }

    class ClassD(name: String, sex: Int) : ClassA(name, sex) {
        override fun fangfa1(): String {
            return ""
        }
    }

    //抽象类
    abstract class ClassE(name: String, sex: Int, var inclik: String) : ClassB("a", 1) {
        abstract fun jths()
        abstract fun jths2(): String
    }

    class ClaassF(name: String = "b", sex: Int = 0, inclik: String = "c") : ClassE("a", 1, inclik) {
        override fun jths() {
        }

        override fun jths2(): String {
            return name + sex + inclik
        }

    }

    class ClaassG(name: String = "e", sex: Int = 0, inclik: String = "f") : ClassE(name, sex, inclik) {
        override fun jths() {
        }

        override fun jths2(): String {
            return name + sex + inclik
        }

    }

    fun diaoyong() {
        ClaassF().jths2()
        ClaassG().jths2()
        diaoyong2()
    }

    //接口
    interface JIEKOU {
        fun sxhs1()
        fun sxhs2(): String {
            return "打印一下"
        }

        var jiekoushuxing: String
    }

    //继承父类和接口
    class ClaassH(name: String = "e", sex: Int = 0, inclik: String = "f") : ClassE(name, sex, inclik), JIEKOU {
        override fun jths() {
        }

        override fun jths2(): String {
            return name + sex + inclik
        }

        override fun sxhs1() {
            print("a")
        }

        override fun sxhs2(): String {
            print("b")
            return super.sxhs2()
        }

        override var jiekoushuxing: String = "dddd"
    }

    fun diaoyong2() {
        ClaassH().jths()
        ClaassH().jths2()
    }
}