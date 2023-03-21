package com.controlstudent.model;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class TuitionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @EqualsAndHashCode.Include
    private Long id;
    @Basic(optional = false)
    @Column(length = 50)
    private String classroom;
    @ManyToOne
    @JoinColumn(name = "id_course",nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_tuition",nullable = false)
    private Tuition tuition;


}
