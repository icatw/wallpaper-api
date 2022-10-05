package com.icatw.wallpaperapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.icatw.wallpaperapi.common.R;
import com.icatw.wallpaperapi.domain.User;

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
    R login(User user);

    /**
     * @param user 用户
     * @return {@link R}
     */
    R register(User user);
}

