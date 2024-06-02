package com.recipe.backend.domain.user.domain;

import com.recipe.backend.domain.inventory.domain.Inventory;
import com.recipe.backend.global.TimeStamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(nullable = false,unique = true, length = 30)
    private String username;

    @Column(nullable = false,unique = true, length = 30)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToOne(mappedBy = "user")
    private Inventory inventory;
}
