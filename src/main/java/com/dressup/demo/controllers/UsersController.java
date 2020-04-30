package com.dressup.demo.controllers;

import com.dressup.demo.models.User;
import com.dressup.demo.repositories.UserRepository;
import com.dressup.demo.service.LookService;
import com.dressup.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LookService lookService;

    @Autowired
    private UserService userService;


    /*@GetMapping("/{username}")
    public String getUserPage(@PathVariable String username, Model model, Principal principal) {
        Optional<User> user = userRepository.findUserByUsername(username);

        if (principal != null) {
            model.addAttribute("currUsername", principal.getName());
        }

        if (user.isPresent()) {
            UserDto userDto = UserDto.from(user.get());
            model.addAttribute("user", user.get());

            // Get users Tweets
            List<Tweet> userTweets = tweetService.getUsersAllTweets(user.get());
            model.addAttribute("userTweets", userTweets);
            // Date Time Formatter
            model.addAttribute("formatter", dateTimeFormatter);

            // Followers Amount
            int followerAmount = 0;
            model.addAttribute("followerAmount", followerAmount);
        } else {
            throw new UsernameNotFoundException("Cant find user");
        }

        return "user_page";
    }
*/



    @PostMapping("/checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam("username") String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.isPresent();
    }


}