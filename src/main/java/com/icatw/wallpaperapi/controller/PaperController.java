package com.icatw.wallpaperapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icatw.wallpaperapi.common.R;
import com.icatw.wallpaperapi.domain.Paper;
import com.icatw.wallpaperapi.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 壁纸表(Paper)表控制层
 *
 * @author icatw
 * @since 2022-10-04 20:55:20
 */
@Api(tags = "壁纸表(Paper)")
@RestController
@RequestMapping("paper")
public class PaperController {

    /**
     * 服务对象
     */
    @Resource
    private PaperService paperService;

    /**
     * 分页查询所有数据
     */
    @ApiOperation(value = "分页查询所有数据 壁纸表")
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Paper> page = new Page<>(current, size);
        return R.ok(this.paperService.page(page));
    }

    /**
     * 分类查询壁纸
     */
    @ApiOperation(value = "根据分类id获取壁纸")
    @GetMapping("type/{typeId}")
    public R selectByType(@PathVariable Long typeId) {
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id" , typeId);
        return R.ok(this.paperService.list(queryWrapper));
    }

    /**
     * 查询最新壁纸
     */
    @ApiOperation(value = "获取最新 壁纸")
    @GetMapping("new")
    public R selectNew() {
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        return R.ok(this.paperService.list(queryWrapper));
    }

    /**
     * 通过主键查询单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据 壁纸表")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.paperService.getById(id));
    }

    /**
     * 新增数据
     */
    @ApiOperation(value = "新增数据 壁纸表")
    @PostMapping
    public R save(@RequestBody Paper paper) {
        return R.ok(this.paperService.save(paper));
    }

    /**
     * 修改数据
     */
    @ApiOperation(value = "修改数据 壁纸表")
    @PutMapping
    public R updateById(@RequestBody Paper paper) {
        return R.ok(this.paperService.updateById(paper));
    }

    /**
     * 单条/批量删除数据
     */
    @ApiOperation(value = "单条/批量删除数据 壁纸表")
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok(this.paperService.removeByIds(id));
    }
}

