This feature helps in exploring java annotations.

1) Annotation, a form of meta data. Provide data about a program that is not part of the program. 

2) Declaration syntax -

		@interface AnnotationName 
		{
				datatype memberName() [default value];
		}

3) Utilization syntax - 

	 @AnnotationName(member1=value1, member2=value2)
 
	Annotations can be applied to class, interface, method, member variables and types. 

4) Annotations can be classified based on the number of members specified in declaration 

      - marker annotations : annotation declared without any members 
				ex: @Override 
				
			- single valued annotations: annotation declared with single member
				ex: @SuppressWarnings(value="unchecked")
				
				As it has single member, name can be dropped and it can be written as @SuppressWarnings("unchecked")
				
			- multi valued annotations: annotations declared with multiple members 
			  ex: @WebServlet(name="LoginServlet", urlPatterns: {"/Login","/SessionTimeOut"}
				
5) 			
				
