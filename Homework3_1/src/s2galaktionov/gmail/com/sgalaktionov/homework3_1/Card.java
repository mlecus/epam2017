package s2galaktionov.gmail.com.sgalaktionov.homework3_1;

/**
 * Created by mlecus on 28.09.2017.
 */
public class Card implements ICard {
    private String name;
    private double balance;


    public Card(String name, double balance) {
        checkNameForCorrectValue(name);
        checkBalanceForCorrectValue(balance);
        this.name = name;
        this.balance = balance;
    }

    public Card(String name) {
        checkNameForCorrectValue(name);
        this.name = name;
    }

    public Card(Card card) {
        this.name = card.name;
        this.balance = card.balance;
    }

    private void checkNameForCorrectValue(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Null value in Name received");
        }
        if (name.equals("")) {
            throw new IllegalArgumentException("Empty string in Name received");
        }
    }

    private void checkBalanceForCorrectValue(double amount) throws IllegalArgumentException {
        if (Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Infinite value in Balance received");
        }

        if (Double.isNaN(amount)) {
            throw new IllegalArgumentException("Not a number value in Balance received");
        }
    }

    private void checkAmontForCorrectValue(double amount) throws IllegalArgumentException {
        if (Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Infinite value in Amount received");
        }

        if (Double.isNaN(amount)) {
            throw new IllegalArgumentException("Not a number value in Amount received");
        }

        if (Double.compare(amount, 0) == -1) {
            throw new IllegalArgumentException("Negative value in Amount received");
        }
    }

    private void checkConversionRankForCorrectValue(double conversionRank) throws IllegalArgumentException {
        if (Double.isInfinite(conversionRank)) {
            throw new IllegalArgumentException("Infinite value received");
        }

        if (Double.isNaN(conversionRank)) {
            throw new IllegalArgumentException("Not a number value in ConversionRank received");
        }

        if (Double.compare(conversionRank, 0) == -1) {
            throw new IllegalArgumentException("Negative value in ConversionRank received");
        }
        if (Double.compare(conversionRank, 0) == 0) {
            throw new IllegalArgumentException("Zero value in ConversionRank received");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void increaseBalance(double amount) throws IllegalArgumentException {
        checkAmontForCorrectValue(amount);
        this.balance += amount;
    }

    @Override
    public void decreaseBalance(double amount) throws IllegalArgumentException {
        checkAmontForCorrectValue(amount);
        this.balance -= amount;
    }

    @Override
    public double convertBalance(double conversionRank) {
        checkConversionRankForCorrectValue(conversionRank);
        return this.balance * conversionRank;
    }

    @Override
    public String toSring() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name:\t").append(name).append("\n")
                .append("Balance:\t").append(balance);
        return sb.toString();
    }
}
