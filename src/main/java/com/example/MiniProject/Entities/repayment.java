package com.example.MiniProject.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "repayment")
public class repayment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int loanId;
    private double amount_due;
    private double amount_paid;
    private String status;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getLoan_id()
    {
        return loanId;
    }

    public void setLoan_id(int loanId)
    {
        this.loanId = loanId;
    }

    public double getAmount_paid()
    {
        return amount_paid;
    }

    public void setAmount_paid(double amount_paid)
    {
        this.amount_paid = amount_paid;
    }

    public double getAmount_due()
    {
        return amount_due;
    }

    public void setAmount_due(double amount_due)
    {
        this.amount_due = amount_due;
    }
}
