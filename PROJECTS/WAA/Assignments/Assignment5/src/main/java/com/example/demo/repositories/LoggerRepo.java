package com.example.demo.repositories;

import com.example.demo.models.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger,Long> {

}
