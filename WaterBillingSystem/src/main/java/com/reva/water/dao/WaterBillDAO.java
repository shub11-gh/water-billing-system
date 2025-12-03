package com.reva.water.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reva.water.bean.WaterBillBean;
import com.reva.water.util.DBUtil;

public class WaterBillDAO {
	
	public String createWaterBill(WaterBillBean bean) throws SQLException 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String msg=null;
		String query = "insert into waterbill_tb (ConsumerNo,Month,Year,StartReading,CurrentReading,Consumption,ConnType,Fixed,VarCharges,TotalCharges) values (?,?,?,?,?,?,?,?,?,?);";
		try 
		{
			conn = DBUtil.getDBConnection();
			if (conn == null) {
				msg="Fail";
                return "Fail";
            }
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,bean.getConsumerNumber());
				pstmt.setString(2,bean.getBillMonth());
				pstmt.setString(3,bean.getYear());
				pstmt.setInt(4,bean.getStartReading());
				pstmt.setInt(5,bean.getCurrentReading());
				pstmt.setInt(6,bean.getTotalConsumption());
				pstmt.setString(7,bean.getConnectionType());
				pstmt.setDouble(8,bean.getFixedCharges());;
				pstmt.setDouble(9,bean.getVariableCharges());
				pstmt.setDouble(10,bean.getTotalCharges());
				
				int rows = pstmt.executeUpdate();
				
				if(rows>0) 
				{
					System.out.println(rows+" rows affected.");
					return "Success";
				}
				else 
					return "Fail";	
	}
	
	public WaterBillBean fetchWaterBill(int consumerNumber,String billMonth,String year) throws SQLException 
	{
		WaterBillBean bean = new WaterBillBean();
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String query = "select * from waterbill_tb where ConsumerNo=? and Month=? and Year=?";
		
		try {
			conn = DBUtil.getDBConnection();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,consumerNumber);
			pstmt.setString(2,billMonth);
			pstmt.setString(3,year);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				bean.setConsumerNumber(rs.getInt("ConsumerNo"));
				bean.setBillMonth(rs.getString("Month"));
				bean.setYear(rs.getString("Year"));
				bean.setStartReading(rs.getInt("StartReading"));
				bean.setCurrentReading(rs.getInt("CurrentReading"));
				bean.setTotalConsumption(rs.getInt("Consumption"));
				bean.setConnectionType(rs.getString("ConnType"));
				bean.setFixedCharges(rs.getFloat("Fixed"));
				bean.setVariableCharges(rs.getFloat("VarCharges"));
				bean.setTotalCharges(rs.getFloat("TotalCharges"));
				return bean;
			}
			else 
			{
				return null;
			}
			
}

	
	public boolean waterBillExists(int consumerNumber,String billMonth,String year)
	{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "select * from waterbill_tb where ConsumerNo=? and Month=? and Year=?;";
		try {
			conn = DBUtil.getDBConnection();
			if(conn == null)
				return false;
			else {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,consumerNumber);
				pstmt.setString(2,billMonth);
				pstmt.setString(3,year);
				
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1) > 0;
				}
				conn.close();
				pstmt.close();
				rs.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
