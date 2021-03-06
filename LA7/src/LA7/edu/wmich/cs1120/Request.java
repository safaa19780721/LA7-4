package LA7.edu.wmich.cs1120;

public class Request<T> implements Comparable<T> {
	private String name;
	private String sdept;
	private int level;
	private String cdept;
	private int num;
	private double gpa;
	
// Constructor
	/**
	 * 
	 * @param studentName name for student
	 * @param studentDept students major
	 * @param studentLevel students grade level
	 * @param courseDept what department of the course they are adding
	 * @param courseNumber what number of the course they are adding
	 * @param GPA_Array their GPA array which equals their calculated gpa
	 */
	public Request(String studentName, String studentDept, String studentLevel, String courseDept, int courseNumber, double[][] GPA_Array) {
		name = studentName;
		sdept = studentDept;
		level = yearsFromGraduation(studentLevel);
		cdept = courseDept;
		num =courseNumber;
		gpa = GPA_Cal(GPA_Array);
		}
	
	@Override
	/**
	 * @param o "o" is a type T request object and is used to compare the students by level/dept
	 * @return -99 a dummy variable
	 */
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		if(o instanceof Request) {
			if(this.getSDept().equals(((Request) o).getSDept())) {
				
				if(this.getLevel() > ((Request) o).getLevel()) {
					return -1;
				}else if(this.getLevel() < ((Request) o).getLevel()) {
					return 1;
				}else if(this.getLevel() == ((Request) o).getLevel()) {
					if(this.getGPA() > ((Request) o).getGPA()) {
						return -1;
					}else if(this.getGPA() < ((Request) o).getGPA()) {
						return 1;
					}else if(this.getGPA() == ((Request) o).getGPA()) {
						return 0;
					}
				}
			}else if (this.getSDept().equals("CS")&&((Request) o).getSDept().equals("ECE")) {
				return 1;
			}else if (this.getSDept().equals("ECE")&&((Request) o).getSDept().equals("CS")) {
				return -1;
			}
		
			
			}
				return -99;
		
		
		
	}
	
	
	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	/**
	 * 
	 * @param level is what grade they are
	 * @return an int for their grade level
	 */
	public int yearsFromGraduation(String level) {
		if(level.contains("Senior")){
			return 0;
		}else if(level.contains("Junior")){
			return 1;
		}else if(level.contains("Sophmore")){
			return 2;
		}else { //freshman
			return 3;
		}
		
	}

	// Calculate the GPA for a particular student.
	/**
	 * 
	 * @param GPA_Array make a 2D array of all the classes they took and the amount of credit hours for each class
	 * @return their calculated gpa
	 */
	private double GPA_Cal(double[][] GPA_Array) {
		double ch = GPA_Array[0][1]+GPA_Array[1][1]+GPA_Array[2][1]+GPA_Array[3][1];
		double qp = 0;
		for(int i = 0;i<GPA_Array.length;i++) {
			qp+= (GPA_Array[i][0]*GPA_Array[i][1]);
		}
		return (qp/ch);
		
	}

	// Getters for a students name and department, and the department and number of a course 
	public String getName() {
		return name;
	}
	public String getSDept() {
		return sdept;
	}
	public String getCDept() {
		return cdept;
	}
	public int getCourseNum() {
		return num;
	}
	public int getLevel() {
		return level;
	}
	public double getGPA() {
		return gpa;
	}

}
