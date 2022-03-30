package movieApp.servlet;

import movieApp.dal.*;
import movieApp.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/usercreate")
public class FilmCreate extends HttpServlet {
	
	protected FilmDao filmDao;
	
	@Override
	public void init() throws ServletException {
		filmDao = FilmDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/FilmCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String filmName = req.getParameter("filmName");
        if (filmName == null || filmName.trim().isEmpty()) {
            messages.put("success", "Invalid FilmName");
        } else {
        	// Create the Film.
        	String tconst = req.getParameter("tconst");
        	// releaseDate in format year i.e. 2021
        	int releaseDate = req.getParameter("releaseDate");
        	boolean isAdult = req.getParameter("isAdult");
        	String title = req.getParameter("title");
	        try {
	        	
	        	Film film = new Film(tconst, filmName, releaseDate, isAdult, title);
	        	film = FilmDao.create(film);
	        	messages.put("success", "Successfully created " + filmName);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/FilmCreate.jsp").forward(req, resp);
    }
}
