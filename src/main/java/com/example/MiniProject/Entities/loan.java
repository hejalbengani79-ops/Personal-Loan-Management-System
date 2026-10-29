package com.example.MiniProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class loan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double income;
    private double loan_amount;
    private double tenure;
    private String status;
    private double emi;
    private double interest_rate;

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getIncome()
    {
        return income;
    }

    public void setIncome(double income)
    {
        this.income = income;
    }

    public double getLoan_amount()
    {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount)
    {
        this.loan_amount = loan_amount;
    }

    public double getTenure()
    {
        return tenure;
    }

    public void setTenure(double tenure)
    {
        this.tenure = tenure;
    }
}
