package github.roger.service.impl;

import github.roger.SpringBaseTestSuit;
import github.roger.entity.User;
import github.roger.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends SpringBaseTestSuit {

    @Autowired
    private UserService userService;

    @Test
    public void findById() {
        User user = userService.findById(1);
        System.out.println(user);
    }
}