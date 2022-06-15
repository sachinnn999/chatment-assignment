package com.sachinnn.facts.model.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AnimalFactsLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String fact;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
}
