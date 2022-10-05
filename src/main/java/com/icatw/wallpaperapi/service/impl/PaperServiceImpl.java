package com.icatw.wallpaperapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icatw.wallpaperapi.domain.Paper;
import com.icatw.wallpaperapi.mapper.PaperMapper;
import com.icatw.wallpaperapi.service.PaperService;
import org.springframework.stereotype.Service;

/**
 * 壁纸表(Paper)表服务实现类
 *
 * @author icatw
 * @since 2022-10-04 20:55:20
 */
@Service("paperService")
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {
}

