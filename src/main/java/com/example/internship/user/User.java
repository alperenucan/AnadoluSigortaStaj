package com.example.internship.user;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
}
