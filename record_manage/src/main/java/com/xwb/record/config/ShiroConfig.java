package com.xwb.record.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro 配置
 * @author xiongwb
 *
 */
@Configuration
public class ShiroConfig {

	@Bean
	public Realm realm() {
		AuthRealm realm = new AuthRealm();
		return realm;
	}
	
	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
	    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
	    chainDefinition.addPathDefinition("/**", "anon");
	    return chainDefinition;
	}
}
