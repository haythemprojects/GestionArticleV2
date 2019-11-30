package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.repository.ArticleRepository;

@Controller
@RequestMapping("/article/")
public class ArticleController {

	ArticleRepository articleRepository;

	@Autowired
	public ArticleController(ArticleRepository repository) {
		this.articleRepository = repository;
	}

	@GetMapping("list")
	public String listArticle(Model model) {
		model.addAttribute("articles", articleRepository.findAll());
		return "article/listArticles";

	}

}
