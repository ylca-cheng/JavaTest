package com.cheng.annotations;


import com.cheng.enums.SensitiveType;
import com.cheng.utils.SensitiveInfoUtils;

import java.lang.annotation.*;

/**
 * @Title: SensitiveInfo.java
 * @Copyright: Copyright (c) 2015
 * @Description: <br>
 *               敏感信息注解标记 <br>
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveInfo {

    SensitiveType type();

}