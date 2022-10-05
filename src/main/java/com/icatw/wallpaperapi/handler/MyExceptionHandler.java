package com.icatw.wallpaperapi.handler;

import com.icatw.wallpaperapi.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author icatw
 * @date 2022/10/4
 * @email 762188827@qq.com
 * @apiNote
 */
@RestControllerAdvice
public class MyExceptionHandler {
    //进行异常处理，处理Exception.class的异常
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex) {
        ex.printStackTrace();
        return R.fail(-999, "系统异常");
    }
}
