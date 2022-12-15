import java.util.Random;

public class TcGenerator {
    private String tcNo = "";
    int firstNumber = 0;
    public String randomGenerate() {
        Random random = new Random();
        firstNumber += random.nextInt(9) +1;


        for(int i =0;i<8;i++) {
            tcNo += random.nextInt(10);
        }
        tcNo= firstNumber+ tcNo;
        hesapla();
        return tcNo;
    }

    private void hesapla() {
        int evenNumbers = 0;
        for(int i=0;i<9;i+=2) {
            try {
            evenNumbers += Integer.parseInt(tcNo.substring(i,i+1)) * 7; }
            catch (NumberFormatException e) {
                System.out.println("Tc numarası stirng değildir");
            };
        }

        int oddNumbers = 0;
        for(int i=1;i<8;i+=2) {
            try {
            oddNumbers+= Integer.parseInt(tcNo.substring(i,i+1)) * 9; }
            catch (NumberFormatException e) {
                System.out.println("Tc numarası String değildir.");
            };
        }

        int tenthNumber = (evenNumbers + oddNumbers) %10;

        tcNo += tenthNumber;

        int eleventhNumber = 0;
        for(int i =0; i<10 ;i++) {
            eleventhNumber += Integer.parseInt(tcNo.substring(i,i+1));
        }
        eleventhNumber %=10;

        tcNo += eleventhNumber;
    }
}
