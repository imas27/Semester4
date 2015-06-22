//imasSetiawanRaharja (13410100227)
import java.util.*;

public class Utama
{
	public static Vector<UsrLogin> dataUser = new Vector<UsrLogin>();
	public static Scanner Scn = new Scanner(System.in);
	
	public static void main (String[]args)
	{
		dataUser.add(new UsrLogin("Imas","papakilo"));
		boolean loginSukses = false;
			if(!cekPass())
			{
				loginSukses = true;
			}
	}
	
	
	public static boolean cekPass() // Cek User dan Password
	{
		boolean Benar = false;
		int i = 0;
		do
		{
			System.out.println();
			System.out.println("-----Login-----");
			System.out.println();
			System.out.print("Masukkan Username \t: ");
			String userLgn = Scn.next();
			System.out.print("Masukkan Password \t: ");
			String passLgn = Scn.next();
			System.out.println();
			int j = 0;
			int idx=-1;
			do
			{
				if(dataUser.elementAt(j).checkPassUser(userLgn, passLgn))
				{
					System.out.println("Selamat Datang, Anda Masuk!");
						Benar = true;
						MenuAdmin();
				}
				else {
					System.out.println("Anda gagal Login!");
				}
				j++;
			}while(j < dataUser.size());
			i++;
		}while((Benar == true) && (i < 3));
		return Benar;
	}
	
	
	public static void MenuAdmin()
	{
		int pilih=0;
		do
		{
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println("            Main Menu         ");
			System.out.println("       TOKO BUAH RAHARJA	");
			System.out.println("--------------------------------");
			System.out.println("1. Tambah Transaksi Penjualan");
			System.out.println("2. Maintenance Barang");
			System.out.println("3. Laporan Omset saat ini");
			System.out.println("4. Lihat data Barang");
			System.out.println("5. Cari Data Barang");
			System.out.println("6. Exit");
			System.out.print  ("Masukkan Pilihan Anda (1-6): ");
			pilih=Scn.nextInt ();
			switch(pilih)
			{
				case 1:
					ManageBuah.Transaksi();;break;
				
				case 2:
					ManageBuah.ManajemenBuah();break;
				
				case 3:
					ManageBuah.LaporanPenjualan();break;
				
				case 4:
					ManageBuah.LihatBuah();break;
				
				case 5:
					//lihat data barang
					ManageBuah.PencarianBuah();break;
					
				default:break;
			}
		}while(pilih<6);
	}
}
