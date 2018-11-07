package com.solo.coderiver.comments.handle;

import com.solo.coderiver.comments.VO.ResultVO;
import com.solo.coderiver.comments.exception.CommentsException;
import com.solo.coderiver.comments.utils.ResultVOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = CommentsException.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        if (e instanceof CommentsException) {
            CommentsException exception = (CommentsException) e;
            return ResultVOUtils.error(exception.getCode(), exception.getMessage());
        }
        return ResultVOUtils.error(-1, "未知错误");
    }

}
