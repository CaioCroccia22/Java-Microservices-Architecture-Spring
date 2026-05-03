package br.com.ccroccia.vendas.online.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Client", description = "Client")
public class Client {

	@Id
	@Schema(description = "Unique register")
	private String id;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description = "Name", minLength = 1, maxLength = 50, nullable = false)
	private String name;
	
	@NotNull
	@Indexed(unique = true)
	@Schema(description = "CPF", nullable = true)
	private Long cpf;
	
	@NotNull
	@Schema(description = "Tel", nullable = false)
	private Long tel;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Indexed(unique = true)
	@Schema(description = "Email", minLength = 1, maxLength = 50, nullable = false)
	@Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
	private String email;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description = "Address", minLength = 1, maxLength = 50, nullable = false)
	private String address;
	
	@NotNull
	@Schema(description="Address Number", nullable = false) 
    private Integer number;
    
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description="City", minLength = 1, maxLength=50, nullable = false)
    private String city;
    
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description="State", minLength = 1, maxLength=50, nullable = false)
    private String state;
	
	
	
	
	
}
