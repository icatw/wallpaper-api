package com.icatw.wallpaperapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icatw.wallpaperapi.domain.Type;
import com.icatw.wallpaperapi.mapper.TypeMapper;
import com.icatw.wallpaperapi.service.TypeService;
import org.springframework.stereotype.Service;

/**
 * 壁纸分类表(Type)表服务实现类
 *
 * @author icatw
 * @since 2022-10-04 20:55:21
 */
@Service("typeService")
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
}

