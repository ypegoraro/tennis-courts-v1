package com.tenniscourts.schedules;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByTennisCourt_IdOrderByStartDateTime(Long id);
    
    List<Schedule> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(LocalDateTime startDate, LocalDateTime endDate);
}