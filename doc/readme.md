EventBus原理总结:
#### 使用方法
1. 定义事件
2. Annotation声明订阅方法
3. 运行时 register对象
   通过Annotation获取订阅的方法，缓存类，对象，方法
4. 事件发生时post对象
   查找订阅了该post对象的对象，方法，通过反射调用方法
5. 结束时unRegister对象
   注销与对象相关的缓存数据

#### 四种订阅线程
      
      a）POSTING（默认）：事件在哪个线程发布，就在哪个线程消费，因此要特别注意不要在UI线程进行耗时的操作，否则会ANR；

      b）MAIN：事件的消费会在UI线程。因此，不宜进行耗时操作，以免引起ANR。

      c）BACKGROUND：如果事件在UI线程产生，那么事件的消费会在单独的子线程中进行。否则，在同一个线程中消费。

      d）ASYNC：不管是否在UI线程产生事件，都会在单独的子线程中消费事件

#### 使用到的重点技术
1. ThreadLocal存储当前post线程的发送信息
   * queue events posted on the same thread while posting
2. executorService
    * 用于发送到各线程
3. Runnable
   * 每个poster实现Runnable
4. 反射技术
   * 发送时调用到Subscriber中的方法 
5. COW技术
   * 防止迭代安全失败问题 
