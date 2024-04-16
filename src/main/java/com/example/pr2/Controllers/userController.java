package com.example.pr2.Controllers;

import com.example.pr2.Repository.UserRepository;
import com.example.pr2.models.modelUser;
import com.example.pr2.models.roleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String userView(Model model)
    {
        model.addAttribute("user_list", userRepository.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String detailView(@PathVariable Long id, Model model)
    {
        model.addAttribute("user_object",userRepository.findById(id).orElseThrow());
        return "info";
    }

    @GetMapping("/{id}/update")
    public String updView(@PathVariable Long id, Model model)
    {
        model.addAttribute("user_object",userRepository.findById(id).orElseThrow());
        model.addAttribute("roles", roleEnum.values());
        return "update";
    }


    @PostMapping("/{id}/update")
    public String update_user(@RequestParam String username,
                              @RequestParam(name="roles[]", required = false) String[] roles,
                              @PathVariable Long id)
    {
        modelUser user = userRepository.findById(id).orElseThrow();
        user.setUsername(username);

        user.getRoles().clear();
        if(roles != null)
        {
            for(String role: roles)
            {
                user.getRoles().add(roleEnum.valueOf(role));
            }
        }



        userRepository.save(user);
        return "redirect:/admin/{id}";
    }

}
