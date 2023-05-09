package com.souleima.biscuits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.entities.Marque;
import com.souleima.biscuits.service.BiscuitService;

@Controller
public class BiscuitController {
	   @RequestMapping("/")
	    public String index() {
	        return "index";
	    }
	
	@Autowired
	BiscuitService biscuitService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Marque> marques = biscuitService.getAllMarques();
		System.out.println(marques);
		Biscuit prod = new Biscuit();
		Marque cat = new Marque();
		cat = marques.get(0); 
		prod.setMarque(cat); 
	modelMap.addAttribute("biscuit", new Biscuit());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("marques", marques);
	return "formBiscuit";
	}
	@RequestMapping("/saveBiscuit")
	public String saveBiscuit(@Valid Biscuit biscuit,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formBiscuit";
	 
	biscuitService.saveBiscuit(biscuit);
	return "formBiscuit";
	}


	@RequestMapping("/ListeBiscuits")
	public String listeBiscuits(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)
	{
		Page<Biscuit> prods = biscuitService.getAllBiscuitsParPage(page, size);
		modelMap.addAttribute("biscuits", prods);		
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
		modelMap.addAttribute("currentPage", page);	
		return "listebiscuits";	
	}
	@RequestMapping("/supprimerBiscuit")
	public String supprimerBiscuit(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)
	{
		biscuitService.deleteBiscuitById(id);
		Page<Biscuit> prods = biscuitService.getAllBiscuitsParPage(page, size);
		modelMap.addAttribute("biscuits", prods);		
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
		modelMap.addAttribute("currentPage", page);	
		modelMap.addAttribute("size", size);	
		return "listeBiscuits";	
	}
	
	@RequestMapping("/modifierBiscuit")
	public String editerBiscuit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		List<Marque> marques = biscuitService.getAllMarques();
		System.out.println(marques);
	Biscuit p= biscuitService.getBiscuit(id);
	modelMap.addAttribute("biscuit", p);
	modelMap.addAttribute("mode", "edit");
	return "formBiscuit";
	}
	
	@RequestMapping("/updateBiscuit")
	public String updateBiscuit(@ModelAttribute("biscuit") Biscuit biscuit,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateSortir = dateformat.parse(String.valueOf(date));
	biscuit.setDateSortir(dateSortir);
	biscuitService.updateBiscuit(biscuit);
	List<Biscuit> prods = biscuitService.getAllBiscuits();
	modelMap.addAttribute("biscuits", prods);
	return "listeBiscuits";
	}
	


}