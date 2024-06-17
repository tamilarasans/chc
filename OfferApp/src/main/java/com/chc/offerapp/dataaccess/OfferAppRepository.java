package com.chc.offerapp.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chc.offerapp.model.Offer;

@Repository
public interface OfferAppRepository extends JpaRepository <Offer,Long> {
	
Offer	findOfferByName(String name);
	


}
