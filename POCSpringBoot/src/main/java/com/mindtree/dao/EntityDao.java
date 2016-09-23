package com.mindtree.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.entity.IndustryStationDeviceMapping;


@Transactional
public interface EntityDao extends CrudRepository<IndustryStationDeviceMapping, Long>{
	
	List<IndustryStationDeviceMapping> findAll();

}
