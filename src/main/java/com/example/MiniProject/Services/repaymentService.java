package com.example.MiniProject.Services;
import com.example.MiniProject.Entities.loan;
import com.example.MiniProject.Entities.repayment;
import com.example.MiniProject.Repositories.loanRepository;
import com.example.MiniProject.Repositories.repaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class repaymentService
{
    private final repaymentRepository repo;
    private final loanRepository repo_loan;
    public repaymentService(repaymentRepository repo, loanRepository repo_loan)
    {
        this.repo = repo;
        this.repo_loan = repo_loan;
    }
    public void createRepayments()
    {
        List<loan> loans = repo_loan.findByStatus("APPROVED");
        for(int i=0; i<loans.size(); i++)
        {
            loan l = loans.get(i);
            if(repo.existsByLoanId(l.getId()))
            {
                continue;
            }
            for(int j=0; j<l.getTenure(); j++)
            {
                repayment r = new repayment();
                r.setLoan_id(l.getId());
                r.setAmount_due(l.getEmi());
                r.setAmount_paid(0);
                r.setStatus("PENDING");
                repo.save(r);
            }
        }
    }
    public repayment updateRepayments(repayment repay, int id)
    {
        Optional<repayment> result = repo.findById(id);
        if(result.isPresent())
        {
            repayment re = result.get();
            System.out.println("ID received: " + id);
            System.out.println("Amount paid received: " + repay.getAmount_paid());
            System.out.println("Amount due in database: " + re.getAmount_due());
            if(Math.round(repay.getAmount_paid() * 100) == Math.round(re.getAmount_due() * 100))
            {
                re.setAmount_paid(repay.getAmount_paid());
                re.setStatus("PAID");
                repo.save(re);
                return re;
            }
        }
        return null;
    }
    public List<repayment> getAllRepayment(int loanId)
    {
        List<repayment> repay = repo.findByLoanId(loanId);
        return repay;
    }
    public double getOutstandingAmount(int loanId)
    {
        List<repayment> repayments = repo.findByLoanId(loanId);
        double totalDue = 0;
        double totalPaid = 0;
        for(int i = 0; i < repayments.size(); i++)
        {
            repayment r = repayments.get(i);
            totalDue += r.getAmount_due();
            totalPaid += r.getAmount_paid();
        }
        return Math.round((totalDue - totalPaid) * 100.0) / 100.0;
    }
}
