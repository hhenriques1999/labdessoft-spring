package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	public String nome;
	public String email;
}
