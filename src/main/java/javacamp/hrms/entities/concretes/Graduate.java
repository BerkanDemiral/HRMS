package javacamp.hrms.entities.concretes;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graduate {
	
	private int id;
	
	@NotBlank(message = "Açıklama alanını boş bırakmayınız")
	private String description;
}
