package com.tenniscourts.schedules;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.tenniscourts.TennisCourt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;
    
    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {
        //TODO: implement addSchedule
        long reservationSlotInHours = 1;
        
        System.out.println(tennisCourtId.toString() + "primeiro argumento");
        System.out.println(createScheduleRequestDTO.getStartDateTime().toString() + "segundo argumento");
        System.out.println(createScheduleRequestDTO.getTennisCourtId().toString() + "3 argumento");
        
        ScheduleDTO scheduleDto = new ScheduleDTO();
        
        Schedule newSchedule = new Schedule();

        newSchedule.setStartDateTime(createScheduleRequestDTO.getStartDateTime());
        newSchedule.setEndDateTime(createScheduleRequestDTO.getStartDateTime().plusHours(reservationSlotInHours));
        
        TennisCourt tennisCourt = new TennisCourt();
        tennisCourt.setId(tennisCourtId);
        
        newSchedule.setTennisCourt(tennisCourt);
        
        scheduleRepository.save(newSchedule);
        scheduleDto = scheduleMapper.map(newSchedule);
        return scheduleDto;
        
        //return scheduleMapper.map(scheduleRepository.saveAndFlush(scheduleMapper.map(scheduleDto)));
    }

    public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        //TODO: implement
        return scheduleMapper.map(scheduleRepository.findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(startDate, endDate));
     //  return null;
    }

    public ScheduleDTO findSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).map(scheduleMapper::map).<RuntimeException>orElseThrow(() -> {
            throw new EntityNotFoundException("Tennis Court not found.");
        });
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }
}
