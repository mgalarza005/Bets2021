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
	public void test1() {
		try {
			//define paramaters
			String queryText="proba galdera";
			Float betMinimum=new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//configure Mock
			Mockito.doReturn(oneDate).when(mockedEvent).getEventDate();
			Mockito.when(mockedDataAccess.createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class))).thenThrow(QuestionAlreadyExist.class);
			

			//invoke System Under Test (sut) 
			sut.createQuestion(mockedEvent, queryText, betMinimum);
			
			//if the program continues fail
		    fail();
		   } catch (QuestionAlreadyExist e) {
			// TODO Auto-generated catch block
			   
			// if the program goes to this point OK
			assertTrue(true);
			} catch (EventFinished e) {
				// if the program goes to this point fail
			    fail();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
	
	
	
	@Test
	//sut.createQuestion:  The event has NOT a question with a queryText.
	public void test2() {
			try {
				//define paramaters
				String queryText="proba galdera";
				Float betMinimum=new Float(2);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date oneDate=null;;
				try {
					oneDate = sdf.parse("05/10/2022");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				//configure Mock
				Mockito.doReturn(oneDate).when(mockedEvent).getEventDate();
				Mockito.doReturn(new Question(queryText, betMinimum,mockedEvent)).when(mockedDataAccess).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));

				

				//invoke System Under Test (sut) 
				Question q=sut.createQuestion(mockedEvent, queryText, betMinimum);
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
				
				ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
				ArgumentCaptor<String> questionStringCaptor = ArgumentCaptor.forClass(String.class);
				ArgumentCaptor<Float> betMinimunCaptor = ArgumentCaptor.forClass(Float.class);
				
				Mockito.verify(mockedDataAccess,Mockito.times(1)).createQuestion(eventCaptor.capture(),questionStringCaptor.capture(), betMinimunCaptor.capture());
				Float f=betMinimunCaptor.getValue();

				assertEquals(eventCaptor.getValue(),mockedEvent);
				assertEquals(questionStringCaptor.getValue(),queryText);
				assertEquals(betMinimunCaptor.getValue(),betMinimum);

			   } catch (QuestionAlreadyExist e) {
				// TODO Auto-generated catch block
				assertTrue(true);
				} catch (EventFinished e) {
				    fail();
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		
	
	
	
	/*
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
	}*/
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
