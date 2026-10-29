package com.example.MiniProject.Controllers;
import com.example.MiniProject.Entities.approval;
import com.example.MiniProject.Entities.loan;
import com.example.MiniProject.Services.loanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class loanController
{
    private final loanService service;
    public loanController(loanService service)
    {
        this.service = service;
    }
    @PostMapping("/loan-applications")
    public loan createLoan(@RequestBody loan l)
    {
        l.setStatus(service.validation(l));
        service.updateLoanInfo(l);
        return l;
    }
    @PatchMapping("/loan-applications/{id}/decision")
    public String updateStatus(@PathVariable int id,@RequestBody approval a)
    {
        service.updateStatusInfo(id, a);
        String s = a.getRemarks();
        return s;
    }
    @GetMapping("/loan-applications/{id}")
    public loan getById(@PathVariable int id)
    {
        loan l = service.UsingId(id);
        return l;
    }
    @GetMapping("/loan-applications")
    public List<loan> getAllLoanDetails()
    {
        return service.GetAll();
    }
}