package com.abcshopapp.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.abcshopapp.util.DbUtil;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter customer id");
		int customerId=sc.nextInt();
		
		System.out.println("Enter product id");
		int productId=sc.nextInt();
		
		System.out.println("Enter quantity");
		int qty=sc.nextInt();
		
		
		
		sc.close();
		int Id=0;
		String productName =null;
		double productPrice = 0;
		Date mfd = null;
		String category=null;
		String sql="select * from product_tbl where product_id= ? ";
		
		try(Connection con =DbUtil.getDBConnection();
				PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1, productId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 Id=rs.getInt(1);
				 productName = rs.getString(2);
				 productPrice = rs.getDouble(3);
				 mfd = rs.getDate(4);
				 category=rs.getString(5);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		double totalPrice=productPrice *qty;
		double orderAmount=totalPrice + (totalPrice*0.05);
		
		System.out.println("Order Amount : "+orderAmount);
		
		
		
		
		
		

	}

}
