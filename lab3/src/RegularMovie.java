public class RegularMovie extends Movie {
    private static final int NUM_DAYS_BASE_CONST = 2;
    private static final int BASE_RENTAL_COST = NUM_DAYS_BASE_CONST;
    private static final double LONG_TERM_RENTAL_COST = 1.5;
    private static final int FREQUENT_RENTER_POINTS = 1;

    public RegularMovie(String title) {
        super(title);
    }

    public double getCharge(int _daysRented) {
        double result = 0;
        result += BASE_RENTAL_COST;
        if (_daysRented > NUM_DAYS_BASE_CONST)
            result += (_daysRented - NUM_DAYS_BASE_CONST) * LONG_TERM_RENTAL_COST;
        return result;
    }

    public int getFrequentRenterPoints(int _daysRented) {
        int frequentRenterPoints = 0;
        // add bonus for a two day new release rental
        frequentRenterPoints += FREQUENT_RENTER_POINTS;
        return frequentRenterPoints;
    }
}
