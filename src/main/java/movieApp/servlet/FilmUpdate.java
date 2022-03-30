package movieApp.servlet;

import movieApp.dal.*;
import movieApp.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/filmupdate")
public class FilmUpdate extends HttpServlet {
	
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

        // Retrieve user and validate.
        String tconst = req.getParameter("tconst");
        if (tconst == null || tconst.trim().isEmpty()) {
            messages.put("success", "Please enter a valid tconst.");
        } else {
        	try {
        		Film film = filmDao.getFilmByTconst(tconst);
        		if(film == null) {
        			messages.put("success", "Tconst does not exist.");
        		}
        		req.setAttribute("blogUser", film);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/FilmUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String tconst = req.getParameter("tconst");
        if (tconst == null || tconst.trim().isEmpty()) {
            messages.put("success", "Please enter a valid tconst.");
        } else {
        	try {
        		Film film = filmDao.getFilmByTconst(tconst);
        		if(film == null) {
        			messages.put("success", "tconst does not exist. No update to perform.");
        		} else {
        			String newFilmName = req.getParameter("filmName");
        			if (newFilmName == null || newFilmName.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid FilmName.");
        	        } else {
        	        	film = filmDao.updateFilmName(film, newFilmName);
        	        	messages.put("success", "Successfully updated " + tconst);
        	        }
        		}
        		req.setAttribute("film", film);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/FilmUpdate.jsp").forward(req, resp);
    }
}
