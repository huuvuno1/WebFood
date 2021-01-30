package nguyenhuuvu.utils;

import nguyenhuuvu.dto.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Configuration
public class SecurityUtils {

    @Bean("myUser")
    @Scope("prototype")
    public static MyUser getPrincipal()
    {
        return (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static List<GrantedAuthority> getListRoles()
    {
        return (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}
