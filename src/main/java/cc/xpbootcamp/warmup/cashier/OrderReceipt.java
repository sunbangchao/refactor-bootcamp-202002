package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {

    private final static String RECEIPT_HEAD = "======Printing Orders======";
    private final static String SALES_TAX = "Sales Tax";
    private final static String TOTAL_AMOUNT = "Total Amount";

    private StringBuilder text;

    private Order order;
    private Double tax;
    private Double totalAmount;

    public OrderReceipt(Order order) {
        this.order = order;
        this.createReceipt();
    }

    private void createReceipt(){
        text = new StringBuilder();

        // print headers
        this.newRow(RECEIPT_HEAD);
        this.createCustomerInfo();
        this.createLineItems();
        this.calculateSalesTaxAndTotalAmount();
        this.createSalesTax();
        this.createTotalAmount();
    }

    private void createCustomerInfo(){
        this.newRow(order.getCustomerName() + "\t" + order.getCustomerAddress());
    }

    private void createLineItems(){
        for (LineItem lineItem : order.getLineItems()) {
            this.newRow(lineItem.getDescription() + "\t" + lineItem.getPrice() + "\t" + lineItem.getQuantity() + "\t" + lineItem.totalAmount());
        }
    }

    private void calculateSalesTaxAndTotalAmount(){
        tax = 0.0;
        totalAmount = 0.0;

        for (LineItem lineItem : order.getLineItems()) {
            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            tax += salesTax;
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }
    }

    private void createSalesTax(){
        this.newRow(SALES_TAX + "\t" + tax);
    }

    private void createTotalAmount(){
        this.newRow(TOTAL_AMOUNT + "\t" + totalAmount);
    }

    private void newRow(String str){
        text.append(str);
        text.append("\n");
    }

    public String printReceipt() {
        return this.text.toString();
    }
}