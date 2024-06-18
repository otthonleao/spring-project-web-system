package dev.otthon.sistemaweb.web.auth.controller;

import dev.otthon.sistemaweb.core.repositories.EmployeeRepository;
import dev.otthon.sistemaweb.core.services.authorization.AuthenticatedUser;
import dev.otthon.sistemaweb.web.auth.dtos.UpdatePasswordForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping( "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }

    @GetMapping("/update-password")
    public ModelAndView updatePassword() {
        var model = Map.of("updatePasswordForm", new UpdatePasswordForm());
        return new ModelAndView("auth/update-password", model);
    }

    @PostMapping("/update-password")
    public String updatePassword(@Valid UpdatePasswordForm updatePasswordForm, BindingResult bindingResult, Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return "/auth/update-password";
        }

        System.out.println(authentication);
        var employee = ((AuthenticatedUser) authentication.getPrincipal()).getEmployee();
        var passwordMatches = passwordEncoder.matches(
                updatePasswordForm.getCurrentPassword(),
                employee.getPassword()
        );

        if (passwordMatches) {
           var newPasswordHash = passwordEncoder.encode(updatePasswordForm.getNewPassword());
           employee.setPassword(newPasswordHash);
           employeeRepository.save(employee);
           return "redirect:/";
        }

        return "/auth/update-password";

    }

}
