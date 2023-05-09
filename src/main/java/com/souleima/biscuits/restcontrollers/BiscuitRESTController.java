package com.souleima.biscuits.restcontrollers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.service.BiscuitService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class BiscuitRESTController {
@Autowired
BiscuitService biscuitService;
@RequestMapping(method = RequestMethod.GET)
public List<Biscuit> getAllBiscuits() {
return biscuitService.getAllBiscuits();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Biscuit getBiscuitById(@PathVariable("id") Long id) {
	return biscuitService.getBiscuit(id);

}
@RequestMapping(method = RequestMethod.POST)
public Biscuit createBiscuit(@RequestBody Biscuit biscuit) {
		return biscuitService.saveBiscuit(biscuit);
}
@RequestMapping(method = RequestMethod.PUT)
public Biscuit updateBiscuit(@RequestBody Biscuit biscuit) {
return biscuitService.updateBiscuit(biscuit);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteBiscuit(@PathVariable("id") Long id)
{
		biscuitService.deleteBiscuitById(id);
}

@RequestMapping(value="/prodscat/{idMarque}",method = RequestMethod.GET)
public List<Biscuit> getBiscuitsByCatId(@PathVariable("idMarque") Long idMarque) {
	return biscuitService.findByMarqueIdMarque(idMarque);
}
}