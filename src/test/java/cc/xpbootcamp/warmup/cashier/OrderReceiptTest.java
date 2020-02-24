package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {


    @Test
    public void should_print_line_item_and_sales_tax_and_total_amount_information(){
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem(new Good("milk",10.0), 2));
            add(new LineItem(new Good("biscuits", 5.0), 5));
            add(new LineItem(new Good("chocolate", 20.0), 1));
        }};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK,1);
        OrderReceipt receipt = new OrderReceipt(new Order(calendar.getTime(), lineItems));
        String output = receipt.printReceipt();

        System.out.println(output);

        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日，EEEE");
        assertThat(output,containsString("===== 老王超市，值得信赖 ======"));
        assertThat(output,containsString(format.format(calendar.getTime())));
        assertThat(output,containsString("milk, 10.00 × 2, 20.00"));
        assertThat(output,containsString("biscuits, 5.00 × 5, 25.00"));
        assertThat(output,containsString("chocolate, 20.00 × 1, 20.00"));
        assertThat(output,containsString("税额：6.50"));
        assertThat(output,containsString("总价：71.50"));
    }

    @Test
    public void should_print_line_item_and_sales_tax_and_discount_and_total_amount_information(){
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem(new Good("milk",10.0), 2));
            add(new LineItem(new Good("biscuits", 5.0), 5));
            add(new LineItem(new Good("chocolate", 20.0), 1));
        }};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK,4);
        OrderReceipt receipt = new OrderReceipt(new Order(calendar.getTime(), lineItems));
        String output = receipt.printReceipt();

        System.out.println(output);

        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日，EEEE");
        assertThat(output,containsString(format.format(calendar.getTime())));
        assertThat(output,containsString("milk, 10.00 × 2, 20.00"));
        assertThat(output,containsString("biscuits, 5.00 × 5, 25.00"));
        assertThat(output,containsString("chocolate, 20.00 × 1, 20.00"));
        assertThat(output,containsString("税额：6.50"));
        assertThat(output,containsString("折扣：1.43"));
        assertThat(output,containsString("总价：70.07"));
    }

}