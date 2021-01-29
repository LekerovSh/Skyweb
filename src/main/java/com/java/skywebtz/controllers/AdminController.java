package com.java.skywebtz.controllers;

import com.java.skywebtz.dto.AdminDTO;
import com.java.skywebtz.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public HashMap<Long, String> add(
            @RequestBody List<Long> longs) {

        try {
            return adminService.add(longs);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @GetMapping
    public List<AdminDTO> show(
            @RequestBody List<Long> longs) {

        return adminService.show(longs);
    }

}
