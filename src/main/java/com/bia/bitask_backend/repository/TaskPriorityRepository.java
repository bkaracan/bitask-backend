package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {

}
