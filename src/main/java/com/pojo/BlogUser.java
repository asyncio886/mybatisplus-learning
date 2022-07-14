package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("users")
public class BlogUser {
    @TableId(type = IdType.AUTO)
    Integer uid;
    String uname;
    String password;
    Date register_time;
    String email;
}
