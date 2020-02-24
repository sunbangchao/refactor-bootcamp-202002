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

    private final static String RECEIPT_HEAD = "===== 老王超市，值得信赖 ======";
    private final static String SALES_TAX = "税额：";
    private final static String TOTAL_AMOUNT = "总价：";
    private final static String DISCOUNT = "折扣：";
    private final static String DIVIDING_LINE = "-----------------------------------";

    private StringBuilder text;

    private OriginalOrder originalOrder;
    private Double tax;
    private Double discount;
    private Double totalAmount;

    public OrderReceipt(OriginalOrder originalOrder) {
        this.originalOrder = originalOrder;
        this.createReceipt();
    }

    private void createReceipt(){
        text = new StringBuilder();

        this.newRow(RECEIPT_HEAD);
        this.newRow();
        this.createDate();
        this.newRow();
        this.createLineItems();
        this.newRow(DIVIDING_LINE);
        this.calculateSalesTaxAndTotalAmountAndDiscount();
        this.createSalesTax();
        this.createDiscount();
        this.createTotalAmount();
    }

    private void createDate(){
        this.newRow(DateUtil.format2YYYYMMDDEEEE_CH(originalOrder.getDate()));
    }

    private void createLineItems(){
        for (LineItem lineItem : originalOrder.getLineItems()) {
            this.newRow(lineItem.getDescription() + ", " + String.format("%.2f",lineItem.getPrice()) + " × " + lineItem.getQuantity() + ", " + String.format("%.2f",lineItem.totalAmount()));
        }
    }

    private void calculateSalesTaxAndTotalAmountAndDiscount(){
        tax = 0.0;
        totalAmount = 0.0;
        discount = 0.0;

        for (LineItem lineItem : originalOrder.getLineItems()) {
            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            tax += salesTax;
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }


    }

    private void createSalesTax(){
        this.newRow(SALES_TAX + String.format("%.2f",tax));
    }

    private void createDiscount(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(originalOrder.getDate());
        if(cal.get(Calendar.DAY_OF_WEEK) == 4){
            discount = totalAmount * .02;
            totalAmount = totalAmount - discount;
            this.newRow(DISCOUNT + String.format("%.2f",discount));
        }
    }

    private void createTotalAmount(){
        this.newRow(TOTAL_AMOUNT + String.format("%.2f",totalAmount));
    }

    private void newRow(String str){
        text.append(str);
        text.append("\n");
    }

    private void newRow(){
        text.append("\n");
    }

    public String printReceipt() {
        return this.text.toString();
    }
}