package com.khoinguyen.authenticator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.khoinguyen.authenticator.model.Account;

public class AuthenticatorService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = UserServiceFactory.getUserService().getCurrentUser().getEmail();
		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("get")) {
			List<Account> accounts = Account.getAccounts(email);
			System.out.println(accounts.size());
			String respons = new Gson().toJson(accounts);
			resp.getWriter().print(respons);
		}
		
		
		
	}
	
}
