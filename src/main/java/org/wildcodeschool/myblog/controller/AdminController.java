package org.wildcodeschool.myblog.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @GetMapping("/management")
    public String getManagementSection() {
        return "Section accessible aux administrateurs et aux managers";
    }
}
