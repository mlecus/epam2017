package s2galaktionov.gmail.com.sgalaktionov.homework3_1;

/**
 * Created by mlecus on 28.09.2017.
 */
public interface ICard {
    public String getName();

    public double getBalance();

    public void increaseBalance(double amount) throws IllegalArgumentException;

    public void decreaseBalance(double amount) throws IllegalArgumentException;

    public double convertBalance(double conversionRank) throws IllegalArgumentException;

    public String toSring();
}
