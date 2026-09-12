package com.carewise.health.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carewise.health.entity.HealthRecord;

@Repository
public interface HealthRecordRepository
        extends JpaRepository<HealthRecord, Long> {
	
	Optional<HealthRecord> findByUserId(Long userId);
	
	boolean existsByUserId(Long userId);

}