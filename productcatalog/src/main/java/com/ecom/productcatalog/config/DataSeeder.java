package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Save categories individually and fetch them back
        Category electronics = new Category();
        electronics.setName("Electronics");
        electronics = categoryRepository.save(electronics); // ✅ get ID

        Category clothing = new Category();
        clothing.setName("Clothing");
        clothing = categoryRepository.save(clothing); // ✅ get ID

        Category home = new Category();
        home.setName("Home and Kitchen");
        home = categoryRepository.save(home); // ✅ get ID

        // Now create products using attached categories with valid IDs
        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smartphone with amazing features");
        phone.setImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9");
        phone.setPrice(699.99);
        phone.setCategory(electronics); // ✅ now electronics has ID

        Product laptop = new Product();
        laptop.setName("Gaming Laptop");
        laptop.setDescription("High-performance laptop with RTX graphics and 16GB RAM");
        laptop.setImageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8");
        laptop.setPrice(1299.49);
        laptop.setCategory(electronics);

        Product tshirt = new Product();
        tshirt.setName("Graphic T-Shirt");
        tshirt.setDescription("Cotton T-shirt with modern artwork print");
        tshirt.setImageUrl("https://www.jockey.in/cdn/shop/products/2718_BLACK_0103_S123_JKY_1.webp?v=1700008021&width=720");
        tshirt.setPrice(19.99);
        tshirt.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Kitchen Blender");
        blender.setDescription("Multi-speed blender with durable glass jar");
        blender.setImageUrl("https://i.pinimg.com/originals/b5/cb/18/b5cb18fd1f1815fcebffbf4a4e67f88c.png");
        blender.setPrice(49.99);
        blender.setCategory(home);

        Product headphones = new Product();
        headphones.setName("Wireless Headphones");
        headphones.setDescription("Noise-cancelling over-ear headphones with Bluetooth");
        headphones.setImageUrl("https://i5.walmartimages.com/asr/78ff8e5b-5570-4eb2-8ca0-422e4a64d51e.a392ad46e96f707de61a5547318e70d1.jpeg");
        headphones.setPrice(89.99);
        headphones.setCategory(electronics);

        Product shoes = new Product();
        shoes.setName("Running Shoes");
        shoes.setDescription("Breathable and cushioned running shoes for men");
        shoes.setImageUrl("https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_750,h_750/global/311123/02/fnd/IND/fmt/png/Quest-X-Men's-Running-Shoes");
        shoes.setPrice(59.99);
        shoes.setCategory(clothing);

        productRepository.saveAll(Arrays.asList(phone, laptop, headphones, tshirt, shoes, blender));
    }

}
