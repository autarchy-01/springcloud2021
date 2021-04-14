package com.silent.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author silent
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
