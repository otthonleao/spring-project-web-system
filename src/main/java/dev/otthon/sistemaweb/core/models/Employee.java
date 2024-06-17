package dev.otthon.sistemaweb.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @ToString.Include
    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 11, nullable = false, unique = true)
    private String phone;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate hireDate;

    @Column(nullable = true)
    private LocalDate resignationDate;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Address address;

    // Muitos empregados tem somente um cargo.
    // Não é opcional que algum empregado fique sem cargo.
    @ManyToOne(optional = false)
    private Position position;

    // Relacionamento Inverso
    // A JPA não cria uma nova coluna, ela entende que deve buscar uma lista de projetos do team por mapeamento
    @ManyToMany(mappedBy = "team")
    private List<Project> projects;

    @Column(nullable = false)
    private String password;
}
