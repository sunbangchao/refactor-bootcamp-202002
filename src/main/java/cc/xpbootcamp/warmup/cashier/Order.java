package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

public class Order {
    Date date;
    List<LineItem> lineItemList;

    public Order(Date date, List<LineItem> lineItemList) {
        this.date = date;
        this.lineItemList = lineItemList;
    }

    public Date getDate() {
        return date;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }
}
