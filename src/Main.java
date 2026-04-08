import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        List<Hardware> masterlist = repo.fetchHardwareMasterlist();

        
        System.out.println("=== HARDWARE MASTERLIST ===");
        for (Hardware h : masterlist) {
            System.out.printf("ID: %-2d | Brand: %-15s | Interpretation: %s%n", 
                h.getId(), h.getBrand(), h.interpretSpec());
        }

        // 2. Polymorphic Audit (Single Loop with instanceof)
        int count16GB = 0;
        int count32GB = 0;
        int count50MP = 0;
       
            
            for (Hardware h : masterlist) {
                if (h instanceof Laptop) {
                        if (h.getSpec() == 16) {
                            count16GB++;
            } else if (h.getSpec() == 32) {
            count32GB++;
        }
        
    } else if (h instanceof Phone) {
        // Handle all phone specs inside this one block
        if (h.getSpec() == 50) {
            count50MP++;
        }
    }
}
        // 3. Final Inventory Output
        System.out.println("\n=== LAPTOP AND PHONE INVENTORY ===");
        System.out.println("Total 16GB Laptops: " + count16GB);
        System.out.println("Total 32GB Laptops: " + count32GB);
        System.out.println("Total 50MP Phones : " + count50MP);
    

    }
}