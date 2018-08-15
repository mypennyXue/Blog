# servlet生命周期 
## Servlet 的生命周期分为5个周期 ： 加载，创建，初始化，处理客户端请求，卸载
 - 加载： 容器通过类加载器使用servlet类对应的文件加载Servlet
 - 创建： 通过调用servlet构造函数创建一个Servlet对象
 - 初始化：调用init方法初始化
 - 处理客户请求：每当有一个客户请求，容器会创建一个线程来处理客户请求
 - 卸载：调用destory方法让servlet自己释放其占用的资源