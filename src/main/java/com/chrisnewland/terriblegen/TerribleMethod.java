package com.chrisnewland.terriblegen;

import java.util.Random;

public class TerribleMethod
{
	private int index;
	private int methodCount;

	public TerribleMethod(int index, int methodCount)
	{
		this.index = index;
		this.methodCount = methodCount;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("public int t").append(index).append("(int i)").append("\n");
		builder.append("{").append("\n");
		
		Random random = new Random();
		
		int randomCall = random.nextInt(methodCount); 
		
		if (random.nextBoolean() || randomCall <= index) // call greater number to prevent loops
		{
			builder.append("\t").append("return i + random.nextInt(10);").append("\n");
		}
		else
		{
			builder.append("\t").append("return i + t").append(randomCall).append("(i);").append("\n");
		}
		
		builder.append("}").append("\n");

		return builder.toString();
	}
}