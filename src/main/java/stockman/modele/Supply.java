package stockman.modele;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Supply implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private String description;
	private Long unitsInStock;
	private Long alertStock;
	
	@ManyToOne (cascade= CascadeType.ALL)
	@JoinColumn(name = "provider_id", nullable = false)
	@JsonBackReference
	private Provider provider;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="supply",cascade = CascadeType.ALL)
	private List<OrderRequest> orderRequestList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Long getAlertStock() {
		return alertStock;
	}

	public void setAlertStock(Long alertStock) {
		this.alertStock = alertStock;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<OrderRequest> getOrderRequestList() {
		return orderRequestList;
	}

	public void setOrderRequestList(List<OrderRequest> orderRequestList) {
		this.orderRequestList = orderRequestList;
	}
	
	
	
	
}
