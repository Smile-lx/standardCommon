package com.real.demo.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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
@TableName("user")
public class User implements Serializable {
    /**
     * 主键
     *
     * @TableId中可以决定主键的类型,不写会采取默认值,默认值可以在yml中配置 AUTO: 数据库ID自增
     * INPUT: 用户输入ID
     * ID_WORKER: 全局唯一ID，Long类型的主键
     * ID_WORKER_STR: 字符串全局唯一ID
     * UUID: 全局唯一ID，UUID类型的主键
     * NONE: 该类型为未设置主键类型
     */
    @TableId(type = IdType.AUTO)
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
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp updateTime;
    /**
     * 删除标志位
     */
    private Boolean deleted;
}
