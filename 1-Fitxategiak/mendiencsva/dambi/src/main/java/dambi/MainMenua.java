package mendiencsva;

/**
 * Hello world!
 *
 */
public class MainMenua 
{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENDIEN MENUA");
            System.out.println("==============");
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bisitatu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    met1();
                    break;
                case 2:
                    met2();
                    break;
                case 3:
                    met3();
                    break;
                case 4:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
}

public static void met1(){
    //readline erabili
    
}

public static void met2(){
    
}

public static void met3(){
    System.out.println("Aukeratu zein probintziatako mendiak esportatu nahi dituzun: ");
    System.out.println("");
    System.out.println("1.- Arabako mendiak esportatu (Araba.csv)");
    System.out.println("2.- Bizkaiko mendiak esportatu (Bizkaia.csv)");
    System.out.println("3.- Gipuzkoako mendiak esportatu (Gipuzkoa.csv)");
    System.out.println("3.- Nafarroako mendiak esportatu (Nafarroa.csv)");
}

}
