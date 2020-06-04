package com.cp.sys.vo;

import com.cp.sys.bean.Loginfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Primary;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//日志vo类
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginfoVo extends Loginfo {
    public static final long SERIAL_VERSION_UID = 1L;

    private Integer paeg=1;
    private Integer limit=10;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
