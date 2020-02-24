package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.utils.DateUtil;

import java.util.Date;
import java.util.List;

public class Order {
    Date orderDate;
    List<LineItem> lineItemList;
    private Double tax;
    private Double discount;
    private Double totalAmount;


    public Order(Date orderDate, List<LineItem> lineItemList) {
        this.orderDate = orderDate;
        this.lineItemList = lineItemList;
        calculateTotalAndTaxAndDiscount();
    }

    private void calculateTotalAndTaxAndDiscount(){
        double tempAmount = lineItemList.stream().mapToDouble(LineItem::getAmount).sum();
        this.tax = tempAmount * ManageConstants.TAX_RATE;
        tempAmount += this.tax;
        this.discount = (DateUtil.getDayOfWeek(orderDate) == 4 ? tempAmount * ManageConstants.DISCOUNT_RATE : 0);
        this.totalAmount = tempAmount - this.discount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public Double getTax() {
        return tax;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}
