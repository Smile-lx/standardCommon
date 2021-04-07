package com.real.demo.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @ClassName User
 * @Description: TODO
 * @Author Smile
 * @Date 2021/4/7
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("tb_user")
public class User implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 乐观锁版本信息
     */
    private Integer version;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 删除标志位
     */
    private Boolean deleted;
}
