#### 跨域简介
跨域指的是域名不同或者端口不同或者协议不同
1. 域名之间的跨域，例如：a.com 和 b.com 
2. 主域名和子域名之间的跨域，例如ab.a.com 和 a.com
3. 不同协议之间的跨域，例如https:// 和 http://
4. 端口不同也存在跨域，例如 a.com:8080 和 a.com
5. ip和域名之间也存在跨域，例如 124.12.42.123 和 a.com

#### 跨域案例
- 编写一个controller
```
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
```

- 在templates目录下新建一个HTML
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>跨域测试</title>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<div id="hello"></div>
</body>
<script>
    $(function () {
        $.get("http://test.aloneness.com:8080/hello", function (data) {
            $("#hello").text(data);
        })
    })
</script>
</html>
```
- 为了测试，更改hosts文件，将test.aloneness.com域名映射到localhost

hosts文件位置： C:\Windows\System32\drivers\etc
```
127.0.0.1     test.aloneness.com
```

- 启动spring boot服务，访问localhost:8080, 会出现跨域

> Access to XMLHttpRequest at 'http://test.aloneness.com:8080/hello' from origin 'http://localhost:8080' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.

当前是在localhost:8080 但想要访问test.aloneness.com下的资源，于是就出现了跨域问题

#### 使用注解的方式解决
Spring 提供了@CrossOrigin注解

属性 | 含义
---|---
value | 指定跨域的集合，默认为*(所有域都支持)，这些值对应HTTP响应头中的Access-Control-Allow-Origin
origins | 同value
allowedHeaders	| 允许请求头中的header，默认都支持
exposedHeaders	| 响应头中允许访问的header，默认为空
methods	| 支持请求的方法，比如GET，POST，PUT等，默认和Controller中的方法上标注的一致。
allowCredentials	| 是否允许cookie随请求发送，使用时必须指定具体的域
maxAge | 预请求的结果的有效期，默认30分钟

```
@GetMapping("/hello")
@CrossOrigin(value = "*")
public String hello(){
    return "hello";
}
```
再访问localhost:8080，即可成功

#### 实现WebMvcConfigurer接口
实现WebMvcConfigurer 接口，重写addCorsMappings()
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void guo(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET");
    }
}
```

#### 使用过滤器实现
```
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
```
