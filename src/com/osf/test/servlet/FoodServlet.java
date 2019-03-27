package com.osf.test.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.osf.test.service.FoodService;
import com.osf.test.service.impl.FoodServiceImpl;
import com.osf.test.utils.URICommand;
import com.osf.test.vo.Food;

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FoodService fs = new FoodServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = URICommand.getCommand(request);
		Food f = new Food();
		//localhost/food/?foodNum=3&foodPrice=2000
		try {
			BeanUtils.populate(f, request.getParameterMap());
			System.out.println(f);		
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (InvocationTargetException e) {			
			e.printStackTrace();
		}
		if("food".equals(cmd)) {
			System.out.println("푸드 리스트 검색!");
			System.out.println(fs.selectFood(f.getFoodNum()));
		}else if("foods".equals(cmd)) {
			System.out.println("푸드 단일 검색 !");
			System.out.println(fs.selectFoodList());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		Food f = new Food();
		try {
			BeanUtils.populate(f, request.getParameterMap());
			System.out.println(f);		
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (InvocationTargetException e) {			
			e.printStackTrace();
		}
		System.out.println("cmd : " + cmd);
		System.out.println(f);
		if("insert".equals(cmd)) {
			System.out.println("insert : "+ fs.insertFood(f));
		}else if("update".equals(cmd)) {
			System.out.println("update : " + fs.updateFood(f));
		}else if("delete".equals(cmd)) {
			System.out.println("delete : " + fs.deleteFood(f.getFoodNum()));
		}
	}

}
