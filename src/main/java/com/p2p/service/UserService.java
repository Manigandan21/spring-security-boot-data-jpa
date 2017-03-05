package com.p2p.service;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.p2p.models.User;
import com.p2p.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String registerUser(User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user = userRepository.saveUser(user);
		return "Success!";
	}

	public String checkCredentials(String authTocken) {
		String response = "Failure";
		String[] auth = decodeBasicAuthTocken(authTocken);
		if(auth.length !=0 && auth.length == 2){
			User user = userRepository.findByEmail(auth[0]);
			System.out.println(user.getPassword()+":"+auth[1]);
			if(bCryptPasswordEncoder.matches(auth[1], user.getPassword()))
			response = "Success!";
			
		}
		return response;
	}

	public String findByEmailAsUser(String email){
		return email;
		/*User user = userRepository.findByEmail(email);
		return user.getEmail();*/
	}
	
	//Non API methods.
	public String[] decodeBasicAuthTocken(String auth){
		if (auth != null && auth.startsWith("Basic")) {
	        // Authorization: Basic base64credentials
	        String base64Credentials = auth.substring("Basic".length()).trim();
	        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
	                Charset.forName("UTF-8"));
	        // credentials = username:password
	        return credentials.split(":",2);
	}
		return null;
}
}
