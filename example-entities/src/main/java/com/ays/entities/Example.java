package com.ays.entities;

import lombok.*;
import javax.persistence.*;

/**
 * @author ayush created on 20/01/2021
 */

@Table(name = "example")
@Data
@EqualsAndHashCode(callSuper = true)
public class Example extends ManagedEntity {
    private String name;
    private String description;
}