package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.Task;
import com.bia.bitask_backend.entity.TaskPriority;
import com.bia.bitask_backend.representation.TaskRepresentation1;
import com.bia.bitask_backend.representation.TaskRepresentation2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

}
