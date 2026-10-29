package com.example.MiniProject.Services;
import java.util.Locale;
import java.util.List;
import java.util.Optional;

import com.example.MiniProject.Entities.approval;
import com.example.MiniProject.Entities.loan;
import com.example.MiniProject.Repositories.loanRepository;
import com.example.MiniProject.ExceptionHandling.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static java.lang.Math.pow;

@Service
public class loanService
{
    private final loanRepository repo;
    private final repaymentService service;
    @Value("${loan.min_loan_amount}")
    private double min_loan_amount;
    @Value("${loan.max_loan_amount}")
    private double max_loan_amount;
    @Value("${loan.min_income}")
    private double min_income;
    @Value("${loan.min_tenure}")
    private double min_tenure;
    @Value("${loan.max_tenure}")
    private double max_tenure;
    public loanService(loanRepository repo, repaymentService service)
    {
        this.repo = repo;
        this.service = service;
    }

    public String validation(loan l1)
    {
        double loan_amount = l1.getLoan_amount();
        double income = l1.getIncome();
        double tenure = l1.getTenure();
        if(loan_amount >=min_loan_amount && loan_amount <= max_loan_amount && income>=min_income && tenure>=min_tenure && tenure<=max_tenure && loan_amount<=5*income)
        {
            return "PENDING";
        }
        else
        {
            return "INELIGIBLE";
        }
    }
    public void updateLoanInfo(loan l1)
    {
        repo.save(l1);
    }
    public String updateStatusInfo(int id, approval a1)
    {
        Optional<loan> result = repo.findById(id);
        if(result.isPresent())
        {
            loan l = result.get();
            if(a1.getStatus().equalsIgnoreCase("approved"))
            {
                l.setStatus("APPROVED");
                l.setInterest_rate(a1.getInterest_rate());
                if(l.getInterest_rate()<=0)
                {
                    return("Invalid rate of interest");
                }
                generateEmi(l);
                repo.save(l);
                service.createRepayments();
            }
            else
            {
                l.setStatus("REJECTED");
                l.setInterest_rate(a1.getInterest_rate());
                repo.save(l);
            }
        }
        else
        {
            throw new ResourceNotFoundException("Loan ID not found: " + id);
        }
        return "";
    }
    public void generateEmi(loan l)
    {
        double p = l.getLoan_amount();
        double r = l.getInterest_rate()/1200;
        double n = l.getTenure();
        double emi;
        emi = (p*r*(pow((1+r),n)))/((pow((1+r),n))-1);
        double Emi = Math.round(emi*100.0)/100.0;
        l.setEmi(Emi);
    }
    public loan UsingId(int id)
    {
        Optional<loan> result = repo.findById(id);
        if(result.isPresent()) {
            loan l = result.get();
            return l;
        }
        throw new ResourceNotFoundException("Loan ID not found: " + id);
    }
    public List<loan> GetAll()
    {
        return repo.findAll();
    }
}
