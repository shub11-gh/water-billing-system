package com.reva.water.service;
import java.sql.SQLException;

import com.reva.water.bean.WaterBillBean;
import com.reva.water.dao.WaterBillDAO;
import com.reva.water.util.InvalidInputException;

public class Administrator {
	
	public String addWaterBill(WaterBillBean bean) throws InvalidInputException, SQLException
	{
		WaterBillDAO dao = new WaterBillDAO();
		double charges = 0.0;
		
		if((bean == null) || (bean.getConsumerNumber() == 0) || (bean.getBillMonth() == null) || (bean.getYear() == null) || (bean.getStartReading() == 0) || (bean.getCurrentReading() == 0) || (bean.getConnectionType() == null)) {
			throw new InvalidInputException("Invalid Input");
		}
		
		if((bean.getConnectionType().trim().isEmpty())) {
			throw new InvalidInputException("Invalid Input");
		}
			
		
		String connType = bean.getConnectionType().trim().toLowerCase();
        if (!"domestic".equals(connType) && !"industrial".equals(connType)) {
            throw new InvalidInputException("Invalid Input");
        }
        
        
		if(bean.getCurrentReading() < bean.getStartReading()) {
			throw new InvalidInputException("Invalid Input");
		}
		
		if(dao.waterBillExists(bean.getConsumerNumber(), bean.getBillMonth(), bean.getYear())) 
		{
			return "Already exists";
		}
		
		
		else 
		{
	        connType = bean.getConnectionType().trim().toLowerCase();
			int totalConsumption = bean.getCurrentReading()-bean.getStartReading();
			bean.setTotalConsumption(totalConsumption);
			
			if(connType.equals("domestic")) {
				
				bean.setFixedCharges(20);
				
				if(bean.getTotalConsumption() <= 5000) {
				   bean.setVariableCharges(bean.getTotalConsumption()*0.004);
				   charges = bean.getFixedCharges()+bean.getVariableCharges();
				   bean.setTotalCharges(charges);
				}
				
				if(bean.getTotalConsumption() >= 5001 && bean.getTotalConsumption() <= 10000) {
					bean.setVariableCharges(((bean.getTotalConsumption()-5000)*0.010) + (5000 * 0.004));
					charges = bean.getFixedCharges()+ bean.getVariableCharges();
					bean.setTotalCharges(charges);
				}
				
				if(bean.getTotalConsumption() >= 10001 && bean.getTotalConsumption() <= 15000) {
					bean.setVariableCharges(((bean.getTotalConsumption()-10000)*0.015) + (5000 * 0.004) + (5000 * 0.010));
					charges = bean.getFixedCharges()+ bean.getVariableCharges();
					bean.setTotalCharges(charges);
				}
				
				if(bean.getTotalConsumption() > 15000) {
					bean.setVariableCharges(((bean.getTotalConsumption()-15000)*0.025) + (5000 * 0.004) + (5000 * 0.010) + (5000 * 0.015));
					charges = bean.getFixedCharges()+ bean.getVariableCharges();
					bean.setTotalCharges(charges);
				}
			}
			
			
			else if(connType.equals("industrial"))
			{
				
				if(bean.getTotalConsumption() <= 10000) {
					bean.setFixedCharges(150);
				}
				else {
					bean.setFixedCharges(200);
				}
				
				
				if(bean.getTotalConsumption() <= 5000) {
				   bean.setVariableCharges(bean.getTotalConsumption()*0.015);
				   charges = bean.getFixedCharges()+bean.getVariableCharges();
				   bean.setTotalCharges(charges);
				}
				
				if(bean.getTotalConsumption() >= 5001 && bean.getTotalConsumption() <= 10000) {
					bean.setVariableCharges(((bean.getTotalConsumption()-5000)*0.020) + (5000 * 0.015));
					charges = bean.getFixedCharges()+ bean.getVariableCharges();
					bean.setTotalCharges(charges);
				}
				
				if(bean.getTotalConsumption() >= 10001 && bean.getTotalConsumption() <= 15000) {
					bean.setVariableCharges(((bean.getTotalConsumption()-10000)*0.025) + (5000 * 0.020) + (5000 * 0.015));
					charges = bean.getFixedCharges()+ bean.getVariableCharges();
					bean.setTotalCharges(charges);
				}
				
				if(bean.getTotalConsumption() > 15000) {
					bean.setVariableCharges(((bean.getTotalConsumption()-15000)*0.035) + (5000 * 0.025) + (5000 * 0.020) + (5000 * 0.015));
					charges = bean.getFixedCharges()+ bean.getVariableCharges();
					bean.setTotalCharges(charges);
				}
			}	
		}
		
		return dao.createWaterBill(bean);
	}

	public WaterBillBean viewWaterBill(int consumerNumber,String billMonth,String year) {
		
		WaterBillDAO dao = new WaterBillDAO();
		try {
			WaterBillBean bean = dao.fetchWaterBill(consumerNumber, billMonth, year);
			return bean;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
