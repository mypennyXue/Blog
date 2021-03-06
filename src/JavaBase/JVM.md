# JVM 内存模型（JMM）

## 内存可见性
 - 所谓可见性 是指当一条线程修改了共享变量的值 新值对于其他变量来是可以立即得知的.
## volatile 的作用
   - 禁止指令重排序
      - 重排序不会对存在数据依赖关系的的操作进行重新排序
      - 重排序是为了优化性能 但是不管怎么排序 单线程下程序的执行结果不能被改变
   - 若用volatile 关键字修饰共享变量 在编译时 会在指令序列中插入内存屏障来禁止特定类型的而处理器重排序
   
   - 线程工作内存从主内存 拷贝共享变量-> 线程操作之后 线程将变量的值回写到主内存 这一系列操作不是原子的 
volatile 关键字的作用是 jvm保证从主内存中加载到线程工作内存的值是最新的

##  final 
 - 如果在一个线程构造了一个不可变对象之后（对象仅包含final字段），就可以保证了这个对象被其他线程正确的查看,
 是错误的 final 只是指向不变 但是指向的值有可能会变

# JVM 堆内存设置原理
## 原理
- JVM 堆内存分为两块 ： Permanent space 和 Heap Space
   - Permanent 即持久代 主要存放的是Java类定义信息 与垃圾收集器要收集的额Java对象关系不大
   - Heap = {Old,NEW = {Eden,from,to}},Old即年老代 New 即年轻代 年老代和年轻代的划分对垃圾收集影响比较大
## 年轻代
 - 所有的新生成的对象首先放在年轻代 年轻代的目标就是尽可能快速的收集掉那些生命周期短的对象 年轻代 一般分为3个区
 一个Eden 2个Survivor(from和to) 
 大部分 对象在Eden区中生成 当Eden区满的时候 还存活的对象将被复制到Survivor区，当一个Survivor区满的时候 、
 此区的存活对象将被复制到另一个Survivor，另一个也满的时候，从前一个Survivor区复制过来的并且此时还存活的对象 将可能被复制到年老代
 Survivor中的而对象既可能来自Eden 也可能来自另一个Survivor。
 - 针对年轻代的垃圾回收即YoungGC
 
 ## 年老代
 - 在年轻代中经历了N次(可配置)垃圾回收后仍然存活的对象 就会被复制到年老代 
 - 针对年老代的垃圾回收即FullGC
 ## 持久代
 - 用于存放静态类型数据 如Java Class，Method等，但是有些应用可能动态生成或调用一些Class 例如 Hibernate 
 ，CGLib等 在这种时候往往需要设置一个比较大的持久代空间来存放这些运行过程中动态增加的类型
 - 当一组对象生成时 内存申请过程如下：
    - JVM 会试图为相关Java对象在年轻代的Eden区中初始化一块内存区域
    - 当Eden区空间足够时 内存申请结束 否则进行下一步 
    - JVM试图释放在Eden区中所有不活跃的对象（Young GC）。释放后若Eden空间仍然不足以放入新对象，JVM则试图将部分Eden区中活跃对象放入Survivor区。
    - Survivor区被用来作为Eden区及年老代的中间交换区域。当年老代空间足够时，Survivor区中存活了一定次数的对象会被移到年老代。
    -  当年老代空间不够时，JVM会在年老代进行完全的垃圾回收（Full GC）。
    - Full GC后，若Survivor区及年老代仍然无法存放从Eden区复制过来的对象，则会导致JVM无法在Eden区为新生成的对象申请内存，即出现“Out of Memory”。
 
 
 
 