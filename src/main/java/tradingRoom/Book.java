package tradingRoom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 */

public final class Book {

    private final List<Wallet> wallets = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();

    public BigDecimal getValue() {
        BigDecimal walletValue = getWalletsValue();
        BigDecimal booksValue = getBooksValue();
        return booksValue.add(walletValue);
    }

    private BigDecimal getBooksValue() {
        return  this.books.stream().map(Book::getValue).reduce(new BigDecimal(0), BigDecimal::add);
    }

    private BigDecimal getWalletsValue() {
        return this.wallets.stream().map(Wallet::getValue).reduce(new BigDecimal(0), BigDecimal::add);
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addWallet(Wallet wallet) {
        this.wallets.add(wallet);
    }
}
