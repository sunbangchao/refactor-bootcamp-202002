package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

public class OriginalOrder {
    Date orderDate;
    List<LineItem> lineItemList;

    public OriginalOrder(Date orderDate, List<LineItem> lineItemList) {
        this.orderDate = orderDate;
        this.lineItemList = lineItemList;
    }

    public Date getDate() {
        return orderDate;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }
}
