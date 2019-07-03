package github.roger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(value = RestHttpRequestProperties.class)
public class SpringConfig {

    @Autowired
    private RestHttpRequestProperties restHttpRequestProperties;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory restTemplateFactory = new SimpleClientHttpRequestFactory();

        restTemplateFactory.setReadTimeout(restHttpRequestProperties.getReadTime());
        restTemplateFactory.setConnectTimeout(restHttpRequestProperties.getConnectTimeout());

        return new RestTemplate(restTemplateFactory);
    }
}
