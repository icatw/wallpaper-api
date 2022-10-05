package com.icatw.wallpaperapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icatw.wallpaperapi.common.R;
import com.icatw.wallpaperapi.common.ResultStatusEnum;
import com.icatw.wallpaperapi.domain.User;
import com.icatw.wallpaperapi.handler.CustomException;
import com.icatw.wallpaperapi.mapper.UserMapper;
import com.icatw.wallpaperapi.service.UserService;
import com.icatw.wallpaperapi.utils.JWTUtils;
import com.icatw.wallpaperapi.utils.MD5Utils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;


/**
 * 壁纸用户表(User)表服务实现类
 *
 * @author icatw
 * @since 2022-10-04 20:55:22
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public R login(User user) {
        try {
            String userName = user.getUserName();
            User one = this.getOne(new QueryWrapper<User>().eq("user_name" , userName));
            if (one != null) {
                //状态为1表示禁用账户，0启用
                if (one.getStatus() == 1) {
                    return R.fail(ResultStatusEnum.DISABLE_USER);
                }
                String password = user.getPassword();
                //输入的密码加密后与数据库密码进行比较
                String formPass = MD5Utils.inputPassToFormPass(password);
                String onePassword = one.getPassword();
                //如果密码相同，生成token
                if (onePassword.equals(formPass)) {
                    //更新最后登陆时间
                    one.setLastLoginTime(new Date());
                    this.updateById(one);
                    //根据用户id生成token，将userId存入token荷载中
                    String token = JWTUtils.createToken(one.getUserId());
                    HashMap<Object, Object> map = new HashMap<>(5);
                    map.put("token" , token);
                    map.put("user" , one);
                    return R.ok(map);
                }
                return R.fail(ResultStatusEnum.PASSWORD_NOT_MATCHING);
            }
            //空，用户名不存在
            return R.fail(ResultStatusEnum.NOT_USER.getCode(), ResultStatusEnum.NOT_USER.getMessage());
        } catch (Exception e) {
            //抛出异常，系统错误
            e.printStackTrace();
            throw new CustomException(ResultStatusEnum.SYSTEM_EXCEPTION);
        }
    }

    @Override
    public R register(User user) {
        String userName = user.getUserName();
        //用户名唯一
        User one = this.getOne(new QueryWrapper<User>().eq("user_name" , userName));
        if (one != null) {
            return R.fail(ResultStatusEnum.USER_EXISTS);
        }
        //用户名不存在，注册
        String password = user.getPassword();
        String formPass = MD5Utils.inputPassToFormPass(password);
        user.setPassword(formPass);
        user.setStatus(0);
        this.save(user);
        return R.ok();
    }
}

