package tutorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestCar {
	
	static Car car;
	
	@BeforeAll
	static void setup() {
		car = new Car();
	}

	@Test
	void testBrand() {
		String brand = "test_brand";
		car.setBrand(brand);
		assertEquals(brand, car.getBrand());
	}
	
	@Test
	void testMake() {
		String make = "test_make";
		car.setMake(make);
		assertEquals(make, car.getMake());
	}
	
	@Test 
	void testHorseP() {
		int horseP = 99;
		car.setHorseP(horseP);
		assertEquals(horseP, car.getHorseP());
	}
	
	@Test
	void testCc() {
		int cc = 98;
		car.setCc(cc);
		assertEquals(cc, car.getCc());
	}
	
	@Test
	void testkDoorsHatchback() {
		int doors = 3;
		assertEquals(doors, new Hatchback("", "", 0, 0 ).getDoors());
	}
	
	@Test
	void testkDoorsSaloon() {
		int doors = 4;
		assertEquals(doors, new Saloon("", "", 0, 0 ).getDoors());
	}
	
	@Test
	void testkDoorsSUV() {
		int doors = 5;
		assertEquals(doors, new SUV("", "", 0, 0 ).getDoors());
	}

}
