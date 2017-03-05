/**
 * 
 */
package com.p2p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.p2p.models.User;
import com.p2p.service.UserService;
import com.p2p.validator.UserValidator;


@RestController
@RequestMapping("/p2p")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	HttpStatus status;
	
	/**
	 * POST /create  --> Create a new user and save it in the database.
	 */
	@RequestMapping("/register")
	@ResponseBody
	public ResponseEntity<String> create(@RequestBody User user, BindingResult bindingResult, Model model) {
		System.out.println("Inner");
		userValidator.validate(user, bindingResult);
		for(ObjectError er : bindingResult.getAllErrors())
		{
		System.out.println(er.toString());
		}
		if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("Failed", HttpStatus.OK);
        }
		System.out.println("********"+user.getRole_type());
		String response = userService.registerUser(user);
		 //securityService.autologin(user.getEmail(), user.getConfirm_password());

		 
	    return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	/**
	 * GET /read  --> Login user using user_id from the database.
	 */
	@RequestMapping("/login")
	public ResponseEntity<String> read(@RequestHeader(value="Authorization") String authTocken) {
		status = HttpStatus.OK; 
		String loginStatus = userService.checkCredentials(authTocken);
		if(!loginStatus.contains("Success!")){
			status = HttpStatus.FORBIDDEN;
		}
	    return new ResponseEntity<String>(loginStatus, status);
	}
	
	/**
	 * GET /update  --> Update a booking record and save it in the database.
	 */
	/*@RequestMapping("/update")
	public User update(@RequestParam Long bookingId, @RequestParam String psngrName) {
		User booking = userRepository.findOne(bookingId);
		booking.setPsngrName(psngrName);
		booking = userRepository.save(booking);
	    return booking;
	}
	
	*//**
	 * GET /delete  --> Delete a booking from the database.
	 *//*
	@RequestMapping("/delete")
	public String delete(@RequestParam Long bookingId) {
		userRepository.delete(bookingId);
	    return "booking #"+bookingId+" deleted successfully";
	}*/
}
