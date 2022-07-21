package com.wipro.office2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.office2.entity.SalaryRecord;
@Repository
public interface SalaryRecordRepository extends JpaRepository<SalaryRecord, Integer>{

}
