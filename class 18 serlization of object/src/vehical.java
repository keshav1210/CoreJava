
import java.io.Serializable;

public class vehical implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7297221173975226273L;
	private String type ;
	private int number ;
	public vehical(String type, int number) {
		this.type = type;
		this.number = number;
	}
	@Override
	public String toString() {
		return "vehical [type=" + type + ", number=" + number + "]";
	}
	

}
