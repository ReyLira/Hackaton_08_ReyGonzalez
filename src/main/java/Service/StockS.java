package Service;

public class StockS {

    @SuppressWarnings("unchecked")
    public static boolean validaStock(int stock, int Cantidad) {

        if (stock == 0 || stock < Cantidad) {
            System.out.println("No hay  stock");
            return true;
        } else {
            System.out.println("Hay stock");
            return false;
        }

    }
}
