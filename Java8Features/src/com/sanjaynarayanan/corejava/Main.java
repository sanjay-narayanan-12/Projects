package com.sanjaynarayanan.corejava;

import com.sanjaynarayanan.corejava.lambda.LambdaExpressions;
import com.sanjaynarayanan.corejava.streams.JavaStreamExample;
import com.sanjaynarayanan.corejava.streams.RealTimeScenerio;

public class Main {

	public static void main(String[] args) {
		System.out.println("-------------Real Time Scenerio-------------");
		RealTimeScenerio.filter();
		System.out.println("-------------Real Time Scenerio-------------");
		System.out.println("-------------Lambda Expressions-------------");
		int width = 10;
		LambdaExpressions.withOutLambda(width);
		LambdaExpressions.withLambda(width);
		System.out.println("-------------Lambda Expressions-------------");
		new JavaStreamExample();
	}

}
