package com.horace.web.utils.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-24 21:39
 */

@Target(ElementType.FIELD) //注解是指定当前自定义注解可以使用在哪些地方，这里仅仅让他可以使用在方法上和属性上；
@Retention(RetentionPolicy.RUNTIME)  //指定当前注解保留到运行时
@Documented
@Constraint(
        validatedBy = {PhoneValidator.class}   //指定了当前注解使用哪个类来进行校验。
)
public @interface PhoneCheck {

    // default 关键字 接口中被default修饰的方法，在类实现这个接口时不必必须实现这个方法
    boolean required() default true;

    String message() default "手机号格式不正确";

    // Class<?> 表示不确定的java类型
    // Class<T> 表示java类型
    // Class<K,V> 分别代表java键值中的key value
    // Class<E> 代表Element
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
