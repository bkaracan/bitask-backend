package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.TaskSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSuggestionRepository extends JpaRepository<TaskSuggestion, Long> {
}
