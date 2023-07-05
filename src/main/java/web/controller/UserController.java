package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import javax.validation.Valid;
//import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import web.model.User;
import web.service.UserServiceInterface;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private final UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String allUsers(ModelMap model) {

        List<User> people = userService.getAllUsers();
        model.put("people", people);
        return "users/all";
    }

    @GetMapping("/{id}")
    public String userPage(@PathVariable("id") long id, ModelMap model) {

        model.put("user", userService.getUserById(id));
        return "users/userPage";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, ModelMap model) {

        model.put("user", userService.getUserById(id));
        return "users/edit";
    }


    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id) {

        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.update(id, user);
        return "redirect:/users";
    }


    @GetMapping("/add")
    public String addForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        System.out.println("bindingResult.hasErrors() = " + bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        return "users/addForm";
    }


    @PostMapping()
    public String addForm(@RequestParam("name") String name, @RequestParam("age") int age, ModelMap model) {

        userService.add(new User(name, age));
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") long id) {

        System.out.println("DELETE" + id);

        userService.delete(id);
        return "redirect:/users";

    }
}
