package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;


    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if(partRepository.count() == 0){
            OutsourcedPart sugar = new OutsourcedPart();
            sugar.setCompanyName("Tipa's Cake Shop");
            sugar.setName("Sugar");
            sugar.setPrice(10.0);
            sugar.setInv(30);

            OutsourcedPart wheat = new OutsourcedPart();
            wheat.setCompanyName("Tipa's Cake Shop");
            wheat.setName("Wheat");
            wheat.setPrice(4.0);
            wheat.setInv(33);

            OutsourcedPart milk = new OutsourcedPart();
            milk.setCompanyName("Tipa's Cake Shop");
            milk.setName("Milk");
            milk.setPrice(7.0);
            milk.setInv(10);

            OutsourcedPart flour = new OutsourcedPart();
            flour.setCompanyName("Tipa's Cake Shop");
            flour.setName("Flour");
            flour.setPrice(2.0);
            flour.setInv(100);

            OutsourcedPart dough = new OutsourcedPart();
            dough.setCompanyName("Tipa's Cake Shop");
            dough.setName("Dough");
            dough.setPrice(15.0);
            dough.setInv(120);

            outsourcedPartRepository.save(sugar);
            outsourcedPartRepository.save(wheat);
            outsourcedPartRepository.save(milk);
            outsourcedPartRepository.save(flour);
            outsourcedPartRepository.save(dough);
        }

        /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);


        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
        */
        if(productRepository.count() == 0) {
            Product cookie = new Product("cookie", 3.0, 15);
            Product cake = new Product("cake", 30.0, 15);
            Product muffin = new Product("muffin", 3.0, 15);
            Product cupcake = new Product("cupcake", 30.0, 15);
            Product bread = new Product("bread", 30.0, 15);
            productRepository.save(cookie);
            productRepository.save(cake);
            productRepository.save(muffin);
            productRepository.save(bread);
            productRepository.save(cupcake);
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
