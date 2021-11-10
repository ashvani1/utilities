package com.utils.filesystem.repository;

import com.utils.filesystem.model.LogsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LogsRepository extends JpaRepository<LogsDTO, String>{
}
