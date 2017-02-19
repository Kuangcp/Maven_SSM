# 电子书阅读平台

## 所用到的知识模块
- Spring
- Springmvc
- mybatis
- Spring redis 
- shiro
- solr
- websocket
- Spring data
- Spring boot
- npm activiti

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
	- 使用Spring来单例！！！！
	
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
  
          