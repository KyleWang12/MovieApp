package movieApp.tools;

import movieApp.dal.*;
import movieApp.model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class Inserter {

	public static void main(String[] args) throws SQLException, ParseException {
		// DAO instances.
//		FilmDao fDao = FilmDao.getInstance();
//		GenreDao gDao = GenreDao.getInstance();
		
		//1.  INSERT objects from our model.
		/**
tt0000001	short	Carmencita	Carmencita	0	1894	\N	1	Documentary,Short
tt0000002	short	Le clown et ses chiens	Le clown et ses chiens	0	1892	\N	5	Animation,Short
tt0000003	short	Pauvre Pierrot	Pauvre Pierrot	0	1892	\N	4	Animation,Comedy,Romance
tt0000004	short	Un bon bock	Un bon bock	0	1892	\N	12	Animation,Short
tt0000005	short	Blacksmith Scene	Blacksmith Scene	0	1893	\N	1	Comedy,Short
tt0000006	short	Chinese Opium Den	Chinese Opium Den	0	1894	\N	1	Short
tt0000007	short	Corbett and Courtney Before the Kinetograph	Corbett and Courtney Before the Kinetograph	0	1894	\N	1	Short,Sport
tt0000008	short	Edison Kinetoscopic Record of a Sneeze	Edison Kinetoscopic Record of a Sneeze	0	1894	\N	1	Documentary,Short
tt0000009	short	Miss Jerry	Miss Jerry	0	1894	\N	40	Romance,Short
tt0000010	short	Leaving the Factory	La sortie de l'usine Lumi��re �� Lyon	0	1895	\N	1	Documentary,Short
		 */
//		Film f1 = new Film("tt0000001", "Carmencita", 1894, false, "Carmencita");
//		Film f2 = new Film("tt0000002", "Le clown et ses chiens", 1892, false, "Le clown et ses chiens");
//		Film f3 = new Film("tt0000003", "Pauvre Pierrot", 1892, false, "Pauvre Pierrot");
//		f1 = fDao.create(f1);
//		f2 = fDao.create(f2);
//		f3 = fDao.create(f3);
		
		/**
tt0000001	Documentary
tt0000001	Short
tt0000002	Animation
tt0000002	Short
tt0000003	Animation
tt0000003	Comedy
tt0000003	Romance
tt0000004	Animation
tt0000004	Short
tt0000005	Comedy
tt0000005	Short
tt0000006	Short
tt0000007	Short
tt0000007	Sport
tt0000008	Documentary
tt0000008	Short
tt0000009	Romance
tt0000009	Short
tt0000010	Documentary
tt0000010	Short
		 */
//		Genre g1 = new Genre("tt0000001", Genre.GenreTypeEnum.DOCUMENTARY);
//		Genre g2 = new Genre("tt0000002", Genre.GenreTypeEnum.SHORT);
//		Genre g3 = new Genre("tt0000003", Genre.GenreTypeEnum.ANIMATION);
//		g1 = gDao.create(g1);
//		g2 = gDao.create(g2);
//		g3 = gDao.create(g3);
//		
		
		// 2. UPDATE.
//		fDao.updateFilmName(f1, "updatedFilmName1");
//		gDao.updateGenreType(g3, Genre.GenreTypeEnum.SHORT);
		
		// 3. READ.
//		Film getf1 = fDao.getFilmByTconst("testtest");
//		System.out.format("getFilmByTconst: %s\n",
//				getf1.getFilmName());
//		System.out.println();
//		
//		List<Film> fList1 = new ArrayList<>();
//		fList1 = fDao.getFilmByFilmName("Bohemios");
//		System.out.format("getFilmByFilmName: %s\n",
//				fList1.get(0).getTconst());
//		System.out.println();
//		
//		List<Film> fList2 = new ArrayList<>();
//		fList2 = fDao.getFilmByReleaseDate(1892);
//		for(Film f:fList2)
//			System.out.format("getFilmByReleaseDate: %s\n",
//					f.getFilmName());
//		System.out.println();
//		
//		List<Film> fList3 = new ArrayList<>();
//		fList3 = fDao.getFilmByisAdult(false);
//		for(Film f:fList3)
//			System.out.format("getFilmByisAdult: %s\n",
//					f.getFilmName());
//		System.out.println();
//		
//		Genre getG1 = gDao.getGenreByTconst("tt0000001");
//		System.out.format("getGenreByTconst: %s\n",
//				getG1.getGenreType().name());
//		System.out.println();
//		
//		List<Film> gList1 = new ArrayList<>();
//		gList1 = gDao.getFilmByGenre(Genre.GenreTypeEnum.SHORT);
//		for(Film f:gList1)
//			System.out.format("getFilmByGenre: %s\n",
//					f.getFilmName());
//		System.out.println();

		
		// 4. Delete.
//		fDao.delete(f1);
//		gDao.delete(g1);
		AnnualGrossDao aD = AnnualGrossDao.getInstance();
//		AnnualGross gross = aD.getAnnualGrossByFilmName("Rich Kids");
//		System.out.println(gross.getDistributorName());
		
	}
}
