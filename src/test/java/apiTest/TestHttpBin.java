package apiTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class TestHttpBin {
	
	@BeforeClass
	public void setup() {
	    RestAssured.baseURI = "https://httpbin.org/";
	}
	
	@Test(priority=1)
	public void testPost() {
	    given().accept(ContentType.JSON).
	    	when().post(baseURI + "/post").
	    	then().assertThat().statusCode(HttpStatus.SC_OK);
	}
	
	@Test(priority=2)
	public void testGet() {
	    given().accept(ContentType.JSON).
	    	when().get().
	    	then().assertThat().statusCode(HttpStatus.SC_OK);
	}
	
	@Test(priority=3)
	public void testUpdate() {
	    given().accept(ContentType.JSON).
	    	when().put(baseURI + "/put").
	    	then().assertThat().statusCode(HttpStatus.SC_OK);
	}
	
	@Test(priority=4)
	public void testDelete() {
	    given().accept(ContentType.JSON).
	    	when().delete(baseURI + "/delete").
	    	then().assertThat().statusCode(HttpStatus.SC_OK);
	}

}
