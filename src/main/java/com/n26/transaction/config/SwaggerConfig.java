package com.n26.transaction.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * This is configuration class for Swagger
 *
 * @author dhiren
 * @since 19-05-2018
 */
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket n26TransactionStatsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("transaction").apiInfo(apiInfo()).select()
                .paths(Predicates.or(PathSelectors.regex("/transactions"),
                        PathSelectors.regex("/statistics"))).build();
    }

    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("N26 Statics Challenge Api").version("1.0").build();
    }

}
