<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br/>
The input values are validated using Bean Validation, Spring, and the Hibernate Validator.
<br /><ul>
		<li>the ID must be all numbers</li> 
		<li>the name cannot be surrounded by parentheses</li>
		<li>the date must be in the past</li>
<br/>
<br/>

<form method="POST">
	<table>
		<tr><td>ID: </td><td><input type="text" name="id"></td></tr><br/>
		<tr><td>Name: </td><td><input type="text" name="name"><br/></td></tr>
		<tr><td>Date: </td><td><input type="text" name="date"><br/></td></tr>
		<tr ><td height="20"></td><td></td></tr>
		<tr><td><input type="submit" name="Submit" /></td><td></td></tr>
	</table>
</form>





<br/>
<br/>
</body>
</html>

<!--  Notes from the book:


WHAT IS BEAN VALIDATION?

Bean Validation is a Java EE API for automatically validating declared business rules on Java beans.

It consists of a metadata model — a set of annotations with which you declare the business rules for a given class

use Hibernate Validator 5.1 to power Bean Validation in this book.


WHY HIBERNATE VALIDATOR?

You still require an implementation of this API to make Bean Validation in your applications work.

Hibernate Validator 5.0 is the reference implementation for JSR 349, meaning it is compliant with the specification


UNDERSTANDING THE ANNOTATION METADATA MODEL

Bean Validation works by way of annotating fields, methods, and more, to indicate that a particular constraint applies to the annotated target. 

Annotating an interface method indicates that the constraint should be applied against the return value of the method after method execution.

These last two patterns facilitate a programming style known as programming by contract or PbC. 


USING BEAN VALIDATION WITH SPRING FRAMEWORK
Spring Framework automatically proxies Spring-managed beans that use Java Bean Validation. 

Calls to annotated methods are intercepted and validated appropriately, whether to check that the consumer provides valid arguments or that the implementation returns legal values.

In this chapter, you explore how to configure Bean Validation in Spring Framework and how to use all the provided constraint annotations to apply business rules to your beans.


CONFIGURING VALIDATION IN THE SPRING FRAMEWORK CONTAINER

Before you can easily use any of the validation tools, you must first set up Bean Validation in the Spring Framework configuration.

To accomplish this you must configure four things: (not sure I did all these)
A validator
(skipped) Message localization for the validator
A method validation processor
Spring MVC form validation

CONFIGURING THE SPRING VALIDATOR BEAN

The org.springframework.validation.Validator interface specifies a tool for validating objects based on annotation constraints.
- servlet context configuration

Now this Spring Validator interface serves as a façade for the Bean Validation API.

 To this day, you may use either the Spring Validator or the javax.validation.Validator to suit your preferences in most cases, but in one particular case, you must use the Spring Validator and its Errors.

When configuring Spring Framework’s validation support, you define a special type of bean (a class that extends org.springframework.validation.beanvalidation.SpringValidatorAdapter) that implements both Validator and Spring Validator. 

You have the choice of using either of the following:
javax.validation.beanvalidation.CustomValidatorBean
javax.validation.beanvalidation.LocalValidatorFactoryBean.

configuring Spring Framework’s LocalValidatorFactoryBean is as simple as instantiating it and returning it in a @Bean method in the RootContextConfiguration class:

The LocalValidatorFactoryBean automatically detects the Bean Validation implementation on the classpath, whether that’s Hibernate Validator or some other implementation, and uses its default javax.validation.ValidatorFactory as the backing factory.

In these cases, which provider Spring selects is unpredictable (it might even change each time!), so you should set the provider class manually if you prefer the provider to be predictable.
- RootContextConfiguration - HibernateValidator.class

SETTING UP ERROR CODE LOCALIZATION

USING A METHOD VALIDATION BEAN POST-PROCESSOR

However, to support validation of method arguments and return values, you need to create an org.springframework.validation.beanvalidation.MethodValidationPostProcessor to proxy the execution of validated methods. 

Spring Framework uses the concept of bean post-processors to configure, customize, and, if necessary, replace beans defined in your configuration before the container completes the startup process.
Instead, you want to configure it to use the LocalValidatorFactoryBean you created earlier.

This MethodValidationPostProcessor looks for classes annotated with @org.springframework.validation.annotation.Validated or @javax.validation.executable.ValidateOnExecution and proxies them so that argument validation occurs on annotated parameters before method execution and return value validation occurs on annotated methods after method execution.
- news source service 

MAKING SPRING MVC USE THE SAME VALIDATION BEANS
Unlike the MethodValidationPostProcessor you just created, which uses a Validator instance, Spring MVC controller form object and argument validation uses a Spring Validator instance. 

To alter this default configuration, you just need to change the ServletContextConfiguration class you created in previous chapters to override WebMvcConfigurerAdapter’s getValidator method and return the validator created in the root application context.

With this change, Spring MVC uses your configured validator to validate appropriate controller handler method arguments, and your Spring Bean Validation is now complete.

ADDING CONSTRAINT VALIDATION ANNOTATIONS TO YOUR BEANS
For Bean Validation, your Spring applications mainly deal with two types of beans:
POJOs or JavaBeans-like entities and form objects that are typically method parameters or return types
Spring Beans like @Controllers and @Services that use those POJOs as method parameters and return types
Both these types of beans use Bean Validation constraint annotations, but in different ways.

UNDERSTANDING THE BUILT-IN CONSTRAINT ANNOTATIONS
the Bean Validation API comes with several built-in annotations that satisfy the most common validation requirements.

UNDERSTANDING COMMON CONSTRAINT ATTRIBUTES

PUTTING CONSTRAINTS TO USE

USING @VALID FOR RECURSIVE VALIDATION

 -->
