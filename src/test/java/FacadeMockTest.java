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
	
	
	
	//Estaliko den baliokidetasun klasea 1,2,5,6,9,10,13,14,17,18,21,22
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
	
	@Test
	//Estaliko den baliokidetasun klasea 1,2,5,6,9,10,13,14,17,18,21,22
	public void erabiltzaileaJadanikErregistratutaDago() {
		try {
			String izena ="Mikeel";
			String pass ="12"; 
			String NAN="12"; 
			String korreoa="12@12"; 
			String KZ="B"; 
			String adina="12";


			mockedUser= new User(izena, pass, NAN, korreoa, KZ, adina);

			
			
			//invoke System Under Test (sut) 
			sut.erregistratu(izena, pass, NAN, korreoa, KZ, adina);

			//verify the result
			//Mockito.verify(mockedDataAccess,Mockito.times(1)).erregistratu(Mockito.any(User.class));
			
			ArgumentCaptor<String> izenaCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> passCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> NANCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> korreoCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> KZCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<String> adinaCaptor = ArgumentCaptor.forClass(String.class);
			
			Mockito.verify(mockedDataAccess, Mockito.times(1)).erregistratu(
					izenaCaptor.capture(),passCaptor.capture(),
					NANCaptor.capture(),korreoCaptor.capture(),KZCaptor.capture(),adinaCaptor.capture());
			
			
			assertTrue(izenaCaptor.getValue()!=izena);
			assertTrue(passCaptor.getValue()!=pass);
			assertTrue(NANCaptor.getValue()!=NAN);
			assertTrue(korreoCaptor.getValue()!=korreoa);
			assertTrue(KZCaptor.getValue()!=KZ);
			assertTrue(adinaCaptor.getValue()!=adina);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	//Estaliko den baliokidetasun klasea 4
	@Test
	public void testParametroBatNull() {
		try {
			String izena =null;
			String pass ="12"; 
			String NAN="12"; 
			String korreoa="12@12"; 
			String KZ="B"; 
			String adina="12";
						
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
	//Estaliko den baliokidetasun klasea 8
		@Test
		public void testParametroBatNull2() {
			try {
				String izena ="mikel";
				String pass =null; 
				String NAN="12"; 
				String korreoa="12@12"; 
				String KZ="B"; 
				String adina="12";
							
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
		//Estaliko den baliokidetasun klasea 12
		@Test
		public void testParametroBatNull3() {
			try {
				String izena ="mikel";
				String pass ="12"; 
				String NAN=null; 
				String korreoa="12@12"; 
				String KZ="B"; 
				String adina="12";
							
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
		//Estaliko den baliokidetasun klasea 16
		@Test
		public void testParametroBatNull4() {
			try {
				String izena ="mikel";
				String pass ="12"; 
				String NAN="12"; 
				String korreoa=null; 
				String KZ="B"; 
				String adina="12";
							
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
		//Estaliko den baliokidetasun klasea 20
		@Test
		public void testParametroBatNull5() {
			try {
				String izena ="mikel";
				String pass ="12"; 
				String NAN="12"; 
				String korreoa="12@12"; 
				String KZ=null; 
				String adina="12";
							
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
		//Estaliko den baliokidetasun klasea 24
		@Test
		public void testParametroBatNull6() {
			try {
				String izena =null;
				String pass ="12"; 
				String NAN="12"; 
				String korreoa="12@12"; 
				String KZ="B"; 
				String adina="12";
							
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
		
	//Estaliko den baliokidetasun klasea 3
	@Test
	public void testParametroBatHustsik() {
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
	
	//Estaliko den baliokidetasun klasea 3
	@Test
	public void testParametroBatHustsik1() {
		try {
			String izena ="";
			String pass ="12"; 
			String NAN="12"; 
			String korreoa="12@12"; 
			String KZ="B"; 
			String adina="12";

				
			
			
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
	//Estaliko den baliokidetasun klasea 7
		@Test
		public void testParametroBatHustsik2() {
			try {
				String izena ="mikel";
				String pass =""; 
				String NAN="12"; 
				String korreoa="12@12"; 
				String KZ="B"; 
				String adina="12";

					
				
				
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
		//Estaliko den baliokidetasun klasea 11
		@Test
		public void testParametroBatHustsik3() {
			try {
				String izena ="mikel";
				String pass ="12"; 
				String NAN=""; 
				String korreoa="12@12"; 
				String KZ="B"; 
				String adina="12";

					
				
				
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
		//Estaliko den baliokidetasun klasea 15
		@Test
		public void testParametroBatHustsik4() {
			try {
				String izena ="mikel";
				String pass ="12"; 
				String NAN="12"; 
				String korreoa=""; 
				String KZ="B"; 
				String adina="12";

					
				
				
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
		//Estaliko den baliokidetasun klasea 19
		@Test
		public void testParametroBatHustsik5() {
			try {
				String izena ="mikel";
				String pass ="12"; 
				String NAN="12"; 
				String korreoa="12@12"; 
				String KZ=""; 
				String adina="12";

					
				
				
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
		//Estaliko den baliokidetasun klasea 23
		@Test
		public void testParametroBatHustsik6() {
			try {
				String izena ="mikel";
				String pass ="12"; 
				String NAN="12"; 
				String korreoa="12@12"; 
				String KZ="B"; 
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
}
