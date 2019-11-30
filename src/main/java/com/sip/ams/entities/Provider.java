package com.sip.ams.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Name is mondotory")
	@Column(name = "name")
	private String name;
	@NotBlank(message = "Email is Mondotory")
	@Column(name = "email")
	private String email;
	@NotBlank(message = "adress is mondotory")
	@Column(name = "adress")
	private String adress;
	
	@OneToMany(mappedBy = "provider",fetch = FetchType.LAZY)
	private List<Article>articles;

	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provider(String name,String email,String adress) {
		super();

		this.name = name;
		this.email = email;
		this.adress = adress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
