package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {

  List<TaskPriority> findAllByNameStartingWithIgnoreCaseOrderByNameAsc(String taskPriorityName);

  @Query(
      """
SELECT tp from TaskPriority tp
WHERE tp.name LIKE lower(:taskPriorityName)
ORDER BY tp.name ASC
""")
  List<TaskPriority> findAllByName(@Param("taskPriorityName") String taskPriorityName);

  @Query(
      value = "select * from task_priority where name like lower(:taskPriorityName) order by name asc",
      nativeQuery = true)
  List<TaskPriority> findAllByNameWithNativeQuery(@Param("taskPriorityName") String taskPriorityName);
}
