package model;

import java.io.Serializable;

public class ExportPermit implements Serializable{
	public static final long serialVersionUID = 1;
	private String id;
	private String comments;
	public ExportPermit(String id, String comments) {
		super();
		this.id = id;
		this.comments = comments;
	}
	public String getId() {
		return id;
	}
	public String getComments() {
		return comments;
	}
	
}
