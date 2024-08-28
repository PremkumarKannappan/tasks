package com.example.batch_processor.repository;

import com.example.batch_processor.entity.Record;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{
}
