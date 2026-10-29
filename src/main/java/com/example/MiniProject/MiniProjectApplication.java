package com.example.MiniProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import java.sql.SQLOutput;

@SpringBootApplication
public class MiniProjectApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MiniProjectApplication.class, args);
	}
}
