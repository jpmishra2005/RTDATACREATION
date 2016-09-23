package com.mindtree.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.entity.IndustryStationDeviceMapping;
import com.mindtree.entity.PollutantData;


@Transactional
public interface EntityDao1 extends CrudRepository<PollutantData, Long>{
	
	List<PollutantData> findAll();

}
