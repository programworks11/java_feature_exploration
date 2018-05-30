package com.learning.feature.lambdaexpression;

import java.util.function.Consumer;

public class LambdaExpressionsVariableScopeLearning {

	public int x = 1;
	public static void main(String[] args)
	{
		LambdaExpressionsVariableScopeLearning st = new LambdaExpressionsVariableScopeLearning();
		LambdaExpressionsVariableScopeLearning.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
	}
	
	class FirstLevel {
		public int x = 2;
		
		void methodInFirstLevel(int x) 
		{
			Consumer<Integer> myConsumer = y -> {
				System.out.println("x = " + x); // 23
                System.out.println("y = " + y); // 23
                System.out.println("this.x = " + this.x); // 2
                System.out.println("LambdaExpressionsVariableScopeLearning.this.x = " +
                		LambdaExpressionsVariableScopeLearning.this.x); //1
			};
			myConsumer.accept(x);
		}
	}
}
