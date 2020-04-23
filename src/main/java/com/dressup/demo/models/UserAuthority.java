package com.dressup.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_role")
public class UserAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) /* http://www.objectdb.com/java/jpa/entity/generated */
    private Integer id;

    @NotBlank
    @Length(max = 30)
    @Column(length = 30, nullable = false, unique = true)
    private String authority;


  /*
    SPECIAL METHODS
  */

    @Override
    public String toString(){
        return authority;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.authority);
        return hash;
    }


    @Override
    public String getAuthority() {
        return authority;
    }
}