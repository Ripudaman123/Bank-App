package com.app.bank.AppController;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;

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
@WebServlet("*.app")
public class BankAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SavingsAccount saving ;
	private CurrentAccount current ;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankAppController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private BankAccountService service = new BankAccountService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		//HttpSession session = request.getSession();
		System.out.println(action);
		

		switch (action) {
		case "/AddAll.app":
			service.allAccounts();
			response.sendRedirect("homePage.jsp");
			break;
		
		case "/AddAccount.app":
			String customerName = request.getParameter("txtName");
			System.out.println(customerName);
			//long contactNumber = Long.parseLong(request.getParameter("contactNumber"));
			String contactNumber=request.getParameter("contactNumber");
			String emailId = request.getParameter("emailId");
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			//LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dob"), formatter);
			String dateOfBirth=request.getParameter("dob");
			Customer customer;
			if (request.getParameter("accountType").equalsIgnoreCase("savings")) {
				double accountBalance = Double.parseDouble(request.getParameter("samount"));
				boolean sal=Boolean.parseBoolean(request.getParameter("ifsav"));
				customer = new Customer(customerName, contactNumber, emailId, dateOfBirth);
				saving = new SavingsAccount(customer, accountBalance, sal);
				service.addSavingsAccount(saving);
			}
			 else {
				double accountBalance1 = Double.parseDouble(request.getParameter("camount"));
				double odLimit = Double.parseDouble(request.getParameter("limit"));
				customer = new Customer(customerName, contactNumber, emailId, dateOfBirth);
				current = new CurrentAccount(customer, accountBalance1, odLimit);
				service.addCurrentAccount(current);
			}
			
			
			response.sendRedirect("homePage.jsp");
			break;
        
	    case "/viewAll.app":
	    	Collection<SavingsAccount> savingaccount= service.viewAllSavings();
	    	request.setAttribute("viewsa", savingaccount);
	    	Collection<CurrentAccount> currentaccount= service.viewAllCurrent();
	    	request.setAttribute("viewcu", currentaccount);
	    	RequestDispatcher dispatcher= request.getRequestDispatcher("viewAll.jsp");
	    	dispatcher.forward(request, response);
	    	break;
		case "/deposit.app":

			int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			double newbal1= service.depositMoney(accountNumber, amount);
			request.setAttribute("bal1", newbal1);
	        dispatcher= request.getRequestDispatcher("deposit.jsp");
	    	dispatcher.forward(request, response);
			break;

		case "/withdraw.app":
			accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			amount = Double.parseDouble(request.getParameter("amount"));
		    double newbal2=service.withdrawMoney(accountNumber, amount);
			request.setAttribute("bal2", newbal2);
	        dispatcher= request.getRequestDispatcher("withdraw.jsp");
	    	dispatcher.forward(request, response);
			break;

		case "/fundTransfer.app":
			accountNumber = Integer.parseInt(request.getParameter("accountNumber1"));
			int accountNumber2 = Integer.parseInt(request.getParameter("accountNumber2"));
			amount = Double.parseDouble(request.getParameter("amount"));
			newbal2=service.withdrawMoney(accountNumber, amount);
			newbal1=service.depositMoney(accountNumber2, amount);
			if(newbal2>0) {
			request.setAttribute("bal1", newbal1);
			request.setAttribute("bal2", newbal2);
			}
			
			dispatcher= request.getRequestDispatcher("fundtransfer.jsp");
	    	dispatcher.forward(request, response);

			/*service.transferMoney(accountNumber, accountNumber2, amount);
		    savingaccount= service.viewAllSavings();
		    currentaccount= service.viewAllCurrent();
		    SavingsAccount savingaccount1=null;
		    CurrentAccount currentaccount1=null;
		    SavingsAccount savingaccount2=null;
		    CurrentAccount currentaccount2=null;
		    Iterator<SavingsAccount> itr=savingaccount.iterator();
		    Iterator<CurrentAccount> itr1=currentaccount.iterator();
		    if(itr.hasNext()||itr1.hasNext())
		    {
		    	if(itr.next().getAccountNumber()==accountNumber||itr1.next().getAccountNumber()==accountNumber)
		    	{
		    		savingaccount1=itr.next();
		    		currentaccount1=itr1.next();
		    	}
		    	else if(itr.next().getAccountNumber()==accountNumber2||itr1.next().getAccountNumber()==accountNumber2)
		    	{
		    		savingaccount2=itr.next();
		    		currentaccount2=itr1.next();
		    	}
		    }
		    if(savingaccount1!=null)
		    {
	    	request.setAttribute("fund", savingaccount1);
		    }
		    else 
		    {
	    	request.setAttribute("fund", currentaccount1);
		    }
		    if(savingaccount2!=null)
		    {
		    	request.setAttribute("fund1", savingaccount2);
		    }
		    else
		    {
		    	request.setAttribute("fund1", currentaccount2);
		    }*/
		    break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
