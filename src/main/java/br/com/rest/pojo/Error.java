package br.com.rest.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Error implements Serializable {

    private Integer code;
    private String title;
    private String detail;
}
