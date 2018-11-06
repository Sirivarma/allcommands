package com.cg.airways.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import com.cg.airways.bean.TourPlanner;
import com.cg.airways.repository.TourPlannerRepository;
@Service
public class TourPlannerServiceImpl implements TourPlannerService {
@Autowired
TourPlannerRepository tourPlannerRepository;
	@Override
	public TourPlanner add(TourPlanner tourPlanner) {
		TourPlanner tour=tourPlannerRepository.save(tourPlanner);
		return tour;
	}
	



}
