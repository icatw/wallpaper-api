package com.icatw.wallpaperapi.service;

import com.icatw.wallpaperapi.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 壁纸用户表(User)表服务接口
 *
 * @author icatw
 * @since 2022-10-04 20:55:21
 */
public interface UserService extends IService<User> {
    /**
     * 登录
     *
     * @param user 用户
     * @return {@link Object}
     */
    Object login(User user);
}

