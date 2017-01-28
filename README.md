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
	      
		      @Deprecated annotation is used to annotate a method as outdated. Compiler generates a warning when it finds any references to the deprecated method.

		      @Override annotation is used to annotate overriding method as overridden from super class/interface. Compiler generates an error if the method with this annotation is not overriding any method. This is a method level annotation.

		      @SupressWarnings annotation is used to annotate a method that may generate compiler warning and on use of this annotation the compiler will supress any warning (type unsafe operations)

		      @FunctionalInterface is  used to annotate an interface as functional interface. A functional interface is an interface with exactly one abstract method. Any deviation from this will generate compile time error.  
	      
	      All these annotations are part of java.lang package. 
	  
	   ii) meta annotations - useful for building custom annotations 
	  
		      @Documented annotation is used to annotate an annotation declaration as documentable ie., javadoc tool will include details of the annotation used in a program when documentation is generated for a class which uses this annotation.	 		 

		      @Inherited annotation is used to annotate an annotation declaration as inheritable ie., an annotation applied to super class/interface will not be passed to child class/interface by default. If an annotation declaration is marked with @Inherited then it gets inherited to child classes.

		      @Retention annotation is used to annotate an annotation declaration so compiler understands till which level it needs to promote the retention. The value passed to annotation determines till which level (source, class, runtime) the annotation is retained. RetentionPolicy enum has values SOURCE, CLASS, RUNTIME.  

		      @Target annotation is used to annotate an annotation declaration to define the contexts in which it is applicable. One or more values can be passed to annotation. This can be applied in 8 different contexts like package, types(class, interface, enums, annotation declaration type), method declarations, constructor declarations, parameter declarations, field declarations, parameter declarations, local variable declarations.ElementType enum has values ANNOTATION_TYPE, CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE. 
	      
	      All these annotations are part of java.lang.annotation.
	      
		      @Documented
		      @Inherited
		      @Retention(RetentionPolicy.CLASS)
		      @Target({ElementType.METHOD, ElementType.TYPE})
		      interface AnnotationName
		      {
			 	datatype membername() default value;
		      }
	      
     
     - custom annotations : annotations that are user defined and these can be defined using meta annotations as shown in above example. These annotations can be used using reflection API
     	   
	
