package com.sachinnn.facts.repository;

import com.sachinnn.facts.model.dao.AnimalFactsLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalFactsLogRepository extends CrudRepository<AnimalFactsLog, Long> {
}
