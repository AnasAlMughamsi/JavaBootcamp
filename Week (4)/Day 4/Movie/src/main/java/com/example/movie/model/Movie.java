package com.example.movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "movie name is required")
    @Size(min = 3, max = 35, message = "movie name should be more then 3 characters")
    @Column(columnDefinition = "varchar(35) not null")
    private String name;
    @NotEmpty(message = "genre is required")
    @Pattern(regexp = "Drama|Action|Comedy")
    @Column(columnDefinition = "varchar(30) not null check ( genre='drama' or genre='action' or genre='comedy' )")
    private String genre;
    @NotNull(message = "rating is required")
    @Range(min = 1, max = 5)
    private int rating;

    @NotEmpty(message = "duration is required")
//    @Range(min = 60)
    private String duration;

//    @Column(columnDefinition = "foreign key (directorID) references director(id)")
    private Integer directorID;
}
