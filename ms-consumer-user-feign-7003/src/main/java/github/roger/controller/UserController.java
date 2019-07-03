package github.roger.controller;

import github.roger.api.MsCustomFeignOrderApi;
import github.roger.api.OrderApi;
import github.roger.entity.User;
import github.roger.exception.CommonException;
import github.roger.service.UserService;
import github.roger.vo.OrderVo;
import github.roger.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderApi orderApi;

    @Autowired
    private MsCustomFeignOrderApi msCustomFeignOrderApi;

    @RequestMapping("/queryUserInfoById/{id}")
    public UserInfoVo queryUserInfoById(@PathVariable("id") Integer id) {
        try {
            User user = userService.findById(id);
            List<OrderVo> orderVoList = orderApi.queryOrderListByUserId(user.getId());

            return new UserInfoVo(user.getUserName(), orderVoList);
        } catch (Exception exc) {
            throw new CommonException(0, exc.getMessage());
        }
    }

    @GetMapping("/getIpAndPort")
    public String getIpAndPort() {
        return orderApi.getRegisterInfo();
    }

    @RequestMapping("/queryUserInfoByIdByCustomFeign/{id}")
    public UserInfoVo queryUserInfoByIdByCustomFeign(@PathVariable("id") Integer id) {
        try {
            User user = userService.findById(id);
            List<OrderVo> orderVoList = msCustomFeignOrderApi.queryOrderListByUserId(user.getId());

            return new UserInfoVo(user.getUserName(), orderVoList);
        } catch (Exception exc) {
            throw new CommonException(0, exc.getMessage());
        }

    }
}