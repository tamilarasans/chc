package com.chc.offerapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chc.offerapp.controller.OfferAppController;
import com.chc.offerapp.model.Offer;

@Service
public class PointsCalculationService {
	Logger logger= LoggerFactory.getLogger(OfferAppController.class);
    public int calculatePoints(double transactionAmount , Offer offv1) {
        if (transactionAmount > offv1.getMaxVal()) {
        	logger.debug("inside points calculation service 100");
            return (int) ((offv1.getOffPtMax() * (transactionAmount - offv1.getMaxVal()))+ (offv1.getOffPtMin()*(offv1.getMaxVal() - offv1.getMinVal())));
        } else if (transactionAmount > offv1.getMinVal()) {
            return (int) (transactionAmount - offv1.getMinVal());
        }
        return 0;
    }
}