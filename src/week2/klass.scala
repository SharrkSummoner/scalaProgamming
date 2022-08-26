package week2

import java.time.Year

object klass extends App {

  class Student(id: Int, val name: String) {
    val uni = "University"

    println("Student class")
  }

  val student = new Student(0, "Bob")
  println(student.name)
  // student.uni

  class SomeClass(a: Int, b: Int, val c: Int) {
    def someFunc(): Int = b
  }

  class StudentOne(id: Int, val name: String) {
    def getId(name: String, id: Int): String = s"$name has ID $id and $name has ID $id"
  }

  val studentOne = new StudentOne(1, "Sam")
  println(studentOne.getId("Pam", 2))

  class StudentThis(id: Int, name: String) {
    def getId(name: String, id: Int): String = s"${this.name} has ID ${this.id} and $name has ID $id"
  }

  val studentThis = new StudentThis(1, "Sam")
  println(studentThis.getId("Pam", 2))

  class StudentDouble(id: Int, val name: String) {
    def getId(name: String, id: Int): String = {
      s"${this.name} has ID ${this.id} and $name has ID $id"
    }

    def getId: String = s"here is $name ID $id"
  }

  val studentDouble = new StudentDouble(1, "Sam")
  println(studentDouble.getId("Pam", 2))
  println(studentDouble.getId)


  class StudentMore(id: Int, val name: String) {
    def this(name: String) = this(0, name)

    def this() = this(0, "NoName")
  }

  val noStudentMore = new StudentMore()
  val newStudentMore = new StudentMore("Will")
  val studentMore = new StudentMore(1, "Sam")

  println(s"$noStudentMore $newStudentMore $studentMore")

  class StudentDefault(id: Int = 0, val name: String)

  val studentDefault = new StudentDefault(1, "San")
  val newStudentDefault = new StudentDefault(name = "Will")

  println(s"$studentDefault $newStudentDefault")

  class Employee(val name: String, var salary: Double) {
    def this() = this("Jhon", 0)
  }

  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")

  class Instructor(val id: Int, val name: String, val surname: String) {
    def fullName(): String = s"${name.toLowerCase().capitalize} ${surname.toLowerCase().capitalize}"
  }

  class Course(courseID: Int, title: String, var releaseYear: String, instructor: Instructor) {
    def getID: String = s"$courseID${instructor.id}"

    def isTaughtBy(instr: Instructor): Boolean = {
      if (instr == instructor) true
      else false
    }

    def copyCourse(releaseYear: String): Unit = {
      Course.this.releaseYear = releaseYear
    }
  }

  //val instructor = new Instructor(1, "sam", "meow")
  val instructor: Instructor = new Instructor(1, "bOb", "As")
  println(instructor.fullName())
  val course: Course = new Course(2, "Course Name", "1234", instructor)
  println(course.getID)
  println(course.isTaughtBy(instructor))
  println(course.copyCourse("11001"))

}