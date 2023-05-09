package com.souleima.biscuits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.souleima.biscuits.entities.Marque;
import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.repos.BiscuitRepository;


@SpringBootTest
class BiscuitsApplicationTests {

	@Autowired
	private BiscuitRepository biscuitRepository;
	
	@Test
	public void testCreateBiscuit() {
	Biscuit prod = new Biscuit("chocotom",1500.00,new Date(),"chocolat");
	biscuitRepository.save(prod);
	}
	
	@Test
	public void testFindBiscuit()
	{
	Biscuit p = biscuitRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateBiscuit()
	{
	Biscuit p = biscuitRepository.findById(1L).get();
	p.setPrixBiscuit(2000.0);
	biscuitRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteBiscuit()
	{
		biscuitRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllBiscuits()
	{
		List<Biscuit> prods = biscuitRepository.findAll();
		
		for (Biscuit p:prods)
			 System.out.println(p);
		
	}
	
	
	@Test
	public void testFindBiscuitByNom()
	{
	List<Biscuit> prods = biscuitRepository.findByNomBiscuit("gaufrette");
	
	for (Biscuit p:prods)
		 System.out.println(p);
	
	}
	
	@Test
	public void testFindBiscuitByNomContains()
	{
	List<Biscuit> prods = biscuitRepository.findByNomBiscuitContains("j");
	
	for (Biscuit p:prods)
		 System.out.println(p);
	
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Biscuit> prods = biscuitRepository.findByNomPrix("chocotom", 1500.00);
		for (Biscuit p : prods)
			{
				System.out.println(p);
			}
	}
	
	
	@Test
	public void testfindByMarque()
	{
	Marque ma = new Marque();
	ma.setIdMarque(1L);
	
	List<Biscuit> prods = biscuitRepository.findByMarque(ma);
	for (Biscuit p : prods)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void findByMarqueIdMarque()
	{
	List<Biscuit> prods = biscuitRepository.findByMarqueIdMarque(1L);
	for (Biscuit p : prods)
	{
		System.out.println(p);
	}
	}
	
	
	@Test
	public void testfindByOrderByNomBiscuitAsc()
	{
	List<Biscuit> prods =  biscuitRepository.findByOrderByNomBiscuitAsc();
	for (Biscuit p : prods)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testTrierBiscuitNomsPrix()
	{
	List<Biscuit> prods = biscuitRepository.trierBiscuitsNomsPrix();
	for (Biscuit p : prods)
	{
	System.out.println(p);
	}
	}
	
	
}