package blackboard;

public class Car implements IdentifiableElement {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id, targetId;
	String plate;
	
	public Car(String id, String plate) {
		this.id = id;
		this.plate = plate;
	}
	
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getTrgId() {
		return targetId;
	}

	@Override
	public void setTrgId(String trgId) {
		this.targetId = id;
		
	}
	
	

}
