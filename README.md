# 电子书阅读平台

## 所用到的知识模块
- Spring
- Springmvc
- mybatis
- Spring redis 
- websocket
- maven
 


## 思想
- AOP
- MVC

## 2017-1-26 23:44:02
- 代码设计了两周，现在才开始使用git，刚开始是觉得挺容易的系统，现在感觉大部分时间花在了不擅长的前端上。
- 深夜提交，还有两个终极BUG没有解决，一个是jetty使用EL表达式，一个是jetty或Tomcat在maven下debug！！！

## 2017-2-9 12:38:42
- 弃用了作为maven插件的jetty或者Tomcat，用回了外置解压的Tomcat
    - 插件的俩WEB服务器都不能开启debug模式，调试麻烦
    - 但是内置的便于配置日志输出，外置Tomcat使用项目内的日志配置文件需要改动挺多
- 网络知识以及业务理解能力薄弱，难以构建良好高效的数据交换架构

## 2017-2-15 23:17:43
- 使用redis作为数据缓存，减少对数据库连接的访问提高性能
	- 使用Spring的IOC来管理来单例
	
## 2017-2-17 21:35:38
- 学新东西的动力没有以前足了
- 想要启动Tomcat之后，初始化运行一些方法，把数据从数据库拿出放入redis中，然后使用了ServletContextListener
    - 然后还是按照往常一样的使用Spring自动注入的便利，来使用service层获取数据，但是忽略了启动顺序
    - **context-param -> listener -> filter -> servlet**
    - 所以在启动这个初始化方法的时候，其实Spring的环境是还没有加载的，所以没有扫描，也就没有了自动注入，也就有了空指针异常
    - 所以要使用如下方法得到Spring的Context（上下文），获取bean，再操作
  
```
    public void contextInitialized(ServletContextEvent event) {  
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        ....
    }
```    

## 2017-2-21 23:02:37
- redis键的压缩处理，提高性能，以及连接池的性能处理
- redis多数据库的使用，提高数据合理性，redis密码的设置，安全性
- 记录对方id的机制要改，加载消息要限制最近30条，其他的在历史记录里分页查看
- 新消息提示，更改阅读状态
- 其他模块的编写
- Toolkit 的仓库转移，改成maven项目，便于发布和处理JAR的关系，发布到maven中央仓库去
- 多阅读别人的代码，查看别人的思路，借鉴，升华
  
## 2017-2-22 22:34:47
- 更改状态表，添加一列，redis发挥更多用处，将常用的不经常刷新的数据全部放在redis中，而不是使用MySQL来查询
- 新建一个消息发送和接收的映射表，发送方，接收方，简化查询
- 现在的思路就是，存储长字符串就要用分隔符，然后正则，或者使用json，使用redis缓存聊天记录，当新消息达到10或20再发送一次批量的插入数据库
- 注销和停库就要清除里面新消息，转存到数据库中，
- 日志要完善，主要体现在service层中

## 2017-2-23 9:56:10
- redis Key失效时间的问题，一般来说redis里的key都是长期的直到tomcat关闭，要清理就要手动清理
    - 一般说来，redis也是自动存储到硬盘的，所以是不会失效的
- github 关于User.email  和 user.name 属性的识别问题

- npm activiti
- shiro
- solr          
