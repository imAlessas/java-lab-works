import java.util.Scanner;

public class DeviazioneStandard{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Inserisci un codice che una volta inserito bloccherà il flusso di numeri: ");
        String code = keyboard.nextLine();

        double num=0, somma=0, sommaq=0;
        int cont=0;
        String s="";
        boolean flag = false;

        do{
            try {
                System.out.print("Inserisci un numero: ");
                s = keyboard.nextLine();
                num = Double.parseDouble(s);

                cont++;                
                somma+=num;
                sommaq=sommaq+(Math.pow(num,2));

            } catch (NumberFormatException e) {
                if(!s.equals(code))
                    System.out.println("Il numero inserito non è valido!");
                flag = true;
            }
        }while(!flag);

        keyboard.close();

        if(s.equals(code)){
            if(cont!=0){
                System.out.print("Media dei numeri: " + (somma/cont)+".\n");
    
                if(cont>1){
                    double dStandard = Math.sqrt((sommaq-Math.pow(somma,2)/cont)/(cont-1));
                    System.out.print("Deviazione standard: "+dStandard);
                }else System.out.println("Deviazione standard: 1");
    
            }else{
                System.out.println("Media dei numeri: 0");
                System.out.println("Deviazione standard: 0");
            }
        }
    }
}