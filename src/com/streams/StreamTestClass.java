package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTestClass {
	public static void main(String[] args) {

		Student student1 = new Student("Jayesh", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Khyati", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Jason", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		/*
		 * 1. Get student with exact match name "jayaesh" 
		 * 2. Get student with matching address "1235" 
		 * 3. Get all student having mobile numbers 3333.
		 * 4. Get all student having mobile number 1233 and 1234
		 * 5. Create a List<Student> from the List<TestStudent>
		 * 6. Convert List<Student> to List<String> of student name 
		 * 7. Convert List<students> to String 
		 * 8. Change the case of List<String> 
		 * 9. Sort List<String> 
		 * 10. Conditionally apply Filter condition, say if flag is enabled
		 * then.
		 */

		Optional<Student> std = students.stream().filter(s -> s.getName().equals("Jayesh")).findFirst();
		if (std.isPresent()) {
			System.out.println("1: " + std);
		}

		Optional<Student> stdNew = students.stream().filter(s -> s.getAddress().getZipcode().equals("1235")).findFirst();
		if (stdNew.isPresent()) {
			System.out.println("2: " +stdNew);
		}
		
		List<Student> studntsFilterMob1 = students.stream().filter(s-> s.getMobileNumbers().stream().anyMatch(m-> m.getNumber().equals("3333"))).collect(Collectors.toList());
		String result = studntsFilterMob1.stream().map(s-> s.getName()).collect(Collectors.joining(",", "[", "]"));
		System.out.println("3:" + result);
		
		List<Student> studentsFilterMob2 = students.stream().filter(s-> s.getMobileNumbers().stream().anyMatch(m-> m.getNumber().equals("1233") || m.getNumber().equals("1234"))).collect(Collectors.toList());
		String result2 = studentsFilterMob2.stream().map(s-> s.getName()).collect(Collectors.joining(",", "[", "]"));
		System.out.println("4: " +result2);
		
		
        TestStudent tmpStud1 = new TestStudent(
                "Jayesh1",
                201,
                new Address("12341"),
                Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
     
            TestStudent tmpStud2 = new TestStudent(
                "Khyati1",
                202,
                new Address("12351"),
                Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
     
            
            List<TestStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
            
            List<Student> collect = tmpStudents.stream().map(tmp-> new Student(tmp.getName(), tmp.getAge(),
            		tmp.getAddress(), tmp.getMobileNumbers())).collect(Collectors.toList());
            collect.forEach(System.out::println);
            
            String collect2 = students.stream().map(s-> s.getName()).collect(Collectors.joining(",", "[", "]"));
            System.out.println(collect2);
	}
}

class Student {
	private String name;
	private int age;
	private Address address;
	private List<MobileNumber> mobileNumbers;

	public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + ", mobileNumbers=" + mobileNumbers
				+ "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<MobileNumber> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

}

class TestStudent {
	public String name;
	public int age;
	public Address address;
	public List<MobileNumber> mobileNumbers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<MobileNumber> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public TestStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}

}

class Address {
	private String zipcode;

	public Address(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + "]";
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}

class MobileNumber {
	private String number;

	public MobileNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "MobileNumber [number=" + number + "]";
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
