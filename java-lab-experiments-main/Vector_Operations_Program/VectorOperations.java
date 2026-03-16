package Vector_Operations_Program;

import java.util.Scanner;

public class VectorOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Vector v1 = inputVector(sc, "first");
            Vector v2 = inputVector(sc, "second");

            System.out.println("\n--- Results ---");
            System.out.println("Vector 1: " + v1 + " | Mag: " + String.format("%.2f", v1.getMagnitude()));
            System.out.println("Vector 2: " + v2 + " | Mag: " + String.format("%.2f", v2.getMagnitude()));

            // Basic Ops
            if (v1.comp.length == v2.comp.length) {
                System.out.println("Addition:    " + v1.add(v2));
                System.out.println("Subtraction: " + v1.subtract(v2));
                System.out.println("Dot Product: " + v1.dotProd(v2));
                
                // 3D Specific Op
                if (v1.comp.length == 3) {
                    System.out.println("Cross Prod:  " + v1.crossProd(v2));
                }
            } else {
                System.out.println("Note: Operations skipped due to differing dimensions.");
            }

        } catch (VectorException ve) {
            System.err.println("Vector Error: " + ve.getMessage());
        } catch (Exception e) {
            System.err.println("Input Error: Please enter valid numbers.");
        } finally {
            sc.close();
        }
    }

    private static Vector inputVector(Scanner sc, String label) throws Exception {
        System.out.print("Enter dimension of " + label + " vector (2 or 3): ");
        int dim = sc.nextInt();
        double[] components = new double[dim];
        System.out.println("Enter " + dim + " components:");
        for (int i = 0; i < dim; i++) {
            components[i] = sc.nextDouble();
        }
        return new Vector(components);
    }
}