# HRMS
### HRMS Project 
![design](https://user-images.githubusercontent.com/54038172/119261047-36b69000-bbde-11eb-9853-72231990ef77.PNG)
-----------------------------------------------------
### Added swagger this project

1. Go to website: https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
2. Copies dependencies tags in "Adding the Maven Dependency" and "Enabling Springfox's Swagger UI"
3. This codes must be these:
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
```
4. We need to paste these codes inside the dependentenices tag in pom.xml
5. We have to paste these codes under main.
```
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("javacamp.hrms")).build();
	}
```
6. And have to added @EnableSwagger2 on main for connect to swagger 
7. Finally go to "localhost:8080/swagger-ui.html"
