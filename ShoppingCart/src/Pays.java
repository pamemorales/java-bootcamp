import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Pays {
	double total = 0;
	int counter = 0;
	double a=0, b=0;
	
	public void setCounter(){
		this.counter ++;
	}
	public Pays (){
		
	}
	public double getDiscount(double subTotal, ArrayList<Items> itemSale){
		Iterator<Items> itrItems = itemSale.iterator();
		while(itrItems.hasNext()){
			Items item = itrItems.next();
			b = item.getPrice();
			if(a < b)
				a = b;
			}
			total = subTotal - a + (subTotal *0.1);
			return total;
		}
}

class CreditCards extends Pays {
	String cardName = "";
	int creditNumber;
	
	public CreditCards(){
	}
	
	public void setDataCreditCard () {
		System.out.println("Ingrese el nombre de la tarjeta de credito");
		Scanner sc = new Scanner(System.in);
		this.cardName = sc.nextLine();
		System.out.println("Ingrese el número de la tarjeta: ");
		this.creditNumber = sc.nextInt();
		sc.nextLine();
		counter ++;
		sc.close();
	}
	
	public double getDiscount(double subtotal) {
		this.total = subtotal - (total * 0.1);
		return total;
		
	}
}
class Paypals extends Pays {
	String email = "", passw = "";
	
	public Paypals (){
		
	}
	
	public void setDataPaypal () {
		
		System.out.println("Ingrese el e-mail");
		Scanner sc = new Scanner(System.in);
		this.email = sc.nextLine();
		System.out.println("Ingrese la contraseña: ");
		this.passw = sc.nextLine();
		counter ++;
		sc.close();
	}
	
	public double getDiscount (double subtotal, ArrayList<Items> itemSale){
		double a = 0, b = 0;
		int i= 0;
		Iterator<Items> itrItems = itemSale.iterator();
		while(itrItems.hasNext()){
			Items item = itrItems.next();
				if(i >= 1){
					b = item.getPrice();
					if (a > b )
						a = b;
				}
			else {
				a = item.getPrice();
				i++;
			}
		}
		this.total = subtotal - a;
		return total;
	}
	
}


