package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.NotificationLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationLevelRepository extends JpaRepository<NotificationLevel, Long> {
}
