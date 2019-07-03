package github.roger.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class CustomRestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("自定义feign请求的拦截器,给HTTP请求设置参数....");
        requestTemplate.header("token","123456");
    }
}
