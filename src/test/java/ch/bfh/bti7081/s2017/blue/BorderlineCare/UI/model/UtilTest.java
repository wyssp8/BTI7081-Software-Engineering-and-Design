//package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;
//
//import static org.junit.Assert.*;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import ch.bfh.bti7081.s2017.blue.BorderlineCare.Util;
//import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
//
//public class UtilTest {
//	
//	Util util = new Util();
//	String generatedSecuredPasswordHash = null;
//	boolean passwordMatched;
//	String currentPassword;
//	@Before
//	public void setUp(){
//		 currentPassword = "test";
//	}
//	
//	@Test
//	public void testPasswordHash() {
//
//		
//		try {
//			generatedSecuredPasswordHash = util.generateStorngPasswordHash(currentPassword);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (InvalidKeySpecException e) {
//			e.printStackTrace();
//		}
//		try {
//			passwordMatched = util.validatePassword(currentPassword, generatedSecuredPasswordHash);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (InvalidKeySpecException e) {
//			e.printStackTrace();
//		}
//		assertTrue(passwordMatched);
//	}
//
//}
