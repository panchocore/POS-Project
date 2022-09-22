package ec.com.pos.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "header")
public class Header {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hdr_id")
	private int hdr_id;
	
	@Column(name="hdr_date")
	private Date hdr_date;
	
	@Column(name="hdr_client")
	private String hdr_client;
	
	@Column(name="hdr_address")
	private String hdr_address;
	
	@Column(name="hdr_total")
	private Double hdr_total;
	
	@OneToMany(mappedBy = "hdr_id")
	private List<Detail> detailList;
	
	

	public int getHdr_id() {
		return hdr_id;
	}

	public void setHdr_id(int hdr_id) {
		this.hdr_id = hdr_id;
	}

	public Date getHdr_date() {
		return hdr_date;
	}

	public void setHdr_date(Date hdr_date) {
		this.hdr_date = hdr_date;
	}

	public String getHdr_client() {
		return hdr_client;
	}

	public void setHdr_client(String hdr_client) {
		this.hdr_client = hdr_client;
	}

	public String getHdr_address() {
		return hdr_address;
	}

	public void setHdr_address(String hdr_address) {
		this.hdr_address = hdr_address;
	}

	public Double getHdr_total() {
		return hdr_total;
	}

	public void setHdr_total(Double hdr_total) {
		this.hdr_total = hdr_total;
	}

	public List<Detail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Detail> detailList) {
		this.detailList = detailList;
	}
	
	
	
}
