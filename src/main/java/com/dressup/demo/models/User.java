package com.dressup.demo.models;

import com.dressup.demo.utils.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordRepeat", message = "The password fields must match")
})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Length(max = 255)
    @Column(nullable = false)
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "users_users_role",
            joinColumns = @JoinColumn(name = "users"),
            inverseJoinColumns = @JoinColumn(name = "users_role")
    )
    private Set<UserAuthority> authorities = new HashSet<>();

    @Length(max = 16)
    @Column(nullable = false)
    private String nickname;

    @NotBlank
    @Transient
    private String passwordRepeat;

    @Column(nullable = false)
    private String email;

    @Length(max = 16)
    @Column(nullable = false)
    private String hashPassword;


    @OneToMany(fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<Item>();

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
