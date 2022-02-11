package tradingRoom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 */

public final class Book  implements TradingCollection{

    private final List<TradingCollection> tradingCollections = new ArrayList<>();

    @Override
    public BigDecimal getValue() {
        return tradingCollections.stream().map(TradingCollection::getValue).reduce(new BigDecimal(0), BigDecimal::add);
    }

    public void addCollection(TradingCollection tradingCollection) {
        this.tradingCollections.add(tradingCollection);
    }

    /**
     * using Collections.unmodifiableList to make the class stay immutable
     */
    public List<TradingCollection> getTradingCollections() {
        return Collections.unmodifiableList(this.tradingCollections);
    }
}
