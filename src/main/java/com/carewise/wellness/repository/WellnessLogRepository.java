package com.carewise.wellness.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carewise.wellness.entity.WellnessLog;

@Repository
public interface WellnessLogRepository
        extends JpaRepository<WellnessLog, Long> {
	
	List<WellnessLog> findByUserId(Long userId);
	
	boolean existsByUserIdAndLogDate(
	        Long userId,
	        LocalDate logDate);

}