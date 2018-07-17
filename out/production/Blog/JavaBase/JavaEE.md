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
    
    
 
   
 