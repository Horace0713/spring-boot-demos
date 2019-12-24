package com.horace.web.utils.validate;

import com.horace.web.utils.ValidatorUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-24 21:43
 */
public class PhoneValidator implements ConstraintValidator<PhoneCheck, String> {

    private boolean require = false;

    /**
     * Initializes the validator in preparation for  校验前的初始化工作
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(PhoneCheck constraintAnnotation) {
        require = constraintAnnotation.required();
    }

    /**
     * Implements the validation logic.  具体的校验逻辑
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param s       object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {

        if (require) {
            return ValidatorUtils.isMobile(s);
        } else {
            if (StringUtils.isEmpty(s)) {
                return true;
            } else {
                //禁止默认消息返回
                context.disableDefaultConstraintViolation();
                //自定义返回消息
                context.buildConstraintViolationWithTemplate("手机号 格式不正确").addConstraintViolation();
                return ValidatorUtils.isMobile(s);
            }
        }
    }
}
