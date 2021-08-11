package com.example.internship.user;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
public class User {

    @Id
    private Long id;
}
