//package com.gzkj.xsksh.common.conf;
//
//import com.gzkj.base.auth.CustomWebResponseExceptionTranslator;
//import com.gzkj.base.conf.EnableSwaggerConfig;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * 资源服务器配置类
// * @author Liuzd QQ：<77822013> 2019/5/28 0028
// */
//@EnableResourceServer
//@Configuration
//@Import(EnableSwaggerConfig.class)
//public class CustomResourceServerConfig {
//
//    private final ResourceServerProperties resource;
//
//    public CustomResourceServerConfig(ResourceServerProperties resource) {
//        this.resource = resource;
//    }
//
//    @Bean
//    public ResourceServerConfigurer resourceServerConfigurer() {
//        return new ResourceSecurityConfigurer(resource);
//    }
//
//    @Bean
//    public RedisTokenStore redisTokenStore(RedisConnectionFactory redisConnectionFactory) {
//        return new RedisTokenStore(redisConnectionFactory);
//    }
//
//    protected static class ResourceSecurityConfigurer extends ResourceServerConfigurerAdapter {
//
//        private final ResourceServerProperties resource;
//
//        private ResourceSecurityConfigurer(ResourceServerProperties resource) {
//            this.resource = resource;
//        }
//
//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources)
//                throws Exception {
//            resources.resourceId(this.resource.getResourceId());
//            OAuth2AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
//            authenticationEntryPoint.setExceptionTranslator(new CustomWebResponseExceptionTranslator());
//            resources.authenticationEntryPoint(authenticationEntryPoint);
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http
//                    .logout().disable()
//                    .cors().and()
//                    .authorizeRequests()
////                    .antMatchers("/kafkaConsumerTask/**").permitAll()
//                    .antMatchers("/**").permitAll()
////                    .antMatchers("/**").hasRole("vip")
//                    .anyRequest()
//                    .authenticated();
//        }
//
//    }
//}
