package com.icatw.wallpaperapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回对象R
 *
 * @author icatw
 * @since 2022-10-04 20:55:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {

    private Integer code;
    private String msg;
    private Object data;

    public static R ok() {
        return new R(ResultStatusEnum.SUCCESS.getCode(), "" , null);
    }

    public static R ok(Object data) {
        return new R(ResultStatusEnum.SUCCESS.getCode(), "" , data);
    }

    public static R fail(Integer code, String msg) {
        return new R(code, msg, null);
    }

    public static R fail() {
        return new R(ResultStatusEnum.SYSTEM_EXCEPTION.getCode(), ResultStatusEnum.SYSTEM_EXCEPTION.getMessage(), null);
    }

}
