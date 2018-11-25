package com.solo.coderiver.project.handle;

import com.solo.coderiver.project.VO.ResultVO;
import com.solo.coderiver.project.exception.ProjectException;
import com.solo.coderiver.project.utils.ResultVOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = ProjectException.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        if (e instanceof ProjectException) {
            ProjectException exception = (ProjectException) e;
            return ResultVOUtils.error(exception.getCode(), exception.getMessage());
        }
        return ResultVOUtils.error(-1, "未知错误");
    }

}
