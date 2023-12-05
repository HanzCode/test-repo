package com.example.tugasmicrol.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity (name = "tbl_user")
public class User {

    @Id
    private Integer id;

    private String name;

    private String NIP;
}
