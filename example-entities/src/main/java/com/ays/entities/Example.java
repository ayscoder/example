package com.ays.entities;

import lombok.*;

import javax.persistence.*;

/**
 * @author user created on 20/01/2021
 */
@Entity
@Table(name = "example")
@Data
@EqualsAndHashCode(callSuper = true)
public class Example extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
}