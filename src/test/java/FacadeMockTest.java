import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.User;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FacadeMockTest {
	DataAccess mockedDataAccess=Mockito.mock(DataAccess.class);
	Event mockedEvent=Mockito.mock(Event.class);
	User mockedUser= Mockito.mock(User.class);

	@InjectMocks
	BLFacade sut=new BLFacadeImplementation(mockedDataAccess);  

	@Test
	//sut.createQuestion: The user is already registered
	public void test3() {
		try {
			String izena ="Mikeel";
			String pass ="12"; 
			String NAN="12"; 
			String korreoa="12@12"; 
			String KZ="B"; 
			String adina="12";


			mockedUser= new User(izena, pass, NAN, korreoa, KZ, adina);

			User u3 = new User(izena, pass, NAN, korreoa, KZ, "15");
			
			//invoke System Under Test (sut) 
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);

			//verify the result
			//Mockito.verify(mockedDataAccess,Mockito.times(1)).erregistratu(Mockito.any(User.class));
			
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			
			//Mockito.verify(mockedDataAccess,Mockito.times(1)).erregistratu(userCaptor.capture());
			User uaux = userCaptor.getValue();
			
			assertEquals(userCaptor.getValue().getAdina(),mockedUser.getAdina());
			assertEquals(userCaptor.getValue().getNAN(), mockedUser.getNAN());
			assertEquals(userCaptor.getValue().getKorreoa(), mockedUser.getKorreoa());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	@Test
	public void testParametrorikEzStringMotakoa() {
		try {
			String izena =null;
			String pass =null; 
			String NAN=null; 
			String korreoa=null; 
			String KZ=null; 
			String adina=null;
						
			//invoke System Under Test (sut)  
			//Question q=sut.createQuestion(ev, queryText, betMinimum);
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }
	@Test
	public void testParametrorikEzStringMotakoa2_0() {
		try {
			String izena ="";
			String pass =""; 
			String NAN=""; 
			String korreoa=""; 
			String KZ=""; 
			String adina="";
				
			
			
			//invoke System Under Test (sut)  
			//Question q=sut.createQuestion(ev, queryText, betMinimum);
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }
	@Test
	public void testParametrorikEzStringMotakoa2_1() {
		try {
			String izena ="";
			String pass =""; 
			String NAN=""; 
			String korreoa="a"; 
			String KZ=""; 
			String adina="";
				
			
			
			//invoke System Under Test (sut)  
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }
	@Test
	public void testParametrorikEzStringMotakoa2_2() {
		try {
			String izena ="";
			String pass =""; 
			String NAN=""; 
			String korreoa="a"; 
			String KZ="a"; 
			String adina="";
			
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
			
			//invoke System Under Test (sut)  
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }
	@Test
	public void testParametrorikEzStringMotakoa2_3() {
		try { 
			String izena ="";
			String pass =""; 
			String NAN=""; 
			String korreoa=""; 
			String KZ="a"; 
			String adina="";
						
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
			
			//invoke System Under Test (sut)  
						
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }
	@Test
	public void testParametrorikEzStringMotakoa2_4() {
		try {
			String izena ="";
			String pass =""; 
			String NAN="a"; 
			String korreoa=""; 
			String KZ=""; 
			String adina="";
			
			User u = new User (izena, pass, NAN, korreoa, KZ, adina);		

			 			
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
			
			//invoke System Under Test (sut)  
			//Question q=sut.createQuestion(ev, queryText, betMinimum);
					
			
			
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }
	
	@Test
	public void testParametrorikEzStringMotakoa2_5() {
		try {
			String izena ="";
			String pass =""; 
			String NAN="a"; 
			String korreoa="a"; 
			String KZ=""; 
			String adina="";
			
			User u = new User (izena, pass, NAN, korreoa, KZ, adina);		

			 			
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
			
			//invoke System Under Test (sut)  
			
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }
	@Test
	public void testErabiltzaileaErregistratuEgingoDa() {
		try {
			String izena ="Mikel";
			String pass ="123"; 
			String NAN="45167729F"; 
			String korreoa="mikel@mikel"; 
			String KZ="23"; 
			String adina="22";
			
			
					
			//invoke System Under Test (sut)  
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);
					
			//verify results
			
			ArgumentCaptor<String> izenaCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> passCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> NANCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> korreoCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> KZCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> adinaCaptor = ArgumentCaptor.forClass(String.class);

			
			Mockito.verify(mockedDataAccess, Mockito.times(1)).erregistratu(
					izenaCaptor.capture(),passCaptor.capture(),
					NANCaptor.capture(),korreoCaptor.capture(),KZCaptor.capture(),adinaCaptor.capture());
			System.out.println(izenaCaptor.getValue() + "eta"+izena );
			assertEquals(izenaCaptor.getValue(),izena);
			assertEquals(passCaptor.getValue(),pass);
			assertEquals(NANCaptor.getValue(),NAN);
			assertEquals(korreoCaptor.getValue(),korreoa);
			assertEquals(KZCaptor.getValue(),KZ);
			assertEquals(adinaCaptor.getValue(),adina);
			
		   } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
			} finally {
				  //Remove the created objects in the database (cascade removing)   
		          //boolean b=testBL.removeEvent(ev);
		           //System.out.println("Finally "+b);          
		        }
		   }

	

}
