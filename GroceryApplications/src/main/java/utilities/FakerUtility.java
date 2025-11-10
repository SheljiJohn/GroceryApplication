package utilities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();

	public String creatARandomFirstName() {

		return faker.name().firstName();

	}

	public String creatARandomLastName() {

		return faker.name().lastName();

	}

	public String generateAddress() {

		return faker.address().fullAddress();

	}

	public String generateEmail() {

		return faker.internet().emailAddress();

	}

	public String generatePhone() {

		return faker.phoneNumber().phoneNumber();

	}

	public Date generateDeliveryTime() {

		return faker.date().future(10, TimeUnit.HOURS);

	}

	public int generateDeliveryChargeLimit() {

		return faker.random().hashCode();

	}

}
