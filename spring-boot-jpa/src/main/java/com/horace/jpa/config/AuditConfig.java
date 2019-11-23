package com.horace.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-23 23:01
 */
@Configuration
public class AuditConfig implements AuditorAware<String> { //string与数据库中的createBy和updateBy字段对应
    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of("horace");

//        return Optional.of(SecurityContextHolder.getContext())  todo spring security
//                .map(SecurityContext::getAuthentication)
//                .map(authentication -> {
//                    if(authentication.isAuthenticated()) {
//                        Object principal = authentication.getPrincipal();
//                        if(principal instanceof String) {
//                            return (String)principal;
//                        } else if(principal instanceof Principal) {
//                            return ((Principal)principal).getName();
//                        } else if (principal instanceof UserDetails) {
//                            return ((UserDetails) principal).getUsername();
//                        }
//                    }
//                    return "anonymousUser";
//                });
    }
}
