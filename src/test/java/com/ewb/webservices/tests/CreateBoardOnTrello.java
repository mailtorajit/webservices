package com.ewb.webservices.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ewb.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateBoardOnTrello extends BaseTest {
	Response response = null;

	@Test
	public void CreateBoard() {
		RestAssured.baseURI = config.getProperty("base_url");
		response = RestAssured.given().queryParam("name", "gdjkfgkdfhg vfddfs")
				.queryParam("key", "a7605cf145d463d572cc49c0da962508").queryParam("keepFromSource", "none")
				.queryParam("prefs_permissionLevel", "private").queryParam("prefs_voting", "disabled")
				.queryParam("prefs_comments", "members").queryParam("prefs_invitations", "members")
				.queryParam("prefs_background", "blue").queryParam("prefs_cardAging", "regular")
				.queryParam("token", "922e97bf18da9254f03ffcf2b19e6f60376657125bf7ed5da94fbeda5d0c087d")
				.contentType("text/html").log().all().post("/1/boards/");

		RequestSpecification request = RestAssured.given();

		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("name", "gdjkfgkdfhg vfddf");
		requestParams.put("key", "a7605cf145d463d572cc49c0da962508");
		requestParams.put("token", "922e97bf18da9254f03ffcf2b19e6f60376657125bf7ed5da94fbeda5d0c087d");
		request.queryParams(requestParams);
		response = request.contentType("text/html").log().all().post("/1/boards/");
		System.out.println(response.getStatusCode());
		System.out.println(RestAssured.baseURI);

		Assert.assertEquals(response.getStatusCode(), 200);
		response = request.queryParam("name", "tests ghdfhgfid").queryParam("idBoard", "5a3946a5ef19ef7baed48657")
				.queryParam("key", "a7605cf145d463d572cc49c0da962508")
				.queryParam("token", "922e97bf18da9254f03ffcf2b19e6f60376657125bf7ed5da94fbeda5d0c087d")
				.contentType("text/html").log().all().post("/1/boards/");
		System.out.println(response.getStatusCode());
		System.out.println(RestAssured.baseURI);

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// @Test
	// public void getBoard() {
	// RestAssured.baseURI =
	// "https://api.trello.com/1/boards/5a39474ee8f87d36d47b4ee7";
	// response = RestAssured.given().param("key",
	// "a7605cf145d463d572cc49c0da962508")
	// .and().param("token",
	// "922e97bf18da9254f03ffcf2b19e6f60376657125bf7ed5da94fbeda5d0c087d").get();
	// System.out.println(response.getStatusCode());
	// System.out.println(response.asString());
	// }

	// @Test
	// public void deleteBoard() {
	// RestAssured.baseURI = "https://api.trello.com/1/boards/SIWq92KP";
	// response = RestAssured.given().param("key",
	// "a7605cf145d463d572cc49c0da962508")
	// .and().param("token",
	// "922e97bf18da9254f03ffcf2b19e6f60376657125bf7ed5da94fbeda5d0c087d").delete();
	// System.out.println(response.getStatusCode());
	// System.out.println(response.asString());
	// }
}
