package com.app.bank.AppController;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.bank.pojo.CurrentAccount;
import com.app.bank.pojo.Customer;
import com.app.bank.pojo.SavingsAccount;
import com.app.bank.service.BankAccountService;


/**
 * Servlet implementation class BankAppController
 */
@WebServlet("/BankAppController")
public class BankAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankAppController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private BankAccountService service = new BankAccountService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		String action = request.getServletPath();
		HttpSession session = request.getSession();
		System.out.println(action);
		
		switch (action) {
		case "/addSaving.app":
			String customerName = request.getParameter("txtName");
			long contactNumber = Long.parseLong(request.getParameter("contactNo"));
			String emailId = request.getParameter("emailId");
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/mm/yyyy");
			LocalDate dateOfBirth=LocalDate.parse(request.getParameter("dob"),formatter);
			Double accountBalance=Double.parseDouble(request.getParameter("balance"));
			Customer customer=new Customer(customerName, contactNumber, emailId, dateOfBirth);
			SavingsAccount saving=new SavingsAccount(customer,accountBalance,true);
			service.addSavingsAccount(saving);
			response.sendRedirect("homePage.app");
			break;
		case "/currentAccount.app":
		    customerName = request.getParameter("txtName");
			contactNumber = Long.parseLong(request.getParameter("contactNo"));
			emailId = request.getParameter("emailId");
			formatter=DateTimeFormatter.ofPattern("dd/mm/yyyy");
			dateOfBirth=LocalDate.parse(request.getParameter("dob"),formatter);
		    accountBalance=Double.parseDouble(request.getParameter("balance"));
			Double odLimit=Double.parseDouble(request.getParameter("limit"));
			customer=new Customer(customerName, contactNumber, emailId, dateOfBirth);
			CurrentAccount current=new CurrentAccount(customer,accountBalance,odLimit);
			service.addCurrentAccount(current);
			response.sendRedirect("homePage.app");
			break;
		case "/homePage.app":
			item = service.viewAllItems();
			request.setAttribute("item", item);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			break;
		case "/delete.app":

			itemId = Integer.parseInt(request.getParameter("itemId"));
			item1 = null;
			item = service.cartItems();
			for (Item items : item) {
				if (items.getId() == itemId) {
					item1 = items;
				}
			}
			service.delete(item1);
			response.sendRedirect("cart.app");
		default:
			break;
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
