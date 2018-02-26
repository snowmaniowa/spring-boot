package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepository;

@RestController
@RequestMapping("/api/v1/")		//# class level request mapping annotation
public class ShipWreckController {

	@Autowired
	ShipWreckRepository shipWreckRepository;

	@RequestMapping(value = "shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> list(){		
		return shipWreckRepository.findAll();
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck){
		return shipWreckRepository.saveAndFlush(shipwreck);
	}

	//# {id} -- anytime there is a input parameter with curly braces, @PathVariable is a MUST
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		return shipWreckRepository.findOne(id);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck inputShipwreck) {
		Shipwreck existingShipWreck = shipWreckRepository.findOne(id);
		BeanUtils.copyProperties(inputShipwreck, existingShipWreck);		
		return shipWreckRepository.save(existingShipWreck);
	}

	@RequestMapping(name="shipwrecks/{id}", method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		Shipwreck existingShipWreck = shipWreckRepository.findOne(id);
		shipWreckRepository.delete(existingShipWreck);
		return existingShipWreck;
	}
		
}