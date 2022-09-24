package com.example.demo1.repositories;

import com.example.demo1.entities.Task1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositorio extends JpaRepository<Task1,Long> {
}
