package com.tnsif.placement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacementController
{
    @Autowired 
	private PlacementService service;
    
    
    @GetMapping("/placement")
    public List<Placement> list()
    {
    	return service.listAll();
    }
    @GetMapping("/placement/{id}")
    public ResponseEntity<Placement> get(@PathVariable Long id)
    {
    	try
    	{
    		Placement placement=service.get(id);
    		return new ResponseEntity<Placement>(placement,HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
    	}
    }
    @PostMapping("/placement")
    public ResponseEntity<Placement> add(@RequestBody Placement placement) {
        try {
            Placement createdPlacement = service.save(placement);
            return new ResponseEntity<>(createdPlacement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/placement/{id}")
    public ResponseEntity<Placement> update(@RequestBody Placement placement, @PathVariable Long id) {
        Placement existingPlacement = service.get(id);
        if (existingPlacement == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingPlacement.setCompanyname(placement.getCompanyname());
        existingPlacement.setJob_Title(placement.getJob_Title());
        existingPlacement.setPlacement_Date(placement.getPlacement_Date());
        existingPlacement.setStudent_Id(placement.getStudent_Id());
        Placement updatedPlacement = service.save(existingPlacement);
        return new ResponseEntity<>(updatedPlacement, HttpStatus.OK);
    }
    
	@DeleteMapping("/placement/{id}")
    public void delete(@PathVariable Long id)
    {
    	service.delete(id);
    }
    
}
