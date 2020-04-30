package com.dressup.demo.models;

import com.dressup.demo.utils.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.*;


@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordRepeat", message = "The password fields must match")
})
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 16)
    @Column(nullable = false)
    private String username;
    @Length(max = 255)
    @Column(nullable = false)
    private String fullName;

    @Length(min = 6)
    @Column(nullable = false)
    private String hashPassword;


    @OneToMany(fetch = FetchType.LAZY)
    private List<Look> looks = new ArrayList<Look>();
    @OneToMany(fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<Item>();

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}
