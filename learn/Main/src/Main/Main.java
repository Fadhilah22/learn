import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Character;

class  Main {
    public ArrayList<String> encodedString;
    public static Scanner scan;
    public static Encoding encode;
    public static boolean bool;

    public Main(){
        this.encodedString = new ArrayList<String>();
        this.scan = new Scanner(System.in);
        this.encode = new Encoding();
    }

    public void printMenu(){
        System.out.println("===== [ Menu ] =====");
        System.out.println("1. Encode");
        System.out.println("2. Decode");
        System.out.println("3. Show saved");
        System.out.println("0. Exit");
        System.out.print("Select option >> ");
    }

    public void showAllEncoded(){
        System.out.println("Encoded strings");
        System.out.println("====================");
        int no = 1;
        for(String encoded : encodedString){
            System.out.printf("%-5d%-15s\n", no, encoded);
            no++;
        }
    }

    public void current(){
        int option;
        boolean isRunning = true;
        while(isRunning){
            printMenu();
            option = scan.nextInt();
            if(option == 1){
                // encode
                String userInput;
                String encoded;

                System.out.print("Enter string input >> ");
                scan.nextLine();
                userInput = scan.nextLine();

                encoded = encode.encodeStringMethod1(userInput);
                System.out.println("encoded >> " + encoded);

                bool = true;
                String save;
                while(bool){
                    System.out.print("Would you like to save this [Y/n]? ");
                    save = scan.nextLine();
                    if(Character.toUpperCase(save.toCharArray()[0]) == 'Y'){
                        encodedString.add(encoded);
                        bool = false;
                    } else if (Character.toUpperCase(save.toCharArray()[0]) == 'N') {
                        bool = false;
                    } else {
                        System.out.println("select valid option");
                    }
                }

            } else if (option == 2){
                // CHECK POINT !!!!!!!!
                bool = true;
                int innerOption;

                while(bool){
                    System.out.println("1. Decode existing string");
                    System.out.println("2. input string");
                    System.out.println("0. back");
                    System.out.print("Select option >> ");
                    scan.nextLine();
                    innerOption = scan.nextInt();

                    if (innerOption == 1){
                        int stringIndex;
                        showAllEncoded();

                        System.out.print("Select string no >> ");
                        scan.nextLine();
                        stringIndex = scan.nextInt();
                        if (stringIndex > encodedString.size()) {
                            System.out.println("Index out of reach (high)");
                        } else if(stringIndex < 0) {
                            System.out.println("Index out of reach (low)");
                        } else if(encodedString.isEmpty()){
                            System.out.println("No saved string");
                        } else {
                            String targetString = encodedString.get(stringIndex-1);
                            System.out.println("Decoded string index "
                                    + stringIndex
                                    + " >> "
                                    + encode
                                        .decodeStringMethod1(targetString));
                        }

                    } else if (innerOption == 2){

                    } else if(innerOption == 0) {
                        bool = false;
                    } else {
                        System.out.println("Select valid option!");
                    }
                }
            } else if(option == 3){
                showAllEncoded();
            } else if(option == 0) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.current();
    }
}
