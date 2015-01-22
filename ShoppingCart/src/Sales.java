import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Sales {
	ArrayList<Items> itemSale = new ArrayList<Items>();
	double total = 0;
	
	public Items loadSale(ArrayList<Items> itemForSale, String name) {
		Items item = new Items();
		Iterator<Items> itrItems = itemForSale.iterator();
		while(itrItems.hasNext()){
			item = itrItems.next();
			if(item.getName() == name.toLowerCase()){
				
			}
		}
		return item;
	}
	
	public double getTotal (ArrayList<Items> itemForSale,String name){
		double subtotal = 0;
		Iterator<Items> itrItems = itemForSale.iterator();
		while(itrItems.hasNext()){
			Items item = itrItems.next();
			if((item.getName()).equals (name)){
				subtotal = item.getPrice();
			}
		}
		return subtotal;
	}
	
	public String typePay() {
		String tPay = "";
		System.out.println("Ingrese el tipo de pago: Efectivo, Tarjeta o Paypal");
		Scanner sc = new Scanner(System.in);
		tPay = sc.nextLine();
		sc.close();
		if((tPay.toLowerCase()).equals("tarjeta"))
			return "tarjeta";
		else {
			if(tPay.toLowerCase() == "efectivo")
			return "efectivo";
			else 
				return "paypal";
		}
	
	}

		
		
	}
