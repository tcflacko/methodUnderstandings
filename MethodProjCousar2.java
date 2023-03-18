import java.util.Scanner;

//append your last name to the class name, and saveAs the file as the same thing
class MethodProjCousar2 {

    // insert the integer in the index position and move all elements right (the
    // 9thindex will fall off)
    // int[] array = { 21, 41, 25, 89, 36, 80, 57, 64, 91, 75 };

    public static void insertValue(int array[], int num, int index) {

        int len = array.length;

        int somethingdifferent = index;

        for (int i = len - 1; i > index; i--) {

            array[i] = array[i - 1];

        }
        array[somethingdifferent] = num;

    }

    // reverse the order of the elements

    public static void reverse(int rev[]) {

        int len = rev.length;

        // Declare

        int thisIsVarC;

        int thisIsVarA;

        int thisIsVarB;

        for (int i = 0; i < len / 2; i++) {

            // Assign

            thisIsVarA = rev[i];

            thisIsVarB = rev[len - 1 - i];

            thisIsVarC = 0;

            // change them using = C.A.A.B.B.C

            thisIsVarC = thisIsVarA;

            thisIsVarA = thisIsVarB;

            thisIsVarB = thisIsVarC;

        }

    }

    // print the array

    public static void printit(int x[], String s) {

        int lengthOfArray = x.length;

        for (int i = 0; i < lengthOfArray; i++) {

            // I added commas to each on but the last

            if (i < lengthOfArray - 1) {

                System.out.print(x[i] + ", ");

            } else {

                System.out.print(x[i] + " ");
            }

        }

    }

    // randomize() method will fill in elements with random numbers from 10 - 99

    public static void randomize(int x[]) {

        int apologizeAndWOnderIfItIsTooLate = x.length;

        int i;

        for (i = 0; i < apologizeAndWOnderIfItIsTooLate; i++) {

            double spaghetti = (Math.random() * 90) + 10;

            x[i] = (int) spaghetti;

        }

    }

    /*
     * you do not need to do anything to this main method,
     * 
     * you need to make the methods above that they call work.
     * 
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] randomNums = new int[10];

        // populate with random numbers by calling the method

        randomize(randomNums);

        // display the random numbers by calling the method

        printit(randomNums, "");

        // reverse the array element order

        reverse(randomNums);

        // display the random numbers by calling the method

        printit(randomNums, " reversed");

        // ask for two integers;

        // inserted number and insert index

        System.out.println("\nPlease give me an integer value between 0 - 9");

        int num = scan.nextInt();

        // insert point index

        System.out.println("Please give me an insert point between 0 - 9 ");

        int index = scan.nextInt();

        // insert the value in the index point by calling the method

        insertValue(randomNums, num, index);

        // display the final result

        printit(randomNums, " final result");

        scan.close();

    }// EOM

}// EOC