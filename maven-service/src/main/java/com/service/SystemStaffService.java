package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.vo.PageVo;
import com.vo.SystemStaff;

public interface SystemStaffService {
    PageVo<SystemStaff> queryPageVo(SystemStaff staff, Integer page, Integer rows);
}
