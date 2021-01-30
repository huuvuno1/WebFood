package nguyenhuuvu.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import nguyenhuuvu.entity.UserEntity;
import nguyenhuuvu.repository.UserRepository;

@Controller(value = "homeControllerWeb")
public class HomeController {
	
	@RequestMapping("/")
	public String viewHome()
	{
		
		return "web/index";
	}
	
}
