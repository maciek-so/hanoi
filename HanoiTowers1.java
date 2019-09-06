import java.util.Scanner;

class Wieze {
int tab[][];
int kije;
int krazki;
int pwolne[];
boolean wygrana = false;
	
	Wieze() {
		kije=3;
		krazki=4;
 		tab = new int[kije][krazki];
		pwolne= new int[kije];
	}
	
	void printCurrent() {
		System.out.println("");
		for(int i=krazki; i>0; i--) {
			for(int j=0; j<kije; j++) {
				if(tab[j][i-1]==0) 
				System.out.print("  |");
				else
				System.out.print("  "+tab[j][i-1]);
			}
			System.out.println("");
		}
			System.out.println("-----------");
			System.out.println("  1  2  3  ");
			//System.out.println("##"+pwolne[0]+"##"+pwolne[1]+"##"+pwolne[2]+"##");
			System.out.println("");
	}
	
	String przeloz(int z, int na) {
		System.out.println("Przenosisz krazek z palika "+z+" na palik "+na+"...");
		if(z==na) {
			System.out.println("Cos w mozgu nie styka? Taki ruch niczego nie zmienia!");
			return "Zablokowano błąd użytkownika!";
		}
		if(pwolne[z-1]<=0) {
			System.out.println("Nie mozna zdjac krazka z pustego palika!");
			return "Zablokowano błąd użytkownika!";
		}

		if (pwolne[na-1]>0) {
			if (tab[z-1][pwolne[z-1]-1]>tab[na-1][pwolne[na-1]-1]) {
				System.out.println("Nie mozna ukladac wiekszego krazka na mniejszym");
				return "Zablokowano błąd użytkownika!";
			}
		}

		if(pwolne[na-1]>=krazki) {
			System.out.println("Palik przepelniony!");
			return "Zablokowano błąd użytkownika!";
		}
		tab[na-1][pwolne[na-1]]=tab[z-1][pwolne[z-1]-1];
		tab[z-1][pwolne[z-1]-1]=0;
		pwolne[z-1]--;
		pwolne[na-1]++;
		if(pwolne[1]==4 || pwolne[2]==4) {
			System.out.println("");	
			this.printCurrent();
			System.out.println("");	
			System.out.println("##################");
			System.out.println("#                #");
			System.out.println("#   YOU WIN :)   #");
			System.out.println("#                #");
			System.out.println("##################");
			wygrana = true;
			return "Wygrana!!!";
		}
		this.printCurrent();
		//System.out.println("Po przelozeniu plansza wyglada jak powyzej.\n");
		return "OK!";
	} 
}


// główny program
class HanoiTowers1 {
  public static void main(String args[]) {
	
	int n=3;
	String st;
	char ch;
    Scanner in = new Scanner(System.in);

	Wieze w = new Wieze();
	w.tab[0][0]=4;
	w.tab[0][1]=3;
	w.tab[0][2]=2;
	w.tab[0][3]=1;
	w.pwolne[0]=4;
	System.out.println("");
	System.out.println("*****###################______ H A N O I ______###################*****");
	System.out.println("");
	System.out.println("Celem gry jest przelozenie stosu krazkow z jednego palika na inny.");
	System.out.println("Obowiazuja przy tym nastepujace zasady:");
	System.out.println("- w jednym ruchu mozna przeniesc tylko jeden krazek z samej gory wybranego stosu na gore innego stosu,");
	System.out.println("- na kazdym ze stosow (na kazdym paliku) ponad krazkiem wiekszym moga znajdowac sie wylacznie krazki mniejsze.");
	System.out.println("");
	System.out.println("Obsluga gry:");
	System.out.println("- postepuj wg instrukcji wyswietlanych na ekranie,");
	System.out.println("- aby opuscic gre w dowolnym momencie wprowadz 'q'.");
	System.out.println("");
	System.out.println("Stan gry (planszy) jest wyswietlany na ekranie przed kazdym ruchem gracza.");
	System.out.println("");	
	System.out.println("Aby rozpoczac nacisnij 's'.");
	st = in.nextLine();
	ch = st.charAt(0);
	if(ch == 's' || ch == 'S') {

		//poprawnie uruchomiona gra:
		int z = 0;
		int na = 0;
		boolean inAccepted = false;
		w.printCurrent();
		while(w.wygrana == false) {		
		while(inAccepted == false) {
			System.out.println("Z ktorego palika chcesz przelozyc krazek?");
			st = in.nextLine();
			ch = st.charAt(0);
			if(ch=='q') return;
			switch(ch) {
			case '1':
				inAccepted = true;
				break;
			case '2':
				inAccepted = true;
				break;
			case '3':
				inAccepted = true;
				break;
			default:
				System.out.println("Ogarnij sie i wpisz poprawny numer palika.");
				break;
		}
		}
		inAccepted = false;
		switch(ch) {
			case '1':
				z=1;
				break;
			case '2':
				z=2;
				break;
			case '3':
				z=3;
				break;
			default:
				System.out.println("No wez sie w garsc!");
				break;
		}
		System.out.println("Na ktory palik chcesz przelozyc krazek?");
		st = in.nextLine();
		ch = st.charAt(0);
		if(ch=='q') return;
		switch(ch) {
			case '1':
				na=1;
				break;
			case '2':
				na=2;
				break;
			case '3':
				na=3;
				break;
			default:
				System.out.println("No wez sie!");
				break;
		}
		w.przeloz(z,na);
	}
	}
	else {
		System.out.println("Nie wyglupiaj sie, '"+ch+"' to nie 's'");
		System.out.println("Game over");
	}
  }
}