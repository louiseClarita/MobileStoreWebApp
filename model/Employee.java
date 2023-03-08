package com.example.webapp.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {
    @Id
    private ObjectId _id;
    private String fname;
    private String department;
    private double salary;
    private int age;
    private String emp_pass;
    private String username;
    
    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmp_pass() {
		return emp_pass;
	}

	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", fname=" + fname + ", department=" + department + ", salary=" + salary
				+ ", age=" + age + ", emp_pass=" + emp_pass + ", username=" + username + "]";
	}

    
    
}
