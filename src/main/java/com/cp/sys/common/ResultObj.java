package com.cp.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
//    登入状态
    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Constast.OK,"登入成功");
    public static final ResultObj LOGIN_ERORR_PASS = new ResultObj(Constast.ERROR,"登入失败,用户密码错误");
    public static final ResultObj LOGIN_ERORR_CODE = new ResultObj(Constast.ERROR,"登入失败,验证码错误");

    private Integer code;
    private String msg;
}
