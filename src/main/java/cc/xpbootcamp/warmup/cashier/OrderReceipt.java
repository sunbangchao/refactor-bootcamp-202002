package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.utils.DateUtil;

import java.util.Calendar;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {

    private static final String RECEIPT_HEAD = "===== 老王超市，值得信赖 ======";
    private static final String SALES_TAX = "税额：";
    private static final String TOTAL_AMOUNT = "总价：";
    private static final String DISCOUNT = "折扣：";
    private static final String DIVIDING_LINE = "-----------------------------------";

    private String info;



    public OrderReceipt(Order order) {
        this.createReceipt(order);
    }

    private void createReceipt(Order order){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(RECEIPT_HEAD);
        stringBuilder.append("\n");
        stringBuilder.append(DateUtil.format2YYYYMMDDEEEE_CH(order.orderDate));
        stringBuilder.append("\n");
        order.getLineItemList().stream().forEach(lineItem -> {
            stringBuilder.append(lineItem.getGood().getDesc() + ", " + String.format("%.2f",lineItem.getGood().getPrice()) + " × " + lineItem.getQuantity() + ", " + String.format("%.2f",lineItem.getAmount()));
            stringBuilder.append("\n");
        });
        stringBuilder.append(DIVIDING_LINE);
        stringBuilder.append("\n");
        stringBuilder.append(SALES_TAX + String.format("%.2f",order.getTax()));
        stringBuilder.append("\n");
        if(order.getDiscount() > 0) {
            stringBuilder.append(DISCOUNT + String.format("%.2f",order.getDiscount()));
            stringBuilder.append("\n");
        }
        stringBuilder.append(TOTAL_AMOUNT + String.format("%.2f",order.getTotalAmount()));

        this.info = stringBuilder.toString();
    }

    public String printReceipt() {
        return this.info;
    }
}