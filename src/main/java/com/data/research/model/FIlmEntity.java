package com.data.research.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "film")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FIlmEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private AuthorEntity author;
}
