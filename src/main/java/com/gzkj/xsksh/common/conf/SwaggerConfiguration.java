package com.gzkj.xsksh.common.conf;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
// * 最基本Swagger配置支持多个controller
 * @author chujiajia
 * @version 1.0
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {


	/**
	 * 创建API应用
	 * apiInfo() 增加API相关信息
	 * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
	 * 采用扫描指定注解@Api
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
//		List<Parameter> pars = new ArrayList<Parameter>();
//		ParameterBuilder ticketPar = new ParameterBuilder();
//		ticketPar.name("Authorization").description("验证").defaultValue("")
//				.modelRef(new ModelRef("string")).parameterType("header")
//				.required(false).build();
		//header中的ticket参数非必填，传空也可以
//		pars.add(ticketPar.build());  //根据每个方法名也知道当前方法在设置什么参数
		//配置多个controller时用
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("xsksh")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any())
				.build();
//				.globalOperationParameters(pars);
	}

	/**
	 * 创建该API的基本信息（这些基本信息会展现在文档页面中）
	 * 访问地址：http://项目实际地址/swagger-ui.html
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("xsksh")
				.version("v1.0")
				.description("xsksh")
				.build();
	}


}
