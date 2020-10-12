package com.service;

import com.vo.InfoUser;
import com.vo.PageVo;

public interface InfoUserService {
    PageVo<InfoUser> queryPageVo(InfoUser infoUser, PageVo<InfoUser> pageVo);

    boolean insertInfo(InfoUser infoUser);

    InfoUser queryInfoUserId(String id);

    boolean updateInfoUser(InfoUser infoUser);

    boolean deleteId(String id);
}
