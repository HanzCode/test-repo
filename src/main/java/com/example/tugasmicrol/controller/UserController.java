package com.example.tugasmicrol.controller;

import com.example.tugasmicrol.dto.request.UserDTO;
import com.example.tugasmicrol.dto.response.ResponseAPI;
import com.example.tugasmicrol.entity.User;
import com.example.tugasmicrol.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:63342")
@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/user")
public class UserController {

    private UserServiceImpl userService;


    @PostMapping("/create")
    public ResponseEntity<ResponseAPI<?>> submit(@RequestBody UserDTO dto){
        return ResponseEntity.ok(userService.createNewUser(dto));
    }
}
