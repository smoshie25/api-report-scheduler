package com.seamfix.scheduler.web;

import com.seamfix.scheduler.entity.ScheduleEntity;
import com.seamfix.scheduler.entity.ScheduleType;
import com.seamfix.scheduler.model.ScheduleDTO;
import com.seamfix.scheduler.service.ScheduleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(path = "/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchedule(@RequestBody @Validated ScheduleDTO scheduleDTO){
        scheduleService.createSchedule(scheduleDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateSchedule(@RequestBody @Validated ScheduleDTO scheduleDTO) throws NotFoundException {
        scheduleService.update(scheduleDTO);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void patchSchedule(@RequestBody @Validated ScheduleDTO scheduleDTO) throws NotFoundException {
        scheduleService.patch(scheduleDTO);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{Id}")
    public ScheduleDTO getById(@PathVariable(value = "Id") String Id) throws NotFoundException {
        return scheduleService.find(Id);
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/{Id}")
    public void deleteSchedule(@PathVariable(value = "Id") String Id) throws NotFoundException {
        scheduleService.delete(Id);
    }

    @RequestMapping(method = RequestMethod.GET, path="/days")
    public ResponseEntity<List<DayOfWeek>> days() {
        return new ResponseEntity<>(Arrays.asList(DayOfWeek.values()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path="/types")
    public ResponseEntity<List<ScheduleType>> types() {
        return new ResponseEntity<>(Arrays.asList(ScheduleType.values()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<ScheduleEntity> getAll(Pageable pageable) throws ParseException {
        /*ScheduleDTO schedule = new ScheduleDTO();
        schedule.setActive(true);
        schedule.setDate(new Date());
        schedule.setDescription("Test Desc");
        schedule.setName("Test");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        schedule.setTime(new Time((stf.parse("192:00:00")).getTime()));
        schedule.setScheduleType(ScheduleType.DAILY);
        //schedule.setFrequency();
        schedule = scheduleService.createSchedule(schedule);*/
        return scheduleService.getAll(pageable);
    }

}
