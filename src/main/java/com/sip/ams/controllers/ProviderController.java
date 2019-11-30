package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.Provider;
import com.sip.ams.repository.ProviderRepository;

@Controller
@RequestMapping("/provider/")
public class ProviderController {
	
	private final ProviderRepository providerRepository;
	
	@Autowired
	public ProviderController(ProviderRepository repository) {
		// TODO Auto-generated constructor stub
		
		this.providerRepository=repository;
	}
	
	@GetMapping("list")
	public String listProvider(Model model)
	{
	model.addAttribute("providers",providerRepository.findAll());
	return "provider/listProviders";
	}
	@GetMapping("add")
	public String showProvider(Model model)
	{
		Provider provider=new Provider();
		model.addAttribute("provider", provider);
		return "provider/addProvider";
	}
	@PostMapping("add")
	public String addProvider(Provider provider)
	{
		providerRepository.save(provider);
		return "redirect:list";
	}
	@GetMapping("delete/{id}")
	public String deleteProvider(@PathVariable("id") long id,Model model)
	{
		providerRepository.deleteById(id);
		model.addAttribute("providers", providerRepository.findAll());
		return "provider/listProviders";
	}
	@GetMapping("edit/{id}")
	public String showProviderupdate(@PathVariable("id")long id,Model model)
	{
		Provider provider=providerRepository.findById(id).
				orElseThrow(()->new IllegalArgumentException("Invalid Id"+id));
		model.addAttribute("provider",provider);
		return "provider/updateProvider";
	}
	@PostMapping("update/{id}")
	public String updateProvider(@PathVariable("id") long id, @Valid Provider provider, BindingResult result,
	        Model model) {
	if(result.hasErrors())
	{
		provider.setId(id);
		return "provider/updateProvider";
	}
	providerRepository.save(provider);
	model.addAttribute("providers", providerRepository.findAll());
	return"provider/listProviders";
	    }
}
