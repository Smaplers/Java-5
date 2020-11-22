# Java-5
Java课程作业项目仓库

一、 实验目的
1. 掌握字符串String及其方法的使用
2. 掌握文件的读取/写入方法
3. 掌握异常处理结构

二、 文件处理部分要求
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。
文件A包括两部分内容：
1. 学生的基本信息；
2. 学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：
1) 每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
2) 允许提供输入参数，统计古诗中某个字或词出现的次数
3) 输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A
4) 考虑操作中可能出现的异常，在程序中设计异常处理程序

三、 学生类部分要求：
1. 设计学生类（可利用之前的）；
2. 采用交互式方式实例化某学生；
3. 设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。

四、 实验流程
1. 建立学生类，要求如下：
1) 设立带有修饰符private的字符串型变量name，number，team
2) 创建变量对应的set与get函数，用来赋值与获取
3) 利用toString来复写学生类，方便后面的写入文件
2. 设计Test类，要求如下：
1) 设立StringBuffer类ReadTxt（String path）函数，用来读取并处理文件格式。
A. 利用FileInputStream将所定地址中的文件打开，并以字节形式进行读取
B. 利用InputStreamReader将上述的字节流来解码为字符型
C. 定义足够大的字符型数组chars
D. 定义StringBuffer型变量s
E. 通过遍历将B中的字符流存入C中所建立的字符型数组中
F. 利用chars的数组下标和单个数组下标中的元素，通过循环将数组中的元素存入D中建立的字符串s
G. 在F中的循环中添加if来判断是否在字符串中添加标点与换行
H. 返回处理好的字符串s （return s）
2) 主函数main，要求：
A. 调用ReadTxt函数
B. 将函数的值赋值给变量s（StringBuffer类型）
C. 建立while循环，利用switch和if来完成对s中出现字或词的次数查询
D. 在while中建立scanner类用于用户输入所需功能代码，1为查询，2为退出
E. 利用pattern和matcher方法，通过正则表达式来统计古诗中字或词出现的次数
F. 通过if与matcher方法来判断古诗中是否有输入的字或词
G. 通过for与if来统计同一字或词出现的次数
H. 初始化学生类对象
I. 通过scanner与学生类中set函数来实例化学生类对象
J. 添加try catch来对输入的值进行异常处理，并添加自定义异常与正则表达式，直到用户正确输入后，程序才会向下运行
K. 将学生类对象用append添加到s中，并通过writer来写入到文件中

五、 核心代码
以下代码展示了Java如何读取文件，如何处理文件中的字符串，利用字节流来读取文件，以及用字符流来将字节转换为字符，并将字符流存储在字符型数组中，并结合数组下标来将处理好的字符赋值在动态字符串中。
public static StringBuffer ReadTxt(String path) {
        StringBuffer s = new StringBuffer();
        // 读取文件内容 (输入流)
        try {
            FileInputStream out = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(out);
            char[] chars = new char[9999999];
            int ch = 0;
            int i = 0;
            while ((ch = isr.read()) != -1) {
                chars[i] = (char) ch;
                i++;
            }
            for (int j = 0; j < i; j++) {
                s.append(chars[j]);
                if ((j + 1) % 7 == 0 && (j + 1) % 2 == 0) {
                    s.append("。" + "\n");
                }
                if ((j + 1) % 7 == 0 && (j + 1) % 2 != 0) {
                    s.append("，");
                }
            }
        } catch (Exception e) {
            System.out.println("1");
        }
        return s;
    }

六.实验总结
    此次实验我进一步了解异常的使用方法，进一步掌握并使用Object根类的toString（）方法,应用在相关对象的信息输出中并在程序中根据输入情况做异常处理；
    基本掌握了字符串String及其方法的使用、掌握文件的读取/写入方法；
    体会到了修饰符private用法：private访问修饰符是限制性最大的一种访问修饰符，被声明为private的成员只能被此类中的其他成员访问，不能被外类看到，提高安全性，实现了数据封装的思想。
    对于cpu.setSpeed(2200)这句话中speed被private保护了起来，没法直接对它进行赋值，必须用使用private所在的程序中调用speed的方法对speed赋值。
    对类的封装也有了更深的理解。
