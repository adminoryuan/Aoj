package com.Aoj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yh
 * @date 2022/7/9 下午2:57
 */
@Data
@TableName("ojbase_tag")
public class TagEntity {
    int id;

    String tagName;
}
