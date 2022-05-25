package com.myz.azloanmanage.exception;


import com.myz.azloanmanage.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author 阿杰
 * @create 2021-04-25 17:26
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result exception(RuntimeException e) {
        log.error("系统运行时异常 --> {}", e.getMessage());
        return new Result(500, e.getMessage());
    }

    /**
     * 自定义权限不足异常
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public Result exception(AccessDeniedException e) {
        log.info("spring security权限不足!!! --> {}", e.getMessage());
        return new Result(403, "权限不足");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public Result exception(UsernameNotFoundException e) {
        log.info("用户名没有找到 --> {}", e.getMessage());
        return new Result(403, e.getMessage());
    }

    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result exception(IllegalArgumentException e) {
        log.info("Assert非法数据 --> {}", e.getMessage());
        return new Result(403, e.getMessage());
    }
}
