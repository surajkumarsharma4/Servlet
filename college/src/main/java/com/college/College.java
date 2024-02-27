package com.college;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/save")
public class College extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int id= Integer.parseInt(req.getParameter("id"));
	String name= req.getParameter("name");
	String email= req.getParameter("email");
	String location= req.getParameter("location");
	String vc_name= req.getParameter("vc_name") ;
		
	try {
		Connection connection=new ConnectDatabase().getConnection();
		PreparedStatement ps=connection.prepareStatement("insert into college values (?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, location);
		ps.setString(5, vc_name);
		int executeUpdate=ps.executeUpdate();
		PrintWriter writer=resp.getWriter();
		if(executeUpdate>0) {
			writer.write("<html><body>");
			writer.write("<h1>user updated<h1>");
		}
		else {
			writer.write("<html><body>");
			writer.write("<h1>user not updated<h1>");
		}
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
