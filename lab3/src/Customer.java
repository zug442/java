import java.util.*;

class Customer {

    public String _name;
    private Vector<MovieRental> _movieRentals = new Vector<MovieRental>();
    private Vector<VideoGameRental> _videoGameRental = new Vector<VideoGameRental>();
    public Customer(String name) {
        _name = name;
    }

    public void addMovieRental(MovieRental arg) {
        _movieRentals.addElement(arg);
    }

    public void addVideoGameRental(VideoGameRental arg) {
        _videoGameRental.addElement(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<MovieRental> movieRentals = _movieRentals.elements();
        Enumeration<VideoGameRental> videoGameRentals = _videoGameRental.elements();
        String result = "Rental Record for " + _name + "\n";

        while (movieRentals.hasMoreElements()) {
            MovieRental aRental = (MovieRental) movieRentals.nextElement();
            // add frequent renter points
            frequentRenterPoints += aRental.getFrequentRenterPoints();
            // show figures for this rental
            result += "\t" + aRental.getMovie().get_title() + "\t"
                    + String.valueOf(aRental.getChange()) + "\n";
            totalAmount += aRental.getChange();
        }
        while (videoGameRentals.hasMoreElements()) {
            VideoGameRental each = (VideoGameRental) videoGameRentals.nextElement();
            frequentRenterPoints = each.getFrequentRenterPoints();
            result += "\t" + each.getVideoGame() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

}
