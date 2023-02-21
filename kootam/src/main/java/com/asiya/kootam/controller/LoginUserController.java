package com.asiya.kootam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asiya.kootam.model.LoginUser;
import com.asiya.kootam.service.LoginUserService;

@Controller
public class LoginUserController {

	@Autowired
	private LoginUserService loginUserService;
	
	// display list of LoginUsers
    @GetMapping("/loginUser")
    public String viewHomePage(Model model) {
    	//List<LoginUser> loginUsers = loginUserService.getAllLoginUser();
		model.addAttribute("listLoginUsers", loginUserService.getAllLoginUser());
	    return "loginUser_list";
		
        
    }
	
	@GetMapping("/loginUser/showNewLoginUserForm")
	public String showNewLoginUserForm(Model model) {
		// create model attribute to bind form data
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", loginUser);
		return "loginUser_new";
	}
	
	@GetMapping("/loginUser/showNewLoginUserForm/{id}")
	public String showNewLoginUserFormGuest(@PathVariable ( value = "id") String id, Model model) {
		// create model attribute to bind form data
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("guest", "Y");
		return "loginUser_newguest";
	}
	
	
	@PostMapping("/loginUser/saveLoginUserGuest")
	public String saveLoginUserUpdate(@ModelAttribute("loginUser") LoginUser loginUser) {
		// save LoginUser to database
		loginUserService.saveLoginUser(loginUser);
		return "redirect:/kootam";
	}
	
	@PostMapping("/loginUser/saveLoginUser")
	public String saveLoginUser(@ModelAttribute("loginUser") LoginUser loginUser) {
		// save LoginUser to database
		loginUserService.saveLoginUser(loginUser);
		
		return "redirect:/loginUser";
	}
	
	
	
	
	@GetMapping("/loginUser/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		LoginUser loginUser=loginUserService.getLoginUserById(id);
		// set LoginUser as a model attribute to pre-populate the form
		model.addAttribute("loginUser", loginUser);
		return "loginUser_update";
	}
	
	@GetMapping("/loginUser/deleteLoginUser/{id}")
	public String deleteLoginUser(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.loginUserService.deleteLoginUserById(id);
		return "redirect:/loginUser";
	}
	
	
}
