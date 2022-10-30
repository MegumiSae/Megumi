package com.wulaoda.loginhouduan.controller;


import com.wulaoda.loginhouduan.req.SysUserLoginReq;
import com.wulaoda.loginhouduan.req.SysUserSaveReq;
import com.wulaoda.loginhouduan.resp.CommonResp;
import com.wulaoda.loginhouduan.resp.SysUserLoginResp;
import com.wulaoda.loginhouduan.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("register")
    public CommonResp register(@RequestBody  SysUserSaveReq req){
       req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        sysUserService.register(req);
        return resp;
    }

    @PostMapping("login")
    public CommonResp login(@RequestBody SysUserLoginReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        SysUserLoginResp loginResp = sysUserService.login(req);
        resp.setContent(loginResp);
        return resp;
    }

}
