import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class UserPersons{

	private static class User{
		protected String name;
		protected String userType;
		protected long icNumber;
		protected String username;
  		protected String password;

  		public User(){
		    }

		    public User(String name,String userType,long icNumber,String username,String password){
		    this.name = name;
		    this.userType = userType;
		    this.icNumber = icNumber;
		    this.username = username;
		    this.password = password;
    		}

    		public String getName() {
			        return name;
			    }

			    public void setName(String name) {
			        this.name = name;
			    }

			    public String getUserType() {
			        return userType;
			    }

			    public void setUserType(String userType) {
			        this.userType = userType;
			    }

			    public long getIcNumber() {
			        return icNumber;
			    }

			    public void setIcNumber(long icNumber) {
			        this.icNumber = icNumber;
			    }

			        public String getUsername() {
			        return username;
			    }

			    public void setUsername(String username) {
			        this.username = username;
			    }

			        public String getPassword() {
			        return password;
			    }

			    public void setPassword(String password) {
			        this.password = password;
    			}
			}

	public static class Doctor extends User{
		String DoctorName;
		String RoomNumber;

		public Doctor(){
		}

		public Doctor(String RoomNumber,String doctorName){
			this.DoctorName = doctorName;
			this.RoomNumber = RoomNumber;
		}
	}

	public static User RegisterUser(){

		Scanner scan = new Scanner(System.in);

		System.out.println("Name: ");
		String name =(scan.nextLine());

		System.out.println("User Type: ");
		String setUserType = (scan.nextLine());

		System.out.println("IC Number: ");
		long setIcNumber = (Long.parseLong(scan.nextLine()));

		System.out.println("Username: ");
		String setUsername =(scan.nextLine());

		System.out.println("Password: ");
		String setPassword = (scan.nextLine());

		User user = new User(name,setUserType,setIcNumber,setUsername,setPassword);

		return user;
		}

	public static Doctor RegisterDoctor(){
		Scanner scan = new Scanner(System.in);

		System.out.println("Doctor Name: ");
		String setDoctorName =(scan.nextLine());

		System.out.println("Doctor Room: ");
		String setDoctorRoom = (scan.nextLine());

		Doctor doctor = new Doctor(setDoctorRoom,setDoctorName);

		return doctor;
	}

	public static void display(User user){
		System.out.println(user.name);
		System.out.println(user.userType);
		System.out.println(user.icNumber);
		System.out.println(user.username);
		System.out.println(user.password);
	}

	public static void displayDoctor(Doctor doctor){

		System.out.println("\nList Of Doctor\n");
		System.out.println(doctor.DoctorName);
		System.out.println(doctor.RoomNumber);
	}


	public static void main(String[] args){
		ArrayList<User> objUser = new ArrayList<User>();
		ArrayList<Doctor> objDoc = new ArrayList<Doctor>();

		//Inser some dummy data to do comparision
		User patient = new User("syafiq","Nurse",123456789012L,"roselia","12345");
		//Add the into ArrayList
		objUser.add(patient);
		System.out.println("Welcome To Patient Navigation System");
		Scanner scan = new Scanner(System.in);
		int answer;

		do{
		System.out.println("Do you want to add new [1] - user  or [2] - Doctor ");
		answer = Integer.parseInt((scan.nextLine()));

		switch(answer){
		case 1:
				do{
						System.out.println("Add New User");
						User user = RegisterUser();
						//objUser.add(user);

						display(user);

						for(int i =0; i< objUser.size();i++){
							User aPL = (User)objUser.get(i);
							int count = 0;
							//Precondition
				            assert aPL.getIcNumber() != user.getIcNumber(): "The IC number are the same";
							//Precondition
				            assert aPL.getUsername() != user.getUsername(): "You input the same username with other user";

				            long num = user.getIcNumber();
				            while(num != 0){
									num /= 10;
				                    ++count;
									}

							//Postcondition
							assert count == 12 : "Please Enter 12 digit IC number";
							}

							objUser.add(user);

							System.out.println("Do you want to add new user [1] - yes , [0] - no");
							answer = Integer.parseInt((scan.nextLine()));
						}while(answer != 0);
				break;
		case 2:
						do{

							System.out.println("Add New Doctor");
							Doctor doctor = RegisterDoctor();
							objDoc.add(doctor);

							do{
							System.out.println("Do you want to delete that doctor [1] - yes , [0] - no");
							answer = Integer.parseInt((scan.nextLine()));

							if(answer == 1){
								for(int i =0; i< objDoc.size();i++){
									System.out.println("Doctor Index : [" + i +"]");
									Doctor doc = (Doctor)objDoc.get(i);
									displayDoctor(doc);
									}
								System.out.println("Which doctor do you want to delete using Doctor Index [],but if you want To exit delete function select index outside of the index");
								answer = Integer.parseInt((scan.nextLine()));

								if(answer+1 >= objDoc.size() && answer <= objDoc.size()){
									objDoc.remove(answer);
								}
								answer = 1;
							}
							}while(answer != 0);

							//Invariant
							assert objDoc.size() >= 1 : "There is no doctor left";

							System.out.println("Do you want to add new doctor [1] - yes , [0] - no");
							answer = Integer.parseInt((scan.nextLine()));
							}while(answer != 0);
				break;

		default: System.out.println("You Had Enter Wrong Input");
				break;
		}//switch end
		System.out.println("Do you want to exit system [1] - yes , [0] - no");
		answer = Integer.parseInt((scan.nextLine()));
		}while(answer == 0);

			System.out.println("Logout of System");
		}
	}
