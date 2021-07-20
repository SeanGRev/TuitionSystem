package com.revature.app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import io.javalin.Javalin;
import com.revature.dao.*;
import com.revature.services.*;
import com.revature.controllers.*;

public class App {
	
	public static void main(String[] args) {
		disableAccessWarnings();
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
		app.get("/employees/:id/sents", rc.getEmployeeSentRequests);
		app.get("/employees/:id/reviews", rc.getEmplyeeReviewRequests);
		app.post("/employees", ec.addEmployee);
		
		app.get("/requests", rc.getAllRequests);
		app.get("/requests/:id", rc.getRequestById);
		app.post("/requests", rc.addRequest);
		app.get("/reimbursements", rec.getAllReimbursements);
		app.get("/reimbursements/:id", rec.getReimbursementById);
		app.get("/reimbursements/:id/presentations", rec.getReimbursementPresentations);
		app.get("/reimbursements/:id/attachments", rec.getReimbursementAttachments);
		app.post("/reimbursements", rec.addReimbursement);
		
		app.get("/events", evc.getAllEvents);
		app.get("/events/:id", evc.getEventById);
		app.post("/events", evc.addEvent);
	}
	
    @SuppressWarnings("unchecked")
    public static void disableAccessWarnings() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception ignored) {
        }
    }
	
}
