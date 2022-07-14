package com.service.lpmls;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mappers.BlogUserMapper;
import com.pojo.BlogUser;
import org.springframework.stereotype.Service;

@Service
@DS("test")
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper,BlogUser> {
}
