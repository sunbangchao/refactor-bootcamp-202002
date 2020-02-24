package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private Good good;
	private int quantity;
	private Double amount;

	public LineItem(Good good, int quantity) {
		this.good = good;
		this.quantity = quantity;
		this.amount = good.getPrice() * quantity;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return this.good.getDesc() + ", " + this.good.getPrice() + " × " + this.quantity + ", " + this.amount;
	}
}