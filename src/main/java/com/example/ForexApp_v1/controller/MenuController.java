package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.model.User;
import com.example.ForexApp_v1.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;


@Controller
public class MenuController {
//    private final UserRepository userRepository = new UserRepository();
//    @GetMapping("/register")
//    public String hello(Model model) {
//        model.addAttribute("user", new User());
//         return "index";
//    }
//    @PostMapping("/register")
//    public String userRegistration(final @Valid User user) { //, final BindingResult bindingResult, final Model model
////        if (bindingResult.hasErrors()){
////            return "security/register";
////        }
//            try {
//           userRepository.createOrUpdate(user);
//       } catch (Exception e) {
////           bindingResult.rejectValue("email", "customUser.email", "Podany adres email jest już w użyciu.");
////           model.addAttribute("registrationForm", customUser);
////           System.out.println("Test");
//           return "security/register";
//       }
//       return "index";
//    }

    //@GetMapping("/register")
    //public String showRegistrationForm(Model model) {
    //   model.addAttribute("customUser", new CustomUser());
    //   return "security/register";
    //}
    //
    //
    //@PostMapping("/register")
    //    //public String userRegistration(final @Valid CustomUser customUser) {
    //   try {
    //       userDAO.saveUser(customUser);
    //   } catch (UserAlreadyExistsException e) {
    //       bindingResult.rejectValue("email", "customUser.email", "Podany adres email jest już w użyciu.");
    //       model.addAttribute("registrationForm", customUser);
    //       System.out.println("Test");
    //       return "security/register";
    //   }
    //   return "index";
    //}
}

