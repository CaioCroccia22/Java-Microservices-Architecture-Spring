package br.com.ccroccia.vendas.online.ProductService.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder; //implement build desing pattern
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Builder
@NoArgsConstructor(force = true)
@Getter
@Setter
@Schema(name = "Products", description = "Products")
public class Product {

    @Id
    @NotNull
    @NotEmpty
    @Schema(name = "Unique register")
    private final int id;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 60)
    @Schema(description = "Name")
    private final String name;


    @NotNull
    @NotEmpty
    @Size(min = 1, max = 60)
    @Schema(description = "Type")
    private final String type;

    @NotNull
    @Schema(description = "Price")
    private final float price;


    public Product(int id, String name, String type, float price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

}
