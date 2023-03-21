package com.controlstudent.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @EqualsAndHashCode.Include
    private Long id;
    @Basic(optional = false)
    @Column(length = 50)
    private String name;
    @Basic(optional = false)
    @Column(length = 30)
    private String acronym;
    @Basic(optional = false)
    private Boolean state;

}
