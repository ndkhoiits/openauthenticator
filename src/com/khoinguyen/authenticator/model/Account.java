package com.khoinguyen.authenticator.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.khoinguyen.authenticator.dao.PMF;

@PersistenceCapable
public class Account {
	@Persistent
	private String email;
	
	@Persistent
	private String secret;
	
	@Persistent
	private String info;
	
	private static final PersistenceManager pmf = PMF.get().getPersistenceManager();
	
	public Account(String email, String secret, String info) {
		this.email = email;
		this.secret = secret;
		this.info = info;
	}
	
	public void save() {
		pmf.makePersistent(this);
	}
	
	public static List<Account> getAccounts(String email) {
		Query query = pmf.newQuery(Account.class);
		List<Account> listAcc = (List<Account>) query.execute();
		query.closeAll();
		List<Account> result = new ArrayList<Account>();
		for (Account a : listAcc) {
			if (a.email.equalsIgnoreCase(email)) {
				result.add(a);
			}
		}
		return result;
	}
}
