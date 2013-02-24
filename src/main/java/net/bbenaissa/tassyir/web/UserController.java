/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.bbenaissa.tassyir.web;

import java.util.Collection;

import javax.validation.Valid;

import net.bbenaissa.tassyir.model.User;
import net.bbenaissa.tassyir.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author benaissa
 */
@Controller
@SessionAttributes(types = User.class)
public class UserController {

	
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.GET)
    public String initCreationForm(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "users/createOrUpdateUserForm";
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "users/createOrUpdateUserForm";
        } else {
            this.userService.saveUser(user);
            status.setComplete();
            return "redirect:/users/" + user.getId();
        }
    }

    @RequestMapping(value = "/users/find", method = RequestMethod.GET)
    public String initFindForm(Model model) {
        model.addAttribute("user", new User());
        return "users/findUsers";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String processFindForm(User user, BindingResult result, Model model) {

        // allow parameterless GET request for /owners to return all records
        if (user.getLastName() == null) {
        	user.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        Collection<User> results = this.userService.findUserByLastName(user.getLastName());
        if (results.size() < 1) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "users/findUsers";
        }
        if (results.size() > 1) {
            // multiple owners found
            model.addAttribute("selections", results);
            return "users/usersList";
        } else {
            // 1 owner found
            user = results.iterator().next();
            return "redirect:/users/" + user.getId();
        }
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public String initUpdateUserForm(@PathVariable("userId") int userId, Model model) {
        User user = this.userService.findUserById(userId);
        model.addAttribute(user);
        return "users/createOrUpdateUserForm";
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.PUT)
    public String processUpdateUserForm(@Valid User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "users/createOrUpdateUserForm";
        } else {
            this.userService.saveUser(user);
            status.setComplete();
            return "redirect:/users/{userId}";
        }
    }

    /**
     * Custom handler for displaying an owner.
     *
     * @param ownerId the ID of the owner to display
     * @return a ModelMap with the model attributes for the view
     */
    @RequestMapping("/users/{userId}")
    public ModelAndView showOwner(@PathVariable("userId") int userId) {
        ModelAndView mav = new ModelAndView("users/userDetails");
        mav.addObject(this.userService.findUserById(userId));
        return mav;
    }

}
