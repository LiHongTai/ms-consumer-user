package github.roger.handler;


import github.roger.exception.CommonException;
import github.roger.vo.UserInfoVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 针对所有的controller抛出的
 *      {@link github.roger.exception.CommonException}
 *    进行统一处理
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public Object dealException() {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserName("容错用户");
        userInfoVo.setOrderVoList(null);

        return userInfoVo;
    }
}
