import com.challenge.product.repository.ProductRepositoryImpl;
import com.challenge.product.repository.FileUtils;

public class TestProductRepository {
    public static void main(String[] args) {
        try {
            FileUtils fileUtils = new FileUtils();
            ProductRepositoryImpl repository = new ProductRepositoryImpl(fileUtils);
            
            // Teste findById
            System.out.println("=== Teste findById ===");
            String produto1 = repository.findById("1");
            System.out.println("Produto ID 1: " + produto1);
            
            // Teste findByName
            System.out.println("\n=== Teste findByName ===");
            String produto2 = repository.findByName("Smartphone Galaxy S23");
            System.out.println("Produto por nome: " + produto2);
            
            // Teste findAll
            System.out.println("\n=== Teste findAll ===");
            var produtos = repository.findAll();
            System.out.println("Total de produtos: " + produtos.size());
            System.out.println("Primeiro produto: " + produtos.get(0));
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}