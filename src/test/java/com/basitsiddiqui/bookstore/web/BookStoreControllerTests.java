package com.basitsiddiqui.bookstore.web;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class BookStoreControllerTests {
    @LocalServerPort
    private int serverPort;

    @BeforeEach
    void setup() {
        RestAssured.port = serverPort;
        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig());
    }

    @AfterEach
    void tearDown() {}

    @Test
    void shouldFindAllBooks() {
        JsonPath jsonPath = given()
                .when()
                .accept(ContentType.JSON)
                .get("/books")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath();

        assertThat(jsonPath.getList("books")).hasSize(4);
        assertThat(jsonPath.getLong("books[0].id")).isEqualTo(1L);
        assertThat(jsonPath.getLong("books[1].id")).isEqualTo(2L);
        assertThat(jsonPath.getLong("books[2].id")).isEqualTo(3L);
    }

    @Test
    void shouldFindBookByValidId() {
        JsonPath jsonPath = given()
                .when()
                .accept(ContentType.JSON)
                .get("/books/1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath();

        assertThat(jsonPath.getList("books")).hasSize(1);
        assertThat(jsonPath.getLong("books[0].id")).isEqualTo(1L);
    }

    @Test
    void shouldFindNoResultsWhenBookNotPresent() {
        JsonPath jsonPath = given()
                .when()
                .accept(ContentType.JSON)
                .get("/books/10")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath();

        assertThat(jsonPath.getList("books")).hasSize(0);
    }

    @Test
    void shouldThrowExceptionFindNoResultsWhenBookNotPresent() {
         given()
        .when()
        .accept(ContentType.JSON)
        .get("/books/1l0")
        .then()
        .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
