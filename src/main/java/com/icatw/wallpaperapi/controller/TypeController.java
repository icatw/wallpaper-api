package com.icatw.wallpaperapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icatw.wallpaperapi.domain.Type;
import com.icatw.wallpaperapi.service.TypeService;
import com.icatw.wallpaperapi.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 壁纸分类表(Type)表控制层
 *
 * @author icatw
 * @since 2022-10-04 20:55:21
 */
@Api(tags = "壁纸分类表(Type)")
@RestController
@RequestMapping("type")
public class TypeController {

    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 壁纸分类表")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Type> page = new Page<>(current, size);
        return R.ok(this.typeService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 壁纸分类表")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.typeService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 壁纸分类表")
    @PostMapping
    public R save(@RequestBody Type type) {
        return R.ok(this.typeService.save(type));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 壁纸分类表")
    @PutMapping
    public R updateById(@RequestBody Type type) {
        return R.ok(this.typeService.updateById(type));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 壁纸分类表")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.typeService.removeByIds(id));
    }
}

