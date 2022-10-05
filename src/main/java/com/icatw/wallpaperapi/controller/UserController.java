package com.icatw.wallpaperapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icatw.wallpaperapi.common.R;
import com.icatw.wallpaperapi.domain.User;
import com.icatw.wallpaperapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 壁纸用户表(User)表控制层
 *
 * @author icatw
 * @since 2022-10-04 20:55:22
 */
@Api(tags = "壁纸用户表(User)")
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 新增数据
     */
    @ApiOperation(value = "登陆")
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        return this.userService.login(user);
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public R register(@RequestBody User user) {
        return this.userService.register(user);
    }

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 壁纸用户表")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<User> page = new Page<>(current, size);
        return R.ok(this.userService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 壁纸用户表")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.userService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 壁纸用户表")
    @PostMapping
    public R save(@RequestBody User user) {
        return R.ok(this.userService.save(user));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 壁纸用户表")
    @PutMapping
    public R updateById(@RequestBody User user) {
        return R.ok(this.userService.updateById(user));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 壁纸用户表")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.userService.removeByIds(id));
    }
}

