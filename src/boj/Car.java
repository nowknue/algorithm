package boj;

public class Car {

	String name;
	int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Car) {
			if (((Car) obj).getName().equals(this.getName()) && ((Car)obj).getPrice() == this.getPrice()) {
				return true;
			} else {
				return false;
			}
		}
		
		return super.equals(obj);
	}
}
