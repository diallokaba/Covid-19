package com.covid.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ville;
    String quartier;
    @Temporal(TemporalType.DATE)
    Date date;
}
