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

    private StringBuilder text;

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
        this.createReceipt();
    }

    private void createReceipt(){
        text = new StringBuilder();

        // print headers
        this.newRow(RECEIPT_HEAD);

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        this.newRow(order.getCustomerName() + "\t" + order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            this.newRow(lineItem.getDescription() + "\t" + lineItem.getPrice() + "\t" + lineItem.getQuantity() + "\t" + lineItem.totalAmount());

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        this.newRow("Sales Tax\t" + totSalesTx);

        // print total amount
        this.newRow("Total Amount\t" + tot);
    }

    public void newRow(String str){
        text.append(str);
        text.append("\n");
    }

    public String printReceipt() {
        return this.text.toString();
    }
}