package com.allyn.demos.kotlinallyndemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

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
    fun Array<Int>.swap(count1: Int, count2: Int) {
        var stwp: Int
        stwp = count1
    }
}