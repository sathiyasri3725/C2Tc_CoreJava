package com.tnsif.placement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlacementService
{
   @Autowired
   private PlacementRepositery repo;
   public List<Placement> listAll()
   {
	   return repo.findAll();
   }
   public Placement get(Long id)
   {
	   return repo.findById(id).get();
   }
   public Placement save(Placement placement)
   {
	    return repo.save(placement);
   }
   public void delete(Long id) 
   {
       repo.deleteById(id);
   }
}
