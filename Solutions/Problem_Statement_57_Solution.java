/*
...
Write a program to print the names of students by creating a Student class. If no name is passed
while creating an object of Student class, then the name should be "Unknown", otherwise the name
should be equal to the String value passed while creating object of Student class.
....
*/
class Hack//creating a class hack
{
	public static void main(String[] args)
	{
		Student obj1=new Student("Riya");//created an object of Student class while passing parameter as name

		Student obj2=new Student();//created an object of Student class without any parameter

		
	}
}

class Student//created class student
{
	Student(String s)//created an constructor with an argument
	{
		System.out.println(s);//prints the name
	}
	Student()//created a default constructor 
	{
		System.out.println("Unknown");//prints "unknown"
	
	}

}
