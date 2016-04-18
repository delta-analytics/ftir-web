package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.entity.User;
import deltaanalytics.ftirweb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    private UserRepository userRepository;

    @RequestMapping("/users")
    public String index(Model model) {
        model.addAttribute("allUsers", userRepository.findAll());
        return "users/users";
    }

    @RequestMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/createUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(User user) {
        logger.info("createUser " + user.toString());
        userRepository.save(user);
        return "redirect:/users/users";
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
    public String editUser(User user) {
        logger.info("editUser " + user.toString());
        userRepository.save(user);
        return "redirect:/users/users";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "users/editUser";
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
