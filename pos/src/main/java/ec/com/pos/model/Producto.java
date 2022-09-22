package ec.com.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prd_id")
	private int prd_id;
	
	@Column(name="prd_name", length = 100)
	private String prd_name;
	
	@Column(name="prd_price")
	private Double prd_price;

	public int getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}

	public String getPrd_name() {
		return prd_name;
	}

	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}

	public Double getPrd_price() {
		return prd_price;
	}

	public void setPrd_price(Double prd_price) {
		this.prd_price = prd_price;
	}

}
