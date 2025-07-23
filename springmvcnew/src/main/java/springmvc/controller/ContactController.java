package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("Header", "LearnCodeWithDurgesh");
		m.addAttribute("Desc", "Home for Programmer");
	}

	@RequestMapping("/contact")
	public String showForm(Model m) {
		/*
		 * m.addAttribute("Header", "LearnCodeWithDurgesh"); m.addAttribute("Desc",
		 * "Home for Programmer")
		 */;

		return "contact";
	}

	/*
	 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
	 * String handleForm(@RequestParam("email") String
	 * userEmail, @RequestParam("userName") String userName,
	 * 
	 * @RequestParam("password") String userPassword, Model model) {
	 * System.out.println("handle1Form is calling"); System.out.println(userEmail);
	 * System.out.println(userName); System.out.println(userPassword);
	 * 
	 * // model.addAttribute("name", userName); // model.addAttribute("email",
	 * userEmail); // model.addAttribute("password", userPassword);
	 * 
	 * User user = new User(); user.setEmail(userEmail); user.setUserName(userName);
	 * user.setPassword(userPassword); System.out.println(user);
	 * 
	 * model.addAttribute("user", user);
	 * 
	 * return "success"; }
	 */

	/* This is more sort way when you have multiple field use to need get data from the view */
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm1(@ModelAttribute User user, Model model) {
		
		if(user.getUserName().isBlank()) {
			return "redirect:/contact";
		}
		/*
		 * 
		 * public String handleForm1(@ModelAttribute("user") User user, Model model) {
		 * both are same thing it will be use when we will add libarary of form tag
		 */
		/*
		 * model.addAttribute("Header", "LearnCodeWithDurgesh");
		 * model.addAttribute("Desc", "Home for Programmer");
		 */
		System.out.println("handle1Form is calling1111111111");
		int createdUser = this.userService.createUser(user);
		model.addAttribute("msg", "User created with id " + createdUser);
		
		return "success";

	}

}
