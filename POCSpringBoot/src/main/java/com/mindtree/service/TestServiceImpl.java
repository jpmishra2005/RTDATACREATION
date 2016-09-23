package com.mindtree.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mindtree.dao.EntityDao;
import com.mindtree.dao.EntityDao1;
import com.mindtree.entity.*;

@Service
@EnableTransactionManagement
@Transactional
public class TestServiceImpl implements TestService {

	@Autowired
	EntityDao dao;
	@Autowired
	EntityDao1 dao1;


	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Async
	public void readData(){
		//	List<PollutantData> pdata=dao1.findAll();	
		//		System.out.println("**********************"+pdata.size());

		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(PollutantData.class);


		List<PollutantData> pollDataList=cr.list();
		System.out.println("**********************"+pollDataList.size());

		for(PollutantData data:pollDataList){
			System.out.println("------------------"+data.toString());
		}
		
		
		
		
		
	}
	@Override
	@Async
	public String asyncMethod() {

		try {
			System.out.println(Thread.currentThread().getName());

			for (int i = 0; i < 1; i++) {
				IndustryStationDeviceMapping industryDevMap = new IndustryStationDeviceMapping();
				industryDevMap.setIndustryID(100+i);
				industryDevMap.setStationID(500+i);
				industryDevMap.setDeviceID(1000+i);
				
				List<PollutantData> pollutantDataList=new ArrayList<PollutantData>();
				
				for(int j=0;j<1;j++){
					PollutantData pollutantData=new PollutantData();
					pollutantData.setIndustryDeviceMap(industryDevMap);
					ParamData param=new ParamData();
					param.setFlag((char) (new Random().nextInt(26) + 'a'));
					param.setParameter("ParamterCheck"+j);
					param.setTimeStamp(new Date());
					param.setUnit("KCL"+j);
					param.setValue(new Random().nextInt());
					pollutantData.setParamData(param);
					pollutantDataList.add(pollutantData);
				}
				
				for(int j=0;j<1;j++){
					PollutantData pollutantData=new PollutantData();
					pollutantData.setIndustryDeviceMap(industryDevMap);
					DiagnosticData diagData=new DiagnosticData();
					diagData.setDiagParam("diagParam"+j);
					diagData.setTimeStamp(new Date());
					diagData.setValue("diagValue"+j);
					pollutantData.setDiagData(diagData);
					pollutantDataList.add(pollutantData);
				}
				
				for(int j=5000;j<5001;j++){
					PollutantData pollutantData=new PollutantData();
					pollutantData.setIndustryDeviceMap(industryDevMap);
					ParamData param=new ParamData();
					DiagnosticData diagData=new DiagnosticData();
				
					
					param.setFlag((char) (new Random().nextInt(26) + 'a'));
					param.setParameter("ParamterCheck"+j);
					param.setTimeStamp(new Date());
					param.setUnit("KCL");
					param.setValue(new Random().nextInt());
					pollutantData.setParamData(param);
					
					
					diagData.setDiagParam("diagParam"+j);
					diagData.setTimeStamp(new Date());
					diagData.setValue("diagValue"+j);
					pollutantData.setDiagData(diagData);
					
					pollutantDataList.add(pollutantData);
				}
			
				
				industryDevMap.setPollutantData(pollutantDataList);
				dao.save(industryDevMap);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Future<Boolean> asyncFutureMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
