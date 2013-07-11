package base.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="RELATIVES")
public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2578492670852544943L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_ID")
	Integer id;
	@Column(name="NAME")
	String name;
	@Column(name="SURNAME")
	String surname;
	@Column(name="ADRES_ID")
	Integer adresId;
	@Column(name="SEX")
	Integer sex;
	@Column(name="MOTHER_ID")
	Integer motherId =null;
	@Column(name="FATHER_ID")
	Integer fatherId =null;
	@Column(name="PARTNER_ID")
	Integer partnerId;
	@Column(name="BIRDTH_DATE")
	Date birdthDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getAdresId() {
		return adresId;
	}
	public void setAdresId(Integer adresId) {
		this.adresId = adresId;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getMotherId() {
		return motherId;
	}
	public void setMotherId(Integer motherId) {
		this.motherId = motherId;
	}
	public Integer getFatherId() {
		return fatherId;
	}
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}
	public Date getBirdthDate() {
		return birdthDate;
	}
	public void setBirdthDate(Date birdthDate) {
		this.birdthDate = birdthDate;
	}
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	
}
