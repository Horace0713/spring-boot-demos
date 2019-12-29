package com.horace.log.desensitize;

import org.springframework.util.StringUtils;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-29 18:37
 */
public class MobileHandlerUtil {

    private MobileHandlerUtil() {
        throw new IllegalStateException("此类不能实例化！！！");
    }

    /**
     * 手机号码保留前三位和后四位，其他隐藏<如:188******1234>
     *
     * @param mobile 手机号
     * @return String
     */
    public static String mobileHandler(String mobile) {

        if (!StringUtils.hasText(mobile)) {
            mobile = mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
        }
        return mobile;
    }
}
