package com.example.tugasmicrol.service.impl;

import com.example.tugasmicrol.dto.request.UserDTO;
import com.example.tugasmicrol.dto.response.ResponseAPI;
import com.example.tugasmicrol.entity.User;
import com.example.tugasmicrol.repo.UserRepo;
import com.example.tugasmicrol.service.UserService;
import com.example.tugasmicrol.validation.DoubleIdUserException;
import com.example.tugasmicrol.validation.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepo userRepo;

    private void cekId(int id){
        if(userRepo.findUserById(id).isPresent()){
            throw new DoubleIdUserException("id telah tersedia");
        }
        return;
    }

    private User objectMapper(UserDTO dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setNIP(dto.getNip());

        return user;
    }

    @Override
    public ResponseAPI<?> createNewUser(UserDTO dto) {
        try{
            cekId(dto.getId());
            User user = userRepo.save(objectMapper(dto));
            return ResponseAPI.builder()
                    .code(HttpStatus.CREATED.value())
                    .message("berhasil menambahkan")
                    .build();
        }catch (DoubleIdUserException exception){
            return ResponseAPI.builder()
                    .code(HttpStatus.CONFLICT.value())
                    .message(exception.getMessage())
                    .build();
        }
    }

    public User findById(int id){
        if(userRepo.findUserById(id).isPresent()){
            return userRepo.findUserById(id).get();
        }
        throw new UserNotFoundException("id tidak ditemukan");
    }
}
