package dev.otthon.sistemaweb.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Project {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Include
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate endDate;

    @Column(nullable = false)
    private BigDecimal budget;

    @Column(nullable = false)
    private BigDecimal cost;

    // Um cliente pode ter muitos projetos
    @ManyToOne(optional = false)
    private Client client;

    // Um gerente pode ter muitos projetos
    @ManyToOne(optional = false)
    private Employee manager;

    // Muitos times, ou membros dos times, podem ter muitos projetos
    @ManyToMany
    private List<Employee> team;
}
