import java.util.ArrayList;
import java.util.Iterator;


public class Items {
	String name = "";
	double price = 0, offerPrice = 0;
	ArrayList<Items> offerL = new ArrayList<Items>();
	
	
	public Items (String name, double price) {
		this.name = name;
		this.price = price;
		
	}
	
	public Items() {
		// TODO Auto-generated constructor stub
	}

	public String getName(){
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setOfferPrice(double oPrice){
		this.offerPrice = oPrice;
	}
	
	
	public double getOfferPrice (){
		return offerPrice;
	}
	
	
	public void displayItems(ArrayList<Items> itemSale) {
		int i = 0;
		Iterator<Items> itrItems = itemSale.iterator();
		while(itrItems.hasNext()){
			i ++;
			Items item = itrItems.next();
			System.out.println(i + "- " + item.getName()  + "         $" + item.getPrice());
		}
		
	}
	
		public void displayOffers(ArrayList<Items> offer) {
			int i = 0;
			Iterator<Items> itrItems = offer.iterator();
			while(itrItems.hasNext()){
				i ++;
				Items item = itrItems.next();
				System.out.println("Precio:        Oferta");
				System.out.println(i + "- " + item.getName()  + "         $" + item.getOfferPrice());
			}
		}
		
		public Items loadOffer(ArrayList<Items> itemForSale, String name, double oPrice) {
			Items item = new Items();
			Iterator<Items> itrItems = itemForSale.iterator();
			while(itrItems.hasNext()){
				item = itrItems.next();
				if((item.getName()).equals(name)){
					item.setOfferPrice(oPrice);}
			}
			return item;
		}
}

