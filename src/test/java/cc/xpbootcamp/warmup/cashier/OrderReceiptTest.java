package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
//    @Test
//    void shouldPrintCustomerInformationOnOrder() {
//        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
//        OrderReceipt receipt = new OrderReceipt(order);
//
//        String output = receipt.printReceipt();
//
//
//        assertThat(output, containsString("Mr X"));
//        assertThat(output, containsString("Chicago, 60601"));
//    }

//    @Test
//    public void shouldPrintLineItemAndSalesTaxInformation() {
//        List<LineItem> lineItems = new ArrayList<LineItem>() {{
//            add(new LineItem("milk", 10.0, 2));
//            add(new LineItem("biscuits", 5.0, 5));
//            add(new LineItem("chocolate", 20.0, 1));
//        }};
//        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));
//
//        String output = receipt.printReceipt();
//
//        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
//        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
//        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
//        assertThat(output, containsString("Sales Tax\t6.5"));
//        assertThat(output, containsString("Total Amount\t71.5"));
//    }

    @Test
    public void should_print_line_item_and_sales_tax_and_total_amount_information(){
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK,1);
        OrderReceipt receipt = new OrderReceipt(new Order(calendar.getTime(), lineItems));
        String output = receipt.printReceipt();

        assertThat(output,containsString("milk, 10.00 × 2, 20.00"));
        assertThat(output,containsString("biscuits, 5.00 × 5, 25.00"));
        assertThat(output,containsString("chocolate, 20.00 × 1, 20.00"));
        assertThat(output,containsString("税额：6.50"));
        assertThat(output,containsString("总价：71.00"));
    }

    @Test
    public void should_print_line_item_and_sales_tax_and_discount_and_total_amount_information(){
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK,4);
        OrderReceipt receipt = new OrderReceipt(new Order(calendar.getTime(), lineItems));
        String output = receipt.printReceipt();

        assertThat(output,containsString("milk, 10.00 × 2, 20.00"));
        assertThat(output,containsString("biscuits, 5.00 × 5, 25.00"));
        assertThat(output,containsString("chocolate, 20.00 × 1, 20.00"));
        assertThat(output,containsString("税额：6.50"));
        assertThat(output,containsString("折扣：1.42"));
        assertThat(output,containsString("总价：69.58"));
    }

}