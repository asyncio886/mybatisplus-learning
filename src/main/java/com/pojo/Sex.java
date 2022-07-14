package com.pojo;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum Sex {
    MALE(1,"男"),
    FEMALE(0,"女");
    @EnumValue
    private Integer tag;
    private String sex;

    Sex(Integer tag, String sex) {
        this.tag = tag;
        this.sex = sex;
    }
}
