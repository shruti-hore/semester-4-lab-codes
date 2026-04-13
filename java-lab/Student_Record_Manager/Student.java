import java.io.*;
import java.util.*;

public class Student {
    static final String FILE_NAME = "Students.csv";
    static final String HEADER = "studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage";

    // Method to calculate percentage
    static double calculatePercentage(double m1, double m2, double m3, double m4, double m5) {
        return (m1 + m2 + m3 + m4 + m5) / 5.0;
    }

    // Initialize file with Header and 2 initial rows
    static void initializeFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(HEADER);
            bw.newLine();
            bw.write("101,Alice,CS,85,90,78,88,92,0.0");
            bw.newLine();
            bw.write("102,Bob,IT,70,65,80,75,70,0.0");
            bw.newLine();
            System.out.println("[CREATE] File initialized with header and 2 rows.");
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    // Add 3 rows with marks4 and marks5 as zero
    static void addThreeRows() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write("103,Charlie,CS,80,70,60,0,0,0.0"); bw.newLine();
            bw.write("104,David,ME,55,65,75,0,0,0.0"); bw.newLine();
            bw.write("105,Eve,EE,90,85,80,0,0,0.0"); bw.newLine();
            System.out.println("[CREATE] Added 3 new rows with marks4/5 as zero.");
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    // Update marks and calculate percentages
    static void updateRecords() {
        List<String> updatedLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine(); // Read Header
            updatedLines.add(line);

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                // If marks4 or marks5 are 0, we "update" them (setting to 80 for demo)
                double m1 = Double.parseDouble(p[3]);
                double m2 = Double.parseDouble(p[4]);
                double m3 = Double.parseDouble(p[5]);
                double m4 = Double.parseDouble(p[6]) == 0 ? 80.0 : Double.parseDouble(p[6]);
                double m5 = Double.parseDouble(p[7]) == 0 ? 85.0 : Double.parseDouble(p[7]);
                
                double pct = calculatePercentage(m1, m2, m3, m4, m5);
                
                updatedLines.add(String.format("%s,%s,%s,%.1f,%.1f,%.1f,%.1f,%.1f,%.2f", 
                                 p[0], p[1], p[2], m1, m2, m3, m4, m5, pct));
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String l : updatedLines) {
                    bw.write(l);
                    bw.newLine();
                }
            }
            System.out.println("[UPDATE] Marks updated and percentages calculated.");
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    // Delete a specific row (e.g., studentId 102)
    static void deleteRecord(String id) {
        List<String> remainingLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(id + ",")) {
                    remainingLines.add(line);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String l : remainingLines) {
                    bw.write(l);
                    bw.newLine();
                }
            }
            System.out.println("[DELETE] Row with ID " + id + " deleted.");
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    static void displayFile() {
        System.out.println("\n--- Current CSV Content ---");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
        }
        System.out.println("---------------------------\n");
    }

    public static void main(String[] args) {
        initializeFile();    // C - Create initial
        displayFile();

        addThreeRows();      // C - Add 3 more
        displayFile();

        updateRecords();     // U - Update marks & Percentage
        displayFile();

        deleteRecord("102"); // D - Delete
        displayFile();
        
        // Triggering an exception for demonstration
        System.out.println("[EXCEPTION TEST] Attempting to read non-existent file:");
        try {
            BufferedReader br = new BufferedReader(new FileReader("wrong_file.csv"));
        } catch (IOException e) {
            System.out.println("Caught Expected Exception: " + e.toString());
        }
    }
}