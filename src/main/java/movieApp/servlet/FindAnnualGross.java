package movieApp.servlet;

import movieApp.dal.*;
import movieApp.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// annual gross by film name
@WebServlet("/findannualgross")
public class FindAnnualGross extends HttpServlet {
	
	protected AnnualGrossDao annualGrossDao;
	
	@Override
	public void init() throws ServletException {
		annualGrossDao = AnnualGrossDao.getInstance();
	}
	
	// get film by film name
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        AnnualGross annualGross = null;
        
        
        String filmName = req.getParameter("filmname");
        if (filmName == null || filmName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid film name.");
        } else {
        	
        	try {
        		annualGross = annualGrossDao.getGrossByFilmName(filmName);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + filmName);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousFirstName", filmName);
        }
        req.setAttribute("annualGross", annualGross);
        
        req.getRequestDispatcher("/FindAnnualGross.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        AnnualGross annualGross = null;
        
        String filmName = req.getParameter("filmName");
        if (filmName == null || filmName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid film name.");
        } else {
        	
        	try {
        		annualGross = annualGrossDao.getGrossByFilmName(filmName);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + filmName);
        }
        req.setAttribute("annualGross", annualGross);
        
        req.getRequestDispatcher("/FindAnnualGross.jsp").forward(req, resp);
    }
}
