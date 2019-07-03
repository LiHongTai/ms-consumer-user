package github.roger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.rest.http.request")
@Data
public class RestHttpRequestProperties {

    private Integer readTime;
    private Integer connectTimeout;
}
