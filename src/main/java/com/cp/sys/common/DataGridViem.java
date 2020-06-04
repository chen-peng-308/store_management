package com.cp.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//返回的json数据格式
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridViem {
    private Integer code=0;
    private String msg="";
    private Long count=0L;
    private Object data;

    public DataGridViem(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DataGridViem(Object data) {
        this.data = data;
    }
}
