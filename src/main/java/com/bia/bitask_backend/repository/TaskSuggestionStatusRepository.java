package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.TaskSuggestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSuggestionStatusRepository extends JpaRepository<TaskSuggestionStatus, Long> {
}
