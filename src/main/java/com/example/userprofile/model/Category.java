package com.example.userprofile.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryName;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Product> product;

	public Category(int id, String category, List<Product> product) {
		this.id = id;
		this.categoryName = category;
		this.product = product;
	}
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String category) {
		this.categoryName = category;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [categoryname=" + categoryName + ", product=" + product + "]";
	}
	
	
	
	
}
