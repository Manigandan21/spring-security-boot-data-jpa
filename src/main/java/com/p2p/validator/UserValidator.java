package com.p2p.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.p2p.models.User;
import com.p2p.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.username");
        }
        System.out.println("1");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
                
        /*if (userService.findByEmailAsUser(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.username");
        }*/
        System.out.println("2");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        System.out.println("3");
        if (!user.getConfirm_password().equals(user.getPassword())) {
            errors.rejectValue("confirm_password", "Diff.userForm.passwordConfirm");
        }
        System.out.println("4");
    }
}
