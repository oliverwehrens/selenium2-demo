package de.hypoport.jm.selenium2.controller;

import de.hypoport.jm.selenium2.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @RequestMapping(method = RequestMethod.POST, value = "/dologin.html")
  public ModelAndView login(@ModelAttribute LoginForm login, Model model) {
    if (login.getPassword().equals("secret")) {
      model.addAttribute("login", login);
      return new ModelAndView("success", "login", login);
    }
    return new ModelAndView("failure");
  }

  @RequestMapping("/showlogin.html")
  public void showLogin(Model model) {
    model.addAttribute("login", new LoginForm());
  }

  @RequestMapping("/logout.html")
  public String logout() {
    return "redirect:/showlogin.html";
  }

}
