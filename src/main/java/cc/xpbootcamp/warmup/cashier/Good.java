package cc.xpbootcamp.warmup.cashier;

public class Good {
    private String desc;
    private Double price;

    public Good(String desc, Double price) {
        this.desc = desc;
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
