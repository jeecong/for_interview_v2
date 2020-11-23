package com.qiutong.work.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -5980087465791184812L;


    private Integer total;

    private Integer size;

    private Integer p;

    private List<T> list;
}
