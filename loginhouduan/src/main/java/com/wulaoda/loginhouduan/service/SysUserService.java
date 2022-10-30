package com.wulaoda.loginhouduan.service;

import com.wulaoda.loginhouduan.req.SysUserLoginReq;
import com.wulaoda.loginhouduan.req.SysUserSaveReq;
import com.wulaoda.loginhouduan.resp.SysUserLoginResp;

public interface SysUserService {
    void register(SysUserSaveReq req);

    SysUserLoginResp login(SysUserLoginReq req);
}
