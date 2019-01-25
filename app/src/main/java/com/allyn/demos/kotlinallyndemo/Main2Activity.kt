package com.allyn.demos.kotlinallyndemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
/**
 * Created by Allyn on 2019/01/09 0009.
url:https://github.com/Allyns
 */
class Main2Activity : AppCompatActivity() {

    var is_add: Boolean = true
    var counts: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mytextView.setOnClickListener { mytextView.text = "测试啦" }
        mytextView.setOnLongClickListener { true }
        mytextView.setOnClickListener {
            //-----------------------字符串操作--------------------------------------
            val strs: Array<String> = arrayOf("aa", "bb", "cc")
            var str: String = ""
            var count: Int = 0
            while (count < strs.size) {
                str = str + strs[count] + ",";
                count++
            }
            print(str)
            mytextView.text = str
            val textData = mytextView.text.toString()
            var strcs = ""
            while (textData.indexOf("测") > 0) {
                strcs = textData.substring(0, textData.indexOf("测"))
            }
            print(strcs)
            val splits: List<String> = strcs.split(",")
            var sp = ""
            for (split in splits) {
                sp = sp + split + ","
            }
            print(sp)
            //字符串可以通过下标获取制定位置
            var ii = sp[0].toString()
            var jj = sp.get(1).toString()
            //$的使用   字符串拼接符号
            mytextView.text = "这个是字符串:$splits"
            //输出￥字符  ${","}
            mytextView.text = "这是美元${"$"}$sp"

            //------------------------------------------条件分支判断操作--------------------------------------
            //存储放  判断 赋值  判断的同时赋值  kotlin的强大
            mytextView.text = if (is_add == false) {
                "添加了"
            } else {
                "无添加"
            }
            mytextView.text = if (is_add) "添加" else "不添加"
            is_add = !is_add
        }
        mytextView.setOnClickListener {
            when (counts) {
                1, 2 -> {
                    mytextView.text = "是这个"
                }
                in 1..10 -> {
                    mytextView.text = "区间"
                }
                else -> {
                    mytextView.text = "否则"
                }
            }
            counts = (counts + 1) % 3
        }
        var bl: Int = 2
        //不用括号，再简写
        when (counts) {
            2, 4 -> mytextView.text = "测试"
            in 1..10 -> mytextView.text = "测试"
            //when支持变量
            bl -> mytextView.text = "变量"
            else -> mytextView.text = "否则"
        }
        //多个分支判断的返回值
        var countType: Number
        countType = when (counts) {
            1 -> counts.toLong()
            in 1..8 -> counts.toFloat()
            else -> counts.toDouble()
        }
        when (countType) {
            is Double -> mytextView.text = "布尔值"
            is Int -> mytextView.text = "整数"
            is Float -> mytextView.text = "测试"
            else -> mytextView.text = "否则"
        }
        kongzhiliu()
        arraykotlin()
        //--------------------------------循环语句操作----------------------------------------
//       var strList:BooleanArray= booleanArrayOf()
        //显示一首诗
        var strList: Array<String> = arrayOf("床前明月光", "疑似地上霜", "举头望明月", "低头思故乡", "aaaaa")
        var poser = ""
        for (str in strList) {
            //这里做一个字符串拼接
            poser = "$poser$str, \n"
        }
        print(poser)
        //一三，号  二四。号
        for (i in strList.indices) {
            if (i % 2 == 0) {
                poser = "$poser$i , \n"
            } else {
                poser = "$poser$i . \n"
            }
            print(poser)
            //简写 一行
            poser = if (i % 2 == 0) "$poser$i , \n" else "$poser$i . \n"
            print(poser)
        }
        //区间
        for (i in 0..strList.size - 1) {
            poser = if (i % 2 == 0) "$poser$i , \n" else "$poser$i . \n"
            print(poser)
        }
        //for 循环新增三个关键字 方便处理复杂的逻辑
        //关键字 util  指定某个区间  不包括某个区间
        for (i in 1..20 union 7..9) {
            //假如说有20个数字 只打印1到10的下标 不打印7到9的下标区间
            //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
        }
        for (i in 11 until 12) {
            //假如有30个数字  只打印11之前的  12之后的不打印
            // 1 2 3 4 5 6 7 8 9 10 11
        }
        //关键字 step 每次递增的值自定义
        for (i in 1..100 step 2) {
            //1 到100 默认是递增1  这里改成每次递增2
            //1 2 4 3 8 10 12 14 16 18 20
        }
        //关键字 downTo  每次递减
        for (i in 100 downTo 1) {
            //每次递减一  从100到1
            //100 99 98 97 96 95 94 93 92 91 89 88 87 86 85 84 83 82 81.....3 2 1
        }
        //举一反三 downTo
        for (i in 100 downTo 1 step 2) {
            //递减 每次递减2
            //100 98 86 84 82 90 ....8 6 4 2 1
        }
        //-----while循环----
        var strListWhile: Array<String> = arrayOf("床前明月光", "疑似地上霜", "举头望明月", "低头思故乡", "aaaaa")
        var poss = ""
        var i = 0
        while (i < strListWhile.size) {
            poss = "$poss$i , \n"
        }
        print(poss)

        do {
            if (counts % 2 == 0) {
                poser = if (i % 2 == 0) "$poser$i , \n" else "$poser$i , \n"

            } else {
                poser = if (i % 2 == 0) "$poser$i , \n" else "$poser$i . \n"
            }
            counts++
        } while (counts < strListWhile.size)
        print(poser)
        var complexList: Array<String> = arrayOf("床前明月光", "疑似地上霜", "  ", "", "举头望明月", "低头思故乡", "aaaaa")
        //关键字 continue 和break的使用
        while (i < complexList.size) {
            if (complexList[i].isNotBlank()) continue
            if (counts % 2 == 0) {
                poser = if (i % 2 == 0) "$poser$i , \n" else "$poser$i , \n"
            } else {
                poser = if (i % 2 == 0) "$poser$i , \n" else "$poser$i . \n"
            }
            i++;
            if (i == 4) {
                break
            }
            print(poser)
        }
        //多层while    tiaochu@ while      break@tiaochu直接跳出内外循环执行操作
        var is_find: Boolean = false
        tiaochu@ while (i < complexList.size) {
            var jj = 0
            var datas = complexList[i]
            while (jj < datas.length) {
                if (datas.contains("一")) {
                    break@tiaochu
                }
                jj++
            }
            i++
        }
        print(if (is_find) "找到了" else " 没找到")
//--------------------------空值的判断与处理----------------------------------------------------------------------------------
        //kotlin 提供的空值判断方法
        /**
         * isNullOrEmpty : 为空指针或者字串长度为0时返回true，非空串与可空串均可调用。
        isNullOrBlank : 为空指针或者字串长度为0或者全为空格时返回true，非空串与可空串均可调用。
        isEmpty : 字串长度为0时返回true，只有非空串可调用。
        isBlank : 字串长度为0或者全为空格时返回true，只有非空串可调用。
        isNotEmpty : 字串长度大于0时返回true，只有非空串可调用。
        isNotBlank : 字串长度大于0且不是全空格串时返回true，只有非空串可调用。
         */

        var aaa: String = ""
//        var ddd: String = null   //没有加？号表示不能赋值null
        var bbb: String? = null
        var ccc: String? = ""   //可能为空

        var eee = bbb?.length  //只是进行了是否为空判断  如果为空返回 字符串"null"

        var ggg = ccc?.length ?: -1  //如果获取的长度为空，返回-1

        var fff: String? = "abc"
        var hhh = fff!!.length  //保证不为空 直接！！
        /***
         *String? 类型后面加问号表示该类型可以为空
         * Leixing？ 在实例后面加问号，如果为空返回null
         * 运算符 ?: 如果为空就执行?::后面的代码
         * 运算符!! 不进行运算是否为空判断 如果为null直接报空指针异常，在报错数据不会为空的情况下调用
         */
        //空指针异常捕捉
        try {
            var isNull: String? = null
            var nullde = isNull!!.length   //这里会报空指针异常
        } catch (e: Exception) {
            print("空指针了")
        }
    }

    fun kongzhiliu() {
        val x = 111
        val y = 222
        when (x) {
            1, 2 -> {
                print("yes")
            }
            in 1..10 -> {
                //1到10
            }
            !in 1..11 -> {

            }
            else -> {
                print("no")
            }
        }
        var z = if (x < y) x else y

        var c = if (x > y) {
            print("yes")
            x
        } else {
            print("no")
            y
        }
        print(z)
        print(c)
    }

    //数组
    fun arraykotlin() {
        val abc: IntArray = intArrayOf(1, 3, 4, 5)
        val a: BooleanArray = booleanArrayOf(true, false, true)
        val b: FloatArray = floatArrayOf(45f, 56f, 9f)
        val c: DoubleArray = doubleArrayOf(5.2, 598.4, 22.0)
        val d: CharArray = charArrayOf('a', 'b', 'c')
        val aa: Array<String> = arrayOf("aaa", "bbb", "ccc")
        val bb: Array<Boolean> = arrayOf(true, false)
        val cc: Array<Int> = arrayOf(1, 2, 3)
    }
//-----------------------------------------函数的基本用法与知识点——------------------------------
    //知识点
    /**
     * 1、Java使用“@Override”表示该函数是重载了父类的方法，而Kotlin使用小写的“override”在同一行表达重载操作；
    2、Java使用“public”表示该函数是公共方法，而Kotlin默认函数就是公开的，所以省略了关键字“public”；
    3、Java使用“void”表示该函数没有返回参数，而Kotlin不存在关键字“void”，若无返回参数则不用特别说明；
    4、Kotlin新增了关键字“fun”，表示这里是函数定义，其格式类似于Java的关键字“class”，而Java不存在关键字“fun”；
    5、Java声明输入参数的格式为“对象类型 对象名称”，而Kotlin声明入参的格式为“对象名称: 对象类型”；
    6、Kotlin引入了空安全机制，如果某个对象允许为空的话，需要在对象类型后面加个问号“?”；
     */

    //重写方法
    override fun onRestart() {
        super.onRestart()
    }

    //基本方法
    fun method1() {

    }

    //有参数
    fun method(str: String?, str2: String?, int1: Int) {
        if (str2 != null) {

        }
    }

    //有参数 需要返回值
    fun method2(str: String?, str2: String, int1: Int): String {
        return ""
    }

    //-----------------------------------参数的高级用法---------------------------

    fun Unite() {
        //改变默认参数
        methodb(strb = "我要吃的是青苹果哦")
        methodc("a", "b", "c", "d", "e", "f", "g", "h")
        methodd("a", "b", "c", "d", arrayOf("a", "b", "c"), arrayOf("a", "b", "c"), arrayOf("a", "b", "c"))
        fanxing("a", arrayListOf("bb", "c", "", 7, 1.1, true), arrayListOf("c", "d", 2.4f))
        setarray(arrayOf(12))
        val arralist = mutableListOf<Int>(4, 5, 6)
        arralist.sup(1, 2)

//        var string_array: Array<String> = arrayOf("How", "do", "you", "do", "I'm   ", "Fine")
//        maxCustom<String>(string_array, { a, b -> a.length > b.length }
    }

    //参数默认赋值
    fun methoda(st: String, str: String = "这是默认参数", inta: Int = 0, doule: Double = 2.3, isOO: Boolean = true) {

    }

    //改变默认参数
    fun methodb(stra: String = "想吃的食物", strb: String = "苹果", strc: String = "辣条", strd: String = "茶叶") {
        var feed = "$strb,$strc,$strd"
        var data = "$stra: $feed"
        print(data)
        //想吃的食物:我要吃的是青苹果哦,辣条，茶叶
    }

    //可变参数  vararg
    fun methodc(stra: String, strb: String, strc: String, strd: String, vararg strss: String?) {
        var found = "$stra,$strb,$strc,$strd"
        for (strddd in strss) {
            found = "$found，$strddd"
        }
        print(found)
    }

    //可变参数  分类
    fun methodd(stra: String, strb: String, strc: String, strd: String, vararg strss: Array<String>): String {
        var found = "$stra,$strb,$strc,$strd"
        for (strddd in strss) {
            for (s in strddd) {
                found = "$found，$s"
            }
        }
        print(found)
        return found
    }

    //-------------------泛型的使用 ------------------------
//方法名前面声明泛型名称
    fun <T> fanxing(stg: String, vararg infos: ArrayList<T>): ArrayList<String> {
        var arrs: List<T>? = listOf()
        var str: String = "$stg"
        for (item in infos) {
            for (tt in item) {
                str = "$str${item.toString()},"
            }
        }
//        arrs.reversed()//反转元素
//        var mlist=arrs?.toMutableList() //可变集合
        return arrayListOf(str)
    }
//------------------------------内联函数-----------------------------------------------------------------
//泛型T具体化方式： inline fun <reified T : Number> 制定T只能是Number的子类
    /**
     * 知识点
     * 举个例子，Int、Float和Double都继承自Number，但是定义一个setArrayNumber(array:Array<Number>)函数，
     * 它并不接受Array<Int>或者Array<Double>的入参，如果要让该方法同时接受源自Number的数组入参，就得定义泛化自Number的泛型函数
     * ，即将<T>改为<reified T : Number>，同时在fun前面添加关键字inline，表示该函数也为内联函数。内联函数在编译之时，
     * 会在调用处把该函数的内部代码直接复制一份，调用十次就会复制十份，而非普通函数那样仅仅提供一个函数的访问地址
     */
//该函数不接受Array<Int>，也不接受Array<Double>，只好沦为孤家寡人
    fun arrayNubmer(array: Array<Number>) {
        var str: String = "abcde"
//        var str: Double = 63.4
        for (item in array) {
            str = str + item.toString() + ","
        }
        print(str)
    }

    //只有内联函数才可以被具体化 制定T只能是Number的子类 只能是数字 String类型不行
    inline fun <reified T : Number> setarray(array: Array<T>) {
        var str: String = "abcde"
//        var str: Double = 63.4
        for (item in array) {
            str = str + item.toString() + ","
        }
        print(str)
    }

    //------------------------------扩展函数-------------------------------------
//用法：    val arralist = mutableListOf<Int>(4,5,6)
//        arralist.sup(1,2)
//个人理解：可以扩展任何类的方法，系统的自建的都可以，
    fun Array<Int>.swap(count1: Int, count2: Int): Int {
        val stwp = this[count1]
        this[count1] = count2
        this[count2] = stwp
        return count1 + count2
    }

    //高级写法，使用泛型，Array中所有类型都支持
    fun <T> MutableList<T>.sup(count1: Int, count2: Int): Int {
        val swap = this[count1]
        this[count1] = this[count2]
        this[count2] = swap
        return count1 + count2
    }

    //-----------尾递归函数---------------------------------------
//如果一个函数的表达式比较简单，一两行就可以搞定的话，Kotlin允许使用等号代替大括号。
    fun fangfa1(s: Int): Int {
        return if (s == 0) s else s - 1
    }

    fun fangfa2(s: Int): Int = if (s == 0) 2 else 3
    //tailrec 关键字 如果这个方法调用了自身的方法 加上关键字tailrec 系统会对这个方法进行优化
    tailrec fun fangfa3(b: Int): Int = if (b == 5) 5 else fangfa3(45)

    //---------------------------------高阶函数-----------------------------------
//把A函数作为B函数的输入参数，就像普通变量一样参与B函数的表达式计算。此时因为B函数的入参内嵌了A函数，故而B函数被称作高阶函数，
//允许将函数表达式作为输入参数传进来，就形成了高阶函数，这里的greater函数就像是个变量
    fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in array)
            if (max == null || greater(item, max))
                max = item
        return max
    }
//调用
//maxCustom<String>(string_array, { a, b -> a.length > b.length }}
//var string_array: Array<String> = arrayOf("How", "do", "you", "do", "I'm   ", "Fine")
    /**
     * 以上代码在调用maxCustom函数时，第二个参数被大括号包了起来，这是Lambda表达式的匿名函数写法，中间的“->”把匿名函数分为两部分，
     * 前半部分表示函数的输入参数，后半部分表示函数体。“{ a, b -> a.length > b.length }”按照规范的函数写法是下面这样的代码：
     */
    fun anonymous(a: String, b: String): Boolean {
        var result: Boolean = a.length > b.length
        return result
    }

    //我的应用哪个
    fun fangfa4(d: Int, fangfa2: (a: Int, b: Int) -> Int): Int {
        var max = 0
        max = fangfa2(2, 3)
        return max
    }

    fun dy() {
        fangfa4(2) { a, b -> a + b - 1 }
    }

    //------------------------------------类与构造方法---------------------------
    /**
     * 继承
     */
    open class ClassA {
    }

    class ClassB : ClassA() {
    }

    /**
     * 构造方法
     */
    fun diaoyong() {
        val d1 = ClassD(1, 2)

        val e = ClassE(1, 2)
        val e1 = ClassE(1, 2, 3)

        val f = ClassF(1, 2)
        val f1 = ClassF(1, 2, 3)

        val g = ClassG(1, 2)
        val g1 = ClassG(1, 2, 3)
    }

    //默认构造方法 使用关键字constructor声明构造方法
    class ClassD constructor(a: Int, b: Int) {
        init {
            print("创建时候的初始化方法")
        }
    }

    ///二级构造方法 这种写法的二级构造函数需要写this声明从属关系
    class ClassE constructor(a: Int, b: Int) {
        init {
            print("1")
        }

        constructor(a: Int, b: Int, c: Int) : this(a, b) {
            print("2")
        }
    }

    //优化 二级构造函数的写法
    class ClassF {
        var a: Int = 0

        constructor(a: Int, b: Int) {
            this.a = a
            print("1")
        }

        constructor(a: Int, b: Int, c: Int) {
            print("2")
        }

        fun fff() {
            var c: Int = 0
            c = a
            print(c)
        }
    }

    //推荐这种写法，充分利用kotlin的优势简化代码
    //持续优化 二级构造的写法 使用可变参数
    class ClassG constructor(a: Int, b: Int, c: Int = 0) {
        init {
            print("1")
            var count1: Int
            count1 = a + b + c
            gff(a, b, c)
        }

        fun gff(a: Int, b: Int, c: Int = 0) {
//            var count1:Int
//            count1=a+b+c
        }
    }

    //--------------------累的属性定义与静态方法与属性-------------------------------------------
    class ClassAA constructor(a: Int, b: Int) {
        var a: Int = 0
        var b: Int = 0

        init {
            this.a = a
            this.b = b
        }

        fun fangwen() {
            var c = a + b
            print(c)
        }
    }

    //上面的类似java的写法太繁琐，kotlin可以更简单,只能在类中这么写
    class ClassBB constructor(var a: Int, var b: Int) {
        fun fangwen() {
            var c = a + b
            print(c)
        }
    }

    class ClassCC constructor(var a: Int, var b: Int) {
        var sexNmae: String? = ""

        fun fangwen(): String {
            val c = a + b
            print(c)
            return if (b == 0) "男的" else "女的"
        }
    }

    fun aady() {
        //调用方式 赋值
        var aa = ClassAA(1, 0)
        var bb = ClassBB(1, 0)
        var cc = ClassCC(1, 0)
        print(cc.fangwen())//男的
    }

    /**
     * //静态方法 静态属性
     */
    class ClassDD constructor(var a: Int, var b: Int) {
        var sexNmae: String = ""

        fun fangwen(): String {
            val c = a + b
            print(c)
            sexNmae = if (b == 0) "男的" else "女的"
            return sexNmae
        }

        //静态成员访问部分
        companion object {
            //静态属性
            var MAN: Int = 0
            var WUMAN: Int = 1
            fun fangwen(sexname: String): Int {
                return when (sexname) {
                    "男的", "公的" -> MAN
                    "女的", "母的" -> WUMAN
                    else -> -1
                }
            }
        }

        //调用
        fun diaoyongdd() {
            var sex = ClassDD.fangwen("公的")
            print(sex)
            ClassCC(ClassDD.MAN, ClassDD.WUMAN)
        }
    }

    //------------------------类的继承接口的继承知识点-----------------------------------------------
    //示例看ClassBig.kt类
    //https://www.cnblogs.com/aqi00/p/7380070.html
    /**
     * public : 对所有人开放。Kotlin的类、函数、变量不加开放性修饰符的话，默认就是public类型。
    internal : 只对本模块内部开放，这是Kotlin新增的关键字。对于App开发来说，本模块便是指App自身。
    protected : 只对自己和子类开放。
    private : 只对自己开放，即私有。
     */
    /**
     * open不控制某个对象的访问权限，只决定该对象能否繁衍开来，open表示是否能被继承
     */
    /**
     * open与private不能同时写
     */
    /**
     * 关键字：abstract 抽象方法没有具体的函数体，故而外部无法直接声明抽象类的实例；只有在子类继承之时重写抽象方法，该子类方可正常声明对象实例
     */
    /**
     * 接口：接口不能定义构造函数，否则编译器会报错“An interface may not have a constructor”；
     * 接口的内部方法通常要被实现它的类进行重写，所以这些方法默认为抽象类型；
     * 与Java不同的是，Kotlin允许在接口内部实现某个方法，而Java接口的所有内部方法都必须是抽象方法；
     * Java的extends和implement这两个关键字在Kotlin中都被冒号取代了
     */
    /**
     *  //Kotlin的接口允许声明抽象属性，实现该接口的类必须重载该属性，
    //与接口内部方法一样，抽象属性前面的open和abstract也可省略掉
    //open abstract var skilledSports:String
     */
    /**
     * //Kotlin的接口与Java的区别在于，Kotlin接口内部允许实现方法，
    //此时该方法不是抽象方法，就不能加上abstract，
    //不过该方法依然是open类型，接口内部的所有方法都默认是open类型
     */




    //------------------------------------特殊类-----------------------------------------------------------------------------
    //https://www.cnblogs.com/aqi00/p/7410118.html
    fun diaoyongTSL(){
        var a=qiantaoA.qiantaoB(1)
        var b=qiantaoC(1).qiantaoD(2)
       var str= when(0){
            meijuA.CUNTIAN.ordinal ->meijuB.CHUNTIAN.jijiename
           meijuA.XIATIAN.ordinal -> meijuB.XIATIAN.jijiename
           else -> meijuB.CHUNTIAN.jijiename
       }
        print(str)
    }
    /**
     嵌套类
     */
    class qiantaoA{
        class qiantaoB(var count:Int){
            fun fangfaa(){
                print(count)
            }
        }
    }
    /**
     *
     * 内部类
     */
    class qiantaoC constructor(var count:Int){
        inner class qiantaoD constructor(var count:Int){
           fun fangfaA(){
                print(count)
            }
        }
    }
    /**
     *枚举类
     *
     */
   enum class meijuA{
        XIATIAN,CUNTIAN,QIUTIAN,DONGTIAN
    }

  enum class meijuB(var jijiename:String){
      //定义枚举的名称
      CHUNTIAN("春天"),XIATIAN("夏天"),QIUTIAN("秋天"),DONGTIAN("冬天")
  }

    /**
     * 密封类
     */

    fun diaoyongmifeng(){
        var str =when(0){
           0-> mifengA.chuntian("春天")
           1-> mifengA.dongtian("冬天")
           2-> mifengA.qiutian("秋天")
            else -> mifengA.xiatian("夏天")
        }
        //密封类是一种严格的枚举类，它的值是一个有限的集合。
        //密封类确保条件分支覆盖了所有的枚举类型，因此不再需要else分支。
        when(str){
            is mifengA.chuntian -> str.name
            is mifengA.xiatian -> str.name
            is mifengA.dongtian -> str.name
            is mifengA.qiutian -> str.name
        }
    }
    sealed class mifengA{
        class xiatian(var name:String):mifengA()
        class chuntian(var name:String):mifengA()
        class dongtian(var name:String):mifengA()
        class qiutian(var name:String):mifengA()
    }
    /**
     * 数据类
     * 1、自动声明与构造入参同名的属性字段；
    2、自动实现每个属性字段的get/set方法；
    3、自动提供equals方法，用于比较两个数据对象是否相等；
    4、自动提供copy方法，允许完整复制某个数据对象，也可在复制后单独修改某几个字段的值；
    5、自动提供toString方法，用于打印数据对象中保存的所有字段值；
     */
    fun diaoyongsjl(){
        var sj=shuju(0,"a")
        sj.count=1
        var c=sj.count
    }
    data class shuju(var count:Int,var str:String)
    /**
     * 模板类
     */
    fun diaoyongmb(){
       var leixa= moban(0,1)
        var leixb=moban(1,"一千")
        print(leixa)
        print(leixb)
    }
    //外部调用模板类构造函数的时候，要在类名后面补充“<参数类型>”，从而动态指定实际的参数类型。不过正如声明变量那样，如果编译器能够根据初始值判断该变量的类型，就无需显式指定该变量的类型；模板类也存在类似的偷懒写法，如果编译器根据输入参数就能知晓参数类型，则调用模板类的构造函数也不必显式指定参数类型。
    class moban<T> (var count:Int,var len:T){
        fun getinfo():String{
            var danwei= when(len){
                is String -> "公里"
                is Number-> "km"
                else -> "未知"
            }
            return "$count${danwei.toString()}"
        }
    }
}




