package com.p2p.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.p2p.models.User;
import com.p2p.repository.UserRepository;

import com.p2p.repository.RoleRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	private final UserRepository userRepository;
	private final RoleRepository userRolesRepository;
	
	@Autowired
    public CustomUserDetailsService(UserRepository userRepository,RoleRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }
	
        
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+username);
		}else{
			List<String> userRoles=userRolesRepository.getUserByRole(user.getRole_type());
			return new CustomUserDetails(user,userRoles);
		}
	}
		
}
