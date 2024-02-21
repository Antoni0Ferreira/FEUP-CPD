import java.util.Scanner;

public class MatrixProduct {

    public static void prodMatrix(int lines, int cols){
        double pha[] = new double[lines * lines];
        double phb[] = new double[lines * lines];
        double phc[] = new double[lines * lines];
        long time1, time2;

        for (int i = 0; i < lines; i++){
            for (int j = 0; j < cols; j++){
                pha[i * lines + j] = 1.0;
            }
        }

        for (int i = 0; i < lines; i++){
            for (int j = 0; j < cols; j++){
                phb[i * cols + j] = (double)(i + 1);
            }
        }

        time1 = System.currentTimeMillis();

        for (int i = 0; i < lines; i++){
            for (int j = 0; j < cols; j++){
                double temp = 0.0;
                for(int k = 0; k < lines; k++){

                    temp += pha[i*lines+k] * phb[k*cols+j];
                }
                phc[i*lines + j] = temp;
            }
        }

        time2 = System.currentTimeMillis();

        System.out.print("Result matrix: \n");

        for (int i = 0; i < 1; i++){
            for (int j = 0; j < Math.min(10,cols); j++){
                System.out.print(phc[j] + " ");
            }
        }

        System.out.printf("\nTime: %3.3f seconds\n\n", (double)(time2 - time1)/1000);
        System.out.println();

    }

    public static void prodMatrixLine(int lines, int cols){
        double pha[] = new double[lines * lines];
        double phb[] = new double[lines * lines];
        double phc[] = new double[lines * lines];
        long time1, time2;

        for (int i = 0; i < lines; i++){
            for (int j = 0; j < cols; j++){
                pha[i * lines + j] = 1.0;
            }
        }

        for (int i = 0; i < lines; i++){
            for (int j = 0; j < cols; j++){
                phb[i * cols + j] = (double)(i + 1);
            }
        }

        time1 = System.currentTimeMillis();

        for (int i = 0; i < lines; i++){
            for (int k = 0; k < lines; k++){
                for(int j = 0; j < cols; j++){

                    phc[i*lines + j] += pha[i*lines+k] * phb[k*cols+j];
                }
            }
        }

        time2 = System.currentTimeMillis();

        System.out.print("Result matrix (lines): \n");

        for (int i = 0; i < 1; i++){
            for (int j = 0; j < Math.min(10,cols); j++){
                System.out.print(phc[j] + " ");
            }
        }

        System.out.printf("\nTime: %3.3f seconds\n\n", (double)(time2 - time1)/1000);
        System.out.println();

    }

    public static void runProdMatrix(){
        int dims = 600;
        while(dims < 3400) {
            System.out.println("====================================================");
            System.out.printf("DIMENSION - %d\n",dims);
            for(int i = 0; i < 5; i++){
                prodMatrix(dims, dims);
                
            }
            dims += 400;
        }
    }

    public static void runProdMatrixLine(){
        int dims = 600;
        while(dims < 3400) {
            System.out.println("====================================================");
            System.out.printf("DIMENSION - %d\n",dims);
            for(int i = 0; i < 5; i++){
                prodMatrixLine(dims, dims);
                
            }
            dims += 400;
        }
    }

    public static void main(String args[]){
        
        Scanner s = new Scanner(System.in); 
        int op = 1;

        do {
            System.out.println();
            System.out.println("1. Multiplication");
            System.out.println("2. Line Multiplication");
            System.out.print("Selection?: ");
            op = s.nextInt();

            if(op==0) break;

            switch (op) {
                case 1:
                    runProdMatrix();
                    break;
            
                default:
                    runProdMatrixLine();
                    break;
            }

        }while(op!=0);
        s.close();
    }
}