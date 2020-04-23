package com.dressup.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

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
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Length(max = 65535)
    @Column(columnDefinition = "text")
    private String description;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brands", nullable = false)
    private Brand brand;


    @NotNull
    @ManyToMany(mappedBy = "items")
    private List<Look> looks = new ArrayList<Look>();

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users", nullable = false)
    private User owner;


    @URL
    private String image_url;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", looks=" + looks +
                ", owner=" + owner +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
