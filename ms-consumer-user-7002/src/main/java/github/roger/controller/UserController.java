package github.roger.controller;

import github.roger.entity.User;
import github.roger.exception.CommonException;
import github.roger.service.UserService;
import github.roger.vo.OrderVo;
import github.roger.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/queryUserInfoById/{id}")
    public UserInfoVo queryUserInfoById(@PathVariable("id") Integer id){
        try {
            User user = userService.findById(id);
            ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://MS-PROVIDER-ORDER/order/queryOrderListByUserId/" + id, List.class);
            List<OrderVo> orderVoList = responseEntity.getBody();

            return new UserInfoVo(user.getUserName(), orderVoList);
        }catch (Exception exc){
            throw new CommonException(0,exc.getMessage());
        }
    }

    @GetMapping("/getIpAndPort")
    public String getIpAndPort() {
        return this.restTemplate.getForObject("http://MS-PROVIDER-ORDER/order/getRegisterInfo",String.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MS-PROVIDER-ORDER");
        log.info("serviceId------------>:{},ip:{},port:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
