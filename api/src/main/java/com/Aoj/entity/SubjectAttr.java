package com.Aoj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yh
 * @date 2022/7/9 下午2:55
 */
@Getter
@Setter
@TableName("ojbase_subject")
public class SubjectAttr {
    /**
     * 题目id
     */
    int sid;

    /**
     * tagid
     */
    int tagid;

}
