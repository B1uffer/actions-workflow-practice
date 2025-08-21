package com.codeit.ecspracticestarter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
    @Value("${SPRING_PROFILES_ACTIVE:#{null}}") // 환경변수를 못찾으면 그냥 터진다
    private String springProfilesActive;

    @Value("${DB_HOST:#{null}}") // application-prod.yml을 참조한다
    private String dbHost;

    @Value("${DB_PASSWORD:#{null}}")
    private String dbPassword;

    @GetMapping("/env")
    public String showEnv() {
        return String.format("""
                SPRING_PROFILES_ACTIVE=%s
                DB_HOST=%s
                DB_PASSWORD=%s
                """, springProfilesActive, dbHost, dbPassword);
    }

    /**
     * """는 JDK 11버전부터 지원할것이다
     */
}
