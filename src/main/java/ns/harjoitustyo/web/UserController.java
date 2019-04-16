package ns.harjoitustyo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ns.harjoitustyo.domain.RegisterUser;
import ns.harjoitustyo.domain.User;
import ns.harjoitustyo.domain.UserRepository;

@Controller
public class UserController {
	 @Autowired
	 private UserRepository urepo;
	 
	 @RequestMapping(value = "/")
	 public String login() {
		 return "loginpage";
	 }
	 
	 @RequestMapping(value = "register")
	 public String addUser(Model model) {
		 model.addAttribute("registeruser", new RegisterUser());
		 return "register";
	 }
	 @RequestMapping(value = "saveuser", method = RequestMethod.POST)
	 public String save(@Valid @ModelAttribute("registeruser") RegisterUser registerUser, BindingResult bindingResult) {
		 if(!bindingResult.hasErrors()) { // VALIDATION ERRORS
			 if(registerUser.getPassword().equals(registerUser.getPasswordCheck())) {
				 String pw = registerUser.getPassword();
				 BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
				 String hashPw = encrypt.encode(pw);
				 
				 User newUser = new User();
				 newUser.setPasswordHash(hashPw);
				 newUser.setUsername(registerUser.getUsername());
				 newUser.setEmail(registerUser.getEmail());
				 newUser.setRole("USER");
				 if(urepo.findByUsername(registerUser.getUsername()) == null) {
					 urepo.save(newUser);
				 }
				 else {
					 bindingResult.rejectValue("username", "err.username", "Username already exists");
					 return "register";
				 }
			 }
			 else {
				 bindingResult.rejectValue("passwordCheck",  "err.passCheck", "Passwords does not match");
				 return "register";
			 }
		 }
		 else {
			 return "register";
		 }
		 return "redirect:/";
	 }
}
