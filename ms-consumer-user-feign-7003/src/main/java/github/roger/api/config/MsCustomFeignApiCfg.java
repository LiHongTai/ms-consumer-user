package github.roger.api.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import github.roger.interceptor.CustomRestInterceptor;
import org.springframework.context.annotation.Bean;

public class MsCustomFeignApiCfg {

    @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options feignRequestOptions(){
        return new Request.Options(30000,30000);
    }

    @Bean
    public RequestInterceptor customRestInterceptor(){
        return new CustomRestInterceptor();
    }
}
