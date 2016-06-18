package com.lukegjpotter.spring.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;

public interface RoadRaceEventDatabaseRecordRepository extends CrudRepository<RoadRaceEventDatabaseRecord, Long> {

}
