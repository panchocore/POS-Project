package ec.com.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name="detail")
public class Detail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dtl_id")
	private Integer dtl_id;
	
	@Column(name="dtl_qty")
	private Integer dtl_qty;
	
	@Column(name="dtl_subtotal")
	private Double dtl_subtotal;
	
	@Column(name="hdr_id")
	private Integer hdr_id;
	
	@Column(name="prd_id")
	private Integer prd_id;
	
	
	public Integer getDtl_id() {
		return dtl_id;
	}

	public void setDtl_id(Integer dtl_id) {
		this.dtl_id = dtl_id;
	}

	public Integer getDtl_qty() {
		return dtl_qty;
	}

	public void setDtl_qty(Integer dtl_qty) {
		this.dtl_qty = dtl_qty;
	}

	public Integer getHdr_id() {
		return hdr_id;
	}

	public void setHdr_id(Integer hdr_id) {
		this.hdr_id = hdr_id;
	}

	public Integer getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(Integer prd_id) {
		this.prd_id = prd_id;
	}

	public Double getDtl_subtotal() {
		return dtl_subtotal;
	}

	public void setDtl_subtotal(Double dtl_subtotal) {
		this.dtl_subtotal = dtl_subtotal;
	}

	
	
	
}
