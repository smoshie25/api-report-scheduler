package com.seamfix.scheduler.service;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.seamfix.scheduler.entity.ScheduleEntity;
import com.seamfix.scheduler.model.ScheduleDTO;
import com.seamfix.scheduler.repo.ScheduleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleDTO createSchedule(ScheduleDTO dto){

        ScheduleEntity entity = mapper.map(dto,ScheduleEntity.class);
        entity.setId(UUID.randomUUID().toString());
        return mapper.map(scheduleRepository.save(entity),ScheduleDTO.class);
    }

    public Page<ScheduleEntity> getAll(Pageable pageable){
        return scheduleRepository.findAll(pageable);
    }


    public ScheduleDTO find(String id) throws NotFoundException {
        ScheduleEntity entity = scheduleRepository.findById(id).get();
        if(entity==null) throw new NotFoundException(String.format("Schedule with id : %s Not found",id));
        return mapper.map(entity,ScheduleDTO.class);
    }

    public void delete(String id) throws NotFoundException {
        ScheduleEntity entity = scheduleRepository.findById(id).get();
        if(entity==null) throw new NotFoundException(String.format("Schedule with id : %s Not found",id));
        scheduleRepository.delete(entity);
    }

    public ScheduleEntity update(ScheduleDTO schedule) throws NotFoundException {
        ScheduleEntity entity = scheduleRepository.findById(schedule.getId()).get();
        if(entity==null) throw new NotFoundException(String.format("Schedule with id : %s Not found",schedule.getId()));
        entity.setName(schedule.getName());
        entity.setDescription(schedule.getDescription());
        entity.setFrequency(schedule.getFrequency());
        entity.setTime(schedule.getTime());
        entity.setFile(schedule.getFile());
        entity.setDate(schedule.getDate());
        entity.setScheduleType(schedule.getScheduleType());
        entity.setActive(schedule.isActive());
        return scheduleRepository.save(entity);
    }

    public ScheduleEntity patch(ScheduleDTO schedule) throws NotFoundException {
        ScheduleEntity entity = scheduleRepository.findById(schedule.getId()).get();
        if(entity==null) throw new NotFoundException(String.format("Schedule with id : %s Not found",schedule.getId()));
        if(schedule.getName()!=null)
            entity.setName(schedule.getName());
        if(schedule.getDescription()!=null)
            entity.setDescription(schedule.getDescription());
        if(schedule.getFrequency()!=null)
            entity.setFrequency(schedule.getFrequency());
        if(schedule.getTime()!=null)
            entity.setTime(schedule.getTime());
        if(schedule.getFile()!=null)
            entity.setFile(schedule.getFile());
        if(schedule.getDate()!=null)
            entity.setDate(schedule.getDate());
        if(schedule.getScheduleType()!=null)
            entity.setScheduleType(schedule.getScheduleType());

        entity.setActive(schedule.isActive());
        return scheduleRepository.save(entity);
    }
}
