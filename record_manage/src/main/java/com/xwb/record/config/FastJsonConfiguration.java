package com.xwb.record.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		converters.removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
		// 先定义一个fastJsonHttpMessageConverte转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		// 添加fastJson的配置信息，比如是否需要格式化返回的JSON数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				// 防止循环引用
                SerializerFeature.DisableCircularReferenceDetect, 
                // 空集合返回[],不返回null
                SerializerFeature.WriteNullListAsEmpty, 
                // 空字符串返回"",不返回null
                SerializerFeature.WriteNullStringAsEmpty,
                // 是否输出值为null的字段,默认为false
                SerializerFeature.WriteMapNullValue
		);
		fastConverter.setFastJsonConfig(fastJsonConfig);

		// 解决fastJson中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);


		// 将fastJsonHttpMessageConverter添加到converters当中
		converters.add(fastConverter);
	}
}
