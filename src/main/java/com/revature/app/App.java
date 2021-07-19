package com.revature.app;


import io.javalin.Javalin;
import com.revature.dao.*;
import com.revature.services.*;
import com.revature.controllers.*;

public class App {
	
	public static void main(String[] args) {
		
		//Establish our Javalin Object
		Javalin app = Javalin.create();
		
		//Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);
		
		//Run Javalin
		app.start(7000);
		
	}

	private static void establishRoutes(Javalin app) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		EmployeeService es = new EmployeeServiceImpl(edao);
		EmployeeController ec = new EmployeeController(es);
		RequestDAO rdao = new RequestDAOImpl();
		RequestService rs = new RequestServiceImpl(rdao);
		RequestController rc = new RequestController(rs);
		ReimbursementDAO redao = new ReimbursementDAOImpl();
		ReimbursementService res = new ReimbursementServiceImpl(redao);
		ReimbursementController rec = new ReimbursementController(res);
		EventDAO evdao = new EventDAOImpl();
		EventService evs = new EventServiceImpl(evdao);
		EventController evc = new EventController(evs);
		
		
		app.get("/", (ctx) -> ctx.result("Tuition System Home Page"));
		
		app.get("/employees", ec.getAllEmployees);
		app.get("/employees/:id", ec.getEmployeeById);
		app.get("employees/:id/sents", rc.getEmployeeRequest);
		app.patch("employees/:id/reviews", rc.getEmplyeeReviewRequests);
		
		app.get("/requests", rc.getAllRequests);
		app.get("/requests/:id", rc.getRequestById);
		
		app.get("/reimbursements", rec.getAllReimbursements);
		app.get("/reimbursements/:id", rec.getReimbursementById);
		
		app.get("/events", evc.getAllEvents);
		app.get("/events/:id", evc.getEventById);
	}
	
}
