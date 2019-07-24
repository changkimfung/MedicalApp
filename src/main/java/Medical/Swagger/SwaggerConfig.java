package Medical.Swagger;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletResponse;

/**
 * 接口文档动态生成配置
 * @author zjf
 * @date   2019/03/06
 */

@Configuration
public class SwaggerConfig {


    @Value("${SwaggerConfig.package}")
    private  String basepackage;

    @Value("${SwaggerConfig.title}")
    private  String title;

    @Value("${SwaggerConfig.description}")
    private  String description;

    @Value("${SwaggerConfig.name}")
    private  String name;

    @Value("${SwaggerConfig.version}")
    private  String version;

    @Bean
    public Docket createRestApi(){

        return  new Docket(DocumentationType.SWAGGER_2)
                            .apiInfo(apiInfo())
                            .select()
                            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                            .paths(PathSelectors.any())
                            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                  .title(title)
                  .description(description)
                  .contact(new Contact(name,null,null))
                  .version("版本号"+version)
                  .build();

    }

}
