package com.formaciontdd.infrastructure.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ISSUES")
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String user;

    @NotBlank
    @Size(max = 150)
    private String description;

    private Date createdAt;

    private Boolean isOpen;
}
