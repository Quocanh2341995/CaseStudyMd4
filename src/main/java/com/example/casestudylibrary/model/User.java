package com.example.casestudylibrary.model;

import com.example.casestudylibrary.model.enumperation.EClass;
import com.example.casestudylibrary.model.enumperation.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phone;
    private String username;
    private String password;
    private String email;
    private Long id_img;
    private ERole eRole;
    private LocalDate dob;
    private EClass eClass;
}
