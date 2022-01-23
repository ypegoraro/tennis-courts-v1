package com.tenniscourts.schedules;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ScheduleController extends BaseRestController {

    private final ScheduleService scheduleService;

    //TODO: implement rest and swagger
    @PostMapping(value = "/schedule",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addScheduleTennisCourt(@RequestBody CreateScheduleRequestDTO createScheduleRequestDTO) {
        return ResponseEntity.created(locationByEntity(scheduleService.addSchedule(createScheduleRequestDTO.getTennisCourtId(), createScheduleRequestDTO).getId())).build();
    }

    //TODO: implement rest and swagger
    @GetMapping("/schedule/{startDate}/{endDate}")
    public ResponseEntity<List<ScheduleDTO>> findSchedulesByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return ResponseEntity.ok(scheduleService.findSchedulesByDates(LocalDateTime.of(startDate, LocalTime.of(0, 0)), LocalDateTime.of(endDate, LocalTime.of(23, 59))));
    }

    //TODO: implement rest and swagger
    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleDTO> findByScheduleId(@PathVariable("id") Long scheduleId) {
        return ResponseEntity.ok(scheduleService.findSchedule(scheduleId));
    }
}
