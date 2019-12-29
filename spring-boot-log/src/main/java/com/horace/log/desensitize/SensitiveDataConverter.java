package com.horace.log.desensitize;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-29 18:35
 */
@Slf4j
public class SensitiveDataConverter extends MessageConverter {


    private List<LogMask> logMasks; //todo 如何init


    private static final String MOBILE_REGEX = "((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}";

    @Override
    public String convert(ILoggingEvent event) {

        // 获取原始日志
        String requestLogMsg = event.getFormattedMessage();

        // 获取返回脱敏后的日志
        return convertMsg(requestLogMsg);
    }

    /**
     * 处理日志字符串，返回脱敏后的字符串
     *
     * @param oriMsg
     * @return
     */
    public String convertMsg(final String oriMsg) {

        String tempMsg = oriMsg;
        if (tempMsg != null && !"".equals(tempMsg)) {
            //todo 如何高效判断出日志中是否有脱敏字段，并且对其脱敏
            if (tempMsg.length() == 11) {
                tempMsg = oriMsg.substring(0, 3) + "****" + oriMsg.substring(7, oriMsg.length());
            }
//            tempMsg = mobileHandler(tempMsg);
        }
        return tempMsg;
    }

    /**
     * 查询符合规则的字符串手机号码
     * 注意：如果手机号有新增号码段需要修改正则表达式
     *
     * @param msg
     */
    private String mobileHandler(String msg) {

        // 将给定的正则表达式编译到模式中
        Pattern pattern = Pattern.compile(MOBILE_REGEX);
        // 创建匹配给定输入与此模式的匹配器。
        Matcher matcher = pattern.matcher(msg);
        // 脱敏处理：查找字符串中是否有符合的子字符串
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            // 查找到符合规则的手机号
            String tmp = matcher.group();
            // 两个判断条件针对两种参数：1、json字符串格式请求；2、json转为VO之后的日志打印
            if (getChar(msg, msg.indexOf(tmp) - 1) == '"' && getChar(msg, msg.indexOf(tmp) + 11) == '"') {
                // 处理手机号
                String v = MobileHandlerUtil.mobileHandler(tmp);
                // 替换掉查找到的字符串
                matcher.appendReplacement(sb, v);
            } else if (getChar(msg, msg.indexOf(tmp) - 1) == '=' && getChar(msg, msg.indexOf(tmp) + 11) == ',') {
                // 处理手机号
                String v = MobileHandlerUtil.mobileHandler(tmp);
                // 替换掉查找到的字符串
                matcher.appendReplacement(sb, v);
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 获取指定位置的字符
     *
     * @param msg
     * @param index
     * @return
     */
    private char getChar(String msg, int index) {
        return msg.charAt(index);
    }
}
