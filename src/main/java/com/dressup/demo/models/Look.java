package com.dressup.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@Entity
@Table(name = "looks")
public class Look {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Length(max = 50)
    @Column(columnDefinition = "text")
    private String description;

    @Size(min = 1, max = 20)
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "looks_items",
            joinColumns = { @JoinColumn(name = "looks") },
            inverseJoinColumns = { @JoinColumn(name = "items") }
    )
    private List<Item> items = new ArrayList<Item>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users", nullable = false)
    private User owner;

    @Override
    public String toString() {
        return name;
    }
}
