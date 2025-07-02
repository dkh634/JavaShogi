package com.example.JavaShogi.login;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class AppUser {
    @Id
    private String username;

    private String password;

    private String role; // 例: "USER", "ADMIN"
}

