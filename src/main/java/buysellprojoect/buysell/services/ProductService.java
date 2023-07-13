package buysellprojoect.buysell.services;

import buysellprojoect.buysell.models.Image;
import buysellprojoect.buysell.models.Product;
import buysellprojoect.buysell.models.User;
import buysellprojoect.buysell.repositories.ProductRepository;
import buysellprojoect.buysell.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Principal principal, Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        product.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            image1.setContentType(MediaType.IMAGE_JPEG_VALUE);
            product.addImageToProduct(image1);
        }

        if (file2.getSize() != 0){
            image2 = toImageEntity(file2);
            image2.setContentType(MediaType.IMAGE_JPEG_VALUE);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0){
            image3 = toImageEntity(file3);
            image3.setContentType(MediaType.IMAGE_JPEG_VALUE);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Product. Title:{}; Author email:{}", product.getTitle(), product.getUser().getEmail());
        product.setPreviewImageId(product.getImages().get(0).getId());
        productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
       return productRepository.findById(id).orElse(null);
    }
}