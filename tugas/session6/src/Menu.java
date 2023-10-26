import java.util.ArrayList;
import java.util.Scanner;


class Menu {
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Mahasiswa> mahasiswaArray = new ArrayList<Mahasiswa>(); 

	public static int printMenu(){
		int opt;
		System.out.println("=========[ Menu ]=========");
		System.out.println("1. Tambah mahasiswa");
		System.out.println("2. Tampilkan mahasiswa");
		System.out.println("0. Keluar");
		System.out.print("Pilih opsi >> ");
		opt = scan.nextInt();
		
		return opt;
	}	

	public void addMenu(){
		int amount;
		boolean addIsRunning = true;
		while(addIsRunning){
			System.out.print("Masukan jumlah mahasiswa [min 4] >> ");		
			amount = scan.nextInt();
			if(amount < 4){
				System.out.println("error: Jumlah mahasiswa kurang dari 4!");
			} else{
				int num = 1;
				while(amount != 0){
					double ipk;
					System.out.print("Masukan ipk mhs" + "-" + num +" >> ");
					ipk = scan.nextDouble();
					while (ipk < 0.0 || ipk > 4.0) {
						System.out.println("Ipk tidak valid");
						System.out.print("Masukan ipk lagi >> ");
						ipk = scan.nextDouble();						
					}					
					addMahasiswa(ipk);		
					System.out.println("data berhasil dimasukan");
					amount--;
					num++;
				}
				addIsRunning = false;
			}
		}
	}

	public void addMahasiswa(double argIpk){
		Mahasiswa maba = new Mahasiswa(argIpk);
		mahasiswaArray.add(maba);
	}

	public void displayMahasiswa(){
		int num = 1;
		for (Mahasiswa mahasiswa : mahasiswaArray){
			System.out.println(" Ipk mahasiswa " + num + " : " + mahasiswa.ipk);
			num++;
		}
		System.out.println("Ipk tertinggi   : " + findMaxIpk());
		System.out.println("Ipk terendah    : " + findMinIpk());
		System.out.println("Ipk rata - rata : " + findAvgIpk());
	}

	public double findMaxIpk(){
		double max = 0;
		for(Mahasiswa mahasiswa : mahasiswaArray) {
			if(max < mahasiswa.ipk) max = mahasiswa.ipk;
		}
		return max;
	}

	public double findMinIpk(){
		double min = 4;
		for(Mahasiswa mahasiswa : mahasiswaArray) {
			if(min > mahasiswa.ipk) min = mahasiswa.ipk;
		}
		return min;
	}

	public double findAvgIpk(){
		double total = 0;		
		for(Mahasiswa mahasiswa : mahasiswaArray) {
			total += mahasiswa.ipk;
		}
		return total / mahasiswaArray.size();
	}

	public static void main(String[] args) {
		Menu menu = new Menu();

		boolean isRunning = true;
		int opt;
		while (isRunning) {
			opt = printMenu();
			if(opt == 1) {
				menu.addMenu();
			} else if (opt == 2) {
				menu.displayMahasiswa();
			} else if (opt == 0) {
				System.exit(0);
			} else {
				System.out.println("Input tidak valid");
			}
		}
	}
}
