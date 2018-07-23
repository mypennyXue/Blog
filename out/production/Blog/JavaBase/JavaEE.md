# Java 数据类型
 - byte
 - char 
 - int 
 - short 
 - long 
 - float
 - double
 - bollean
 
 ## 缓冲池 
 - new Integer(123) Integer.valueOf(123) 的区别在于 new Integer(123) 每次都会新建一个对象,
 而 Integer.valueOf(123) 可能会使用缓存 对象，因此多次使用integer.valueOf(123) 会取得同一个对象的引用
  编译器在自动装箱的过程调用valueOf()方法.
  
 ## String
  String 被申明为final 因此不可以被继承
  内部使用char数组存储数据 该数组被申明为final 这意味着value 数组被初始化后就不能再引用其他的数组 并且String内部没有改变 
  value数组的方法 因此可以保证String不可变
  
 ## String 不可变的好处
 - 可以缓存hash值
  因为String的hash值经常被使用（String 用作HashMao的key）不可变得特性可以使得hash值也不变，因此只需要进行一次计算
 - String pool的需要
  如果一个String 对象已经被创建过了，那么就会从String pool中取得引用 只有String 是不可变得 才能使用String pool
 ## 安全性
 String 经常作为参数 String不可以变性 可以保证参数不可变， 例如在作为网络连接参数的情况下如果String是可变的那么在
  网络连接的过程中个String 被改变 改变String对象的那一方以为现在连接的是其他的主机 而实际的情况却不一定是
 ## 线程安全
 String不可变性天使具备线程安全，可以在多个线程中安全的使用
 
 ## String StringBuffer StringBuilder
 ### 可变性
 - String 不可变
 - StringBuilder和Stringbuffer 可变
 ### 线程安全
 - String 不可变 线程安全
 - StringBuilder 不是线程安全的
 - StringBuffer 是线程安全的 synchronized 进行同步

##String.intern()
 - 使用String.intern() 可以保证相同的内容的字符串变量引用相同的内存对象
 - new String() 会新建一个对象
 - String str = "" 会自动的将新建的对象放入String pool中
 
##运算
### 参数传递
    java 的参数是以值得形式传入方法中 而不是引用
## float 和 double
    - 1.1 的字面量是double类型 不能直接将1.1 直接赋值给float变量 因为这是向下转型，不能隐式向下转型
    - 1.1f 字面量才是float类型
## 隐式类型转换
   - 1 的 字面量是int 比short的精度要高 因此不能隐式的将int类型转型为short
   short s1 = 1; 编译不能通过
   但 += 可以进行隐式的类型转换 s1 += 1; 相当于 s1 = (short) (s1 + 1);
#继承
##访问权限
- java中有三个访问权限修饰符：private，protected，public 如果不加访问修饰符，表示包级可见
可以对类或类中的成员（字段以及方法）加上访问修饰符
- 如果子类的方法覆盖了父类的方法，那么子类中该方法的访问级别不允许低于父类的访问级别，
这是为了确保可以使用父类实例的地方都可以使用子类实例（里氏特换原则）
# 抽象类与接口

## 抽象类
- 抽象类和抽象方法都使用abstract进行申明，抽象类一般包含抽象方法，抽象方法一定位于抽象类中。
   抽象类和普通类最大的区别是 抽象类不能被实例化 需要继承抽象类才能实例化其子类。
## 接口
- 接口的字段默认都是static 和 final的
接口的成员（字段和方法） 默认都是public的 并且不允许定义为private或者protected
 ## 比较
  - 从设计层面上看 抽象类提供了一种IS-A关系，那么就必须满足里氏特换原则，而 接口更像一种LIKE-A关系, 它
  只是提供一种方法实现契约 并不要求接口和实现接口的类具有IS-A关系
  - 使用上 一个类可以实现多个接口，但是不能继承多个抽象类
  - 接口的字段只能是static和final类型的 而抽象类的字段没有这种限制
  - 接口的方法只能是public 而抽象类的方法可以有多重访问权限
  
## 使用选择
 ### 使用抽象类
 - 需要在相关的类中共享代码
 - 需要能控制继承来的成员的访问权限 而不是都为public
 - 需要继承非静态和非常量字段
 ### 使用接口
 - 需要让不相关的类都是些一个方法,例如不相关的类都可以实现Compareable接口中的compareTo()方法
 - 需要使用多重继承
 ##super
 - 访问父类的构造函数： 可以使用super() 函数访问父类的的构造函数 从而完成一些初始化的工作
 - 访问父类的成员：如果子类覆盖了父类中的某个方法的实现 可以通过使用super关键字来引用父类的而方法实现

## 不常见的关键字
   ### native 
    修饰的方法是一个原生态的方法 方法对应的实现不是在当前文件而是在用其他语言实现的文件中
   java 语言本身不能对操作系统底层进行访问和操作 可以通过JNI接口调用其他语言来实现对底层的访问。
   ### transient 
    一个类实现了Serrilizable的接口 某些属性不需要序列话的时候 可以使用transient，
   transient 只能修饰变量 不能修饰类和方法
   - transient 变量不再是对象持久化的一部分，该变量内容在序列后无法取得访问
   - transient 只能修饰变量 不能修饰方法和类 
   
##Object 常用方法
 - public final native Classs<T> getClass();
 - public native int hashCode();
 - public boolean equal(Object o);
 - proteced native Object clone() throws CloneNotSupportException;
 - public String getString();
 - public native void notify();
 - public native void wait(Long timeout) throws InterruptException;
 - public native void wait(Long timeout ,int nanao) throws InterruptException;
 - public native void wait() throw InterruptException;
 - public void finalize throws Throwable;
###equal 
 - equal 与 == 的区别：
 对于基本类型 == 是判断两个变量的值是否相等 没有equal() 方法
 - 对于引用类型 == 判断两个变量是否引用的是同一个对象 而 equal 判断的是两个对象是否等价
 - hashcode()
 hashCode() 返回的是对象的散列值而equal()是用来判两个对象是否等价 hashCode相等的两个对象一定等价
 等价的两个对象hashCode不一定相等
 - clone()
  clone() 是Object 的一个protected 的方法 如果一个类没有显示的重写clone()方法 就不能调用clone方法
  - 深度拷贝和浅拷贝 ： 深拷贝 拷贝对象和原始对象引用同一个对象 浅拷贝 拷贝对象和原始对象 引用不同对象
  # 关键字
  ##final 
  - 申明变量是 基本数据的值不能改变 引用变量不能引用其他的对象 但是被引用的对象本身的值可以修改
  - 申明方法 方法不能被重写 private 方法 被隐式的指定为final 如果一个子类中定义的方法和基类的private 方法签名相同 
  此时不是重写而是重新定义了一个方法
  - 申明类 类不能被继承
  ##static
  - 静态变量 类所有的实例都共享静态变量 静态变量在内存中只存在一份
  - 实例变量 每创建一个实例就会创建一个实例变量与该实例同生共死  
  - 静态方法 静态方法在类加载的时候就存在了 不依赖任何实例 所以静态方法必须要有实现 不能是abstract的 
  静态方法只能访问静态的方法或者变量 方法中不能有this 或者super这样的关键字
  - 静态语句块 在类初始化时执行一次
  - 静态内部类：非静态内部类需要依赖外部类实例 静态内部类不需要 静态内部类 不能访问外部类的非静态变量和方法
  - 静态导入包 ： 在使用静态变量和方法时不用指定className 
  ##初始化顺序
  - 静态变量和静态语句块 优先于 实例变量和普通语句块  静态变量和静态语句块初始化顺序取决于他们在代码中
  的顺序 最后才是 构造函数
  - 存在继承关系的时候初始化顺序 父类（静态变量和静态语句块） 子类（静态变量和静态语句块） 
  父类（实例变量和普通语句块） 父类（构造） 子类（实例变量和普通语句块） 子类（构造）
  
  #反射
  - 每个类都有一个Class对象 包含了与类有关的信息 编译一个类时 会产生一个同名的.class文件 
  该文件保存着Class对象 类加载相当于Class对象的加载 类在第一次使用的时候才动态的加载到jvm
  可以使用Class.forName("") 的方式来控制类的加载 这个方法会返回一个Class对象 
  
  # 异常
Throwable 可以用来表示任何可以作为异常抛出的类 分为两种: ERROR 和EXCEPTION
- ERROR 表示JVM无法处理的错误
- exception 分为两种 受检异常（需要使用try ...catch ...b捕获处理 比并能重异常中恢复  ）
和非受检异常 （是程序运行时的错误 此时程序崩溃并且不能恢复） 
# 泛型
# 注解
# 特性   
  
   
                                                     
                              
                                                     

                                                      

 