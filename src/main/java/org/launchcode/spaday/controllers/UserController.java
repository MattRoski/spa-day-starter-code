package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //this class is a controller
@RequestMapping(value = "/user")
//handle any http request(GET,POST)...
//Any HTTP requests that come to us on the /user route, this is where you will find how that get handled
public class UserController {

    private UserData userData = new UserData(); //used to store all our users

    @GetMapping(value = "add") //Since we are in the user directory, @RequestMapping(/user)... we just put add as the parameter NOT user/add
    public String displayAddUserForm(){
        return "user/add"; //dont need .html extension bcuz springs default behavior wants to return a html file
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user,String verify){
        model.addAttribute("user",user);
        model.addAttribute("verify",verify);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());
        //because the values are passes to the model..it rerenders the form with the values still there

        if( (user.getPassword().equals(verify)) && (user.getPassword() != "")){
            //provide list of users
            //to provide data to our thymeleaf need to use model.addAttribute
            userData.add(user); //need to add to our list when there is a successful registration, so if they successfully login in/register(if passwords are equal) we add the user to the userData object
            model.addAttribute(this.userData.getAll());
            return "user/index";
        } else{
            model.addAttribute("error","Passwords do not match");
            return "user/add";
        }
    }
}
