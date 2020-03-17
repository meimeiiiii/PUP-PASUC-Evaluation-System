package services;

import java.util.List;

import dao.ActivityLogDAO;
import dao.CCERankDAO;
import dao.FacultyDAO;
import dao.PECDAO;
import model.Faculty;
import model.PEC;

public class AccountSvc {
	FacultyDAO fDAO = new FacultyDAO();
	CCERankDAO crDAO = new CCERankDAO();
	ActivityLogDAO actDAO = new ActivityLogDAO();
	
	public boolean login (String email, String psw) {
		System.out.println("*SERVICE: Login");
		
		if(fDAO.checkAccount(email,psw) == true) {
			System.out.println("**successful");
//			actDAO.add(fDAO.getUser(email).get(0).getEmpId(),"Login Successful");
//			F.setEmpId(email);;
//			F.setPassword(psw);
			return true;
		}else {
			System.out.println("**unsuccessful");
			return false;
		}
	}
	
	public boolean forgotpw (String email) {
		System.out.println("*SERVICE: Forgot Password");
		
		if(fDAO.forgotpw(email) == true) {
			System.out.println("**successful");
			return true;
		}else {
			System.out.println("**unsuccessful");
			return false;
		}
	}
	
	public boolean addUser(String fn, String mn, String ln, String cn, String email, 
			String bd, String gen, String add, String empId, String dept, String psw, 
			int scoreEduc, int scoreExp, int scoreProf) {
		System.out.println("*SERVICE: Add User");
		
		Faculty F = new Faculty();

//		if (fDAO.checkEmpId(empId) == false) {
//			if (fDAO.checkEmail(email) == false) {
				F.setEmpId(empId);
				F.setFirstName(fn);
				F.setMiddleName(mn);
				F.setLastName(ln);
				F.setContactNumber(cn);
				F.setEmail(email);
				F.setBirthDate(bd);
				F.setGender(gen);
				F.setAddress(add);
				F.setDepartment(dept);
				F.setPassword(psw);
				F.setScoreEduc(scoreEduc);
				F.setScoreExp(scoreExp);
				F.setScoreProf(scoreProf);
				F.setRank(crDAO.getRank(scoreEduc+scoreExp+scoreProf));
				
				if(fDAO.add(F) == true) {
					System.out.println("**successful");
					return true;
				}else {
					System.out.println("**unsuccessful. Error in adding.");
					return false;
				}
//			}else {
//				System.out.println("**unsuccessful. Email exists.");
//				return 1;
//			}
//		}else {
//			System.out.println("**unsuccessful. EmpId exists.");
//			return 2;
//		}
	}
	
	public boolean checkUserExist(String email) {
		System.out.println("*SERVICE: Check User");
		return fDAO.checkEmail(email);
	}
	
	public boolean deleteUser(String email, String psw) {
		System.out.println("*SERVICE: Delete user");
		if(fDAO.checkAccount(email,psw) == true) {
			if(fDAO.delete(email) == 1) {				// DELETE RECORDS AS WELL
				System.out.println("**successful");
				return true;
			}else {
				System.out.println("**unsuccessful");
				return false;
			}
		}else {
			System.out.println("**unsuccessful. Incorrect inputs.");
			return false;
		}
	}
	
	public List<Faculty> getUser(String email){
		System.out.println("*SERVICE: Get User");
		List <Faculty> Faculty = fDAO.getUser(email);
		System.out.println("**" + Faculty);
		return Faculty;
	}
	
	public List<Faculty> getUserFrID(String empId){
		System.out.println("*SERVICE: Get User");
		List <Faculty> Faculty = fDAO.getUserfromID(empId);
		System.out.println("**" + Faculty);
		return Faculty;
	}
	
	public List<Faculty> getEmailandId(){
		System.out.println("*SERVICE: Get All Email & Emp Id");
		List <Faculty> Faculty = fDAO.getEmailandId();
		System.out.println("**" + Faculty);
		return Faculty;
	}

	public int updateUser(String email, String fn, String mn, String ln, String cn,  
			String bd, String gen, String add, String dept) {
		System.out.println("*SERVICE: Update for " + email);
		
		Faculty F = new Faculty();

			if (fDAO.checkEmail(email) == true) {
				
				//F.setEmpId(empId);
				F.setFirstName(fn);
				F.setMiddleName(mn);
				F.setLastName(ln);
				F.setContactNumber(cn);
				F.setEmail(email);
				F.setBirthDate(bd);
				F.setGender(gen);
				F.setAddress(add);
				F.setDepartment(dept);
				//F.setPassword(psw);
				
				if(fDAO.update(F) == true) {
					System.out.println("**successful");
					return 0;
				}else {
					System.out.println("**unsuccessful. Error in updating");
					return 1;
				}
			}else {
				System.out.println("**unsuccessful. Email doesn't exist");
				return 2;
			}
	} 
	
	public boolean changeEmail(String oldEmail, String newEmail) {
		System.out.println("*SERVICE: Change Email");
		
		if(fDAO.changeEmail(oldEmail, newEmail) == 1) {
			System.out.println("**successful");
			return true;
		}else {
			System.out.println("**unsuccessful");
			return false;
		}
	} 

	public boolean changePassword(String email, String oldPsw, String newPsw) {
		System.out.println("*SERVICE: Change Password");
		
		boolean check = fDAO.checkAccount(email,oldPsw);
		System.out.println("Check: " + check);
		if(check == false) {
			System.out.println("**Incorrect password");
			return false;
		}else {
			System.out.println("**Correct password");
			boolean result = fDAO.changePassword(email, newPsw);
			System.out.println("result " + result);
			return true;
		}
	} 
	
	
	
	PECDAO pDAO = new PECDAO();
	
	public boolean addUserPEC(String fn, String mn, String ln, String email, 
			String pos, String rights, String psw) {
		System.out.println("*SERVICE: Add User (PEC)");
		
		PEC P = new PEC();
		
			
				P.setFirstName(fn);
				P.setMiddleName(mn);
				P.setLastName(ln);
				P.setEmail(email);
				P.setPosition(pos);
				P.setPassword(psw);
				P.setRights(rights);
				
				if(pDAO.add(P) == true) {
					System.out.println("**successful");
					return true;
				}else {
					System.out.println("**unsuccessful. Error in adding.");
					return false;
				}
//			}else {
//				System.out.println("**unsuccessful. Email exists.");
//				return 1;
//			}
//		}else {
//			System.out.println("**unsuccessful. EmpId exists.");
//			return 2;
//		}
	}
	
	public boolean loginPEC (String email, String psw) {
		System.out.println("*SERVICE: Login");
		
		if(pDAO.checkAccount(email,psw) == true) {
			System.out.println("**successful");
//			F.setEmpId(email);
//			F.setPassword(psw);
			return true;
		}else {
			System.out.println("**unsuccessful");
			return false;
		}
	}
	
	public List<PEC> getUserPEC(String email){
		System.out.println("*SERVICE: Get User");
		List <PEC> PEC = pDAO.getUser(email);
		System.out.println("**" + PEC);
		return PEC;
	}
	
	public List<PEC> getAllUserPEC(){
		System.out.println("*SERVICE: Get All User");
		List <PEC> PEC = pDAO.getAllUsers();
		System.out.println("**" + PEC);
		return PEC;
	}
	
	public int updateUserPEC(String email, String fn, String mn, String ln, String cn,  
			String bd, String gen, String add, String dept) {
		System.out.println("*SERVICE: Update for " + email);
		
		Faculty F = new Faculty();

			if (fDAO.checkEmail(email) == true) {
				
				//F.setEmpId(empId);
				F.setFirstName(fn);
				F.setMiddleName(mn);
				F.setLastName(ln);
				F.setContactNumber(cn);
				F.setEmail(email);
				F.setBirthDate(bd);
				F.setGender(gen);
				F.setAddress(add);
				F.setDepartment(dept);
				//F.setPassword(psw);
				
				if(fDAO.update(F) == true) {
					System.out.println("**successful");
					return 0;
				}else {
					System.out.println("**unsuccessful. Error in updating");
					return 1;
				}
			}else {
				System.out.println("**unsuccessful. Email doesn't exist");
				return 2;
			}
	} 
	
	public boolean changeEmailPEC(String oldEmail, String newEmail) {
		System.out.println("*SERVICE: Change Email");
		
		if(fDAO.changeEmail(oldEmail, newEmail) == 1) {
			System.out.println("**successful");
			return true;
		}else {
			System.out.println("**unsuccessful");
			return false;
		}
	} 

	public boolean changePasswordPEC(String email, String oldPsw, String newPsw) {
		System.out.println("*SERVICE: Change Password");
		
		boolean check = pDAO.checkAccount(email,oldPsw);
		System.out.println("Check: " + check);
		if(check == false) {
			System.out.println("**Incorrect password");
			return false;
		}else {
			System.out.println("**Correct password");
			boolean result = pDAO.changePassword(email, newPsw);
			System.out.println("result " + result);
			return true;
		}
	} 
	
	public List<Faculty> getAllUsers(){
		System.out.println("*SERVICE: Get User");
		List <Faculty> Faculty = fDAO.getAllUsers();
		System.out.println("**" + Faculty);
		return Faculty;
	}
	
	
}	
	
	
	// 0 success, 1 error update, 2 wrong psw
	
//	public String sendCodeToEmail(int task, String empId, String email) {
//		System.out.println("***Send to email");
//		
//        String code = "ab429c";
//		
//		//-TEST
//        String name = "Louisa May Jasmine"; 
//        String msg = "Hi, " + name
//       		+ "\n\n Thanks for registering on PUP PASUC Evaluation Online." 
//       		+ "\n\n For the last step to complete your registration, here is your verification code: " + code
//       		+ "\n\n If this isn't initiated by you, ignore this message.";
//		//-TEST
//		
//		if (task == 1) { // FOR FORGOT PASSWORD
//			if (fDAO.checkEmail(email) == true) {
//				//SEND CODE
//				return code;
//			}else {
//				return null;
//			}	
//		}else if (task == 2) { // FOR CHANGE EMAIL AND NEW ACCOUNT
//			if (fDAO.checkEmail(email) == false) {
//				//SEND CODE
//				return code;
//			}else {
//				return null;
//			}	
//		}else {
//			return null;
//		}
//	}
//
//	public boolean sendEmail(String to, String msg, String subject) {
//	      String from = "pup_pasuc@gmail.com";
//	      String host = "localhost";
//
//	      Properties properties = System.getProperties();
//
//	      properties.setProperty("mail.smtp.host", host);
//
//	      Session session = Session.getDefaultInstance(properties);
//
//	      try {
//	         MimeMessage message = new MimeMessage(session);
//
//	         message.setFrom(new InternetAddress(from));
//
//	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//	         message.setSubject(subject);
//
//	         message.setContent(msg, "text/html");
//
//	         Transport.send(message);
//	         System.out.println("Sent message successfully....");
//	         
//	         return true;
//	         
//	      } catch (MessagingException mex) {
//	         mex.printStackTrace();
//	         return false;
//	      }
//	   }


