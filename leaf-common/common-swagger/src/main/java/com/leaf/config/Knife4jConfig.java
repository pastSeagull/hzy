package com.leaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("# swagger-bootstrap-ui-demo RESTful APIs")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .title("板蓝根")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("wo")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.leaf"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
//    @Bean
//    public Docket docket(Environment environment){
//        Profiles profiles = Profiles.of("dev","adaf");
//        Boolean fl =environment.acceptsProfiles(profiles);
//        return  new Docket(DocumentationType.SWAGGER_2)
//                .groupName("hzy")
//                .enable(true)
//                .apiInfo(new ApiInfoBuilder()
//                        .title("nightStart")
//                        .description("黑夜")
//                        .version("1.0.0")
//                        .contact(new Contact("night","977504087@qq.com","977504087@qq.com"))
//                        .license("Apache.2.0")
//                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
//                        .extensions(new ArrayList<VendorExtension>())
//                        .termsOfServiceUrl("http://baidu.com")
//                        .build())
//                .select()
//                //要扫描接口的方式
//                //指定要扫描的包
//                .apis(RequestHandlerSelectors.basePackage("com.night"))
//                .paths(PathSelectors.any())
//                .build();
//
//    }
}
