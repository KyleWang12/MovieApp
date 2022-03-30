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


@WebServlet("/filmdelete")
public class FilmDelete extends HttpServlet {
	
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
        // Provide a title and render the JSP.
        messages.put("title", "Delete Film");        
        req.getRequestDispatcher("/FilmDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String tconst = req.getParameter("tconst");
        if (tconst == null || tconst.trim().isEmpty()) {
            messages.put("title", "Invalid Tconst");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the Film.
        	Film film = new Film(tconst);
	        try {
	        	film = FilmDao.delete(film);
	        	// Update the message.
		        if (film == null) {
		            messages.put("title", "Successfully deleted " + tconst);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + tconst);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/FilmDelete.jsp").forward(req, resp);
    }
}
