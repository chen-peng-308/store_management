package com.cp.sys.vo;

import com.cp.sys.bean.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends Permission {
    public static final long SERIA_VERSION_UID = 1L;
}
