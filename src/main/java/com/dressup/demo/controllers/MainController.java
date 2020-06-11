package com.dressup.demo.controllers;

import com.dressup.demo.config.oauth.VkConnector;
import com.dressup.demo.config.security.UserDetailsImpl;
import com.dressup.demo.dto.SignUpDto;
import com.dressup.demo.service.SignUpService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private SignUpService service;


   @PreAuthorize("permitAll()")
   @GetMapping("/main")
   public String getMainPage() {
       return "index";
   }

   @Autowired
   private VkConnector vkConnector;

   @PreAuthorize("permitAll()")
   @GetMapping("/welcome")
   public String welcome(@AuthenticationPrincipal OAuth2User principal, ModelMap map){
      map.put("username",principal.getName());
      return "success/signup";
   }

   @GetMapping("/login")
   public String getLoginPage(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam(value = "error", required = false) String error, ModelMap map) throws MalformedURLException {
     map.addAttribute("vkLogin", vkConnector.getLoginUrl());
      if(userDetails != null) {
         return "redirect:/profile";
      }
      if(error != null) {
         map.put("error", "USER_NOT_FOUND");
      }
      return "security/login";
   }

   @GetMapping("/signup")
   public String getRegisterPage(Model map) {
      map.addAttribute("form", new SignUpDto());
      return "security/signup";
   }

   @PostMapping("/signup")
   public String signup(@Valid @ModelAttribute("form") SignUpDto form, BindingResult bindingResult,
                        Model map, RedirectAttributes redirectAttributes) {
      if (!bindingResult.hasErrors()) {
         service.signUp(form);
         redirectAttributes.addFlashAttribute("username", form.getUsername());
         return "redirect:/signup/success";
      } else {
         map.addAttribute("form", form);
         return"security/signup";
      }
   }

   @RequestMapping("/signup/success")
   @PreAuthorize("permitAll()")
   public String signup_sucesss(Model model, ModelMap map){
      map.put("username", model.asMap().get("username"));
      return "success/signup";
   }

   @GetMapping("/vklogin")
   public String enterWithVk(@RequestParam(value = "code", required = false) String code) throws IOException {

      if (code != null) {
         return "redirect:" + vkConnector.getAccessToken(code).toString();
      }
      return "home";
      }



   @GetMapping("/user")
   @ResponseBody
   public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
      return Collections.singletonMap("name", principal.getAttribute("name"));
   }


   @GetMapping("/accessDenied")
   public String getError403Page(){
      return "errors/403";
   }
   @GetMapping("/error")
   public String getErrorPage(){
      return "errors/default";
   }

}
