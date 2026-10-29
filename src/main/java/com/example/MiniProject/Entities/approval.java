package com.example.MiniProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class approval
{
    @Id
    private int id;
    private String status;
    private double interest_rate;
    private String remarks;

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public double getInterest_rate()
    {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate)
    {
        this.interest_rate = interest_rate;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
