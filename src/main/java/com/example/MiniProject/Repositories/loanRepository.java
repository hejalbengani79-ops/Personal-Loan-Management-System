package com.example.MiniProject.Repositories;
import com.example.MiniProject.Entities.loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface loanRepository extends JpaRepository<loan, Integer>
{
    List<loan> findByStatus(String status);
}
