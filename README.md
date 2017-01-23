This feature helps in exploring java annotations.

1) Annotation, a form of meta data. Provide data about a program that is not part of the program. Annotations provide additional information about the program to compiler, java runtime.

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
				
5) Annotations can again be classified as 
    
     - standard annotations :  annotations that are provided as part of API 
     
       These can be classified again as
   	   i)  general purpose annotations - useful for general purpose in programs and they are available in java.lang package
	  
	      @Deprecated, @Override, @SuppressWarnings, @FuncationalInterface (java 8) are general purpose annotations
	      
	      @Deprecated annotation is way a programmer can mark a method as outdated. Compiler generates a warning when it finds any references to the deprecated method.
	      
	      @Override annotation is way a programmer can ensure that he has overridden a method from super class/interface. Compiler generates an error if the method is not overriden. This is a method level annotation.
	      
	      @SupressWarnings is way a programmer can inform the compiler to not worry about type-unsafe operations performed in a method
	      
	      @FunctionalInterface is way a programmer can inform the compiler that a particular interface is a functional interface. A functional interface is an interface with exactly one method.
	  
	   ii) meta annotations - useful for building custom annotations 
	  
	      @Documented, @Inherited, @Retention, @Target are custom annotations
     
     - custom annotations : annotations that are user defined
				
