package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.TaskAssignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssigneeRepository extends JpaRepository<TaskAssignee, Long> {
}
