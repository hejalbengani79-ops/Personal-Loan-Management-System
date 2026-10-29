package com.example.MiniProject.Controllers;
import com.example.MiniProject.Entities.repayment;
import com.example.MiniProject.Services.repaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class repaymentController
{
    private final repaymentService service;
    public repaymentController(repaymentService service)
    {
        this.service = service;
    }
    @GetMapping("/loans/{id}/repayments")
    public List<repayment> getSchedule(@PathVariable("id") int loanId)
    {
        List<repayment> repay = service.getAllRepayment(loanId);
        return repay;
    }
    @PostMapping("/loans/{id}/repayments")
    public repayment updateRepayment(@RequestBody repayment r,@PathVariable("id") int id)
    {
        repayment re = service.updateRepayments(r,id);
        return re;
    }
    @GetMapping("/loans/{id}/outstanding")
    public double getOutstandingAmount(@PathVariable("id") int loanId)
    {
        return service.getOutstandingAmount(loanId);
    }
}
