package com.seamfix.scheduler;

import com.seamfix.scheduler.entity.ScheduleEntity;
import com.seamfix.scheduler.entity.ScheduleType;
import com.seamfix.scheduler.model.ScheduleDTO;
import com.seamfix.scheduler.service.ScheduleService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class SchedulerApplicationTests {

    @Autowired
    ScheduleService scheduleService;

    @Test
    void contextLoads() throws ParseException, NotFoundException {
        ScheduleDTO schedule = new ScheduleDTO();
        schedule.setActive(true);
        //schedule.setDate(new Date());
        schedule.setDescription("Test Desc");
        schedule.setName("Test");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        //schedule.setTime(new Time((stf.parse("192:00:00")).getTime()));
        schedule.setScheduleType(ScheduleType.DAILY);
        //schedule.setFrequency();
        schedule = scheduleService.createSchedule(schedule);

        assertThat(schedule.getId()).isNotNull();
        assertThat(schedule.getScheduleType()).isEqualTo(ScheduleType.DAILY);

        assertThat(scheduleService.getAll(Pageable.unpaged())).isNotEmpty();

        schedule.setActive(false);
        ScheduleEntity update = scheduleService.update(schedule);
        assertEquals(null,false,update.isActive());

        schedule.setActive(true);
        schedule.setName("Patch Test");
        ScheduleEntity patch = scheduleService.patch(schedule);
        assertEquals(null,true,patch.isActive());
        assertEquals(null,"Patch Test",patch.getName());
        assertEquals(null,"Test Desc",patch.getDescription());

        scheduleService.delete(schedule.getId());
        assertThat(scheduleService.getAll(Pageable.unpaged())).isEmpty();


    }

}
