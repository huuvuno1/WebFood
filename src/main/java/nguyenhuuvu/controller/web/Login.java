package nguyenhuuvu.controller.web;

import nguyenhuuvu.utils.SecurityUtils;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Login {
	
	@RequestMapping("/login")
	public String viewLogin(Session session)
	{
		if (SecurityUtils.getListRoles().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS")))
			return "admin/login";
		else
			return "redirect:/";
	}
}
