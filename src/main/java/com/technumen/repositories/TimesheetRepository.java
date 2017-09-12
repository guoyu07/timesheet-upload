package com.technumen.repositories;

import com.technumen.models.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
}
