import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        // PassWord Complex
        boolean pctunu = false;
        boolean pctdoi = false;
        boolean pcttrei = false;

        System.out.println("Bine ai venit la Verificatorul de Parole!");
        System.out.println("Scrie o parola care sa aiba urmatoarele caracteristici:");
        System.out.println("1. Sa fie intre 6 si 20 de caractere");
        System.out.println("2. Trebuie sa contina cel putin o litera mica, o litera mare si un numar");
        System.out.println("3. Nu se accepta caractere repetate de mai mult de 3 ori.");
        Scanner wordScaner = new Scanner(System.in);

        String pass = wordScaner.nextLine();
        //testare marime parola
        if (pass.length() < 6) {
            System.out.println("Prea Mica");
        } else if (pass.length() > 20) {
            System.out.println("Prea Mare");
        } else {
            System.out.println("Punct 1 OK");
            pctunu = true;
        }
        //testare daca parola are toate tipurile de caractere
        //String normalChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
        boolean litereMici = false;
        boolean litereMari = false;
        boolean numere = false;
        if (pass.matches("(?=.*[a-z]).*")) {
            litereMici = true;
        } else {
            System.out.println("Lipsesc literele mici");
        }
        if (pass.matches("(?=.*[A-Z]).*")) {
            litereMari = true;
        } else {
            System.out.println("Lipsesc literele mari");
        }
        if (pass.matches("(?=.*[0-9]).*")) {
            numere = true;
        } else {
            System.out.println("Lipsesc Numere");
        }

        if (litereMari == true && litereMici == true && numere == true) {
            System.out.println("Punct 2 OK");
            pctdoi = true;
        }
        
        //compar caracterele
        for (int i = 2; i < pass.length(); i++) {
            //System.out.println(pass.charAt(i));
            if (pass.charAt(i - 1) == pass.charAt(i)) {
                if (pass.charAt(i - 2) == pass.charAt(i - 1))
                    System.out.println("Avem o repetitie de 3 caractere consecutive: " + pass.charAt(i - 2) + "(" + (i - 2) + ") - " + pass.charAt(i - 1) + "(" + (i - 1) + ") - " + pass.charAt(i) + "(" + (i) + ")");
                pcttrei = false;

            } else {
                pcttrei = true;
            }
        }

        if (pcttrei == true) {
            System.out.println("Punct 3 OK");
        } else {
            System.out.println("Explicatie: X=caracterul (pozitia caracterului in parola)");
        }

        if (pctunu == true && pctdoi == true && pcttrei == true) {
            System.out.println("Parola indeplineste toate cele 3 conditii !");
        }
        
       //cred ca asa ar trebuii la ultima cerinta, nu mi-a fost foarte clar ceea ce ar fi trebuit,
        //si m-am gandit ca trebuie sa fac o verificare a conditiilor pe a vedea daca poate sa existe o schimbare a parolei
        if(pass.length()<6 && pass.length()>20 && litereMici == true && litereMari == true && numere == true && pcttrei == true)
        {
        	System.out.println("Insertia, stergere si inlocuirea unui caracter poate fi considerata ca o schimbare!");
        }
        else
        {
        	System.out.println("Insertia, stergerea si inlocuirea unui caracter nu se poate efectua deoarece nu se respecta criterile!");
        }

    }
}
