package com.example.tugasmicrol.service;


import com.example.tugasmicrol.dto.request.UserDTO;
import com.example.tugasmicrol.dto.response.ResponseAPI;

public interface UserService {

    ResponseAPI<?> createNewUser(UserDTO dto);

}
