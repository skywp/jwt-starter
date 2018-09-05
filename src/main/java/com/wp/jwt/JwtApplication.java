package com.wp.jwt;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
@SpringBootApplication
public class JwtApplication extends WebMvcConfigurerAdapter {

	/**
	 * 第一种方式实现fastjson
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		/**
		 * 1.先定义一个convert转换消息的对象.
		 * 2.添加fastjson的配置信息，比如：是否要格式化返回的json数据；
		 * 3.在convert中添加配置信息；
		 * 4.将convert添加到converts中。
		 */
		//1.需要先定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		//2.添加fastjson的配置信息，比如：是否要格式化返回json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3.在convert中添加配置信息
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastJsonHttpMessageConverter);
	}

	public static void main(String[] args) {
		//第一种方式启动
		SpringApplication.run(JwtApplication.class, args);

//		//关闭banner 启动
//		SpringApplication app = new SpringApplication(StudyApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
	}
}
