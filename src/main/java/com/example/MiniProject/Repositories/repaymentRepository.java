package com.example.MiniProject.Repositories;

import com.example.MiniProject.Entities.repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repaymentRepository extends JpaRepository<repayment, Integer>
{
    List<repayment> findByLoanId(int loanId);
    boolean existsByLoanId(int loanId);
}
