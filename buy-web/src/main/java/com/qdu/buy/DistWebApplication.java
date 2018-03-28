package com.qdu.buy;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

//springboot启动类

//@EnableDiscoveryClient   //取消服务注册功能
@SpringBootApplication
@MapperScan("com.qdu.buy.dao")
@EnableCaching
@EnableAsync
public class DistWebApplication {

	public static void main(String[] args) {
 		SpringApplication.run(DistWebApplication.class, args);
	}

	/**
	 * 增加自定义视图变量和方法
	 *
	 * @return
	 */
	@Bean
	public CommandLineRunner customFreemarker(FreeMarkerViewResolver resolver) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				//增加视图
				//resolver.setViewClass(.class);
				//添加自定义解析器
//				Map map = resolver.getAttributesMap();
//				map.put("conver", new MyConver());
			}
		};
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error.html");
			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html");

			container.addErrorPages(error401Page, error404Page, error500Page);
		});
	}


}
