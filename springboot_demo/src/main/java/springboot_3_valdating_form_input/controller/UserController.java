package springboot_3_valdating_form_input.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot_3_valdating_form_input.domain.User;
import springboot_3_valdating_form_input.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Get the User list
     * @param map
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public String getUserList(ModelMap map) {
        map.addAttribute("userList", userService.findAll());
        return "userList";
    }


    /**
     * Create the user form
     * @param map
     * @return
     */

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new User());
        map.addAttribute("action", "create");
        return "userForm";
    }


    /**
     * Create User
     * @param map
     * @param user
     * @param bindingResult
     * @return
     */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(ModelMap map, @ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "userForm";
        }

        userService.insertByUser(user);
        return "redirect:/users/";
    }

    /**
     * Display the user list which need to update
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("user", userService.findById(id));
        map.addAttribute("action", "update");
        return "userForm";
    }


    /**
     * Update User
     * @param map
     * @param user
     * @param result
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(ModelMap map, @ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            map.addAttribute("action", "update");
            return "userForm";
        }

        userService.update(user);
        return "redirect:/users/";
    }


    /**
     * Delete the user information
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deteleUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users/";
    }

}
