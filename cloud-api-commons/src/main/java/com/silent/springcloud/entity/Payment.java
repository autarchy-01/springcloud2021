package com.silent.springcloud.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author silent
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment implements Serializable {

    private Long id;

    private String serial;
}
