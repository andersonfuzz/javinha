package com.javinha.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javinha.api.models.Task;

@Repository
public interface TasksRepository extends JpaRepository<Task, UUID> {

}
