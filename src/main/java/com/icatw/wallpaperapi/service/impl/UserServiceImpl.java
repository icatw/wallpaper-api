package com.icatw.wallpaperapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icatw.wallpaperapi.domain.User;
import com.icatw.wallpaperapi.mapper.UserMapper;
import com.icatw.wallpaperapi.service.UserService;
import com.icatw.wallpaperapi.utils.JWTUtils;
import com.icatw.wallpaperapi.utils.MD5Utils;
import org.springframework.stereotype.Service;

/**
 * 壁纸用户表(User)表服务实现类
 *
 * @author icatw
 * @since 2022-10-04 20:55:22
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Object login(User user) {
        String userName = user.getUserName();
        User one = this.getOne(new QueryWrapper<User>().eq("user_name" , userName));
        if (one != null) {
            String password = user.getPassword();
            //输入的密码加密后与数据库密码进行比较
            String formPass = MD5Utils.inputPassToFormPass(password);
            String onePassword = one.getPassword();
            //如果密码相同，生成token
            if (onePassword.equals(formPass)){
                JWTUtils.createToken(1L);
            }
        }
        return null;
    }
}

