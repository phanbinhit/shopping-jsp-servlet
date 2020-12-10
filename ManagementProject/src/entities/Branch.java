package entities;

import java.util.Objects;

public class Branch {
	private int id;
	private String title;
	public Branch(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", title=" + title + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Branch)) {
			return false;
		}
		Branch that = (Branch) obj;
		return getId() == that.getId();
	}
	
}
