# SpringMVC
Spring简单应用+Druid+JNDI多数据源切换
  1.这个项目主要是用了简单的Spring框架，提供页面转换的功能，至于更深层的（如注入等等）都没用上
  2.Druid连接池应该没什么问题，配置的是全变量，可以配置多个数据源
  3.JNDI的有点在于数据源配置在Tomcat上面，运行Tomcat就能创建数据库
  4.本项目主要是用了两个数据源，MySQL+sybase
