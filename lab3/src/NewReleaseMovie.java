public class NewReleaseMovie extends Movie {

    private static final int RENTAL_COST = 3;
    private static final int FREQUENT_RENTER_POINTS = 1;
    public static final int NUM_DAYS_BASE_CONST = 1;
    public static final int LONG_TERM_POINTS = 2;

    public NewReleaseMovie(String title) {
        super(title);
    }

    public double getCharge(int _daysRented) {
        double result = 0;
        result += _daysRented * RENTAL_COST;
        return result;
    }

    public int getFrequentRenterPoints(int _daysRented) {
        int frequentRenterPoints = 0;
        if(_daysRented > NUM_DAYS_BASE_CONST)
            frequentRenterPoints += LONG_TERM_POINTS;
        else
            frequentRenterPoints += FREQUENT_RENTER_POINTS;
        return frequentRenterPoints;
    }
}