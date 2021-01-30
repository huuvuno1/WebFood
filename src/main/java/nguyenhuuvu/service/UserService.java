package nguyenhuuvu.service;

import java.util.ArrayList;
import java.util.List;

import nguyenhuuvu.dto.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nguyenhuuvu.entity.RoleEntity;
import nguyenhuuvu.entity.UserEntity;
import nguyenhuuvu.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findOneByUsername(username);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		List<RoleEntity> roles = user.getRoles();
		for (RoleEntity roleEntity : roles) {
			GrantedAuthority grant = new SimpleGrantedAuthority(roleEntity.getRoleName());
			grantedAuthorities.add(grant);
		}
		MyUser myUser = new MyUser(user.getUsername(), user.getPassword(), true, true,
				true, true, grantedAuthorities);
		myUser.setFullname(user.getFullname());
		return myUser;
	}
}
