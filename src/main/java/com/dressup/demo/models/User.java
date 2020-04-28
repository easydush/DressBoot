package com.dressup.demo.models;

import com.dressup.demo.utils.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @NotBlank
    @Transient
    private String passwordRepeat;

    @Length(max = 16)
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
