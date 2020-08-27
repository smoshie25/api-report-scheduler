package com.seamfix.scheduler.repo;

import com.seamfix.scheduler.entity.ScheduleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ScheduleRepository extends PagingAndSortingRepository<ScheduleEntity,String> {

}
