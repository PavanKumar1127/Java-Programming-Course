package objectOrientedProgramming;

/**
 * Encapsulation is about bundling the data (properties) and the methods that
 * operate on the data into a single unit (class), thus hiding the internal
 * details.
 */
public class Encapsulation {

}

class VehicleNew {
    private String color; // Private property

    // Getter and Setter methods for the private property
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

//AJavaclasswhichisafullyencapsulatedclass. 
class TestCar {

	// privatevariable
	private String name;

	// gettermethodforname
	public String getName() {
		return name;

	}

	// settermethodforname
	public void setName(String name) {
		this.name = name;
	}

}

//Javaclasstotesttheencapsulatedclass. 
class Test {
	public static void main(String[] args) {
		// creatinginstanceoftheencapsulatedclass
		TestCar car = new TestCar();

		// settingvalueinthenamemember
		car.setName("Honda");

		// gettingvalueofthenamemember
		System.out.println(car.getName());
	}
}