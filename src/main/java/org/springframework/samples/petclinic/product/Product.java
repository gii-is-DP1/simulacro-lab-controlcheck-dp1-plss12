package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @NotNull
    @Size(min=3, max=50)
    String name;
    
    @NotNull
    @Min(0)
    double price;
    
    @ManyToOne
    ProductType productType;
}
