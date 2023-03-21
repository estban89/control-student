package com.controlstudent.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Tuition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @EqualsAndHashCode.Include
    private Long id;
    @Basic(optional = false)
    private LocalDateTime date;
    @Basic(optional = false)
    private Boolean state;
    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;
    @OneToMany(mappedBy = "tuition", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TuitionDetail> details;
}
