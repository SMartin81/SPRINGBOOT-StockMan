package stockman.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Provider implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private Long siret;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="provider",cascade = CascadeType.ALL)
	private List<Supply> supplyList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSiret() {
		return siret;
	}

	public void setSiret(Long siret) {
		this.siret = siret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Supply> getSupplyList() {
		return supplyList;
	}

	public void setSupplyList(List<Supply> supplyList) {
		this.supplyList = supplyList;
	}
	

}
