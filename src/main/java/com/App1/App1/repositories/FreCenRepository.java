package com.App1.App1.repositories;

import com.App1.App1.model.entity.FreCen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreCenRepository extends JpaRepository<FreCen, Long> {
}