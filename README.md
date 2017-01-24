This feature helps in exploring java annotations.

1) Annotation, a form of meta data. Provide data about a program that is not part of the program. Annotations provide additional information about the program to compiler, java runtime. All annotations class have a super type java.lang.annotations.Annotation.

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
	      
	      @Deprecated annotation is way a programmer can mark a method as outdated. Compiler generates a warning when it finds any references to the deprecated method.
	      
	      @Override annotation is way a programmer can ensure that he has overridden a method from super class/interface. Compiler generates an error if the method is not overriden. This is a method level annotation.
	      
	      @SupressWarnings is way a programmer can inform the compiler to not worry about type-unsafe operations performed in a method
	      
	      @FunctionalInterface is way a programmer can inform the compiler that a particular interface is a functional interface. A functional interface is an interface with exactly one method. Any deviation from this will generate compile time error.  
	      
	      All these annotations are part of java.lang package. 
	  
	   ii) meta annotations - useful for building custom annotations 
	  
	      @Documented annotation is a way programmer can mark an annotation declaration as documentable ie., javadoc tool will include details of the annotation used in a program.	 		 
		    
	      @Inherited annotation is a way programmer can mark an annotation declaration as inheritable ie., an annotation applied to super class/interface will not be passed to child class/interface by default. If an annotation declaration is marked with @Inherited then it gets inherited to child classes.
	      
	      @Retention annotation is a way programmer can mark an annotation declaration to be retained. The value passed to annotation determines till which state the annotation is retained. RetentionPolicy enum has values SOURCE, CLASS, RUNTIME.  
	      
	      , @Target are custom annotations
	      
	      All these annotations are part of java.lang.annotation.
     
     - custom annotations : annotations that are user defined
				
