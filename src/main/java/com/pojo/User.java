package com.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private Long id;
    private String name;
    private String password;
    @TableField("is_deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer is_deleted;
    Sex sex;
}
