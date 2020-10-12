package com.service;

import com.vo.PageVo;
import com.vo.SystemStaff;

public interface SystemStaffService {
    PageVo<SystemStaff> queryPageVo(SystemStaff staff, PageVo<SystemStaff> pageVo);

    boolean insertStaff(SystemStaff staff);

    SystemStaff queryStaffId(String id);

    boolean updateStaffId(SystemStaff staff);

    boolean deleteStaffId(String id);

    PageVo<SystemStaff> queryAllPageVo(SystemStaff staff,PageVo<SystemStaff> pageVo);
}
