import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		String in = "", name = "";
		double price = 0, total= 0, subTotal = 0;
		Scanner sc = new Scanner(System.in);
		Sales sale = new Sales();
		ArrayList<Items> itemForSale = new ArrayList<Items>();
		ArrayList<Items> itemSale = new ArrayList<Items>();
		ArrayList<Items> offerL = new ArrayList<Items>();
		Items item = new Items();
		System.out.println("Ingrese items para vender");
		in = "si";
		while(in.compareTo("si") == 0){
			System.out.println("Ingrese un nombre para el item");
			name = sc.nextLine();
			if(name.equals(" ")){
				System.out.println("Ingrese un nombre para el item");
			}
			else {
				System.out.println("Ingrese el precio");
				price = sc.nextDouble();
				sc.nextLine();
				if(price > 0){
					Items art = new Items(name, price);
					itemForSale.add(art);
				}
				else {
				System.out.println("Ingrese valores permitidos");
				}
			}
			System.out.println("Desea seguir cargando items? Si / No");
			in = sc.nextLine();
			in = in.toLowerCase();	
			if (!in.equals("si") || !in.equals("no")){
				System.out.println("ingrese si o no");
			}
		}
		
		System.out.println("Bienvenido, que desea elegir: 1 - Ventas, 2 - Cargar Ofertas? Ingrese n° de opción");
		x = sc.nextInt();
		sc.nextLine();
			if (x == 1){
				in = "si";
				while (in.compareTo("si") == 0){
					item.displayItems(itemForSale);
					System.out.println("Elija un item: ");
					name = sc.nextLine();
					itemSale.add(sale.loadSale(itemForSale, name));
					subTotal = sale.getTotal(itemForSale, name);
					System.out.println("El total de la compra es: " + subTotal);
					System.out.println("Agregar otro item a la compra: si/no ");
					in = sc.nextLine();
					in = in.toLowerCase();
				}
			System.out.println("Ingrese el modo de pago: Efectivo, Tarjeta o Paypal");
			in = sc.nextLine();
			in = in.toLowerCase();
			if(in.equals("efectivo")){
				Pays pay = new Pays();
				total = pay.getDiscount(subTotal, itemSale);
				pay.setCounter();
				
				System.out.println("Obtuvo un descuento en su compra el total es: "+ total);
			}
			else {
				if(in.equals("tarjeta")){
					CreditCards credit = new CreditCards();
					credit.setDataCreditCard();
					total = credit.getDiscount(subTotal);
					System.out.println("El total es: " + total + "obtuvo 10% de descuento por su compra");
				}
			else {
				Paypals paypal =new Paypals();
				paypal.setDataPaypal();
				total = paypal.getDiscount(subTotal, itemSale);
				System.out.println("El total de su compra es:" + total + "obtuvo un descuento en su compra" );
			}
		}
	}
	else {
			if(x == 2){
				in = "si";
				while(in.compareTo("si") == 0){
				item.displayItems(itemSale);
				System.out.println("Ingrese el nombre del item para oferta");
				in = sc.nextLine();
				System.out.println("Ingrese el precio para la oferta");
				price = sc.nextDouble();
				sc.nextLine();
				offerL.add(item.loadOffer(itemForSale, name, price));
				System.out.println("Desea agregar mas ofertas? si/no");
				in = sc.nextLine();
				in = in.toLowerCase();
				
				}
				
			}
			else {
				System.out.println("Opción incorrecta");
				
			}
			item.displayOffers(offerL);
		
		}
		sc.close();
	}
}
