package com.chc.offerapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chc.offerapp.dataaccess.OfferAppRepository;
import com.chc.offerapp.model.Offer;
import com.chc.offerapp.service.PointsCalculationService;

@RestController
@RequestMapping("/api/points")
public class OfferAppController {
	Logger logger= LoggerFactory.getLogger(OfferAppController.class);
	@Autowired
	private OfferAppRepository offerrepo;
	@Autowired
	private PointsCalculationService pointsService;


public OfferAppController(PointsCalculationService pointsService,OfferAppRepository offerrepo) {
    this.pointsService = pointsService;
    this.offerrepo=offerrepo;
}

@GetMapping("/calculate")
public ResponseEntity<Integer> calculatePoints(@RequestParam double transactionAmount) {
	Offer offv1=offerrepo.findOfferByName("Offer2p");
	if(!offv1.getName().equals("Offer2p"))
	{
		throw new IllegalStateException();
	}
	logger.debug("Offer name...."+offv1.getDesc());
    int points = pointsService.calculatePoints(transactionAmount,offv1);
	logger.debug("Offer points...."+points);
    return ResponseEntity.ok(points);
}

/*
@RequestMapping(method=RequestMethod.POST,value="/addoffer", consumes="application/json")
public HttpStatusCode addOffer(@RequestBody Offer offer) {
	if(!offer.getName().equals("Offer2p"))
	{
		throw new IllegalArgumentException();
	}
	offerrepo.save(offer);
	logger.debug("Offer details saved successfully...."+offer.getDesc());
    return ResponseEntity.ok().build().getStatusCode();
}*/

@PostMapping(value = "/addoffer", consumes = "application/json")
public ResponseEntity<Object> addOffer(@RequestBody Offer offer) {
    if (!offer.getName().equals("Offer2p")) {
        throw new IllegalArgumentException("The offer name is not valid.");
    }
    offerrepo.save(offer);
    logger.debug("Offer details saved successfully...." + offer.getDesc());
    // Return the saved offer in the response body along with the status code
    return new ResponseEntity<>(offer, HttpStatus.CREATED);
}

@ExceptionHandler(IllegalStateException.class)
public ResponseEntity<Object> handleException(IllegalStateException e) {
	
	return new ResponseEntity<Object>("Illegal State exp from controller",HttpStatus.BAD_REQUEST);
}

}
