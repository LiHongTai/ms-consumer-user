package github.roger.api;

import feign.RequestLine;
import github.roger.api.config.MsCustomFeignApiCfg;
import github.roger.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-provider-order",configuration = MsCustomFeignApiCfg.class,path = "/order")
public interface MsCustomFeignOrderApi {

    @RequestLine("GET /queryOrderListByUserId/{userId}")
    List<OrderVo> queryOrderListByUserId(@PathVariable("userId") Integer userId);
}
