import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class App {
    static ArrayList<Order> orders = new ArrayList<Order>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;

        do {
            System.out.println("-------------------");
            System.out.println(" BUCKS COFFEE ");
            System.out.println("-------------------");
            System.out.println("1. Buy Coffee ");
            System.out.println("2. Check Out ");
            System.out.println("3. Exit ");
            System.out.println("-------------------");
            System.out.print("Pilihanmu: ");
            pilih = sc.nextInt();
            sc.nextLine(); // agar tak mendapat error setelah input integer;

            if (pilih == 1) {
                orders = buycoffee(orders);
            } else if (pilih == 2) {
                orders = checkout(orders);
            }

        } while (pilih != 3);

        orders.clear();
    }

    private static ArrayList<Order> buycoffee(ArrayList<Order> orders) {
        String nama, tipe, gula = null;
        int qty;

        System.out.print("Input nama kopi: ");
        nama = sc.nextLine();

        boolean ok;
        do {
            System.out.print("Input nama tipe [ Cappucino, Latte, Americano ]: ");
            tipe = sc.nextLine();
            ok = cekkopi(tipe);
        } while (ok == false);

        do {
            System.out.print("Tambah gula [ Y / T ]: ");
            gula = sc.nextLine();
            ok = cekgula(gula);
        } while (ok == false);

        System.out.print("Quantity: ");
        qty = sc.nextInt();

        // masukkan kedalam arraylist
        orders.add(new Order(nama, tipe, gula, qty));

        return orders;
    }

    private static ArrayList<Order> checkout(ArrayList<Order> orders) {
        int harga, jumlah, total = 0, bayar;

        System.out.println("Jumlah order: " + String.valueOf(orders.size()));
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-5s| %-15s| %-13s| %-13s| %-13s| %-13s| %-13s|",
                "No.", "Name", "Type", "Extra", "Qty", "Price", "Total");
        System.out.println(); // enter 1x
        System.out.println("----------------------------------------------------");

        int num = 1;
        for (int i = 0; i < orders.size(); i++) {
            harga = (orders.get(i).getQty() * orders.get(i).getName().length() * 100);

            if (orders.get(i).getSugar().equals("Y") ||
                    orders.get(i).getSugar().equals("y")) {
                jumlah = orders.get(i).getQty() * harga;
            } else {
                jumlah = (int) ((int) (orders.get(i).getQty() * harga) + (orders.get(i).getQty() * 0.03));
            }

            System.out.printf("| %-5s| %-15s| %-13s| %-13s| %-13s| %-13s| %-13s|",
                    num++,
                    orders.get(i).getName(),
                    orders.get(i).getType(),
                    orders.get(i).getSugar(),
                    orders.get(i).getQty(),
                    harga,
                    jumlah);

            System.out.println();

            total += jumlah;
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Total: " + total);

        boolean ok;
        do {
            System.out.println("Bayar: ");
            bayar = sc.nextInt();
            ok = cekbayar(total, bayar);
        } while (ok == false);

        orders.clear();

        System.out.println("Kembalian: " + abs(total - bayar));
        System.out.println("Succesfully add new order!");
        System.out.println("Press enter to continue..");

        sc.nextLine();
        sc.nextLine();

        return orders;
    }

    private static boolean cekkopi(String tipe) {
        boolean ok = false;

        if (tipe.equals("Cappucino") ||
                tipe.equals("Latte") ||
                tipe.equals("Americano")) {
            ok = true;
        }

        return ok;
    }

    private static boolean cekgula(String gula) {
        boolean ok = false;

        if (gula.equals("Y") ||
                gula.equals("y") ||
                gula.equals("T") ||
                gula.equals("t")) {
            ok = true;
        }

        return ok;
    }

    private static boolean cekbayar(int total, int bayar) {
        boolean ok = false;

        if (bayar >= total) {
            ok = true;
        }

        return ok;
    }

}