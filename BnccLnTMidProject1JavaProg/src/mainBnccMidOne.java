import java.util.Scanner;
import java.util.Vector;

public class mainBnccMidOne {
	int menu;
	Scanner scan = new Scanner (System.in);
	
	Vector<String> nameData = new Vector<>();
	Vector<String> genderData = new Vector<>();
	Vector<String> kodeData = new Vector<>();
	Vector<String> jabatanData= new Vector<>();
	Vector<Double> gajiData = new Vector<>();
	
	public void printMenu() {
		do {
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			System.out.println("ENTER to return");
			menu = scan.nextInt(); scan.nextLine();
			
			switch (menu) {
			case 1:
				inputData();
				break;
			case 2:
				viewData();
				break;
			case 3:
				updateData();
				break;
			case 4:
				deleteData();
				break;
			}
		} while (menu != 5);
	}
	
	public void inputData() {
		String namaKaryawan, jenisKelamin, jabatan;
		String kodeKaryawan= "";
		Double gajiKaryawan = null;
		
		do {
			System.out.println("Input nama karyawan [>= 3 huruf]: ");
			namaKaryawan = scan.nextLine();
		} while (namaKaryawan.length() < 3);
		
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki || Perempuan] (Case sensitive): ");
			jenisKelamin = scan.nextLine();
		} while (!(jenisKelamin.equals("Laki-laki") || jenisKelamin.equals("Perempuan")));
		
		
		do {
			System.out.println("Input jabatan [Manager || Supervisor || Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (! (jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		
		kodeKaryawan += (char)(Math.random()*26+'A');
		kodeKaryawan += (char)(Math.random()*26+'A') + "-";
		for (int i = 0; i < 4; i++) {
			kodeKaryawan += (int)(Math.random()*10);
		} System.out.println("Berhasil nemabahkan kawyaran dengan id  " + kodeKaryawan);
		
		
		int managerCount = 0;
		for (int i = 0; i < jabatanData.size(); i++) {
			if (jabatanData.get(i).equals("Manager")) {
				managerCount++;
			}
		}
		// jika anggota dengan jabatan yg sama lebih dari 3 (4..)
		// maka naikkkan gaji 3 orang pertama
		if (managerCount > 3) {
			for (int i = 0; i < gajiData.size()-1; i++) {
				// set gaji menjadi gaji asli + 10% gaji
				gajiData.set(i, gajiData.get(i) + ( gajiData.get(i)* 10 / 100));
			}
		}
//		jabatanData.add("Manager");
//		jabatanData.add("Supervisor");
//		jabatanData.add("Admin");
//		
//		gajiData.add(10.0);
//		gajiData.add(7.5);
//		gajiData.add(5.0);	
		
		System.out.println("Gaji sebelum bonus : ");
		for (int i = 0; i < jabatanData.size(); i++) {
			System.out.println((i+1) + ". " + jabatanData.get(i) + " | " + gajiData.get(i));
		}
//		bonus();
		System.out.println("\nGaji sesudah bonus : ");
		for (int i = 0; i < jabatanData.size(); i++) {
			System.out.println((i+1) + ". " + jabatanData.get(i) + " | " + gajiData.get(i));
		}
		nameData.add(namaKaryawan);
		genderData.add(jenisKelamin);
		kodeData.add(kodeKaryawan);
		jabatanData.add(jabatan);	
		gajiData.add(gajiKaryawan);
	}

	public void viewData() {
		if(nameData.isEmpty()) {
			System.out.println("\n-Data is Empty-");
		}else {
			for (int i = 0; i < nameData.size()-1; i++) {
				for (int j = 0; j < nameData.size()-1; j++) {
					char c1 = nameData.get(j).charAt(0);
					char c2 = nameData.get(j+1).charAt(0);
					if(c1 > c2) {
						// switch kodeData
						String tempKode = kodeData.get(j);
						kodeData.set(j, kodeData.get(j+1));
						kodeData.set(j+1, tempKode);
						// switch nameData
						String tempName = nameData.get(j);
						nameData.set(j, nameData.get(j+1));
						nameData.set(j+1, tempName);
						// switch genderData
						String tempGender = genderData.get(j);
						genderData.set(j, genderData.get(j+1));
						genderData.set(j+1, tempGender);
						// switch jabatanData
						String tempJabatan = jabatanData.get(j);
						jabatanData.set(j, jabatanData.get(j+1));
						jabatanData.set(j+1, tempJabatan);
						// switch gajiData
						Double tempGaji = gajiData.get(j);
						gajiData.set(j, gajiData.get(j+1));
						gajiData.set(j+1, tempGaji);
						}
					}
				}
			// view data
				for (int i = 0; i < nameData.size(); i++) {
					System.out.println("\nNo. " + (i+1));
					System.out.println("Kode Karyawan	: " + kodeData.get(i));
					System.out.println("Nama Karyawan   : " + nameData.get(i));
					System.out.println("Jenis Kelamin 	: " + genderData.get(i));
					System.out.println("Jabatan      	: " + jabatanData.get(i));
					System.out.println("Gaji Karyawan 	: " + gajiData.get(i));
					}
				}
			}
	public void updateData() {
		viewData();
		int update;
		
		do {
			System.out.print("\nInput candidate to be updated [1.."+ nameData.size() +"] : ");
			update = scan.nextInt();
			scan.nextLine();
		}while(update < 0 || update > nameData.size());
		
		if(update != 0) {
			String namaKaryawan, jenisKelamin, jabatan;
			String kodeKaryawan= "";
			int age;
			do {
				System.out.println("Input nama karyawan [>= 3 huruf]: ");
				namaKaryawan = scan.nextLine();
			} while (namaKaryawan.length() < 3);
			
			do {
				System.out.println("Input jenis kelamin [Laki-laki || Perempuan] (Case sensitive): ");
				jenisKelamin = scan.nextLine();
			} while (!(jenisKelamin.equals("Laki-laki") || jenisKelamin.equals("Perempuan")));
			
			
			do {
				System.out.println("Input jabatan [Manager || Supervisor || Admin] (Case Sensitive): ");
				jabatan = scan.nextLine();
			} while (! (jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
			
			
			kodeKaryawan += (char)(Math.random()*26+'A');
			kodeKaryawan += (char)(Math.random()*26+'A') + "-";
			for (int i = 0; i < 4; i++) {
				kodeKaryawan += (int)(Math.random()*10);
			} System.out.println("Berhasil mengupdate kawyaran dengan id  " + kodeKaryawan);
			
			
			nameData.set(update-1, namaKaryawan);
			genderData.set(update-1,jenisKelamin);
			kodeData.set(update-1,kodeKaryawan);
			jabatanData.set(update-1,jabatan);
			gajiData.set(update-1, gajiKaryawan);
		}
	}
	
	public void deleteData() {
		viewData();
		int delete;
		do {
			System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
			delete = scan.nextInt();
		}while(delete < 0 || delete > nameData.size());
		if(delete != 0) {
			nameData.remove(delete-1);
			genderData.remove(delete-1);
			kodeData.remove(delete-1);
			jabatanData.remove(delete-1);
			gajiData.remove(delete-1);
			System.out.println("Karyawan dengan kode" + kodeData + "telah dihapus");
		}
	}
	
	public mainBnccMidOne() {
		printMenu();
	}

	public static void main(String[] args) {
		new mainBnccMidOne();
	}
}