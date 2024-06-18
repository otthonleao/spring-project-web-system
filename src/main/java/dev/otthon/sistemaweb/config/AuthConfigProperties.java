package dev.otthon.sistemaweb.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "dev.otthon.sistemaweb.auth") //<groupId> + <artifactId> + auth
public class AuthConfigProperties {

    private String rememberMeToken;
    private Integer rememberMeValiditySeconds;

}
