package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

	@RequestMapping("/user/{userId}/{userName}")
	public String getuserDetail(@PathVariable("userId") int userId, @PathVariable("userName") String userName) {
		System.out.println(userId);
		System.out.println(userName);
		return "home";
	}

	@RequestMapping("/home1")
	public String home1() {
		return "home";
	}

//  handling for request
	@RequestMapping("/welcome")
	public String welcome(@RequestParam("user") String name, Model m) {
		System.out.println(name);
		m.addAttribute("name", name);
		return "home";
	}

	@RequestMapping("/home")
	public String home(Model model) {

		// String str=null; System.out.println(str.length());

		/*
		 * String tr="jgkj"; System.out.println(Integer.parseInt(tr));
		 */
		model.addAttribute("name", "Durgesh Tiwari");
		model.addAttribute("id", 1434);

		List<String> friends = new ArrayList<String>();
		friends.add("Vandan");
		friends.add("Roshani");
		friends.add("ABC");
		model.addAttribute("f", friends);
		System.out.println("This is home url");
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		System.out.println("This is about controller");
		return "about";
	}

	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("This is helpcontroller");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "uttam");
		modelAndView.addObject("rollNumber", 12345);
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time", now);
		modelAndView.setViewName("help");

		// Marks

		List<Integer> list = new ArrayList<Integer>();
		list.add(1234);
		list.add(12345);
		list.add(1236);
		list.add(1254);

		modelAndView.addObject("marks", list);

		// setting the view names
		return modelAndView;

	}
	/*
	 * @ExceptionHandler({ NullPointerException.class, NumberFormatException.class
	 * }) public String exceptionHandlerNull(Model m) {
	 * m.addAttribute("msg","Null Pointer exception has occured"); return
	 * "nullPage";
	 * 
	 * }
	 */

	/*
	 * @ExceptionHandler(value = NullPointerException.class) public String
	 * exceptionHandlerNull(Model m) { m.addAttribute("msg",
	 * "Null Pointer exception has occured"); return "nullPage";
	 * 
	 * }
	 * 
	 * if you want handle single exception
	 * 
	 * @ExceptionHandler(value = NumberFormatException.class) public String
	 * exceptionHandlerNumberFormatException(Model m) { m.addAttribute("msg",
	 * "NumberFormat exception has occured"); return "nullPage";
	 * 
	 * }
	 * 
	 * it will be handle all exception it is called genric exception
	 * 
	 * @ExceptionHandler(value = Exception.class) public String
	 * exceptionHandlergeneric(Model m) { m.addAttribute("msg",
	 * "NumberFormat exception has occured"); return "nullPage";
	 * 
	 * }
	 */
}
