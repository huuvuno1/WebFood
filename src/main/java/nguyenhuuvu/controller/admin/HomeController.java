package nguyenhuuvu.controller.admin;

import nguyenhuuvu.utils.SecurityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "homeControllerAdmin")
public class HomeController {
	
	@RequestMapping("/admin")
	public String viewHomeAdmin()
	{
		return "admin/index";
	}
}
