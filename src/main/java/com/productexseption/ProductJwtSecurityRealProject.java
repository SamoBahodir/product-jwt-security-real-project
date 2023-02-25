package com.productexseption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@Slf4j
@EntityScan(basePackages = "com.productexseption")
@EnableJpaRepositories(basePackages = "com.productexseption")
@SpringBootApplication(scanBasePackages = "com.productexseption")
public class ProductJwtSecurityRealProject {
    // 1-> rest api
    // 2-> jwt,
    public static void main(String[] args) {
        var run = SpringApplication.run(ProductJwtSecurityRealProject.class, args);
        initApplication(run.getEnvironment());
    }

    private static void initApplication(Environment env) {
        var serverPort = Optional.ofNullable(env.getProperty("server.port")).orElse("8081");
        var hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info(
                """

                        ----------------------------------------------------------
                        \tApplication '{}' is running! Access URLs:
                        \tLocal: \t\thttp://localhost:{}
                        \tExternal: \thttps://{}:{}
                        \tProfile(s): \t{}
                        ----------------------------------------------------------""",
                env.getProperty("spring.application.name"),
                serverPort,
                hostAddress,
                serverPort,
                env.getActiveProfiles()
        );
    }
}