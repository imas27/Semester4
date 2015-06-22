import java.util.*;

public class ManageBuah
{
	public static Vector <dBuah> dbBuah = new Vector<dBuah>();
	public static Vector <UsrLogin> dataUser = new Vector<UsrLogin>();
	public static Vector idTransaksi = new Vector();
	public static Scanner Scn = new Scanner(System.in);
	public static String [][] tblBuah= {
		{"B01","Apel","5000"},
		{"B02","Jeruk","5000"},
		{"B03","Jambu","6000"},
		{"B04","Alpukat","7000"},
		{"B05","Pisang","6000"},
		{"B06","Sirsat","6000"},
		{"B07","Ceri","6000"},
		{"B08","Durian","8000"},
		{"","",""}
		};
	public static int HARGA[]={5000,5000,6000,7000,6000,6000,6000,8000,0};
	public static int omset[] ={0,0,0,0,0,0,0,0,0,0};

	public static void ManajemenBuah()
	{	
		int pilih = 0;	
		do
		{
			System.out.println();
			System.out.println("================================");
			System.out.println(" 		Menu Maintenance Buah	");
			System.out.println(" 		TOKO BUAH RAHARJA	");
			System.out.println("================================");
			System.out.println();
			System.out.println("1. Tambah Data Buah");
			System.out.println("2. Lihat Data Buah");
			System.out.println("3. Ubah data buah");
			System.out.println("4. Hapus Data Buah");
			System.out.println("5. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-5) : ");
			pilih = Scn.nextInt();
			System.out.println();
			switch(pilih)
			{
				case 1 : TambahBuah();break;
				
				case 2 : LihatBuah();break;
				
				case 3 : ubahData ();break;
				
				case 4 : HapusBuah();break;
				
				default:break;
			}
		}while(pilih < 5);
	}
	
	public static void ubahData()
	{
		System.out.println("=======================");
        System.out.println("\t Ubah Data ");
        System.out.println("=======================");
        System.out.print("Masukkan ID yang datanya akan edit : ");
        String id = Scn.next();
        for(int j=0;j<tblBuah.length;j++)
           { 
            if(tblBuah[j][0].equals(id))
            {
			System.out.print("Nama \t= " );
            tblBuah[j][1]=Scn.next();
            System.out.print("Harga\t= " );
            tblBuah[j][2]=Scn.next();
            break; 
            }
           } 
	}
	
	//tambah(insert) data
	public static void TambahBuah()
	{
		int i=8;
		System.out.println("     Tambah Data Buah Baru     ");
		System.out.println("-------------------------------");
		while(true)
        {
		System.out.print("ID \t= " );
		tblBuah[i][0]=Scn.next();
        System.out.print("Nama Buah \t= " );
        tblBuah[i][1]=Scn.next();
        System.out.print("Harga \t= " );
        tblBuah[i][2]=Scn.next();
        i++;
        System.out.println();
        System.out.print("Ingin Tambah buah ? (y/n) = " );
        String tambah=Scn.next();
            if (tambah.equalsIgnoreCase("n"))
            {break;}
           System.out.println();
        }
	}
	
	//lihat seluruh data
	public static void LihatBuah()
	{
		System.out.println("ID | Nama | Harga");
		int angka=0;
		for(int k=0;k<tblBuah.length;k++)
			{
				System.out.println(tblBuah[k][0]+" | "+tblBuah[k][1]+" | "+tblBuah[k][2]);
				angka=1;
			}
	}
	
	//hapus buah
	public static void HapusBuah()
	{
		System.out.println("=======================");
        System.out.println("\t Hapus Data ");
        System.out.println("=======================");
        System.out.print("Masukkan ID yang datanya akan diHapus : ");
        String id = Scn.next();
          for(int i=0;i<tblBuah.length;i++)
          { 
			for(int j=0;j<tblBuah[i].length;j++)
            if(tblBuah[i][j].equals(id))
            {
				//tblBuah.remove(i);break;
				
            }
          }
	}
	
	public static int cariIdxnmBuah(String nama)
	{
		int i=0;
		while(i<tblBuah.length)
		{
			if (tblBuah[i][1].contains(nama))
				return i;
				i++;
		}
	return -1;
	}
	
	public static int cariIdx(String id)
	{
		int i=0;
		while(i<tblBuah.length)
		{
			if (tblBuah[i][0].contains(id))
				return i;
				i++;
		}
		return -1;
	}
	
	
	
	//Transaksi
	public static void Transaksi()
	{
		Date date = new Date();
		int index=0;
		String trans="";
		String tmbh="";
		double ttl=0;
			System.out.println("-------------------");
			System.out.println("Transaksi Penjualan");
			System.out.println("-------------------");
			System.out.println("Tanggal dan WAktu : "+date.toString());
			System.out.print("TR ke- : ");
			trans=Scn.next();
			idTransaksi.add(trans);
			do
			{
				System.out.print("Masukan nama Barang : ");
				String buah=Scn.next();
				//cari data
				int idx=-1;//data tidak ketemu - out of range -
				for(int i=0;i<tblBuah.length;i++){
					if(tblBuah[i][1].equalsIgnoreCase(buah)){
					idx=i;
					break;
					}
				}
				if(idx!=-1){
				  System.out.println("Harga " + buah + ": Rp." + tblBuah[idx][2]);
				  System.out.print("Jumlah " + buah + " yang dibeli = ");
				  int jml=Scn.nextInt();
				  int total=jml*HARGA[idx];
				  omset[idx] +=jml;
				  System.out.println("Total = Rp." + total);
				  System.out.println();
				  System.out.print("Apakah ada Transaksi lagi ?: ");
				  tmbh=Scn.next();
				  System.out.println();
				}else
				{
				  System.out.println("==================================");
				  System.out.println("Buah tidak tersedia !!");
				}
			}while(tmbh.equalsIgnoreCase("Y"));
	}
	
	//omset saat ini
	public static void LaporanPenjualan()
	{
			Date date = new Date();
			double totalOmset=0;;
			System.out.println("ID Transaksi#: "+idTransaksi);
			System.out.println("Tanggal dan Waktu : "+date.toString());
			System.out.println("-----------------------------------------------------");
			System.out.println("Nama Buah | Kuantitas \t SubTotal");
			System.out.println("-----------------------------------------------------");
			
			for(int i=0; i<tblBuah.length;i++)
			{
				System.out.println(tblBuah[i][1]+"\t"+omset[i]+"\t"+omset[i]*HARGA[i]);
				totalOmset +=(omset[i]*HARGA[i]);
			}
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("Total Keseluruhan : Rp. " + totalOmset);
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("");
		
	}
	
	//pencarian data
	public static void PencarianBuah()
	{
		int pilih = 0;
		
		do
		{
			System.out.println();
			System.out.println("================================");
			System.out.println(" 	   Menu Pencarian Data	");
			System.out.println("        TOKO BUAH RAHARJA	");
			System.out.println("================================");
			System.out.println();
			System.out.println("1. Pencarian berdasarkan ID");
			System.out.println("2. Pencarian berdasarkan Nama");
			System.out.println("3. Pencarian berdasarkan Harga");
			System.out.println("4. Keluar");
			System.out.print("Masukkan Pilihan Anda (1-4) : ");
			pilih = Scn.nextInt();
			System.out.println();
			switch(pilih)
			{
				case 1 : cariID();break;
				
				case 2 : cariNama();break;
				
				case 3 : cariHarga();break;
				
				default:break;
			}
		}while(pilih < 4);
	}
	//pencarian melalui ID
	public static void cariID()
	{
	int angka=0;
		System.out.print("Masukan ID: ");
		String id=Scn.next();
		System.out.println("| ID | Nama Buah | Harga");
		for(int k =0;k<tblBuah.length;k++){
		if (tblBuah[k][0].equalsIgnoreCase(id))
			{					
				System.out.println("|"+tblBuah[k][0]+" | "+tblBuah[k][1]+" | "+tblBuah[k][2]);
				angka=1;
			}else
			{
			}
			}
			if(angka==1)
			{
			}
			else
			{ 
				System.out.println("Data Tidak Ada ");
			}
			
	}
	//pencarian berdasarkan Nama
	public static void cariNama()
	{
		int angka=0;
		System.out.print("Masukan Nama Barang: ");
		String nama=Scn.next();
		System.out.println("| ID | Nama Buah | Harga");
		for(int k =0;k<tblBuah.length;k++){
			if(tblBuah[k][1].toLowerCase().contains(nama))
			{
			System.out.println("|"+tblBuah[k][0]+" | "+tblBuah[k][1]+" | "+tblBuah[k][2]);
			angka=1;
			}else
			{
			}
			}
			if(angka==1)
			{
			}else
			{ 
				System.out.println("Data Tidak Ada ");
			}
		
	}
	//pencarian berdasarkan harga
	public static void cariHarga()
	{
		int angka=0;
		System.out.print("Masukan Harga: ");
		String harga=Scn.next();
		System.out.println("| ID | Nama Buah | Harga");
		for(int k =0;k<tblBuah.length;k++){
			if(tblBuah[k][2].equalsIgnoreCase(harga))
			{
			System.out.println("|"+tblBuah[k][0]+" | "+tblBuah[k][1]+" | "+tblBuah[k][2]);
			angka=1;
			}else
			{
			}
			}
			if(angka==1)
			{
			}else
			{ 
				System.out.println("Data Tidak Ada ");
			}
		
	}
}
