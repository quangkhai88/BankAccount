package tradingRoom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 */

public final class Book  implements TradingCollection{

    private final List<Wallet> wallets = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();

    @Override
    public BigDecimal getValue() {
        BigDecimal walletValue = getCollectionValue(this.wallets);
        BigDecimal booksValue = getCollectionValue(this.books);
        return booksValue.add(walletValue);
    }

    private BigDecimal getCollectionValue(List<? extends TradingCollection> list) {
        return list.stream().map(TradingCollection::getValue).reduce(new BigDecimal(0), BigDecimal::add);
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addWallet(Wallet wallet) {
        this.wallets.add(wallet);
    }
}
