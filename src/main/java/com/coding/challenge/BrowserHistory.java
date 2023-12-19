package com.coding.challenge;

import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
	int curr = -1;
	int size = 0;
	final List<String> l = new ArrayList<>();

	public BrowserHistory(String homepage) {
		l.add(homepage);
		curr = 0;
		size = size + 1;
	}

	public static void main(String[] args) {
		final BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com");
		browserHistory.visit("facebook.com");
		browserHistory.visit("youtube.com");
		assert "facebook.com".equals(browserHistory.back(1));
		assert "google.com".equals(browserHistory.back(1));
		assert "facebook.com".equals(browserHistory.forward(1));
		browserHistory.visit("linkedin.com");
		assert "linkedin.com".equals(browserHistory.forward(2));
		assert "google.com".equals(browserHistory.back(2));
		assert "leetcode.com".equals(browserHistory.back(7));

		final BrowserHistory browserHistory2 = new BrowserHistory("esgriv.com");
		browserHistory2.visit("cgrt.com");
		browserHistory2.visit("tip.com");
		assert "esgriv.com".equals(browserHistory2.back(9));
		browserHistory2.visit("kttzxgh.com");
		assert "kttzxgh.com".equals(browserHistory2.forward(7));
		browserHistory2.visit("crqje.com");
		browserHistory2.visit("iybch.com");
		assert "iybch.com".equals(browserHistory2.forward(5));
		browserHistory2.visit("uun.com");
		assert "esgriv.com".equals(browserHistory2.back(10));
		browserHistory2.visit("hci.com");
		browserHistory2.visit("whula.com");
		assert "whula.com".equals(browserHistory2.forward(10));
	}

	public void visit(String url) {
		curr = curr + 1;
		if (curr < l.size()) {
			l.set(curr, url);
			size = curr + 1;
		} else {
			l.add(url);
			size = size + 1;
		}
	}

	public String back(int steps) {
		curr = Math.max(0, curr - steps);
		return l.get(curr);
	}

	public String forward(int steps) {
		curr = Math.min(curr + steps, size - 1);
		return l.get(curr);
	}
}
