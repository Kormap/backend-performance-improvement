package com.performance.improvement.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
    //http://localhost:8080/swagger-ui/index.html
    private static final String API_TITLE = "backend-performance-improvement API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "backend-performance-improvement API 명세서";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info() // API 문서 정보 설정
                        .title(API_TITLE) // API 제목
                        .version(API_VERSION) // API 버전
                        .description(API_DESCRIPTION) // API 설명
                        .termsOfService("https://www.example.com/terms") // 서비스 약관 링크
                        .license( // 라이센스 정보
                                new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")
                        )
                        .contact( // 연락처 정보
                                new Contact()
                                        .name("Support Team") // 지원 팀 이름
                                        .url("https://www.example.com/support") // 지원 페이지 링크
                                        .email("test@gmail.com") // 이메일 주소
                        )
                );
    }


}
