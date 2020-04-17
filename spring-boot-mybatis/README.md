#### spring-boot-mybatis

- 整合数据连接池druid

注意需要引进spring-jdbc, 否则启动报错, 整合mybatis时已经有spring-jdbc,不需要额外引入

- 访问地址
```java
http://localhost:8080/druid/index.html
```

- spring boot整合mybatis
```java
mybatis:
  type-aliases-package: com.aloneness.springbootmybatis.domain
  mapper-locations: classpath:mapper/*.xml
```
加入@MapperScan注解 

- 整合分页插件PageHelper 

注意：PageHelper.startPage(1, 2); 需要放在查询语句之前，否则会失效