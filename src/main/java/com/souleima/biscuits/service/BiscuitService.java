package com.souleima.biscuits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.souleima.biscuits.entities.Marque;
import com.souleima.biscuits.entities.Biscuit;

public interface BiscuitService {
	Biscuit saveBiscuit(Biscuit p);
	Biscuit updateBiscuit(Biscuit p);
	void deleteBiscuit(Biscuit p);
	void deleteBiscuitById(Long id);
	Biscuit getBiscuit(Long id);
	List<Marque> getAllMarques();
	Page<Biscuit> getAllBiscuitsParPage(int page, int size);
	List<Biscuit> getAllBiscuits();
	List<Biscuit> findByNomBiscuit(String nom);
	List<Biscuit> findByNomBiscuitContains(String nom);
	List<Biscuit> findByNomPrix (String nom, Double prix);
	List<Biscuit> findByMarque (Marque marque);
	List<Biscuit> findByMarqueIdMarque(Long id);
	List<Biscuit> findByOrderByNomBiscuitAsc();
	List<Biscuit> trierBiscuitsNomsPrix();
}