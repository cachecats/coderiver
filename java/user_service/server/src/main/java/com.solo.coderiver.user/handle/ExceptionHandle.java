package com.solo.coderiver.user.handle;

import com.solo.coderiver.user.VO.ResultVO;
import com.solo.coderiver.user.exception.UserException;
import com.solo.coderiver.user.utils.ResultVOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultVOUtils.error(userException.getCode(), userException.getMessage());
        }
        return ResultVOUtils.error(-1, "未知错误");
    }

}
