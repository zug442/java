import org.junit.*;

public class MovieRentalTest extends junit.framework.TestCase {

    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new RegularMoive("The Man Who Knew Too Much");
        mulan = new ChildrensMovie("Mulan");
        slumdogMillionaire = new NewReleaseMovie("Slumdog Millionaire" );
    }


    @Test
    public void testGetTitle() {
        assertEquals("The Man Who Knew Too Much", theManWhoKnewTooMuch.get_title());
    }


    @Test
    public void testGetDaysRented() {
        assertEquals(2, new MovieRental(theManWhoKnewTooMuch, 2).getDaysRented());
    }

    @Test
    public void testGetMovie() {
        assertEquals(theManWhoKnewTooMuch, new MovieRental(theManWhoKnewTooMuch, 2).getMovie());
    }

    @Test
    public void testGetName() {
        String name = "John Doe"; 
        assertEquals(name, new Customer(name)._name);
    }

    @Test
    public void testStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(new RegularMoive("Time"), 0));
        assertEquals("Rental Record for John Doe\n" +
                "\tTime\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", johnDoe.statement());
        johnDoe.addMovieRental(new MovieRental(new RegularMoive("Time2"), 2));
        assertEquals("Rental Record for John Doe\n" +
                "\tTime\t2.0\n" +
                "\tTime2\t2.0\n" +
                "Amount owed is 4.0\n" +
                "You earned 2 frequent renter points", johnDoe.statement());
        johnDoe.addMovieRental(new MovieRental(new RegularMoive("Time3"), 5));
        assertEquals("Rental Record for John Doe\n" +
                "\tTime\t2.0\n" +
                "\tTime2\t2.0\n" +
                "\tTime3\t6.5\n" +
                "Amount owed is 10.5\n" +
                "You earned 3 frequent renter points", johnDoe.statement());
        System.out.println("testStatementRegularMovieOnly: OK");
    }

    @Test
    public void testStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addMovieRental(new MovieRental(new ChildrensMovie("Tom and Jarry"), 0));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                "\tTom and Jarry\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", johnDoeJr.statement());
        johnDoeJr.addMovieRental(new MovieRental(new ChildrensMovie("Tom and Jarry young"), 3));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                "\tTom and Jarry\t1.5\n" +
                "\tTom and Jarry young\t1.5\n" +
                "Amount owed is 3.0\n" +
                "You earned 2 frequent renter points", johnDoeJr.statement());
        johnDoeJr.addMovieRental(new MovieRental(new ChildrensMovie("Tom and Jarry young 2"), 4));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                "\tTom and Jarry\t1.5\n" +
                "\tTom and Jarry young\t1.5\n" +
                "\tTom and Jarry young 2\t2.75\n" +
                "Amount owed is 5.75\n" +
                "You earned 3 frequent renter points", johnDoeJr.statement());
        System.out.println("testStatementChildrensMovieOnly: OK");
    }

    @Test
    public void testStatementNewReleaseOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        janeDoe.addMovieRental(new MovieRental(new NewReleaseMovie("Avengers"), 0));
        assertEquals("Rental Record for Jane Doe\n" +
                "\tAvengers\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points", janeDoe.statement());
        janeDoe.addMovieRental(new MovieRental(new NewReleaseMovie("Avengers:Age of Altron"), 1));
        assertEquals("Rental Record for Jane Doe\n" +
                "\tAvengers\t0.0\n" +
                "\tAvengers:Age of Altron\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 2 frequent renter points", janeDoe.statement());
        janeDoe.addMovieRental(new MovieRental(new NewReleaseMovie("Avengers:Final"), 3));
        assertEquals("Rental Record for Jane Doe\n" +
                "\tAvengers\t0.0\n" +
                "\tAvengers:Age of Altron\t3.0\n" +
                "\tAvengers:Final\t9.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 4 frequent renter points", janeDoe.statement());
        System.out.println("testStatementNewReleaseOnly: OK");
    }
}