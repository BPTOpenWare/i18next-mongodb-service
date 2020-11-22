package com.bptopenware.messages.i18nextrepository;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.AccessType;


@Entity
@Table(name = "Resources")
@Access(value=AccessType.FIELD)
public class I18NextDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resID;

	private String sysid;
	
	private String appid;
	
	private String compid;
	
	private String language;
	
	private String namespace;
	
	private String resource;
	
	private Integer modID;
	
	private String creTS;
	
	private String revTS;

	/**
	 * @return the resID
	 */
	public Long getResID() {
		return resID;
	}

	/**
	 * @param resID the resID to set
	 */
	public void setResID(Long resID) {
		this.resID = resID;
	}

	/**
	 * @return the sysid
	 */
	public String getSysid() {
		return sysid;
	}

	/**
	 * @param sysid the sysid to set
	 */
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * @return the compid
	 */
	public String getCompid() {
		return compid;
	}

	/**
	 * @param compid the compid to set
	 */
	public void setCompid(String compid) {
		this.compid = compid;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * @return the resource
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * @param resource the resource to set
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}

	/**
	 * @return the modID
	 */
	public Integer getModID() {
		return modID;
	}

	/**
	 * @param modID the modID to set
	 */
	public void setModID(Integer modID) {
		this.modID = modID;
	}

	/**
	 * @return the creTS
	 */
	public String getCreTS() {
		return creTS;
	}

	/**
	 * @param creTS the creTS to set
	 */
	public void setCreTS(String creTS) {
		this.creTS = creTS;
	}

	/**
	 * @return the revTS
	 */
	public String getRevTS() {
		return revTS;
	}

	/**
	 * @param revTS the revTS to set
	 */
	public void setRevTS(String revTS) {
		this.revTS = revTS;
	}
	

	
}