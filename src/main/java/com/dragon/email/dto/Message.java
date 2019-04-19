package com.dragon.email.dto;

import lombok.Data;

/**
 * @author ljn
 * @date 2019/4/19.
 */
@Data
public class Message {

    private String messageCode;

    private String messageStatus;

    private String cause;
}
