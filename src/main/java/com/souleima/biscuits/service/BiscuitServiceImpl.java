package com.souleima.biscuits.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.souleima.biscuits.entities.Marque;
import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.repos.BiscuitRepository;
import com.souleima.biscuits.repos.MarqueRepository;


@Service
public class BiscuitServiceImpl implements BiscuitService{

	@Autowired
	BiscuitRepository biscuitRepository;
	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
	public Biscuit saveBiscuit(Biscuit p) {
		return biscuitRepository.save(p);
	}

	@Override
	public Biscuit updateBiscuit(Biscuit p) {
		return biscuitRepository.save(p);
	}

	@Override
	public void deleteBiscuit(Biscuit p) {
		biscuitRepository.delete(p);
		
	}

	@Override
	public void deleteBiscuitById(Long id) {
		biscuitRepository.deleteById(id);
		
	}

	@Override
	public Biscuit getBiscuit(Long id) {
		return biscuitRepository.findById(id).get();
	}

	@Override
	public List<Biscuit> getAllBiscuits() {
		
		return biscuitRepository.findAll();
	}
	@Override
	public Page<Biscuit> getAllBiscuitsParPage(int page, int size) {
	return biscuitRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Biscuit> findByNomBiscuit(String nom) {
		
		return biscuitRepository.findByNomBiscuit(nom);
	}

	@Override
	public List<Biscuit> findByNomBiscuitContains(String nom) {
		
		return biscuitRepository.findByNomBiscuitContains(nom);
	}

	@Override
	public List<Biscuit> findByNomPrix(String nom, Double prix) {
		return biscuitRepository.findByNomPrix(nom, prix);

	}

	@Override
	public List<Biscuit> findByMarque(Marque marque) {
		
		return biscuitRepository.findByMarque(marque);
	}

	@Override
	public List<Biscuit> findByMarqueIdMarque(Long id) {
	
		return biscuitRepository.findByMarqueIdMarque(id);
	}

	@Override
	public List<Biscuit> findByOrderByNomBiscuitAsc() {
		
		return biscuitRepository.findByOrderByNomBiscuitAsc();
	}

	@Override
	public List<Biscuit> trierBiscuitsNomsPrix() {
	
		return biscuitRepository.trierBiscuitsNomsPrix();
	}
	@Override
	public List<Marque> getAllMarques() {
		
		return marqueRepository.findAll();
	}
	
	

}