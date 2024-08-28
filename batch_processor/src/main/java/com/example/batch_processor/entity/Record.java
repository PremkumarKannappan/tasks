package com.example.batch_processor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PREM_CSV_READER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tableName;
    private String columnName;
    private String dataType;
}