package com.example.internship.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ExcelCell(0)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="isSent",nullable = true)
    private boolean isSent;
}
